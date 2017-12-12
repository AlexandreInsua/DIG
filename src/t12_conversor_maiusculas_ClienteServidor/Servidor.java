package t12_conversor_maiusculas_ClienteServidor;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import javax.swing.JTextField;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils.Text;

import java.awt.Insets;
import javax.swing.JScrollPane;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JList;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {

	private JFrame frame;
	private JTextField txtPort;
	private JList list;
	private boolean serverStarted = false;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Servidor window = new Servidor();
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
	public Servidor() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));

		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.NORTH);

		JLabel lblNewLabel = new JLabel("Porto");
		panel.add(lblNewLabel);

		txtPort = new JTextField();
		txtPort.setText("4444");
		panel.add(txtPort);
		txtPort.setColumns(10);

		JScrollPane scrollPane = new JScrollPane();
		frame.getContentPane().add(scrollPane, BorderLayout.CENTER);

		list = new JList();
		scrollPane.setViewportView(list);

		JPanel panel_1 = new JPanel();
		frame.getContentPane().add(panel_1, BorderLayout.SOUTH);

		JButton btnStart = new JButton("Conectar");
		btnStart.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				startServer();
			}
		});
		panel_1.add(btnStart);

		JButton btnShutdown = new JButton("Apagar");
		btnShutdown.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				stopServer();
			}
		});
		panel_1.add(btnShutdown);
	}

	public JTextField getTxtPorto() {
		return txtPort;
	}

	public JList getList() {
		return list;
	}

	private void startServer() {
		// crear un serrvidor á escoita

		
		ServerSocket ss = null;
		PrintWriter saida = null;
		BufferedReader entrada = null;
		Socket sc = null;
		// creamos canles de entrada e saida

		try {int port = Integer.parseInt(txtPort.getText());
			ss = new ServerSocket(port);
			System.out.println("Servidor arrincado");
			while (serverStarted) {
				// BUCLE
				// Agardamos a que chegue algo
				sc = ss.accept();
				System.out.println("Chega un novo cliente");
				// abrimos os fluxos
				saida = new PrintWriter(sc.getOutputStream(),true);
				entrada = new BufferedReader(new InputStreamReader(sc.getInputStream()));
System.out.println("E/S abertos");

				String mensaxe = entrada.readLine();
				System.out.println("Chega unha mensaxe.");
				
				// convertílo á maiúsculas
				mensaxe = mensaxe.toUpperCase();
				
				// pasamos o dlm para a lista
				
				DefaultListModel dlm = (DefaultListModel) list.getModel();
				dlm.addElement(mensaxe);

				// e o devolvemos ao cliente

				saida.println(mensaxe);
				saida.flush();


			}
			saida.close();
			entrada.close();
			sc.close();
			ss.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private void stopServer() {
		serverStarted = false;
	}
}
