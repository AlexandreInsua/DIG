package teoria19GenerarAleatorioLOG;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.GridBagLayout;
import javax.swing.JTextField;
import java.awt.GridBagConstraints;
import javax.swing.JLabel;
import java.awt.Insets;
import java.util.logging.Logger;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Principal {

	public final static Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
	
	private JFrame frame;
	private JTextField txtNumero;
	private int contador = 0;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal window = new Principal();
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
	public Principal() {
		initialize();
		MiLogPersonalizado.configurar();
		LOGGER.info("Aplicación iniciada.");
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 262, 130);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		frame.getContentPane().setLayout(gridBagLayout);
		
		JLabel lblNewLabel = new JLabel("Numero aleatorio");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 20, 5, 5);
		gbc_lblNewLabel.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		frame.getContentPane().add(lblNewLabel, gbc_lblNewLabel);
		
		txtNumero = new JTextField();
		GridBagConstraints gbc_txtNumero = new GridBagConstraints();
		gbc_txtNumero.insets = new Insets(20, 0, 5, 20);
		gbc_txtNumero.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtNumero.gridx = 1;
		gbc_txtNumero.gridy = 0;
		frame.getContentPane().add(txtNumero, gbc_txtNumero);
		txtNumero.setColumns(10);
		
		JButton btnGenerar = new JButton("Generar n\u00FAmero aleatorio");
		btnGenerar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int numeroAleatorio = Math.round( (float)Math.random() * 1000f );
				txtNumero.setText(numeroAleatorio + "");
				if(numeroAleatorio <=0 || numeroAleatorio >=100) {
					LOGGER.warning("Peligro el numero no esta entre 0 y 100: "+numeroAleatorio);
				}else {
					LOGGER.info("Se genero un nuevo numero aleatorio "+numeroAleatorio);
				}
				
				if(contador == 5) {
					LOGGER.severe("Exceso de peticiones de número aleatorio.");
				}
				contador++;
			
			}
		});
		GridBagConstraints gbc_btnGenerar = new GridBagConstraints();
		gbc_btnGenerar.gridwidth = 2;
		gbc_btnGenerar.insets = new Insets(0, 0, 0, 20);
		gbc_btnGenerar.gridx = 0;
		gbc_btnGenerar.gridy = 1;
		frame.getContentPane().add(btnGenerar, gbc_btnGenerar);
	}

}
