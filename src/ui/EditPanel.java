package ui;

import javax.swing.JPanel;
import entity.Inventory;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;

/*
* Created by jeongwhanchoi on 22/06/2018.
*/


class EditPanel extends JPanel { 
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public EditPanel(Inventory inventory) {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{847, 0};
		gridBagLayout.rowHeights = new int[]{135, 177, 164, 0};
		gridBagLayout.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel lblNewLabel = new JLabel("Edit The Fields According To The Serial Number");
		lblNewLabel.setFont(new Font("Helvetica Neue", Font.BOLD, 15));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		add(lblNewLabel, gbc_lblNewLabel);
		InstrumentEditTablePanel pnlInstrumentEditTable = new InstrumentEditTablePanel();
		InstrumentEditPanel pnlInstrumentEdit = new InstrumentEditPanel(pnlInstrumentEditTable,inventory);
		GridBagConstraints gbc_pnlInstrumentEditTable = new GridBagConstraints();
		gbc_pnlInstrumentEditTable.fill = GridBagConstraints.BOTH;
		gbc_pnlInstrumentEditTable.insets = new Insets(0, 0, 5, 0);
		gbc_pnlInstrumentEditTable.gridx = 0;
		gbc_pnlInstrumentEditTable.gridy = 1;
		this.add(pnlInstrumentEditTable, gbc_pnlInstrumentEditTable);
		GridBagConstraints gbc_pnlInstrumentEdit = new GridBagConstraints();
		gbc_pnlInstrumentEdit.anchor = GridBagConstraints.NORTH;
		gbc_pnlInstrumentEdit.fill = GridBagConstraints.HORIZONTAL;
		gbc_pnlInstrumentEdit.gridx = 0;
		gbc_pnlInstrumentEdit.gridy = 2;
		this.add(pnlInstrumentEdit, gbc_pnlInstrumentEdit);
	}
}