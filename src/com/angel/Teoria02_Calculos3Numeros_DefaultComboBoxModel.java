package com.angel;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Teoria02_Calculos3Numeros_DefaultComboBoxModel {

	// CLASE ENUM - ENUMERADO EN JAVA
	// A clase Enum é unha clase especial que
	// limita a creación de obxectos a aqueles que están explicitamente
	// enumerados na declaración da clase.
	//
	// ~ Declaración ~
	// coa palabra reservada enum e os elementos en maiúsculas:
	// public enum Cara{
	// OLLOS, NARIZ, BOCA, QUEIXO
	// }
	//
	// ~ Instanciación ~ 
	// Corpo ollos = Corpo.OLLOS;
	//
	// ~ Métodos ~
	// ollos.name(); -> devolve un String co nome da constante (OLLOS)
	// ollos.toString(); -> devolve un String co nome da constante (OLLOS)
	// ollos.ordinal();  -> devolve un int co índice do enumerado (0)
	// ollos.value() ->
	// Corpo.values(); -> Devolve un array que contén todos os enum
	

	public enum OPERACIONES {
		SUMAR(0), RESTAR(1), MULTIPLICAR(2), DIVIDIR(3);

		private final int value;

		private OPERACIONES(int value) {
			this.value = value;
		}
	}

	private JFrame frame;
	private JTextField txtNumero1;
	private JTextField txtNumero2;
	private JTextField txtNumero3;
	private JComboBox cbxOperacion;
	private JLabel lblResultado;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Teoria02_Calculos3Numeros_DefaultComboBoxModel window = new Teoria02_Calculos3Numeros_DefaultComboBoxModel();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Teoria02_Calculos3Numeros_DefaultComboBoxModel() {
		initialize();
		cbxOperacion.setSelectedIndex(OPERACIONES.RESTAR.value);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 248, 219);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 0, 0, 0 };
		gridBagLayout.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0 };
		gridBagLayout.columnWeights = new double[] { 0.0, 1.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		frame.getContentPane().setLayout(gridBagLayout);

		JLabel lblNewLabel = new JLabel("Numero 1");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		frame.getContentPane().add(lblNewLabel, gbc_lblNewLabel);

		txtNumero1 = new JTextField();
		GridBagConstraints gbc_txtNumero1 = new GridBagConstraints();
		gbc_txtNumero1.insets = new Insets(0, 0, 5, 0);
		gbc_txtNumero1.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtNumero1.gridx = 1;
		gbc_txtNumero1.gridy = 0;
		frame.getContentPane().add(txtNumero1, gbc_txtNumero1);
		txtNumero1.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("Numero 2");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 1;
		frame.getContentPane().add(lblNewLabel_1, gbc_lblNewLabel_1);

		txtNumero2 = new JTextField();
		GridBagConstraints gbc_txtNumero2 = new GridBagConstraints();
		gbc_txtNumero2.insets = new Insets(0, 0, 5, 0);
		gbc_txtNumero2.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtNumero2.gridx = 1;
		gbc_txtNumero2.gridy = 1;
		frame.getContentPane().add(txtNumero2, gbc_txtNumero2);
		txtNumero2.setColumns(10);

		JLabel lblNewLabel_2 = new JLabel("Numero 3");
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 0;
		gbc_lblNewLabel_2.gridy = 2;
		frame.getContentPane().add(lblNewLabel_2, gbc_lblNewLabel_2);

		txtNumero3 = new JTextField();
		GridBagConstraints gbc_txtNumero3 = new GridBagConstraints();
		gbc_txtNumero3.insets = new Insets(0, 0, 5, 0);
		gbc_txtNumero3.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtNumero3.gridx = 1;
		gbc_txtNumero3.gridy = 2;
		frame.getContentPane().add(txtNumero3, gbc_txtNumero3);
		txtNumero3.setColumns(10);

		JLabel lblNewLabel_3 = new JLabel("Operación");
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_3.gridx = 0;
		gbc_lblNewLabel_3.gridy = 3;
		frame.getContentPane().add(lblNewLabel_3, gbc_lblNewLabel_3);

		cbxOperacion = new JComboBox();
		cbxOperacion.setModel(new DefaultComboBoxModel(new String[] { "SUMAR", "RESTAR", "MULTIPLICAR", "DIVIDIR" }));
		GridBagConstraints gbc_cbxOperacion = new GridBagConstraints();
		gbc_cbxOperacion.insets = new Insets(0, 0, 5, 0);
		gbc_cbxOperacion.fill = GridBagConstraints.HORIZONTAL;
		gbc_cbxOperacion.gridx = 1;
		gbc_cbxOperacion.gridy = 3;
		frame.getContentPane().add(cbxOperacion, gbc_cbxOperacion);

		JButton btnCalcular = new JButton("Calcular");
		btnCalcular.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String n1 = txtNumero1.getText();
				String n2 = txtNumero2.getText();
				String n3 = txtNumero3.getText();

				if (n1.isEmpty() || n2.isEmpty() || n3.isEmpty()) {
					lblResultado.setText("Error, tienes que rellenar todos los campos");
					return;
				}

				float numero1 = Float.parseFloat(n1);
				float numero2 = Float.parseFloat(n2);
				float numero3 = Float.parseFloat(n3);

				// cbxOperacion.getSelectedIndex() // meda un numero ej 1
				// cbxOperacion.getSelectedItem() // me da un texto ej RESTA
				if (cbxOperacion.getSelectedIndex() == OPERACIONES.SUMAR.value) {
					float resultado = numero1 + numero2 + numero3;
					lblResultado.setText(resultado + "");
				} else if (cbxOperacion.getSelectedIndex() == OPERACIONES.RESTAR.value) { // resto
					float resultado = numero1 - numero2 - numero3;
					lblResultado.setText(resultado + "");
				} else if (cbxOperacion.getSelectedIndex() == OPERACIONES.MULTIPLICAR.value) { // multiplico
					float resultado = numero1 * numero2 * numero3;
					lblResultado.setText(resultado + "");
				} else if (cbxOperacion.getSelectedIndex() == OPERACIONES.DIVIDIR.value) { // divido
					float resultado = numero1 / numero2 / numero3;
					lblResultado.setText(resultado + "");
				} else {
					lblResultado.setText("Error en la operación");
				}

			}
		});
		GridBagConstraints gbc_btnCalcular = new GridBagConstraints();
		gbc_btnCalcular.insets = new Insets(0, 0, 5, 0);
		gbc_btnCalcular.gridx = 1;
		gbc_btnCalcular.gridy = 4;
		frame.getContentPane().add(btnCalcular, gbc_btnCalcular);

		lblResultado = new JLabel("0");
		GridBagConstraints gbc_lblResultado = new GridBagConstraints();
		gbc_lblResultado.gridx = 1;
		gbc_lblResultado.gridy = 5;
		frame.getContentPane().add(lblResultado, gbc_lblResultado);
	}

	public JComboBox getCbxOperacion() {
		return cbxOperacion;
	}

	public JLabel getLblResultado() {
		return lblResultado;
	}
}
