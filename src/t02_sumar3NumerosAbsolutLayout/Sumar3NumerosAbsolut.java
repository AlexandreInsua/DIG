package t02_sumar3NumerosAbsolutLayout;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.SwingConstants;
import java.awt.Color;

public class Sumar3NumerosAbsolut {

	private JFrame frame;
	private JTextField txtNum01;
	private JTextField txtNum02;
	private JTextField txtNum03;
	private JLabel lblResult;
	private JButton btnClean;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Sumar3NumerosAbsolut window = new Sumar3NumerosAbsolut();
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
	public Sumar3NumerosAbsolut() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setForeground(Color.RED);
		frame.getContentPane().setBackground(Color.BLACK);
		frame.setResizable(false);
		frame.setBounds(100, 100, 290, 229);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("N\u00FAmero 1");
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setBounds(10, 14, 93, 14);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("N\u00FAmero 2");
		lblNewLabel_1.setForeground(Color.RED);
		lblNewLabel_1.setBounds(10, 53, 93, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("N\u00FAmero 3");
		lblNewLabel_2.setForeground(Color.RED);
		lblNewLabel_2.setBounds(10, 85, 93, 14);
		frame.getContentPane().add(lblNewLabel_2);
		
		txtNum01 = new JTextField();
		txtNum01.setForeground(Color.BLACK);
		txtNum01.setHorizontalAlignment(SwingConstants.RIGHT);
		txtNum01.setBounds(113, 14, 86, 20);
		frame.getContentPane().add(txtNum01);
		txtNum01.setColumns(10);
		
		txtNum02 = new JTextField();
		txtNum02.setForeground(Color.BLACK);
		txtNum02.setHorizontalAlignment(SwingConstants.RIGHT);
		txtNum02.setBounds(113, 53, 86, 20);
		frame.getContentPane().add(txtNum02);
		txtNum02.setColumns(10);
		
		txtNum03 = new JTextField();
		txtNum03.setForeground(Color.BLACK);
		txtNum03.setHorizontalAlignment(SwingConstants.RIGHT);
		txtNum03.setBounds(113, 85, 86, 20);
		frame.getContentPane().add(txtNum03);
		txtNum03.setColumns(10);
		
		JButton btnToSum = new JButton("Sumar");
		btnToSum.setBackground(Color.BLACK);
		btnToSum.setForeground(Color.BLACK);
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
		btnToSum.setBounds(10, 123, 93, 23);
		frame.getContentPane().add(btnToSum);
		
		lblResult = new JLabel("--");
		lblResult.setHorizontalAlignment(SwingConstants.RIGHT);
		lblResult.setBounds(123, 127, 46, 14);
		frame.getContentPane().add(lblResult);
		
		btnClean = new JButton("Limpar");
		btnClean.setForeground(Color.BLACK);
		btnClean.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				txtNum01.setText("");
				txtNum02.setText("");
				txtNum03.setText("");
				lblResult.setText("-");
			}
		});
		btnClean.setBounds(14, 157, 89, 23);
		frame.getContentPane().add(btnClean);
	}
	public JLabel getLblResult() {
		return lblResult;
	}
}
