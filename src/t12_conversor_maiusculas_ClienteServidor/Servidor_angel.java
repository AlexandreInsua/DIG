package t12_conversor_maiusculas_ClienteServidor;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.DefaultListCellRenderer;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.awt.event.ActionEvent;

public class Servidor_angel implements Runnable {

	private JFrame frame;
	private JTextField txtPuerto;
	private boolean servidorArrancado = false;
	private JList list;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Servidor_angel window = new Servidor_angel();
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
	public Servidor_angel() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.NORTH);
		
		JLabel lblNewLabel = new JLabel("Puerto:");
		panel.add(lblNewLabel);
		
		txtPuerto = new JTextField();
		txtPuerto.setText("4444");
		panel.add(txtPuerto);
		txtPuerto.setColumns(10);
		
		JButton btnArrancar = new JButton("Arrancar Servidor");
		btnArrancar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				arrancar();
			}
		});
		panel.add(btnArrancar);
		
		JButton btnParar = new JButton("Parar servidor");
		btnParar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				parar();
			}
		});
		panel.add(btnParar);
		
		JScrollPane scrollPane = new JScrollPane();
		frame.getContentPane().add(scrollPane, BorderLayout.CENTER);
		
		list = new JList();
		list.setModel(new DefaultListModel());
		scrollPane.setViewportView(list);
	}
	
	private void arrancar() {
		Thread hilo = new Thread(this);
		hilo.start();
	}
	
	private void parar() {
		servidorArrancado = false;
	}

	@Override
	public void run() {
		PrintWriter salida = null;
		BufferedReader entrada = null;
		ServerSocket ss  = null;
		Socket sc = null;
		// Crear un socket de servidor (a la escucha)
		try {
			servidorArrancado = true;
			int puerto = Integer.parseInt( txtPuerto.getText() );
			ss = new ServerSocket( puerto );
			System.out.println("Servidor Arrancado");
			while(servidorArrancado) {
				// Esperamos a que un cliente se conecte
				sc = ss.accept();
				System.out.println("Llega un cliente nuevo");
				// Abrimos dos canales (entrada/salida) por el cual enviar y recibir la información
				salida = new PrintWriter( sc.getOutputStream() , true );
				entrada = new BufferedReader( 
						new InputStreamReader( sc.getInputStream() ) );
				System.out.println("Canales E/S abiertos");
				
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
				// Esperamos a que nos llege algo de algun cliente por el canal de entrada
				String mensaje = entrada.readLine();
				System.out.println("llega un mensaje");
				// lo convertimos a mayuscula
				mensaje = mensaje.toUpperCase();
				
				DefaultListModel dlm = (DefaultListModel) list.getModel();
				dlm.addElement(mensaje);
				
				// Se lo devolvemos al cliente por el canal de salida
				salida.println(mensaje);
				salida.flush();
				//sc.close();
			}
			
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				salida.close();
				entrada.close();
				//ss.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
		
	}
	
	


}
