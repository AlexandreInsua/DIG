package exerciciosRepaso.exercicio10;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import javax.swing.JTextField;
import java.awt.Insets;
import javax.swing.JButton;
import javax.swing.JSpinner;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import java.awt.event.ActionEvent;

public class Principal {

	private JFrame frame;
	private JSpinner txtNumero;
	private JTextField txtRuta;
	private JLabel lblMensaje;

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
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		frame.getContentPane().setLayout(gridBagLayout);
		
		JLabel lblNewLabel = new JLabel("Número de numeros a generar:");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		frame.getContentPane().add(lblNewLabel, gbc_lblNewLabel);
		
		txtNumero = new JSpinner();
		GridBagConstraints gbc_txtNumero = new GridBagConstraints();
		gbc_txtNumero.insets = new Insets(0, 0, 5, 0);
		gbc_txtNumero.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtNumero.gridx = 1;
		gbc_txtNumero.gridy = 0;
		frame.getContentPane().add(txtNumero, gbc_txtNumero);
		
		JLabel lblNewLabel_1 = new JLabel("Ruta del fichero destino:");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 1;
		frame.getContentPane().add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		txtRuta = new JTextField();
		GridBagConstraints gbc_txtRuta = new GridBagConstraints();
		gbc_txtRuta.insets = new Insets(0, 0, 5, 0);
		gbc_txtRuta.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtRuta.gridx = 1;
		gbc_txtRuta.gridy = 1;
		frame.getContentPane().add(txtRuta, gbc_txtRuta);
		txtRuta.setColumns(10);
		
		JButton btnNewButton = new JButton("Generar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int cantidad = (int) txtNumero.getValue();
				ArrayList<Integer> listaNumerosAleatorios  = generarXNumerosAleatorios( cantidad );
				guardarFichero(txtRuta.getText(), listaNumerosAleatorios);
				lblMensaje.setText("Fichero generado correctamente: "+ txtRuta.getText() );
			}
		});
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.insets = new Insets(0, 0, 5, 0);
		gbc_btnNewButton.gridx = 1;
		gbc_btnNewButton.gridy = 2;
		frame.getContentPane().add(btnNewButton, gbc_btnNewButton);
		
		lblMensaje = new JLabel("Mensaje...");
		GridBagConstraints gbc_lblMensaje = new GridBagConstraints();
		gbc_lblMensaje.gridwidth = 2;
		gbc_lblMensaje.insets = new Insets(0, 0, 0, 5);
		gbc_lblMensaje.gridx = 0;
		gbc_lblMensaje.gridy = 3;
		frame.getContentPane().add(lblMensaje, gbc_lblMensaje);
	}
	
	
	public static int generarAleatorio(int min, int max) {
		max = max + 1;
		double valorAleatorio = Math.random() * (max - min) + min;
		return (int) valorAleatorio;
	}

	public static ArrayList generarXNumerosAleatorios(int cantidad) {
		ArrayList<Integer> listaNumerosAleatorios = new ArrayList<Integer>();
		for (int i = 0; i < cantidad; i++) {
			int aleatorio = generarAleatorio(0, 9);
			listaNumerosAleatorios.add(aleatorio);
		}
		return listaNumerosAleatorios;
	}
	public static void guardarFichero(String ruta, ArrayList<Integer> numerosAleatorios) {
		File fichero = new File(ruta);
		PrintWriter pw = null;
		try {
			pw = new PrintWriter(fichero);
			for (int n : numerosAleatorios) {
				pw.println(n);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {
			pw.close();
		}
	}

	
}
