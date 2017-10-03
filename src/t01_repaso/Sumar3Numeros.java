package t01_repaso;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Sumar3Numeros {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField txtNum01;
	private JTextField txtNum02;
	private JTextField txtNum03;
	private JLabel lblResult;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Sumar3Numeros window = new Sumar3Numeros();
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
	public Sumar3Numeros() {
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
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 1.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		frame.getContentPane().setLayout(gridBagLayout);
		
		JLabel lblNum01 = new JLabel("N\u00FAmero 1");
		GridBagConstraints gbc_lblNum01 = new GridBagConstraints();
		gbc_lblNum01.anchor = GridBagConstraints.EAST;
		gbc_lblNum01.insets = new Insets(0, 0, 5, 5);
		gbc_lblNum01.gridx = 0;
		gbc_lblNum01.gridy = 0;
		frame.getContentPane().add(lblNum01, gbc_lblNum01);
		
		textField = new JTextField();
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.insets = new Insets(0, 0, 5, 5);
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 1;
		gbc_textField.gridy = 0;
		frame.getContentPane().add(textField, gbc_textField);
		textField.setColumns(10);
		
		txtNum01 = new JTextField();
		GridBagConstraints gbc_txtNum01 = new GridBagConstraints();
		gbc_txtNum01.insets = new Insets(0, 0, 5, 5);
		gbc_txtNum01.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtNum01.gridx = 2;
		gbc_txtNum01.gridy = 0;
		frame.getContentPane().add(txtNum01, gbc_txtNum01);
		txtNum01.setColumns(10);
		
		JLabel lblNum02 = new JLabel("N\u00FAmero 2");
		GridBagConstraints gbc_lblNum02 = new GridBagConstraints();
		gbc_lblNum02.anchor = GridBagConstraints.EAST;
		gbc_lblNum02.insets = new Insets(0, 0, 5, 5);
		gbc_lblNum02.gridx = 0;
		gbc_lblNum02.gridy = 1;
		frame.getContentPane().add(lblNum02, gbc_lblNum02);
		
		textField_1 = new JTextField();
		GridBagConstraints gbc_textField_1 = new GridBagConstraints();
		gbc_textField_1.insets = new Insets(0, 0, 5, 5);
		gbc_textField_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_1.gridx = 1;
		gbc_textField_1.gridy = 1;
		frame.getContentPane().add(textField_1, gbc_textField_1);
		textField_1.setColumns(10);
		
		txtNum02 = new JTextField();
		GridBagConstraints gbc_txtNum02 = new GridBagConstraints();
		gbc_txtNum02.insets = new Insets(0, 0, 5, 5);
		gbc_txtNum02.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtNum02.gridx = 2;
		gbc_txtNum02.gridy = 1;
		frame.getContentPane().add(txtNum02, gbc_txtNum02);
		txtNum02.setColumns(10);
		
		JLabel lblNum03 = new JLabel("N\u00FAmero 3");
		GridBagConstraints gbc_lblNum03 = new GridBagConstraints();
		gbc_lblNum03.anchor = GridBagConstraints.EAST;
		gbc_lblNum03.insets = new Insets(0, 0, 5, 5);
		gbc_lblNum03.gridx = 0;
		gbc_lblNum03.gridy = 2;
		frame.getContentPane().add(lblNum03, gbc_lblNum03);
		
		textField_2 = new JTextField();
		GridBagConstraints gbc_textField_2 = new GridBagConstraints();
		gbc_textField_2.insets = new Insets(0, 0, 5, 5);
		gbc_textField_2.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_2.gridx = 1;
		gbc_textField_2.gridy = 2;
		frame.getContentPane().add(textField_2, gbc_textField_2);
		textField_2.setColumns(10);
		
		txtNum03 = new JTextField();
		GridBagConstraints gbc_txtNum03 = new GridBagConstraints();
		gbc_txtNum03.insets = new Insets(0, 0, 5, 5);
		gbc_txtNum03.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtNum03.gridx = 2;
		gbc_txtNum03.gridy = 2;
		frame.getContentPane().add(txtNum03, gbc_txtNum03);
		txtNum03.setColumns(10);
		
		JButton btnToSum = new JButton("Sumar");
		btnToSum.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				try  {
					float n1 = Float.parseFloat( txtNum01.getText());
					float n2 = Float.parseFloat(txtNum02.getText());
					float n3 = Float.parseFloat(txtNum03.getText());
					Float result = n1+n2+n3;
					lblResult.setText(result+"");	}
						catch (NumberFormatException ex){
							lblResult.setText("Erro medio grave");
						
						
						}
			}
		});
		GridBagConstraints gbc_btnToSum = new GridBagConstraints();
		gbc_btnToSum.insets = new Insets(0, 0, 5, 5);
		gbc_btnToSum.gridx = 0;
		gbc_btnToSum.gridy = 3;
		frame.getContentPane().add(btnToSum, gbc_btnToSum);
		
		lblResult = new JLabel("New label");
		GridBagConstraints gbc_lblResult = new GridBagConstraints();
		gbc_lblResult.insets = new Insets(0, 0, 5, 5);
		gbc_lblResult.gridx = 2;
		gbc_lblResult.gridy = 3;
		frame.getContentPane().add(lblResult, gbc_lblResult);
		
		JButton btnClear = new JButton("Limpar");
		GridBagConstraints gbc_btnClear = new GridBagConstraints();
		gbc_btnClear.insets = new Insets(0, 0, 5, 5);
		gbc_btnClear.gridx = 0;
		gbc_btnClear.gridy = 4;
		frame.getContentPane().add(btnClear, gbc_btnClear);
	}

	public JLabel getLblResult() {
		return lblResult;
	}
}
