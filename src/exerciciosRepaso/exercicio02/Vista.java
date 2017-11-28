package exerciciosRepaso.exercicio02;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class Vista {

	private JFrame frmSumador;
	private JTextField textNum1;
	private JTextField textNum2;
	private JTextField textNum3;
	private JTextField textNum4;
	private JTextField textResultado;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Vista window = new Vista();
					window.frmSumador.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Vista() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmSumador = new JFrame();
		frmSumador.setTitle("Sumador\r\n");
		frmSumador.setBounds(100, 100, 307, 300);
		frmSumador.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 0, 0, 0 };
		gridBagLayout.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0 };
		gridBagLayout.columnWeights = new double[] { 0.0, 0.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		frmSumador.getContentPane().setLayout(gridBagLayout);

		JLabel lblNmero = new JLabel("N\u00FAmero 1");
		GridBagConstraints gbc_lblNmero = new GridBagConstraints();
		gbc_lblNmero.anchor = GridBagConstraints.EAST;
		gbc_lblNmero.insets = new Insets(0, 0, 5, 5);
		gbc_lblNmero.gridx = 0;
		gbc_lblNmero.gridy = 1;
		frmSumador.getContentPane().add(lblNmero, gbc_lblNmero);

		textNum1 = new JTextField();
		textNum1.setHorizontalAlignment(SwingConstants.RIGHT);
		GridBagConstraints gbc_textNum1 = new GridBagConstraints();
		gbc_textNum1.insets = new Insets(0, 0, 5, 0);
		gbc_textNum1.gridx = 1;
		gbc_textNum1.gridy = 1;
		frmSumador.getContentPane().add(textNum1, gbc_textNum1);
		textNum1.setColumns(10);

		JLabel lblNmero_1 = new JLabel("N\u00FAmero 2");
		GridBagConstraints gbc_lblNmero_1 = new GridBagConstraints();
		gbc_lblNmero_1.anchor = GridBagConstraints.EAST;
		gbc_lblNmero_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNmero_1.gridx = 0;
		gbc_lblNmero_1.gridy = 2;
		frmSumador.getContentPane().add(lblNmero_1, gbc_lblNmero_1);

		textNum2 = new JTextField();
		textNum2.setHorizontalAlignment(SwingConstants.RIGHT);
		GridBagConstraints gbc_textNum2 = new GridBagConstraints();
		gbc_textNum2.insets = new Insets(0, 0, 5, 0);
		gbc_textNum2.fill = GridBagConstraints.HORIZONTAL;
		gbc_textNum2.gridx = 1;
		gbc_textNum2.gridy = 2;
		frmSumador.getContentPane().add(textNum2, gbc_textNum2);
		textNum2.setColumns(10);

		JLabel lblNmero_2 = new JLabel("N\u00FAmero 3");
		GridBagConstraints gbc_lblNmero_2 = new GridBagConstraints();
		gbc_lblNmero_2.anchor = GridBagConstraints.EAST;
		gbc_lblNmero_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNmero_2.gridx = 0;
		gbc_lblNmero_2.gridy = 3;
		frmSumador.getContentPane().add(lblNmero_2, gbc_lblNmero_2);

		textNum3 = new JTextField();
		textNum3.setHorizontalAlignment(SwingConstants.RIGHT);
		textNum3.setText("");
		GridBagConstraints gbc_textNum3 = new GridBagConstraints();
		gbc_textNum3.insets = new Insets(0, 0, 5, 0);
		gbc_textNum3.fill = GridBagConstraints.HORIZONTAL;
		gbc_textNum3.gridx = 1;
		gbc_textNum3.gridy = 3;
		frmSumador.getContentPane().add(textNum3, gbc_textNum3);
		textNum3.setColumns(10);

		JLabel lblNmero_3 = new JLabel("N\u00FAmero 4");
		GridBagConstraints gbc_lblNmero_3 = new GridBagConstraints();
		gbc_lblNmero_3.anchor = GridBagConstraints.EAST;
		gbc_lblNmero_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblNmero_3.gridx = 0;
		gbc_lblNmero_3.gridy = 4;
		frmSumador.getContentPane().add(lblNmero_3, gbc_lblNmero_3);

		textNum4 = new JTextField();
		textNum4.setHorizontalAlignment(SwingConstants.RIGHT);
		GridBagConstraints gbc_textNum4 = new GridBagConstraints();
		gbc_textNum4.insets = new Insets(0, 0, 5, 0);
		gbc_textNum4.fill = GridBagConstraints.HORIZONTAL;
		gbc_textNum4.gridx = 1;
		gbc_textNum4.gridy = 4;
		frmSumador.getContentPane().add(textNum4, gbc_textNum4);
		textNum4.setColumns(10);

		JButton btnClean = new JButton("Limpar");
		btnClean.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textNum1.setText("");
				textNum2.setText("");
				textNum3.setText("");
				textNum4.setText("");
				textResultado.setText("");
			}
		});
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Seleccione operaci\u00F3n:", "Suma", "Resta", "Multiplicaci\u00F3n", "Divisi\u00F3n"}));
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				float num1 = Float.parseFloat(textNum1.getText());
				float num2 = Float.parseFloat(textNum2.getText());
				float num3 = Float.parseFloat(textNum3.getText());
				float num4 = Float.parseFloat(textNum4.getText());
				
				int option = comboBox.getSelectedIndex();
				
				textResultado.setText(Calculador.calcularNumeros(option, num1, num2, num3, num4)+" ");
				
			}
		});
		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.anchor = GridBagConstraints.EAST;
		gbc_comboBox.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox.gridx = 0;
		gbc_comboBox.gridy = 5;
		frmSumador.getContentPane().add(comboBox, gbc_comboBox);
		GridBagConstraints gbc_btnClean = new GridBagConstraints();
		gbc_btnClean.insets = new Insets(0, 0, 5, 0);
		gbc_btnClean.gridx = 1;
		gbc_btnClean.gridy = 5;
		frmSumador.getContentPane().add(btnClean, gbc_btnClean);

		JLabel lblResultado = new JLabel("Resultado");
		GridBagConstraints gbc_lblResultado = new GridBagConstraints();
		gbc_lblResultado.anchor = GridBagConstraints.EAST;
		gbc_lblResultado.insets = new Insets(0, 0, 0, 5);
		gbc_lblResultado.gridx = 0;
		gbc_lblResultado.gridy = 6;
		frmSumador.getContentPane().add(lblResultado, gbc_lblResultado);

		textResultado = new JTextField();
		textResultado.setHorizontalAlignment(SwingConstants.RIGHT);
		textResultado.setEditable(false);
		GridBagConstraints gbc_textResultado = new GridBagConstraints();
		gbc_textResultado.gridx = 1;
		gbc_textResultado.gridy = 6;
		frmSumador.getContentPane().add(textResultado, gbc_textResultado);
		textResultado.setColumns(10);
	}

}
