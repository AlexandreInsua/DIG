package teoria;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Teoria05_Sumar3NumerosAbsolutos {

	private JFrame frame;
	private JTextField txtNum1;
	private JTextField txtNum2;
	private JTextField txtNum3;
	private JLabel lblResultado;
	private JButton btnLimpiar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Teoria05_Sumar3NumerosAbsolutos window = new Teoria05_Sumar3NumerosAbsolutos();
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
	public Teoria05_Sumar3NumerosAbsolutos() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setBounds(100, 100, 322, 239);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Número1");
		lblNewLabel.setBounds(32, 28, 61, 16);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Número2");
		lblNewLabel_1.setBounds(32, 70, 61, 16);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Número3");
		lblNewLabel_2.setBounds(32, 113, 61, 16);
		frame.getContentPane().add(lblNewLabel_2);
		
		txtNum1 = new JTextField();
		txtNum1.setBounds(105, 23, 130, 26);
		frame.getContentPane().add(txtNum1);
		txtNum1.setColumns(10);
		
		txtNum2 = new JTextField();
		txtNum2.setBounds(105, 65, 130, 26);
		frame.getContentPane().add(txtNum2);
		txtNum2.setColumns(10);
		
		txtNum3 = new JTextField();
		txtNum3.setBounds(105, 108, 130, 26);
		frame.getContentPane().add(txtNum3);
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
		btnSumar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				
			}
		});
		btnSumar.setBounds(80, 161, 117, 29);
		frame.getContentPane().add(btnSumar);
		
		lblResultado = new JLabel("0");
		lblResultado.setBounds(203, 166, 78, 16);
		frame.getContentPane().add(lblResultado);
		
		btnLimpiar = new JButton("Limpiar");
		btnLimpiar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtNum1.setText("");
				txtNum2.setText("");
				txtNum3.setText("");
				lblResultado.setText("0");
			}
		});
		btnLimpiar.setBounds(244, 65, 72, 29);
		frame.getContentPane().add(btnLimpiar);
	}
	public JLabel getLblResultado() {
		return lblResultado;
	}
}
