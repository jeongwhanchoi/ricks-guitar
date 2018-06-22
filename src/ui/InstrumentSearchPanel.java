package ui;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.*;

import entity.Builder;
import entity.InstrumentSpec;
import entity.InstrumentType;
import entity.Inventory;
import entity.Style;
import entity.Type;
import entity.Wood;

import java.awt.Font;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

/*
* Created by jeongwhanchoi on 22/06/2018.
*/

public class InstrumentSearchPanel extends JPanel implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	InstrumentTablePanel pnlInstrumentTable;

	JButton btnSearch = new JButton("Search");
	JButton btnDelete = new JButton("Delete");
	Inventory inventory;

	//ComboBox
	JComboBox<String> cmbBuilder = new JComboBox<String>();
	JComboBox<String> cmbInstrumentType = new JComboBox<String>();
	JComboBox<String> cmbType = new JComboBox<String>();
	JComboBox<String> cmbBackWoodc = new JComboBox<String>();
	JComboBox<String> cmbTopWood = new JComboBox<String>();
	JComboBox<String> cmbStyle = new JComboBox<String>();

	//JLabel
	JLabel lblSerialNumber = new JLabel("serialNumber");
	JLabel lblPrice = new JLabel("price");
	JLabel lblNumberString = new JLabel("String");
	JLabel lblModel = new JLabel("Model Name");
	JLabel lblBuilder = new JLabel("Builder");
	JLabel lblType = new JLabel("Type");
	JLabel lblInstrumentType = new JLabel("Instrument Type");
	JLabel lblBackWood = new JLabel("Back Wood");
	JLabel lblTopWood = new JLabel("Top Wood");
	JLabel lblStyle = new JLabel("Style");

	//JTextField
	JTextField txtSerialNumber = new JTextField(10);
	JTextField txtPrice = new JTextField(10);
	JTextField txtNumberString = new JTextField(10);
	JTextField txtModel = new JTextField(10);

	//JPanel
	JPanel pnlSearch = new JPanel();
	JPanel pnlButton = new JPanel();

	JPanel pnlSerialText = new JPanel();
	JPanel pnlPriceText = new JPanel();
	JPanel pnlModelText = new JPanel();
	JPanel pnlNumStringText = new JPanel();
	JPanel pnlStyleText = new JPanel();
	JPanel pnlBuilderText = new JPanel();
	JPanel pnlTypeText = new JPanel();
	JPanel pnlInstrumentTypeText = new JPanel();
	JPanel pnlBackWoodText = new JPanel();
	JPanel pnlTopWoodText = new JPanel();
	private final JLabel lblUseComboBoxes = new JLabel("\nUse Combo Boxes To Search");

	public InstrumentSearchPanel(Inventory inventory, InstrumentTablePanel pnlInstrumentTable) {
		this.inventory = inventory;
		setComboBox();

		this.pnlInstrumentTable = pnlInstrumentTable;
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] {299, 0};
		gridBagLayout.rowHeights = new int[] {130, 237, 69, 0};
		gridBagLayout.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);

		GridBagConstraints gbc_lblUseComboBoxes = new GridBagConstraints();
		gbc_lblUseComboBoxes.fill = GridBagConstraints.VERTICAL;
		gbc_lblUseComboBoxes.insets = new Insets(0, 0, 5, 0);
		gbc_lblUseComboBoxes.gridx = 0;
		gbc_lblUseComboBoxes.gridy = 0;
		lblUseComboBoxes.setFont(new Font("Helvetica Neue", Font.BOLD, 16));
		add(lblUseComboBoxes, gbc_lblUseComboBoxes);
		pnlSearch.setBackground(UIManager.getColor("Button.background"));

		pnlSearch.setLayout(new GridLayout(8, 2));
		lblInstrumentType.setHorizontalAlignment(SwingConstants.CENTER);
		lblInstrumentType.setFont(new Font("Helvetica Neue", Font.PLAIN, 13));

		pnlInstrumentTypeText.add(lblInstrumentType);

		pnlSearch.add(pnlInstrumentTypeText);
		cmbInstrumentType.setFont(new Font("Helvetica Neue", Font.PLAIN, 13));
		pnlSearch.add(cmbInstrumentType);

		lblBuilder.setFont(new Font("Helvetica Neue", Font.PLAIN, 13));

		pnlBuilderText.add(lblBuilder);

		pnlSearch.add(pnlBuilderText);
		cmbBuilder.setFont(new Font("Helvetica Neue", Font.PLAIN, 13));
		pnlSearch.add(cmbBuilder);
		lblType.setFont(new Font("Helvetica Neue", Font.PLAIN, 13));

		pnlTypeText.add(lblType);

		pnlSearch.add(pnlTypeText);
		cmbType.setFont(new Font("Helvetica Neue", Font.PLAIN, 13));
		pnlSearch.add(cmbType);
		lblBackWood.setFont(new Font("Helvetica Neue", Font.PLAIN, 13));

		pnlBackWoodText.add(lblBackWood);
		pnlSearch.add(pnlBackWoodText);
		cmbBackWoodc.setFont(new Font("Helvetica Neue", Font.PLAIN, 13));
		pnlSearch.add(cmbBackWoodc);
		lblTopWood.setFont(new Font("Helvetica Neue", Font.PLAIN, 13));

		pnlTopWoodText.add(lblTopWood);
		pnlSearch.add(pnlTopWoodText);
		cmbTopWood.setFont(new Font("Helvetica Neue", Font.PLAIN, 13));
		pnlSearch.add(cmbTopWood);
		lblStyle.setFont(new Font("Helvetica Neue", Font.PLAIN, 13));

		pnlStyleText.add(lblStyle);
		pnlSearch.add(pnlStyleText);
		cmbStyle.setFont(new Font("Helvetica Neue", Font.PLAIN, 13));
		pnlSearch.add(cmbStyle);

		pnlSearch.add(pnlModelText);
		lblModel.setFont(new Font("Helvetica Neue", Font.PLAIN, 13));
		pnlModelText.add(lblModel);
		pnlSearch.add(txtModel);

		pnlSearch.add(pnlNumStringText);
		lblNumberString.setFont(new Font("Helvetica Neue", Font.PLAIN, 13));
		pnlNumStringText.add(lblNumberString);
		pnlSearch.add(txtNumberString);
		GridBagConstraints gbc_pnlSearch = new GridBagConstraints();
		gbc_pnlSearch.insets = new Insets(0, 0, 5, 0);
		gbc_pnlSearch.gridx = 0;
		gbc_pnlSearch.gridy = 1;
		this.add(pnlSearch, gbc_pnlSearch);
		FlowLayout flowLayout = (FlowLayout) pnlButton.getLayout();
		flowLayout.setHgap(50);
		pnlButton.setBackground(UIManager.getColor("Button.background"));
		btnSearch.setFont(new Font("Helvetica Neue", Font.PLAIN, 13));

		pnlButton.add(btnSearch);
		btnSearch.addActionListener(this);
		btnDelete.setFont(new Font("Helvetica Neue", Font.PLAIN, 13));
		pnlButton.add(btnDelete);
		btnDelete.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {

				String primaryKey = pnlInstrumentTable.deleteRecord();
				inventory.remove(primaryKey);
			}
		});
		GridBagConstraints gbc_pnlButton = new GridBagConstraints();
		gbc_pnlButton.anchor = GridBagConstraints.SOUTH;
		gbc_pnlButton.fill = GridBagConstraints.HORIZONTAL;
		gbc_pnlButton.gridx = 0;
		gbc_pnlButton.gridy = 2;
		this.add(pnlButton, gbc_pnlButton);
		this.setVisible(true);
	}

	public void setComboBox() {
		cmbInstrumentType.addItem("INSTRUMENTTYPE");
		for (InstrumentType i : InstrumentType.values()) {
			cmbInstrumentType.addItem(i.toString());
		}

		cmbBackWoodc.addItem("BACKWOOD");
		for (Wood i : Wood.values()) {
			cmbBackWoodc.addItem(i.toString());
		}

		cmbTopWood.addItem("TOPWOOD");
		for (Wood i : Wood.values()) {
			cmbTopWood.addItem(i.toString());
		}

		cmbBuilder.addItem("BUILDER");
		for (Builder i : Builder.values()) {
			cmbBuilder.addItem(i.toString());
		}

		cmbType.addItem("TYPE");
		for (Type i : Type.values()) {
			cmbType.addItem(i.toString());
		}

		cmbStyle.addItem("STYLE");
		for (Style i : Style.values()) {
			cmbStyle.addItem(i.toString());
		}
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		// TODO Auto-generated method stub
		Map<String, Comparable> properties = new HashMap<String, Comparable>();

		if (cmbBuilder.getSelectedItem() != "BUILDER") {
			properties.put("builder", (String) cmbBuilder.getSelectedItem());
		}

		if (cmbInstrumentType.getSelectedItem() != "INSTRUMENTTYPE") {
			properties.put("instrumentType", (String) cmbInstrumentType.getSelectedItem());
		}

		if (cmbType.getSelectedItem() != "TYPE") {
			properties.put("type", (String) cmbType.getSelectedItem());
		}

		if (cmbBackWoodc.getSelectedItem() != "BACKWOOD") {
			properties.put("backWood", (String) cmbBackWoodc.getSelectedItem());
		}

		if (cmbTopWood.getSelectedItem() != "TOPWOOD") {
			properties.put("topWood", (String) cmbTopWood.getSelectedItem());
		}

		if (cmbStyle.getSelectedItem() != "STYLE") {
			properties.put("style", (String) cmbStyle.getSelectedItem());
		}

		if (!txtNumberString.getText().equals("")) {
			properties.put("numString", Integer.parseInt(txtNumberString.getText()));
		}

		if (!txtModel.getText().equals("")) {
			properties.put("model", (String) txtModel.getText());
		}

		InstrumentSpec instrumentSpec = new InstrumentSpec(properties);
		List<?> instruments = inventory.search(instrumentSpec);

		pnlInstrumentTable.renewTable(instruments);
	}

}