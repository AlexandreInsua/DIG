package app002_box_list;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.SwingConstants;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Calculo3Numeros {

	// Enumeración del copón
	public enum OPERATIONS {SUMAR (0), RESTAR(1), MULTIPLICAR(2), DIVIDIR(3);
		private final int value;
		private OPERATIONS (int value) {
			this.value= value;}
		}

	private JFrame frame;
	private JTextField txtNumber1;
	private JTextField txtNumber2;
	private JComboBox cbxOperation;
	private JLabel lblResult;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Calculo3Numeros window = new Calculo3Numeros();
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
	public Calculo3Numeros() {
		initialize();
		// Seleccionado por defecto
		cbxOperation.setSelectedIndex(OPERATIONS.SUMAR.value);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 0, 0, 0, 0 };
		gridBagLayout.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0 };
		gridBagLayout.columnWeights = new double[] { 0.0, 1.0, 1.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		frame.getContentPane().setLayout(gridBagLayout);

		JLabel lblNewLabel = new JLabel("N\u00FAmero 1");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		frame.getContentPane().add(lblNewLabel, gbc_lblNewLabel);

		txtNumber1 = new JTextField();
		GridBagConstraints gbc_txtNumber1 = new GridBagConstraints();
		gbc_txtNumber1.insets = new Insets(0, 0, 5, 5);
		gbc_txtNumber1.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtNumber1.gridx = 1;
		gbc_txtNumber1.gridy = 0;
		frame.getContentPane().add(txtNumber1, gbc_txtNumber1);
		txtNumber1.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("N\u00FAmero 2");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 1;
		frame.getContentPane().add(lblNewLabel_1, gbc_lblNewLabel_1);

		txtNumber2 = new JTextField();
		GridBagConstraints gbc_txtNumber2 = new GridBagConstraints();
		gbc_txtNumber2.insets = new Insets(0, 0, 5, 5);
		gbc_txtNumber2.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtNumber2.gridx = 1;
		gbc_txtNumber2.gridy = 1;
		frame.getContentPane().add(txtNumber2, gbc_txtNumber2);
		txtNumber2.setColumns(10);

		JLabel lblNewLabel_2 = new JLabel("Operaci\u00F3n");
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 0;
		gbc_lblNewLabel_2.gridy = 2;
		frame.getContentPane().add(lblNewLabel_2, gbc_lblNewLabel_2);

		cbxOperation = new JComboBox();
		cbxOperation.setModel(new DefaultComboBoxModel(new String[] { "Sumar", "Restar", "Multiplicar", "Dividir" }));
		GridBagConstraints gbc_cbxOperation = new GridBagConstraints();
		gbc_cbxOperation.insets = new Insets(0, 0, 5, 5);
		gbc_cbxOperation.fill = GridBagConstraints.HORIZONTAL;
		gbc_cbxOperation.gridx = 1;
		gbc_cbxOperation.gridy = 2;
		frame.getContentPane().add(cbxOperation, gbc_cbxOperation);

		lblResult = new JLabel("0");
		GridBagConstraints gbc_lblResult = new GridBagConstraints();
		gbc_lblResult.insets = new Insets(0, 0, 5, 5);
		gbc_lblResult.gridx = 1;
		gbc_lblResult.gridy = 3;
		frame.getContentPane().add(lblResult, gbc_lblResult);

		JButton btnCalculate = new JButton("Calcular");
		btnCalculate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				String n1 = txtNumber1.getText();
				String n2 = txtNumber2.getText();
				float num1 = Float.parseFloat(n1);
				float num2 = Float.parseFloat(n2);
				float result;

				if (n2.isEmpty() || n1.isEmpty() ) {
					lblResult.setText("Erro: tes que encher os números:");
					return;
				}
				
				/*// mellor a primeira opción e só a primeira opcion
				if (cbxOperation.getSelectedItem().equals("Sumar") || cbxOperation.getSelectedIndex() == 0) {
					result = num1 + num2;
					lblResult.setText(result + "");

				} else if (cbxOperation.getSelectedItem().equals("Restar") || cbxOperation.getSelectedIndex() == 1) {
					result = num1 - num2;
					lblResult.setText(result + "");

				} else if (cbxOperation.getSelectedItem().equals("Multiplicar")  || cbxOperation.getSelectedIndex() == 2) {
					result = num1 * num2;
					lblResult.setText(result + "");

				} else if (cbxOperation.getSelectedItem() .equals("dividid") || cbxOperation.getSelectedIndex() == 3) {
					result = num1 / num2;
					lblResult.setText(result + "");

				} else {
					lblResult.setText("Erro na operación");

				}*/
				
				
				// MELLOR USAR UN ENUMERADO
				
				if (cbxOperation.getSelectedIndex() == OPERATIONS.SUMAR.value) {
					result = num1 + num2;
					lblResult.setText(result + "");

				}else if (cbxOperation.getSelectedIndex() == OPERATIONS.RESTAR.value) {
					result = num1 - num2;
					lblResult.setText(result + "");

				} else if ( cbxOperation.getSelectedIndex() == OPERATIONS.MULTIPLICAR.value) {
					result = num1 * num2;
					lblResult.setText(result + "");

				} else if (cbxOperation.getSelectedIndex() == OPERATIONS.DIVIDIR.value) {
					result = num1 / num2;
					lblResult.setText(result + "");

				} else {
					lblResult.setText("Erro na operación");

				}

			}
		});
		GridBagConstraints gbc_btnCalculate = new GridBagConstraints();
		gbc_btnCalculate.insets = new Insets(0, 0, 5, 5);
		gbc_btnCalculate.gridx = 0;
		gbc_btnCalculate.gridy = 4;
		frame.getContentPane().add(btnCalculate, gbc_btnCalculate);

		JButton btnReset = new JButton("Borrar");
		btnReset.setHorizontalAlignment(SwingConstants.RIGHT);
		GridBagConstraints gbc_btnReset = new GridBagConstraints();
		gbc_btnReset.insets = new Insets(0, 0, 5, 5);
		gbc_btnReset.gridx = 1;
		gbc_btnReset.gridy = 4;
		frame.getContentPane().add(btnReset, gbc_btnReset);
	}

	public JComboBox getCbxOperation() {
		return cbxOperation;
	}

	public JLabel getLblResult() {
		return lblResult;
	}
}
