package t06_ficheirosDeTexto;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;

import java.awt.Insets;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.awt.event.ActionEvent;

public class EstadisticasNumeros {

	private JFrame frame;
	private JTextField textRuta;
	private JLabel lblMenor;
	private JLabel lblMayor;
	private JLabel lblMedia;
	private JLabel lblSuma;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EstadisticasNumeros window = new EstadisticasNumeros();
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
	public EstadisticasNumeros() {
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
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		frame.getContentPane().setLayout(gridBagLayout);
		
		JLabel lblRutaDelFichero = new JLabel("Ruta del fichero");
		GridBagConstraints gbc_lblRutaDelFichero = new GridBagConstraints();
		gbc_lblRutaDelFichero.insets = new Insets(0, 0, 5, 5);
		gbc_lblRutaDelFichero.anchor = GridBagConstraints.EAST;
		gbc_lblRutaDelFichero.gridx = 0;
		gbc_lblRutaDelFichero.gridy = 0;
		frame.getContentPane().add(lblRutaDelFichero, gbc_lblRutaDelFichero);
		
		textRuta = new JTextField();
		GridBagConstraints gbc_textRuta = new GridBagConstraints();
		gbc_textRuta.insets = new Insets(0, 0, 5, 5);
		gbc_textRuta.fill = GridBagConstraints.HORIZONTAL;
		gbc_textRuta.gridx = 1;
		gbc_textRuta.gridy = 0;
		frame.getContentPane().add(textRuta, gbc_textRuta);
		textRuta.setColumns(10);
		
		JButton btnSeleccionar = new JButton("Seleccionar");
		btnSeleccionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser fc = new JFileChooser();
				// JFileChooser.FILES_ONLY  permito solo elegir ficheros
				// JFileChooser.DIRECTORIES_ONLY  permito solo elegir directorios
				// JFileChooser.FILES_AND_DIRECTORIES  permito elegir fichero y direcctorios
				fc.setFileSelectionMode( JFileChooser.FILES_ONLY );
				FileNameExtensionFilter filtro = new FileNameExtensionFilter("*.TXT", "txt");
				fc.setFileFilter(filtro);
				int resultado = fc.showOpenDialog(frame);
				
				// JFileChooser.APPROVE_OPTION  cuando todo ha ido bien
				// JFileChooser.CANCEL_OPTION cuando el usuario cancele
				// JFileChooser.ERROR_OPTION cuando exista algun problema
				if(resultado == JFileChooser.APPROVE_OPTION) {
					File fichero = fc.getSelectedFile();
					textRuta.setText(  fichero.getAbsolutePath()  );}
			}
		});
		GridBagConstraints gbc_btnSeleccionar = new GridBagConstraints();
		gbc_btnSeleccionar.insets = new Insets(0, 0, 5, 0);
		gbc_btnSeleccionar.gridx = 2;
		gbc_btnSeleccionar.gridy = 0;
		frame.getContentPane().add(btnSeleccionar, gbc_btnSeleccionar);
		
		JLabel lblSumaDeLos = new JLabel("Suma de los n\u00FAmeros");
		GridBagConstraints gbc_lblSumaDeLos = new GridBagConstraints();
		gbc_lblSumaDeLos.insets = new Insets(0, 0, 5, 5);
		gbc_lblSumaDeLos.gridx = 0;
		gbc_lblSumaDeLos.gridy = 1;
		frame.getContentPane().add(lblSumaDeLos, gbc_lblSumaDeLos);
		
		lblSuma = new JLabel("");
		GridBagConstraints gbc_lblSuma = new GridBagConstraints();
		gbc_lblSuma.insets = new Insets(0, 0, 5, 5);
		gbc_lblSuma.gridx = 1;
		gbc_lblSuma.gridy = 1;
		frame.getContentPane().add(lblSuma, gbc_lblSuma);
		
		JLabel lblMediaDeLos = new JLabel("Media de los n\u00FAmeros");
		GridBagConstraints gbc_lblMediaDeLos = new GridBagConstraints();
		gbc_lblMediaDeLos.insets = new Insets(0, 0, 5, 5);
		gbc_lblMediaDeLos.gridx = 0;
		gbc_lblMediaDeLos.gridy = 2;
		frame.getContentPane().add(lblMediaDeLos, gbc_lblMediaDeLos);
		
		lblMedia = new JLabel("");
		GridBagConstraints gbc_lblMedia = new GridBagConstraints();
		gbc_lblMedia.insets = new Insets(0, 0, 5, 5);
		gbc_lblMedia.gridx = 1;
		gbc_lblMedia.gridy = 2;
		frame.getContentPane().add(lblMedia, gbc_lblMedia);
		
		JLabel lblNmeroMayor = new JLabel("N\u00FAmero mayor");
		GridBagConstraints gbc_lblNmeroMayor = new GridBagConstraints();
		gbc_lblNmeroMayor.insets = new Insets(0, 0, 5, 5);
		gbc_lblNmeroMayor.gridx = 0;
		gbc_lblNmeroMayor.gridy = 3;
		frame.getContentPane().add(lblNmeroMayor, gbc_lblNmeroMayor);
		
		lblMayor = new JLabel("");
		GridBagConstraints gbc_lblMayor = new GridBagConstraints();
		gbc_lblMayor.insets = new Insets(0, 0, 5, 5);
		gbc_lblMayor.gridx = 1;
		gbc_lblMayor.gridy = 3;
		frame.getContentPane().add(lblMayor, gbc_lblMayor);
		
		JLabel lblNmeroMenor = new JLabel("N\u00FAmero menor");
		GridBagConstraints gbc_lblNmeroMenor = new GridBagConstraints();
		gbc_lblNmeroMenor.insets = new Insets(0, 0, 5, 5);
		gbc_lblNmeroMenor.gridx = 0;
		gbc_lblNmeroMenor.gridy = 4;
		frame.getContentPane().add(lblNmeroMenor, gbc_lblNmeroMenor);
		
		JButton btnCalcular = new JButton("Calcular");
		btnCalcular.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String ruta = textRuta.getText();
				if (ruta.isEmpty()){
					JOptionPane.showMessageDialog(null, "El fichero está vacío ", "Error", JOptionPane.ERROR_MESSAGE);
				}
				try {
					String linea = leerPrimeraLineaFichero(ruta);
					int[] listaEnteros = extraerNumerosDeTexto(linea, ";");
					float suma = sumarElementosArray(listaEnteros);
					float media = mediaElementosArray(listaEnteros);
					float max = maximoElementosArray(listaEnteros);
					float min = minimoElementosArray(listaEnteros);
					
					lblSuma.setText( String.valueOf(suma)  );
					lblMedia.setText(new Float(media).toString());
					lblMayor.setText(max+"");
					lblMenor.setText(min+"");
				} catch (IOException ioe) {
					JOptionPane.showMessageDialog(frame, "Error al leer el fichero");
				}
			
			}
		});
		
		lblMenor = new JLabel("");
		GridBagConstraints gbc_lblMenor = new GridBagConstraints();
		gbc_lblMenor.insets = new Insets(0, 0, 5, 5);
		gbc_lblMenor.gridx = 1;
		gbc_lblMenor.gridy = 4;
		frame.getContentPane().add(lblMenor, gbc_lblMenor);
		GridBagConstraints gbc_btnCalcular = new GridBagConstraints();
		gbc_btnCalcular.insets = new Insets(0, 0, 0, 5);
		gbc_btnCalcular.gridx = 1;
		gbc_btnCalcular.gridy = 5;
		frame.getContentPane().add(btnCalcular, gbc_btnCalcular);
	}

	public JLabel getLblMenor() {
		return lblMenor;
	}
	public JLabel getLblMayor() {
		return lblMayor;
	}
	public JLabel getLblMedia() {
		return lblMedia;
	}
	public JLabel getLblSuma() {
		return lblSuma;
	}
	

	private String leerPrimeraLineaFichero(String ruta) throws IOException {
		File fichero = new File(ruta);
		if( ! fichero.exists()) {
			return null;
		}
		
		FileReader fr = null;
		try {
			fr = new FileReader(fichero);
			BufferedReader br = new BufferedReader(fr);
			return br.readLine();
		} catch ( IOException e) {
			throw new IOException("Problemas al leer el fichero");
		} finally {
			try {
				fr.close();
			} catch (IOException e) {
				throw new IOException("Problemas al intentar cerrar el fichero");
			}
		}
	}
	
	private int[] extraerNumerosDeTexto(String texto, String separador) {
		String[] listaTextos = texto.split(separador);
		int[] listaEnteros = new int[listaTextos.length];
		for(int i=0;i<listaTextos.length;i++) {
			listaEnteros[i] = Integer.parseInt(  listaTextos[i] );
		}
		return listaEnteros;
	}
	
	private float sumarElementosArray(int[] elementos) {
		float suma=0;
		for(int i=0;i<elementos.length;i++) {
			suma = suma + elementos[i];
		}
		return suma;
	}

	private float mediaElementosArray(int[] elementos) {
		float suma = sumarElementosArray(elementos);
		return suma / elementos.length; 
	}
	
	private float maximoElementosArray(int[] elementos) {
		int max = -9999999;
		for(int i=0;i<elementos.length;i++) {
			if(max < elementos[i]) {
				max = elementos[i];
			}
		}
		return max;
	}
	private float minimoElementosArray(int[] elementos) {
		int min = 9999999;
		for(int i=0;i<elementos.length;i++) {
			if(min > elementos[i]) {
				min = elementos[i];
			}
		}
		return min;
	}
}
