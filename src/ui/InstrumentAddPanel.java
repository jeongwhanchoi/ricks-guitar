package ui;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import dao.RickDAO;
import entity.Builder;
import entity.Instrument;
import entity.InstrumentSpec;
import entity.InstrumentType;
import entity.Inventory;
import entity.Style;
import entity.Type;
import entity.Wood;

import java.awt.FlowLayout;
import java.awt.Font;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.SwingConstants;

/*
* Created by jeongwhanchoi on 22/06/2018.
*/

public class InstrumentAddPanel extends JPanel implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	JButton btn = new JButton("Add Instrument");

	JComboBox<String> cmbBuilder = new JComboBox<String>();
	JComboBox<String> cmbInstrumentType = new JComboBox<String>();
	JComboBox<String> cmbType = new JComboBox<String>();
	JComboBox<String> cmbBackWood = new JComboBox<String>();
	JComboBox<String> cmbTopWood = new JComboBox<String>();
	JComboBox<String> cmbStyle = new JComboBox<String>();

	JLabel lblSerialNumber = new JLabel("Serial Number");
	JLabel lblPrice = new JLabel("Price");
	JLabel lblNumString = new JLabel("String");
	JLabel lblModel = new JLabel("Model Name");
	JLabel lblBuilder = new JLabel("Builder");
	JLabel lblType = new JLabel("Type");
	JLabel lblInstrumentType = new JLabel("Instrument Type");
	JLabel lblBackWood = new JLabel("Back Wood");
	JLabel lblTopWood = new JLabel("Top Wood");
	JLabel lblStyle = new JLabel("Style");

	JTextField txtSerialNumber = new JTextField(10);
	JTextField txtPrice = new JTextField(10);
	JTextField txtNumString = new JTextField(10);
	JTextField txtModel = new JTextField(10);

	JPanel pnlAdd = new JPanel();
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
	Inventory inventory;
	private final JLabel lblUseComboBox = new JLabel("Use Combo Box To Add");

	public InstrumentAddPanel(Inventory inventory) {
		setForeground(Color.WHITE);
		setBackground(UIManager.getColor("Button.background"));
		this.inventory = inventory;
		setComboBox();
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{733, 0};
		gridBagLayout.rowHeights = new int[]{41, 338, 152, 0};
		gridBagLayout.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);

		GridBagConstraints gbc_lblUseComboBox = new GridBagConstraints();
		gbc_lblUseComboBox.insets = new Insets(0, 0, 5, 0);
		gbc_lblUseComboBox.gridx = 0;
		gbc_lblUseComboBox.gridy = 0;
		lblUseComboBox.setVerticalAlignment(SwingConstants.BOTTOM);
		lblUseComboBox.setFont(new Font("Helvetica Neue", Font.BOLD, 15));
		add(lblUseComboBox, gbc_lblUseComboBox);
		GridBagConstraints gbc_pnlAdd = new GridBagConstraints();
		gbc_pnlAdd.fill = GridBagConstraints.BOTH;
		gbc_pnlAdd.insets = new Insets(0, 0, 5, 0);
		gbc_pnlAdd.gridx = 0;
		gbc_pnlAdd.gridy = 1;
		add(pnlAdd, gbc_pnlAdd);
		pnlAdd.setForeground(Color.WHITE);
		pnlAdd.setBackground(Color.DARK_GRAY);
		pnlAdd.setLayout(new GridLayout(10, 2));
		pnlInstrumentTypeText.setBorder(new LineBorder(Color.DARK_GRAY, 2));
		pnlInstrumentTypeText.setForeground(Color.WHITE);
		pnlInstrumentTypeText.setBackground(UIManager.getColor("Button.background"));
		lblInstrumentType.setFont(new Font("Helvetica Neue", Font.PLAIN, 13));

		pnlInstrumentTypeText.add(lblInstrumentType);
		cmbInstrumentType.setFont(new Font("Helvetica Neue", Font.PLAIN, 13));	

		pnlAdd.add(pnlInstrumentTypeText);
		pnlAdd.add(cmbInstrumentType);
		pnlBuilderText.setBorder(new LineBorder(Color.DARK_GRAY, 2));
		pnlBuilderText.setForeground(Color.WHITE);
		pnlBuilderText.setBackground(UIManager.getColor("Button.background"));
		lblBuilder.setFont(new Font("Helvetica Neue", Font.PLAIN, 13));

		pnlBuilderText.add(lblBuilder);

		pnlAdd.add(pnlBuilderText);
		cmbBuilder.setFont(new Font("Helvetica Neue", Font.PLAIN, 13));
		pnlAdd.add(cmbBuilder);
		pnlTypeText.setBorder(new LineBorder(Color.DARK_GRAY, 2));
		pnlTypeText.setForeground(Color.WHITE);
		pnlTypeText.setBackground(UIManager.getColor("Button.background"));
		lblType.setFont(new Font("Helvetica Neue", Font.PLAIN, 13));

		pnlTypeText.add(lblType);

		pnlAdd.add(pnlTypeText);
		cmbType.setFont(new Font("Helvetica Neue", Font.PLAIN, 13));
		pnlAdd.add(cmbType);
		pnlBackWoodText.setBorder(new LineBorder(Color.DARK_GRAY, 2));
		pnlBackWoodText.setForeground(Color.WHITE);
		pnlBackWoodText.setBackground(UIManager.getColor("Button.background"));
		lblBackWood.setFont(new Font("Helvetica Neue", Font.PLAIN, 13));

		pnlBackWoodText.add(lblBackWood);
		pnlAdd.add(pnlBackWoodText);
		cmbBackWood.setFont(new Font("Helvetica Neue", Font.PLAIN, 13));
		pnlAdd.add(cmbBackWood);
		pnlTopWoodText.setBorder(new LineBorder(Color.DARK_GRAY, 2));
		pnlTopWoodText.setForeground(Color.WHITE);
		pnlTopWoodText.setBackground(UIManager.getColor("Button.background"));
		lblTopWood.setFont(new Font("Helvetica Neue", Font.PLAIN, 13));

		pnlTopWoodText.add(lblTopWood);
		pnlAdd.add(pnlTopWoodText);
		cmbTopWood.setFont(new Font("Helvetica Neue", Font.PLAIN, 13));
		pnlAdd.add(cmbTopWood);
		pnlStyleText.setBorder(new LineBorder(Color.DARK_GRAY, 2));
		pnlStyleText.setForeground(Color.WHITE);
		pnlStyleText.setBackground(UIManager.getColor("Button.background"));
		lblStyle.setFont(new Font("Helvetica Neue", Font.PLAIN, 13));

		pnlStyleText.add(lblStyle);
		pnlAdd.add(pnlStyleText);
		cmbStyle.setFont(new Font("Helvetica Neue", Font.PLAIN, 13));
		pnlAdd.add(cmbStyle);
		pnlModelText.setBorder(new LineBorder(Color.DARK_GRAY, 2));
		pnlModelText.setForeground(Color.WHITE);
		pnlModelText.setBackground(UIManager.getColor("Button.background"));

		pnlAdd.add(pnlModelText);
		lblModel.setFont(new Font("Helvetica Neue", Font.PLAIN, 13));
		pnlModelText.add(lblModel);
		txtModel.setFont(new Font("Helvetica Neue", Font.PLAIN, 13));
		pnlAdd.add(txtModel);
		pnlSerialText.setBorder(new LineBorder(Color.DARK_GRAY, 2));
		pnlSerialText.setForeground(Color.WHITE);
		pnlSerialText.setBackground(UIManager.getColor("Button.background"));

		pnlAdd.add(pnlSerialText);
		lblSerialNumber.setFont(new Font("Helvetica Neue", Font.PLAIN, 13));
		pnlSerialText.add(lblSerialNumber);
		txtSerialNumber.setFont(new Font("Helvetica Neue", Font.PLAIN, 13));
		pnlAdd.add(txtSerialNumber);
		pnlPriceText.setBorder(new LineBorder(Color.DARK_GRAY, 2));
		pnlPriceText.setForeground(Color.WHITE);
		pnlPriceText.setBackground(UIManager.getColor("Button.background"));

		pnlAdd.add(pnlPriceText);
		lblPrice.setFont(new Font("Helvetica Neue", Font.PLAIN, 13));
		pnlPriceText.add(lblPrice);
		txtPrice.setFont(new Font("Helvetica Neue", Font.PLAIN, 13));
		pnlAdd.add(txtPrice);
		pnlNumStringText.setBorder(new LineBorder(Color.DARK_GRAY, 2));
		pnlNumStringText.setForeground(Color.WHITE);
		pnlNumStringText.setBackground(UIManager.getColor("Button.background"));

		pnlAdd.add(pnlNumStringText);
		lblNumString.setFont(new Font("Helvetica Neue", Font.PLAIN, 13));
		pnlNumStringText.add(lblNumString);
		txtNumString.setFont(new Font("Helvetica Neue", Font.PLAIN, 13));
		pnlAdd.add(txtNumString);
		FlowLayout flowLayout_1 = (FlowLayout) pnlButton.getLayout();
		flowLayout_1.setHgap(50);
		flowLayout_1.setVgap(50);
		GridBagConstraints gbc_pnlButton = new GridBagConstraints();
		gbc_pnlButton.fill = GridBagConstraints.BOTH;
		gbc_pnlButton.gridx = 0;
		gbc_pnlButton.gridy = 2;
		add(pnlButton, gbc_pnlButton);
		pnlButton.setBackground(UIManager.getColor("Button.background"));
		btn.setFont(new Font("Helvetica Neue", Font.PLAIN, 13));

		pnlButton.add(btn);
		btn.addActionListener(this);
	}

	public void setComboBox() {
		cmbInstrumentType.addItem("INSTRUMENTTYPE");
		for (InstrumentType i : InstrumentType.values()) {
			cmbInstrumentType.addItem(i.toString());
		}

		cmbBackWood.addItem("BACKWOOD");
		for (Wood i : Wood.values()) {
			cmbBackWood.addItem(i.toString());
		}

		cmbTopWood.addItem("TOPWOOD");
		for (Wood i : Wood.values()) {
			cmbTopWood.addItem(i.toString());
		}

		cmbBuilder.addItem("BUILDER");
		for (Builder i : Builder.values()) {
			cmbBuilder.addItem(i.toString());
		}

		cmbStyle.addItem("STYLE");
		for (Style i : Style.values()) {
			cmbStyle.addItem(i.toString());
		}

		cmbType.addItem("TYPE");
		for (Type i : Type.values()) {
			cmbType.addItem(i.toString());
		}
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		// TODO Auto-generated method stub
		RickDAO rickDAO = new RickDAO();
		Map<String, Comparable> properties = new HashMap<String, Comparable>();
		String serialNumber;
		double price;

		if (!txtSerialNumber.getText().equals("")) {
			serialNumber = txtSerialNumber.getText();
		} else {
			System.out.println("Please input the serial number");
			return;
		}

		if (!txtPrice.getText().equals("")) {
			price = Double.parseDouble(txtPrice.getText());
		} else {
			System.out.println("Please input the price");
			return;
		}

		if (cmbBuilder.getSelectedItem() != "BUILDER") {
			properties.put("builder", (String) cmbBuilder.getSelectedItem());
		} else {
			properties.put("builder", "");
		}

		if (cmbInstrumentType.getSelectedItem() != "INSTRUMENTTYPE") {
			properties.put("instrumentType", (String) cmbInstrumentType.getSelectedItem());
		} else {
			properties.put("instrumentType", "");
		}

		if (cmbType.getSelectedItem() != "TYPE") {
			properties.put("type", (String) cmbType.getSelectedItem());
		} else {
			properties.put("type", "");
		}

		if (cmbBackWood.getSelectedItem() != "BACKWOOD") {
			properties.put("backWood", (String) cmbBackWood.getSelectedItem());
		} else {
			properties.put("backWood", "");
		}

		if (cmbTopWood.getSelectedItem() != "TOPWOOD") {
			properties.put("topWood", (String) cmbTopWood.getSelectedItem());
		} else {
			properties.put("topWood", "");
		}

		if (cmbStyle.getSelectedItem() != "STYLE") {
			properties.put("style", (String) cmbStyle.getSelectedItem());
		} else {
			properties.put("style", "");
		}

		if (!txtNumString.getText().equals("")) {
			properties.put("numString", Integer.parseInt(txtNumString.getText()));
		} else {
			properties.put("numString", 5);
		}

		if (!txtModel.getText().equals("")) {
			properties.put("model", (String) txtModel.getText());
		} else {
			properties.put("model", "");
		}


		InstrumentSpec instrumentSpec = new InstrumentSpec(properties);
		Instrument instrument = new Instrument(serialNumber, price, instrumentSpec);
		inventory.addInstrument(serialNumber, price, instrumentSpec);
		rickDAO.insertInstrument(instrument);

	}

}
