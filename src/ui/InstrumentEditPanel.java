package ui;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import entity.Inventory;
import java.awt.Font;
import javax.swing.UIManager;
import javax.swing.border.EtchedBorder;

import dao.RickDAO;

/*
* Created by jeongwhanchoi on 22/06/2018.
*/

public class InstrumentEditPanel extends JPanel implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JLabel lblSerialNumber = new JLabel("Serial Number");
	JTextField txtSerialNumber = new JTextField(15);
	JPanel pnlSerialNumberSearch = new JPanel();
	JPanel pnlSerialNumberText = new JPanel();

	JPanel pnlButton = new JPanel();

	JButton btnSearch = new JButton("Search");
	JButton btnEdit = new JButton("Edit");

	InstrumentEditTablePanel pnlInstrumentEditTable;
	Inventory inventory;

	public InstrumentEditPanel(InstrumentEditTablePanel pnlInstrumentEditTable, Inventory inventory) {
		setBackground(UIManager.getColor("Button.background"));
		this.pnlInstrumentEditTable = pnlInstrumentEditTable;
		this.inventory = inventory;
		pnlButton.setBackground(UIManager.getColor("Button.background"));
		btnSearch.setFont(new Font("Helvetica Neue", Font.PLAIN, 13));

		pnlButton.add(btnSearch);
		btnEdit.setFont(new Font("Helvetica Neue", Font.PLAIN, 13));
		pnlButton.add(btnEdit);
		this.setLayout(new GridLayout(3, 2));
		add(pnlSerialNumberSearch);
		pnlSerialNumberSearch.setBackground(UIManager.getColor("Button.background"));
		pnlSerialNumberSearch.setSize(1000, 400);
		pnlSerialNumberText.setBorder(new EtchedBorder(EtchedBorder.RAISED, Color.GRAY, Color.DARK_GRAY));
		pnlSerialNumberSearch.add(pnlSerialNumberText);
		lblSerialNumber.setToolTipText("serial number of the instrument");
		lblSerialNumber.setFont(new Font("Helvetica Neue", Font.PLAIN, 13));
		pnlSerialNumberText.add(lblSerialNumber);
		txtSerialNumber.setFont(new Font("Helvetica Neue", Font.PLAIN, 13));
		pnlSerialNumberSearch.add(txtSerialNumber);
		this.add(pnlButton);
		btnSearch.addActionListener(this);
		btnEdit.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent event)
			{
				pnlInstrumentEditTable.updateInstrument(inventory);
			}			
		});
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		// TODO Auto-generated method stub
		RickDAO rickDAO = new RickDAO();
		List matchingInstruments = new LinkedList();

		String serialNumber = txtSerialNumber.getText().toString();
		matchingInstruments = rickDAO.getInstruments(serialNumber);
		pnlInstrumentEditTable.search(matchingInstruments);

	}
}
