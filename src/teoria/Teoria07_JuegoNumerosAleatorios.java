package teoria;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.security.SecureRandom;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Teoria07_JuegoNumerosAleatorios {

	private JFrame frame;
	private JSpinner spnNumero;

	private int numeroAleatorio;
	private final static int MAX_NUMERO_INTENTOS = 3;
	private int numeroIntentos;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Teoria07_JuegoNumerosAleatorios window = new Teoria07_JuegoNumerosAleatorios();
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
	public Teoria07_JuegoNumerosAleatorios() {
		numeroIntentos = 0;
		numeroAleatorio = generarNumeroAleatorio();
		initialize();
	}
	
	private int generarNumeroAleatorio() {
		final int MAX = 10;
		final int MIN = 0;
		return (int)(Math.random() * (MAX - MIN) + MIN);
	}
	
	private int generaNumerosAleatoriosVer2() {
		SecureRandom sr = new SecureRandom();
		return sr.nextInt(11);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 1.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		frame.getContentPane().setLayout(gridBagLayout);
		
		JLabel lblenQueNumero = new JLabel("\u00BFEn que numero estoy pensando?");
		lblenQueNumero.setFont(new Font("Tahoma", Font.BOLD, 20));
		GridBagConstraints gbc_lblenQueNumero = new GridBagConstraints();
		gbc_lblenQueNumero.gridwidth = 3;
		gbc_lblenQueNumero.insets = new Insets(0, 0, 5, 5);
		gbc_lblenQueNumero.gridx = 0;
		gbc_lblenQueNumero.gridy = 0;
		frame.getContentPane().add(lblenQueNumero, gbc_lblenQueNumero);
		
		JLabel lblNewLabel = new JLabel("Inserta n\u00FAmero:");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 0, 5);
		gbc_lblNewLabel.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 1;
		frame.getContentPane().add(lblNewLabel, gbc_lblNewLabel);
		
		spnNumero = new JSpinner();
		spnNumero.setModel(new SpinnerNumberModel(0, 0, 10, 1));
		GridBagConstraints gbc_spnNumero = new GridBagConstraints();
		gbc_spnNumero.insets = new Insets(0, 0, 0, 5);
		gbc_spnNumero.fill = GridBagConstraints.HORIZONTAL;
		gbc_spnNumero.gridx = 1;
		gbc_spnNumero.gridy = 1;
		frame.getContentPane().add(spnNumero, gbc_spnNumero);
		
		JButton btnProbar = new JButton("Probar");
		btnProbar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int numero = (Integer)spnNumero.getValue();
				if (numero == numeroAleatorio) {
					JOptionPane.showMessageDialog(frame, "HAS ACERTADO");
				}else {
					numeroIntentos++;
					if(numeroIntentos == 3) {
						System.exit(0);
					}else{
						JOptionPane.showMessageDialog(frame, "HAS FALLADO  VUELVE A INTENTARLO");
						
					}
				}
			}
		});
		
		GridBagConstraints gbc_btnProbar = new GridBagConstraints();
		gbc_btnProbar.gridx = 2;
		gbc_btnProbar.gridy = 1;
		frame.getContentPane().add(btnProbar, gbc_btnProbar);
	}

}
