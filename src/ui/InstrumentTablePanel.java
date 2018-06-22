package ui;

import java.awt.Dimension;
import java.util.Iterator;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import dao.RickDAO;
import entity.Instrument;

import java.awt.Color;
import java.awt.Font;
import javax.swing.UIManager;

/*
* Created by jeongwhanchoi on 22/06/2018.
*/

public class InstrumentTablePanel extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	String tableColumns[] = { "serialNumber", "instrumentType", "price", "builder", "model", 
			"type", "backWood", "topWood", "numString", "style" };

	Object rowData[][] = {};

	DefaultTableModel defaultTableModel = new DefaultTableModel(rowData, tableColumns) {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		@Override
		public boolean isCellEditable(int row, int column) {
			return false;
		}

	};

	JTable table = new JTable(defaultTableModel);

	JScrollPane scr = new JScrollPane(table);

	public InstrumentTablePanel() {
		table.setFont(new Font("Helvetica Neue", Font.PLAIN, 12));
		table.setBackground(Color.WHITE);
		setBackground(UIManager.getColor("Button.background"));
		Dimension size = new Dimension();
		size.setSize(520, 450);
		scr.setPreferredSize(size);
		this.add(scr);
		repaint();
	}


	public void renewTable(List<?> instruments) {
		defaultTableModel.setRowCount(0);
		for (Iterator<?> iterator = instruments.iterator(); iterator.hasNext();) {
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

	public String deleteRecord() {
		if (table.getSelectedRowCount() > 0) {

			for (int i : table.getSelectedRows()) {
				RickDAO rickDAO = new RickDAO();
				String primaryValue = String.valueOf(defaultTableModel.getValueAt(i, 0));
				rickDAO.deleteInstrumnet(String.valueOf(defaultTableModel.getValueAt(i, 0)));
				return primaryValue;
			}

		}
		return "";
	}

}
