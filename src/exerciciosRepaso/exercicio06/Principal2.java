package exerciciosRepaso.exercicio06;

import java.awt.EventQueue;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JFrame;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;

import java.awt.Insets;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/* 
 * O JFileChooser actívase cando se preme no botón, polo que se implementa dentro do corpo do listener
 */
public class Principal2 {

	private JFrame frame;
	private JTextField txtRuta;
	private JLabel lblSuma;
	private JLabel lblMedia;
	private JLabel lblMayor;
	private JLabel lblMenor;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal2 window = new Principal2();
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
	public Principal2() {
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
		gridBagLayout.columnWidths = new int[] { 0, 0, 0, 0 };
		gridBagLayout.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0 };
		gridBagLayout.columnWeights = new double[] { 0.0, 1.0, 0.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		frame.getContentPane().setLayout(gridBagLayout);

		JLabel lblRuta = new JLabel("Ruta:");
		GridBagConstraints gbc_lblRuta = new GridBagConstraints();
		gbc_lblRuta.insets = new Insets(0, 0, 5, 5);
		gbc_lblRuta.anchor = GridBagConstraints.EAST;
		gbc_lblRuta.gridx = 0;
		gbc_lblRuta.gridy = 0;
		frame.getContentPane().add(lblRuta, gbc_lblRuta);

		txtRuta = new JTextField();
		GridBagConstraints gbc_txtRuta = new GridBagConstraints();
		gbc_txtRuta.insets = new Insets(0, 0, 5, 5);
		gbc_txtRuta.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtRuta.gridx = 1;
		gbc_txtRuta.gridy = 0;
		frame.getContentPane().add(txtRuta, gbc_txtRuta);
		txtRuta.setColumns(10);

		JButton btnNewButton = new JButton("Seleccionar fichero...");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser fc = new JFileChooser();
				// JFileChooser.FILES_ONLY permito solo elegir ficheros
				// JFileChooser.DIRECTORIES_ONLY permito solo elegir directorios
				// JFileChooser.FILES_AND_DIRECTORIES permito elegir fichero y
				// direcctorios
				fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
				FileNameExtensionFilter filtro = new FileNameExtensionFilter("*.TXT", "txt");
				fc.setFileFilter(filtro);
				int resultado = fc.showOpenDialog(frame);

				// JFileChooser.APPROVE_OPTION cuando todo ha ido bien
				// JFileChooser.CANCEL_OPTION cuando el usuario cancele
				// JFileChooser.ERROR_OPTION cuando exista algun problema
				if (resultado == JFileChooser.APPROVE_OPTION) {
					File ficheroOrigen = fc.getSelectedFile();
					txtRuta.setText(ficheroOrigen.getAbsolutePath());

					String contenido = leerFichero(ficheroOrigen.getAbsolutePath());

					String[] textos = contenido.split(";");

					float laSuma = calcularSuma(textos);
					lblSuma.setText(laSuma + "");
					float laMedia = calcularMedia(textos);
					lblMedia.setText(laMedia + "");

					float elMaximo = calcularMaximo(textos);
					lblMayor.setText(elMaximo + "");

					float elMinimo = calcularMinimo(textos);
					lblMenor.setText(elMinimo + "");

				}

			}
		});
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.insets = new Insets(0, 0, 5, 0);
		gbc_btnNewButton.gridx = 2;
		gbc_btnNewButton.gridy = 0;
		frame.getContentPane().add(btnNewButton, gbc_btnNewButton);

		JLabel lblNewLabel_1 = new JLabel("Suma total:");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 2;
		frame.getContentPane().add(lblNewLabel_1, gbc_lblNewLabel_1);

		lblSuma = new JLabel("-");
		GridBagConstraints gbc_lblSuma = new GridBagConstraints();
		gbc_lblSuma.insets = new Insets(0, 0, 5, 5);
		gbc_lblSuma.gridx = 1;
		gbc_lblSuma.gridy = 2;
		frame.getContentPane().add(lblSuma, gbc_lblSuma);

		JLabel lblNewLabel_2 = new JLabel("Media total:");
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 0;
		gbc_lblNewLabel_2.gridy = 3;
		frame.getContentPane().add(lblNewLabel_2, gbc_lblNewLabel_2);

		lblMedia = new JLabel("-");
		GridBagConstraints gbc_lblMedia = new GridBagConstraints();
		gbc_lblMedia.insets = new Insets(0, 0, 5, 5);
		gbc_lblMedia.gridx = 1;
		gbc_lblMedia.gridy = 3;
		frame.getContentPane().add(lblMedia, gbc_lblMedia);

		JLabel lblNewLabel_3 = new JLabel("Mumero mayor:");
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_3.gridx = 0;
		gbc_lblNewLabel_3.gridy = 4;
		frame.getContentPane().add(lblNewLabel_3, gbc_lblNewLabel_3);

		lblMayor = new JLabel("-");
		GridBagConstraints gbc_lblMayor = new GridBagConstraints();
		gbc_lblMayor.insets = new Insets(0, 0, 5, 5);
		gbc_lblMayor.gridx = 1;
		gbc_lblMayor.gridy = 4;
		frame.getContentPane().add(lblMayor, gbc_lblMayor);

		JLabel lblNewLabel_4 = new JLabel("Numero menor:");
		GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
		gbc_lblNewLabel_4.insets = new Insets(0, 0, 0, 5);
		gbc_lblNewLabel_4.gridx = 0;
		gbc_lblNewLabel_4.gridy = 5;
		frame.getContentPane().add(lblNewLabel_4, gbc_lblNewLabel_4);

		lblMenor = new JLabel("-");
		GridBagConstraints gbc_lblMenor = new GridBagConstraints();
		gbc_lblMenor.insets = new Insets(0, 0, 0, 5);
		gbc_lblMenor.gridx = 1;
		gbc_lblMenor.gridy = 5;
		frame.getContentPane().add(lblMenor, gbc_lblMenor);
	}

	private static String leerFichero(String rutaFichero) {
		String textoCompleto = "";
		FileReader fr = null;
		try {
			File fichero = new File(rutaFichero);
			fr = new FileReader(fichero);
			BufferedReader br = new BufferedReader(fr);
			String linea;
			while ((linea = br.readLine()) != null) {
				textoCompleto = textoCompleto + linea;
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				fr.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return textoCompleto;
	}

	public static float calcularSuma(String[] textos) {
		float total = 0;
		for (int i = 0; i < textos.length; i++) {
			float valor = Float.parseFloat(textos[i]);
			total = total + valor;
		}
		return total;
	}

	public static float calcularMedia(String[] textos) {
		float suma = calcularSuma(textos);
		return suma / textos.length;
	}

	public static float calcularMaximo(String[] textos) {
		float elMaximo = -999999;
		for (int i = 0; i < textos.length; i++) {
			float valor = Float.parseFloat(textos[i]);
			if (valor > elMaximo)
				elMaximo = valor;
		}
		return elMaximo;
	}

	public static float calcularMinimo(String[] textos) {
		float elMinimo = 999999;
		for (int i = 0; i < textos.length; i++) {
			float valor = Float.parseFloat(textos[i]);
			if (valor < elMinimo)
				elMinimo = valor;
		}
		return elMinimo;
	}

	/*
	 * public static void main(String[] args) { String contenido = leerFichero(
	 * "C:\\Users\\DAM\\workspace\\EjercicioRepaso12\\src\\fichero.txt");
	 * System.out.println(contenido); String[] textos = contenido.split(";");
	 * 
	 * float laSuma = calcularSuma (textos); System.out.println("SUMA:" +
	 * laSuma);
	 * 
	 * float laMedia = calcularMedia(textos); System.out.println("MEDIA:" +
	 * laMedia);
	 * 
	 * float elMaximo = calcularMaximo(textos); System.out.println("MAX:" +
	 * elMaximo);
	 * 
	 * float elMinimo = calcularMinimo(textos); System.out.println("MIN:" +
	 * elMinimo); }
	 */

}
