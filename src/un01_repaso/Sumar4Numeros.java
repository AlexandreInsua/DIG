package un01_repaso;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Sumar4Numeros {

	private JFrame frame;
	private JTextField txtN1;
	private JTextField txtN2;
	private JTextField txtN3;
	private JTextField txtN4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Sumar4Numeros window = new Sumar4Numeros();
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
	public Sumar4Numeros() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 241, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		txtN1 = new JTextField();
		txtN1.setBounds(10, 25, 86, 20);
		frame.getContentPane().add(txtN1);
		txtN1.setColumns(10);
		
		txtN2 = new JTextField();
		txtN2.setBounds(124, 25, 86, 20);
		frame.getContentPane().add(txtN2);
		txtN2.setColumns(10);
		
		txtN3 = new JTextField();
		txtN3.setBounds(10, 56, 86, 20);
		frame.getContentPane().add(txtN3);
		txtN3.setColumns(10);
		
		txtN4 = new JTextField();
		txtN4.setBounds(124, 56, 86, 20);
		frame.getContentPane().add(txtN4);
		txtN4.setColumns(10);
		
		JLabel lblResult = new JLabel("-");
		lblResult.setHorizontalAlignment(SwingConstants.CENTER);
		lblResult.setBounds(85, 87, 46, 14);
		frame.getContentPane().add(lblResult);
		
		JButton btnToSum = new JButton("Sumar");
		btnToSum.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent arg0) {
				float n1 = Float.parseFloat(txtN1.getText());
				float n2 = Float.parseFloat(txtN2.getText());
				float n3 = Float.parseFloat(txtN3.getText());
				float n4 = Float.parseFloat(txtN4.getText());
				
				float result = n1+ n2 + n3 +n4;
				
				lblResult.setText(result + "");
			}
		});
		btnToSum.setBounds(70, 123, 89, 23);
		frame.getContentPane().add(btnToSum);
	}
	public JTextField getTxtN1() {
		return txtN1;
	}
	public JTextField getTxtN3() {
		return txtN3;
	}
	public JTextField getTxtN2() {
		return txtN2;
	}
	public JTextField getTxtN4() {
		return txtN4;
	}
}
