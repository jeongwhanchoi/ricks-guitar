package ui;

import javax.swing.*;

import dao.RickDAO;
import entity.Inventory;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

/*
* Created by jeongwhanchoi on 22/06/2018.
*/

public class RicksGuitarApp extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public RicksGuitarApp() {
		setBackground(Color.DARK_GRAY);
		getContentPane().setForeground(Color.WHITE);
		getContentPane().setFont(new Font("Helvetica Neue", Font.PLAIN, 13));
		getContentPane().setBackground(Color.DARK_GRAY);
		getContentPane().setLayout(new BorderLayout(0, 0));

		JLabel lblRicksGuitar = new JLabel("Rick's Guitar");
		lblRicksGuitar.setIcon(new ImageIcon("/Users/jeongwhanchoi/Documents/RickGuitar/RickGuitar/resources/guitar-50.png"));
		lblRicksGuitar.setBackground(Color.DARK_GRAY);
		lblRicksGuitar.setHorizontalAlignment(SwingConstants.CENTER);
		lblRicksGuitar.setVerticalAlignment(SwingConstants.TOP);
		lblRicksGuitar.setForeground(Color.WHITE);
		lblRicksGuitar.setFont(new Font("Helvetica Neue", Font.BOLD, 28));
		getContentPane().add(lblRicksGuitar, BorderLayout.NORTH);

		JLabel lblNewLabel = new JLabel("©jeongwhanchoi     2018 ");
		lblNewLabel.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel.setForeground(Color.LIGHT_GRAY);
		lblNewLabel.setFont(new Font("Chalkboard", Font.PLAIN, 13));
		getContentPane().add(lblNewLabel, BorderLayout.SOUTH);
	}

	public SearchPanel pnlSearch = null;
	public AddPanel pnlAdd = null;
	public EditPanel pnlEdit = null;

	public static void main(String[] args) {
		Inventory inventory = new Inventory();
		initializeInventory(inventory);

		RicksGuitarApp superpanel = new RicksGuitarApp();
		superpanel.setTitle("Rick's Guitar");
		superpanel.pnlSearch = new SearchPanel(inventory);
		superpanel.pnlAdd = new AddPanel(inventory);
		superpanel.pnlEdit = new EditPanel(inventory);

		JTabbedPane tabbedPane = new JTabbedPane();

		tabbedPane.addTab("SEARCH", superpanel.pnlSearch);
		tabbedPane.addTab("ADD", superpanel.pnlAdd);
		tabbedPane.addTab("EDIT", superpanel.pnlEdit);

		superpanel.getContentPane().add(tabbedPane);

		superpanel.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		superpanel.setSize(900, 600);
		superpanel.setVisible(true);
	}

	private static void initializeInventory(Inventory inventory) {
		RickDAO rickDAO = new RickDAO();
		inventory.getInstrumentsFromDB(rickDAO.getAllInstruments());
	}

}