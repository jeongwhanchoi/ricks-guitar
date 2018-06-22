package ui;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import dao.RickDAO;
import entity.Instrument;
import entity.InstrumentSpec;
import entity.Inventory;

import java.awt.Color;
import java.awt.Dimension;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.swing.*;
import java.awt.Font;

/*
* Created by jeongwhanchoi on 22/06/2018.
*/

public class InstrumentEditTablePanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	JFrame jFrame = new JFrame("");

	String tableColumns[] = { "serialNumber", "instrumentType", "price", "builder", "model", "type", "backWood",
			"topWood", "numString", "style" };

	Object rowData[][] = {};

	DefaultTableModel defaultTableModel = new DefaultTableModel(rowData, tableColumns);

	JTable table = new JTable(defaultTableModel);

	JScrollPane scr = new JScrollPane(table);

	public InstrumentEditTablePanel() {
		table.setFont(new Font("Helvetica Neue", Font.PLAIN, 15));
		table.setBackground(Color.WHITE);
		Dimension size = new Dimension();
		size.setSize(800, 50);
		scr.setPreferredSize(size);
		this.add(scr);
		repaint();
	}

	public void search(List<?> matchingInstruments) {
		defaultTableModel.setRowCount(0);
		for (Iterator<?> iterator = matchingInstruments.iterator(); iterator.hasNext();) {
			Instrument instrument = (Instrument) iterator.next();

			Object rowData[] = { 
					(String) instrument.getSerialNumber(), 
					(String) instrument.getSpec().getProperty("instrumentType"),
					instrument.getPrice(),
					(String) instrument.getSpec().getProperty("builder"),
					(String) instrument.getSpec().getProperty("model"),
					(String) instrument.getSpec().getProperty("type"),
					(String) instrument.getSpec().getProperty("backWood"),
					(String) instrument.getSpec().getProperty("topWood"), 
					instrument.getSpec().getProperty("numString"),
					(String) instrument.getSpec().getProperty("style") };
			defaultTableModel.addRow(rowData);
		}
	}

	public void updateInstrument(Inventory inventory){
		switch( table.getSelectedRowCount() )
		{
		case 0:
			JOptionPane.showMessageDialog(jFrame, "There's no column selected");
			break;

		case 1:
			String serialNumber = String.valueOf(defaultTableModel.getValueAt(table.getSelectedRow(), 0));
			String instrumentType = String.valueOf(defaultTableModel.getValueAt(table.getSelectedRow(), 1));
			String price = String.valueOf(defaultTableModel.getValueAt(table.getSelectedRow(), 2));
			String builder = String.valueOf(defaultTableModel.getValueAt(table.getSelectedRow(), 3));
			String model = String.valueOf(defaultTableModel.getValueAt(table.getSelectedRow(), 4));
			String type = String.valueOf(defaultTableModel.getValueAt(table.getSelectedRow(), 5));
			String backWood = String.valueOf(defaultTableModel.getValueAt(table.getSelectedRow(), 6));
			String topWood = String.valueOf(defaultTableModel.getValueAt(table.getSelectedRow(), 7));
			String numString =String.valueOf( defaultTableModel.getValueAt(table.getSelectedRow(), 8));
			String style = String.valueOf(defaultTableModel.getValueAt(table.getSelectedRow(), 9));

			Map<String, String> map = new HashMap<String, String>();
			map.put("instrumentType", instrumentType);
			map.put("builder", builder);
			map.put("model", model);
			map.put("type", type);
			map.put("backWood", backWood);
			map.put("topWood", topWood);
			map.put("numString", numString);
			map.put("style", style);
			InstrumentSpec instrumentSpec = new InstrumentSpec(map);
			Instrument instrument = new Instrument(serialNumber,Double.parseDouble(price),instrumentSpec);
			RickDAO rickDAO = new RickDAO();
			rickDAO.updateInstrument(instrument);
			inventory.update(instrument);
			break;

		default:
			JOptionPane.showMessageDialog(jFrame, "Please select one column");
			break;
		}
	}
}