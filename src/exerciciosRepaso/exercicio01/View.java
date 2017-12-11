package exerciciosRepaso.exercicio01;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/* Aplicación JSwing que suma catro números que se meten por caixas de texto. Tamén ten un botón de limpar*/

public class View {

	private JFrame frame;
	private JTextField textNumber1;
	private JTextField textNumber2;
	private JTextField textNumber3;
	private JTextField textNumber4;
	private JLabel lblResult;
	
	Sumador sumador = new Sumador();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					View window = new View();
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
	public View() {
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
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		frame.getContentPane().setLayout(gridBagLayout);
		
		JLabel lblNmero = new JLabel("N\u00FAmero 1: ");
		GridBagConstraints gbc_lblNmero = new GridBagConstraints();
		gbc_lblNmero.anchor = GridBagConstraints.EAST;
		gbc_lblNmero.insets = new Insets(0, 0, 5, 5);
		gbc_lblNmero.gridx = 0;
		gbc_lblNmero.gridy = 0;
		frame.getContentPane().add(lblNmero, gbc_lblNmero);
		
		textNumber1 = new JTextField();
		GridBagConstraints gbc_textNumber1 = new GridBagConstraints();
		gbc_textNumber1.insets = new Insets(0, 0, 5, 0);
		gbc_textNumber1.fill = GridBagConstraints.HORIZONTAL;
		gbc_textNumber1.gridx = 1;
		gbc_textNumber1.gridy = 0;
		frame.getContentPane().add(textNumber1, gbc_textNumber1);
		textNumber1.setColumns(10);
		
		JLabel lblNmero_1 = new JLabel("N\u00FAmero 2:");
		GridBagConstraints gbc_lblNmero_1 = new GridBagConstraints();
		gbc_lblNmero_1.anchor = GridBagConstraints.EAST;
		gbc_lblNmero_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNmero_1.gridx = 0;
		gbc_lblNmero_1.gridy = 1;
		frame.getContentPane().add(lblNmero_1, gbc_lblNmero_1);
		
		textNumber2 = new JTextField();
		GridBagConstraints gbc_textNumber2 = new GridBagConstraints();
		gbc_textNumber2.insets = new Insets(0, 0, 5, 0);
		gbc_textNumber2.fill = GridBagConstraints.HORIZONTAL;
		gbc_textNumber2.gridx = 1;
		gbc_textNumber2.gridy = 1;
		frame.getContentPane().add(textNumber2, gbc_textNumber2);
		textNumber2.setColumns(10);
		
		JLabel lblNmero_2 = new JLabel("N\u00FAmero 3:");
		GridBagConstraints gbc_lblNmero_2 = new GridBagConstraints();
		gbc_lblNmero_2.anchor = GridBagConstraints.EAST;
		gbc_lblNmero_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNmero_2.gridx = 0;
		gbc_lblNmero_2.gridy = 2;
		frame.getContentPane().add(lblNmero_2, gbc_lblNmero_2);
		
		textNumber3 = new JTextField();
		GridBagConstraints gbc_textNumber3 = new GridBagConstraints();
		gbc_textNumber3.insets = new Insets(0, 0, 5, 0);
		gbc_textNumber3.fill = GridBagConstraints.HORIZONTAL;
		gbc_textNumber3.gridx = 1;
		gbc_textNumber3.gridy = 2;
		frame.getContentPane().add(textNumber3, gbc_textNumber3);
		textNumber3.setColumns(10);
		
		JLabel lblNmero_3 = new JLabel("N\u00FAmero 4:");
		GridBagConstraints gbc_lblNmero_3 = new GridBagConstraints();
		gbc_lblNmero_3.anchor = GridBagConstraints.EAST;
		gbc_lblNmero_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblNmero_3.gridx = 0;
		gbc_lblNmero_3.gridy = 3;
		frame.getContentPane().add(lblNmero_3, gbc_lblNmero_3);
		
		textNumber4 = new JTextField();
		GridBagConstraints gbc_textNumber4 = new GridBagConstraints();
		gbc_textNumber4.anchor = GridBagConstraints.EAST;
		gbc_textNumber4.insets = new Insets(0, 0, 5, 0);
		gbc_textNumber4.gridx = 1;
		gbc_textNumber4.gridy = 3;
		frame.getContentPane().add(textNumber4, gbc_textNumber4);
		textNumber4.setColumns(10);
		
		JButton btnCalculate = new JButton("Calcular");
		btnCalculate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				float num1 = Float.parseFloat(textNumber1.getText());
				float num2 = Float.parseFloat(textNumber2.getText());
				float num3 = Float.parseFloat(textNumber3.getText());
				float num4 = Float.parseFloat(textNumber4.getText());
				
				lblResult.setText(sumador.sumarNumero(num1, num2, num3, num4)+ "");
			}
		});
		GridBagConstraints gbc_btnCalculate = new GridBagConstraints();
		gbc_btnCalculate.insets = new Insets(0, 0, 5, 5);
		gbc_btnCalculate.gridx = 0;
		gbc_btnCalculate.gridy = 4;
		frame.getContentPane().add(btnCalculate, gbc_btnCalculate);
		
		JButton btnClean = new JButton("Limpar");
		btnClean.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textNumber1.setText("");
				textNumber2.setText("");
				textNumber3.setText("");
				textNumber4.setText("");
				lblResult.setText("-");
			}
		});
		GridBagConstraints gbc_btnClean = new GridBagConstraints();
		gbc_btnClean.anchor = GridBagConstraints.EAST;
		gbc_btnClean.insets = new Insets(0, 0, 5, 0);
		gbc_btnClean.gridx = 1;
		gbc_btnClean.gridy = 4;
		frame.getContentPane().add(btnClean, gbc_btnClean);
		
		lblResult = new JLabel("-");
		GridBagConstraints gbc_lblResult = new GridBagConstraints();
		gbc_lblResult.anchor = GridBagConstraints.EAST;
		gbc_lblResult.gridx = 1;
		gbc_lblResult.gridy = 5;
		frame.getContentPane().add(lblResult, gbc_lblResult);
	}
	public JLabel getLblResult() {
		return lblResult;
	}
}
