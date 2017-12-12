package t12_conversor_maiusculas_ClienteServidor;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.awt.event.ActionEvent;

public class Cliente_angel {

	private JFrame frame;
	private JTextField txtIP;
	private JTextField txtPuerto;
	private JTextField txtFrase;
	private JButton btnEnviar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Cliente_angel window = new Cliente_angel();
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
	public Cliente_angel() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 305, 177);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		frame.getContentPane().setLayout(gridBagLayout);
		
		JLabel lblNewLabel = new JLabel("IP:");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(10, 0, 5, 5);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		frame.getContentPane().add(lblNewLabel, gbc_lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Puerto:");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.insets = new Insets(10, 0, 5, 0);
		gbc_lblNewLabel_1.gridx = 1;
		gbc_lblNewLabel_1.gridy = 0;
		frame.getContentPane().add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		txtIP = new JTextField();
		txtIP.setText("localhost");
		GridBagConstraints gbc_txtIP = new GridBagConstraints();
		gbc_txtIP.insets = new Insets(0, 0, 5, 5);
		gbc_txtIP.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtIP.gridx = 0;
		gbc_txtIP.gridy = 1;
		frame.getContentPane().add(txtIP, gbc_txtIP);
		txtIP.setColumns(10);
		
		txtPuerto = new JTextField();
		txtPuerto.setText("4444");
		GridBagConstraints gbc_txtPuerto = new GridBagConstraints();
		gbc_txtPuerto.insets = new Insets(0, 0, 5, 0);
		gbc_txtPuerto.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtPuerto.gridx = 1;
		gbc_txtPuerto.gridy = 1;
		frame.getContentPane().add(txtPuerto, gbc_txtPuerto);
		txtPuerto.setColumns(10);
		
		txtFrase = new JTextField();
		txtFrase.setText("hola");
		GridBagConstraints gbc_txtFrase = new GridBagConstraints();
		gbc_txtFrase.gridwidth = 2;
		gbc_txtFrase.insets = new Insets(0, 0, 5, 0);
		gbc_txtFrase.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtFrase.gridx = 0;
		gbc_txtFrase.gridy = 3;
		frame.getContentPane().add(txtFrase, gbc_txtFrase);
		txtFrase.setColumns(10);
		
		btnEnviar = new JButton("Enviar");
		btnEnviar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				enviar();
			}
		});
		GridBagConstraints gbc_btnEnviar = new GridBagConstraints();
		gbc_btnEnviar.anchor = GridBagConstraints.EAST;
		gbc_btnEnviar.gridx = 1;
		gbc_btnEnviar.gridy = 4;
		frame.getContentPane().add(btnEnviar, gbc_btnEnviar);
	}
	
	private void enviar() {
		PrintWriter salida = null;
		BufferedReader entrada = null;
		Socket sc = null;
		//TODO faltan las validaciones
		String ip = txtIP.getText();
		int puerto = Integer.parseInt( txtPuerto.getText() );
		try {
			// Establecer la conexión con un socket(TCP) al servidor (ip/puerto)
			sc = new Socket(ip, puerto);
			System.out.println("Conexión con el servidor establecida");
			// Abrimos dos canales (entrada/salida) por el cual enviar y recibir la información
			salida = new PrintWriter( sc.getOutputStream() , true );
			entrada = new BufferedReader( 
					new InputStreamReader( sc.getInputStream() ) );
			System.out.println("Canales E/S abiertos");
			// Enviamos por el canal de salida la frase
			salida.println(  txtFrase.getText()  );
			salida.flush();
			System.out.println("Mensaje enviado");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			// Esperamos la respuesta del servidor con la frase en mayusculas
			txtFrase.setText( entrada.readLine()  );
			System.out.println("Mensaje recibido");
			// Cerrar la conexión
			
			
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				salida.close();
				entrada.close();
				//sc.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
