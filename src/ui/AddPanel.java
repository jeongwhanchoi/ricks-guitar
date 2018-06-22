package ui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JPanel;

import entity.Inventory;

/*
* Created by jeongwhanchoi on 22/06/2018.
*/

class AddPanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public AddPanel(Inventory inventory) {
		setLayout(new FlowLayout());
		InstrumentAddPanel pnlInstrumentAdd = new InstrumentAddPanel(inventory);
		this.add(pnlInstrumentAdd, BorderLayout.CENTER);
	}
}