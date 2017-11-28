package teoria;

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

public class Teoria01_sumar3Numeros {

	private JFrame frame;
	private JTextField txtNum1;
	private JTextField txtNum2;
	private JTextField txtNum3;
	private JLabel lblResultado;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Teoria01_sumar3Numeros window = new Teoria01_sumar3Numeros();
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
	public Teoria01_sumar3Numeros() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		frame.getContentPane().setLayout(gridBagLayout);
		
		JLabel lblNewLabel = new JLabel("Número1");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		frame.getContentPane().add(lblNewLabel, gbc_lblNewLabel);
		
		txtNum1 = new JTextField();
		GridBagConstraints gbc_txtNum1 = new GridBagConstraints();
		gbc_txtNum1.insets = new Insets(0, 0, 5, 0);
		gbc_txtNum1.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtNum1.gridx = 1;
		gbc_txtNum1.gridy = 0;
		frame.getContentPane().add(txtNum1, gbc_txtNum1);
		txtNum1.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Número2");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 1;
		frame.getContentPane().add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		txtNum2 = new JTextField();
		GridBagConstraints gbc_txtNum2 = new GridBagConstraints();
		gbc_txtNum2.insets = new Insets(0, 0, 5, 0);
		gbc_txtNum2.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtNum2.gridx = 1;
		gbc_txtNum2.gridy = 1;
		frame.getContentPane().add(txtNum2, gbc_txtNum2);
		txtNum2.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Número3");
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 0;
		gbc_lblNewLabel_2.gridy = 2;
		frame.getContentPane().add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		txtNum3 = new JTextField();
		GridBagConstraints gbc_txtNum3 = new GridBagConstraints();
		gbc_txtNum3.insets = new Insets(0, 0, 5, 0);
		gbc_txtNum3.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtNum3.gridx = 1;
		gbc_txtNum3.gridy = 2;
		frame.getContentPane().add(txtNum3, gbc_txtNum3);
		txtNum3.setColumns(10);
		
		JButton btnSumar = new JButton("SUMAR");
		btnSumar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String numero1 = txtNum1.getText();
				String numero2 = txtNum2.getText();
				String numero3 = txtNum3.getText();
				
				try {
					float n1 = Float.parseFloat(numero1);
					float n2 = Float.parseFloat(numero2);
					float n3 = Float.parseFloat(numero3);
					
					float resultado = n1 + n2 + n3;

					lblResultado.setText( resultado + "" );
					
				}catch(NumberFormatException ex) {
					lblResultado.setText(  "Error"  );
				}
			}
		});
		GridBagConstraints gbc_btnSumar = new GridBagConstraints();
		gbc_btnSumar.insets = new Insets(0, 0, 5, 0);
		gbc_btnSumar.gridx = 1;
		gbc_btnSumar.gridy = 3;
		frame.getContentPane().add(btnSumar, gbc_btnSumar);
		
		lblResultado = new JLabel("0");
		GridBagConstraints gbc_lblResultado = new GridBagConstraints();
		gbc_lblResultado.gridx = 1;
		gbc_lblResultado.gridy = 4;
		frame.getContentPane().add(lblResultado, gbc_lblResultado);
	}

	public JLabel getLblResultado() {
		return lblResultado;
	}
}
