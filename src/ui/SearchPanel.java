package ui;

import java.awt.BorderLayout;

import javax.swing.JPanel;

import entity.Inventory;

/*
* Created by jeongwhanchoi on 22/06/2018.
*/

class SearchPanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public SearchPanel(Inventory inventory) {
		setLayout(new BorderLayout());
		InstrumentTablePanel pnlInstrumentTable = new InstrumentTablePanel();
		InstrumentSearchPanel pnlInstrumentSearch = new InstrumentSearchPanel(inventory, pnlInstrumentTable);

		this.add(pnlInstrumentSearch, BorderLayout.WEST);
		this.add(pnlInstrumentTable, BorderLayout.EAST);
	}
}