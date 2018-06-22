package dao;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import entity.Instrument;
import entity.InstrumentSpec;

/*
* Created by jeongwhanchoi on 22/06/2018.
*/

public class RickDAO {

	private Connection connection;
	private ResultSet resultSet;
	private Statement statement;
	static final private String tableName = "instruments";

	public RickDAO() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			// get db properties
			Properties props = new Properties();
			props.load(new FileInputStream("config.properties"));

			String user = props.getProperty("user");
			String password = props.getProperty("password");
			String dburl = props.getProperty("dburl");

			// connect to database
			connection = DriverManager.getConnection(dburl, user, password);

			System.out.println("DB connection successful to: " + dburl);

			statement = connection.createStatement();

		} catch (Exception e) {
			System.out.println(e.toString());
		}
	}

	public List<Instrument> getAllInstruments() {
		List<Instrument> matchingInstruments = new LinkedList<Instrument>();
		String sqlQuery = "SELECT * FROM " + tableName;

		try {
			statement.executeQuery(sqlQuery);

			if (statement.execute(sqlQuery)) {
				resultSet = statement.getResultSet();
				while (resultSet.next()) {
					Map<String, Comparable> properties = new HashMap<String, Comparable>();
					properties.put("instrumentType", (String) resultSet.getString("instrumentType"));
					properties.put("builder", (String) resultSet.getString("builder"));
					properties.put("model", (String) resultSet.getString("model"));
					properties.put("type", (String) resultSet.getString("type"));
					properties.put("backWood", (String) resultSet.getString("backWood"));
					properties.put("topWood", (String) resultSet.getString("topWood"));
					properties.put("numString", resultSet.getInt("numString"));
					properties.put("style", (String) resultSet.getString("style"));

					InstrumentSpec matchingInstrumentSpec = new InstrumentSpec(properties);
					Instrument instrument = new Instrument(resultSet.getString("serialNumber"),
							resultSet.getFloat("price"), matchingInstrumentSpec);

					matchingInstruments.add(instrument);
				}
			}
			connection.close();
			resultSet.close();
			statement.close();
		} catch (Exception e) {
			System.out.println(e.toString());
		}

		return matchingInstruments;
	}

	public List<Instrument> getInstruments(String serialNumber) {
		List<Instrument> matchingInstruments = new LinkedList<Instrument>();
		String sqlQuery = "SELECT * FROM " + tableName  + " WHERE serialNumber ='" + serialNumber + "';";

		try {
			//    	  //Order with serialNum
			//    	  serialNumber += "%";
			//    	  ((PreparedStatement) statement).setString(1, serialNumber);

			statement.executeQuery(sqlQuery);

			if (statement.execute(sqlQuery)) {
				resultSet = statement.getResultSet();
				while (resultSet.next()) {
					Map<String, Comparable> properties = new HashMap<String, Comparable>();
					properties.put("instrumentType", resultSet.getString("instrumentType"));
					properties.put("builder", resultSet.getString("builder"));
					properties.put("model", resultSet.getString("model"));
					properties.put("type", resultSet.getString("type"));
					properties.put("backWood", resultSet.getString("backWood"));
					properties.put("topWood", resultSet.getString("topWood"));
					properties.put("numString", resultSet.getInt("numString"));
					properties.put("style", resultSet.getString("style"));

					InstrumentSpec matchingInstrumentSpec = new InstrumentSpec(properties);
					Instrument instrument = new Instrument(resultSet.getString("serialNumber"),
							resultSet.getFloat("price"), matchingInstrumentSpec);

					matchingInstruments.add(instrument);
				}
			}
			connection.close();
			resultSet.close();
			statement.close();
		} catch (Exception e) {
			System.out.println(e.toString());
		}

		return matchingInstruments;
	}

	public void insertInstrument(Instrument instrument) {
		String sql = "INSERT INTO " + tableName
				+ "(serialNumber, price, instrumentType, builder, model, type, backWood,"
				+ " topWood, numString, style) VALUES('" + instrument.getSerialNumber() + "', " + instrument.getPrice()
				+ ", '" + instrument.getSpec().getProperty("instrumentType") + "', '"
				+ instrument.getSpec().getProperty("builder") + "', '" + instrument.getSpec().getProperty("model")
				+ "', '" + instrument.getSpec().getProperty("type") + "', '"
				+ instrument.getSpec().getProperty("backWood") + "', '" + instrument.getSpec().getProperty("topWood")
				+ "', " + instrument.getSpec().getProperty("numString") + ", '"
				+ instrument.getSpec().getProperty("style") + "')";
		try {
			statement.executeUpdate(sql);
			statement.close();
			connection.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}


	public void deleteInstrumnet(String serialNumber) {
		String sql = "DELETE FROM " + tableName + " WHERE serialNumber = '" + serialNumber + "';";
		try {
			statement.executeUpdate(sql);
			statement.close();
			connection.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void updateInstrument(Instrument instrument) {
		String sql = "UPDATE " + tableName + " SET "
				+"instrumentType='"+instrument.getSpec().getProperty("instrumentType")+"', "
				+"price='"+String.valueOf(instrument.getPrice())+"', "
				+"builder='"+instrument.getSpec().getProperty("builder")+"', "
				+"model='"+instrument.getSpec().getProperty("model")+"', "
				+"type='"+instrument.getSpec().getProperty("type")+"', "
				+"backWood='"+instrument.getSpec().getProperty("backWood")+"', "
				+"topWood='"+instrument.getSpec().getProperty("topWood")+"', "
				+"numString='"+String.valueOf(instrument.getSpec().getProperty("numString"))+"', "
				+"style='"+instrument.getSpec().getProperty("style")+"'"+
				" WHERE serialNumber = '" +instrument.getSerialNumber()+"';" ;
		try {
			statement.executeUpdate(sql);
			statement.close();
			connection.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}