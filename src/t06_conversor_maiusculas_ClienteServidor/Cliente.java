package t06_conversor_maiusculas_ClienteServidor;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import javax.swing.JTextField;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils.Text;

import java.awt.Insets;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Cliente {

	private JFrame frame;
	private JTextField textIP;
	private JTextField textPort;
	private JTextField textMessage;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Cliente window = new Cliente();
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
	public Cliente() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 289, 209);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 71, 301, 0 };
		gridBagLayout.rowHeights = new int[] { 0, 0, 0, 0, 0, 0 };
		gridBagLayout.columnWeights = new double[] { 0.0, 1.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		frame.getContentPane().setLayout(gridBagLayout);

		JLabel lblServerIP = new JLabel("Direcci\u00F3n");
		GridBagConstraints gbc_lblServerIP = new GridBagConstraints();
		gbc_lblServerIP.insets = new Insets(5, 5, 5, 5);
		gbc_lblServerIP.gridx = 0;
		gbc_lblServerIP.gridy = 0;
		frame.getContentPane().add(lblServerIP, gbc_lblServerIP);

		textIP = new JTextField();
		GridBagConstraints gbc_textIP = new GridBagConstraints();
		gbc_textIP.insets = new Insets(5, 5, 5, 5);
		gbc_textIP.fill = GridBagConstraints.HORIZONTAL;
		gbc_textIP.gridx = 1;
		gbc_textIP.gridy = 0;
		frame.getContentPane().add(textIP, gbc_textIP);
		textIP.setColumns(10);

		JLabel lblPort = new JLabel("Porto");
		GridBagConstraints gbc_lblPort = new GridBagConstraints();
		gbc_lblPort.insets = new Insets(5, 5, 5, 5);
		gbc_lblPort.gridx = 0;
		gbc_lblPort.gridy = 1;
		frame.getContentPane().add(lblPort, gbc_lblPort);

		textPort = new JTextField();
		GridBagConstraints gbc_textPort = new GridBagConstraints();
		gbc_textPort.insets = new Insets(5, 5, 5, 5);
		gbc_textPort.fill = GridBagConstraints.HORIZONTAL;
		gbc_textPort.gridx = 1;
		gbc_textPort.gridy = 1;
		frame.getContentPane().add(textPort, gbc_textPort);
		textPort.setColumns(10);

		JLabel lblMessage = new JLabel("Mensaxe");
		GridBagConstraints gbc_lblMessage = new GridBagConstraints();
		gbc_lblMessage.insets = new Insets(5, 5, 5, 5);
		gbc_lblMessage.gridx = 0;
		gbc_lblMessage.gridy = 2;
		frame.getContentPane().add(lblMessage, gbc_lblMessage);

		textMessage = new JTextField();
		GridBagConstraints gbc_textMessage = new GridBagConstraints();
		gbc_textMessage.insets = new Insets(5, 5, 5, 5);
		gbc_textMessage.fill = GridBagConstraints.HORIZONTAL;
		gbc_textMessage.gridx = 1;
		gbc_textMessage.gridy = 2;
		frame.getContentPane().add(textMessage, gbc_textMessage);
		textMessage.setColumns(10);

		JButton btnSend = new JButton("Enviar");
		btnSend.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {

				sendMessage();

			}
		});
		GridBagConstraints gbc_btnSend = new GridBagConstraints();
		gbc_btnSend.gridx = 1;
		gbc_btnSend.gridy = 4;
		frame.getContentPane().add(btnSend, gbc_btnSend);
	}

	private void sendMessage() {
		// Establecer un socket
		@SuppressWarnings("unused")
		String ip = textIP.getText();
		int porto = Integer.parseInt(textPort.getText());
		Socket sc = null;
		PrintWriter saida = null;
		BufferedReader entrada = null;
		// TODO faltan as validacións

		try {
			//
			sc = new Socket(textIP.getText(), porto);

			// Abrir un fluxo de saída
			// Abrir un fluxo de entrada
			saida = new PrintWriter(sc.getOutputStream());
			entrada = new BufferedReader(new InputStreamReader(sc.getInputStream()));

			// Enviar
			saida.println(textMessage.getText());

			// Agardamos a resposta do servidor co frase en maiúsculas
			textMessage.setText(entrada.readLine());

			// Pechar a conexión

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				saida.close();
				entrada.close();
				sc.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

	public JTextField getTextIP() {
		return textIP;
	}

	public JTextField getTextPort() {
		return textPort;
	}

	public JTextField getTextMessage() {
		return textMessage;
	}
}
