package XogoNumero;

/*
 * Xera un número do 1 ao 10 e pregúntalle ao usuario para que o adiviñe. Ten tres oportunidades. Se acerta, lanza un popup de felicitación e senón, pecha o aplicativos.
 */

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.GridLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

public class XogoNumero {
	final static int MAX =10;
	final static int MIN = 0;
	private final static int NUMBER = (int) Math.random()*(MAX-MIN+MAX); // Random *(max-min)+min
	private  final static int INTENTS_MAX_NUM=3;
	private int intents=0;
	
	private JFrame frame;
	private JTextField textUserNumber;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
	
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					XogoNumero window = new XogoNumero();
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
	public XogoNumero() {
		
		
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
		gridBagLayout.columnWidths = new int[]{434, 0};
		gridBagLayout.rowHeights = new int[]{87, 87, 87, 0};
		gridBagLayout.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		frame.getContentPane().setLayout(gridBagLayout);
		
		JLabel lblEnQueNmero = new JLabel("En que n\u00FAmero estou pensando?");
		GridBagConstraints gbc_lblEnQueNmero = new GridBagConstraints();
		gbc_lblEnQueNmero.fill = GridBagConstraints.BOTH;
		gbc_lblEnQueNmero.insets = new Insets(0, 0, 5, 0);
		gbc_lblEnQueNmero.gridx = 0;
		gbc_lblEnQueNmero.gridy = 0;
		frame.getContentPane().add(lblEnQueNmero, gbc_lblEnQueNmero);
		lblEnQueNmero.setHorizontalAlignment(SwingConstants.CENTER);
		lblEnQueNmero.setFont(new Font("Verdana", Font.BOLD, 20));
		
		textUserNumber = new JTextField();
		GridBagConstraints gbc_textUserNumber = new GridBagConstraints();
		gbc_textUserNumber.fill = GridBagConstraints.BOTH;
		gbc_textUserNumber.insets = new Insets(0, 0, 5, 0);
		gbc_textUserNumber.gridx = 0;
		gbc_textUserNumber.gridy = 1;
		frame.getContentPane().add(textUserNumber, gbc_textUserNumber);
		textUserNumber.setHorizontalAlignment(SwingConstants.CENTER);
		textUserNumber.setColumns(10);
		
		JButton btnButton = new JButton("Enviar");
		GridBagConstraints gbc_btnButton = new GridBagConstraints();
		gbc_btnButton.fill = GridBagConstraints.BOTH;
		gbc_btnButton.gridx = 0;
		gbc_btnButton.gridy = 2;
		frame.getContentPane().add(btnButton, gbc_btnButton);
		btnButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent arg0) {
				String optionText = textUserNumber.getText();
				int option = Integer.parseInt(optionText);
				while (intents<INTENTS_MAX_NUM) {
					if (option==NUMBER) {
						JOptionPane.showMessageDialog(lblEnQueNmero, "Felicidades, Acertaches!!!!");
						break;
					} else {
						JOptionPane.showMessageDialog(lblEnQueNmero, "Tes outro intento");
						textUserNumber.setText("");
					}
					intents++;
				}
				lblEnQueNmero.setText("LOOSER!!!");
				System.exit(0);
			}
		});
	}


}
