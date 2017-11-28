package teoria;
import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import javax.swing.JTextField;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

import java.awt.Insets;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.awt.event.ActionEvent;

public class Teoria12_EstadisticasNumerosFichero {

	private JFrame frame;
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
					Teoria12_EstadisticasNumerosFichero window = new Teoria12_EstadisticasNumerosFichero();
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
	public Teoria12_EstadisticasNumerosFichero() {
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
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 1.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		frame.getContentPane().setLayout(gridBagLayout);
		
		JLabel lblNewLabel = new JLabel("Ruta del fichero");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		frame.getContentPane().add(lblNewLabel, gbc_lblNewLabel);
		
		JTextField txtRuta = new JTextField();
		GridBagConstraints gbc_txtRuta = new GridBagConstraints();
		gbc_txtRuta.insets = new Insets(0, 0, 5, 5);
		gbc_txtRuta.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtRuta.gridx = 1;
		gbc_txtRuta.gridy = 0;
		frame.getContentPane().add(txtRuta, gbc_txtRuta);
		txtRuta.setColumns(10);
		
		JButton btnSeeccionar = new JButton("Seleccionar...");
		btnSeeccionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
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
					txtRuta.setText(  fichero.getAbsolutePath()  );
				}
				
				
			}
		});
		GridBagConstraints gbc_btnSeeccionar = new GridBagConstraints();
		gbc_btnSeeccionar.insets = new Insets(0, 0, 5, 0);
		gbc_btnSeeccionar.gridx = 2;
		gbc_btnSeeccionar.gridy = 0;
		frame.getContentPane().add(btnSeeccionar, gbc_btnSeeccionar);
		
		JLabel lblNewLabel_1 = new JLabel("Suma de los n\u00FAmeros");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.insets = new Insets(0, 10, 5, 5);
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 2;
		frame.getContentPane().add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		lblSuma = new JLabel("");
		GridBagConstraints gbc_lblSuma = new GridBagConstraints();
		gbc_lblSuma.anchor = GridBagConstraints.WEST;
		gbc_lblSuma.insets = new Insets(0, 0, 5, 5);
		gbc_lblSuma.gridx = 1;
		gbc_lblSuma.gridy = 2;
		frame.getContentPane().add(lblSuma, gbc_lblSuma);
		
		JLabel lblNewLabel_2 = new JLabel("Media de los n\u00FAmeros");
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.insets = new Insets(0, 10, 5, 5);
		gbc_lblNewLabel_2.gridx = 0;
		gbc_lblNewLabel_2.gridy = 3;
		frame.getContentPane().add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		lblMedia = new JLabel("");
		GridBagConstraints gbc_lblMedia = new GridBagConstraints();
		gbc_lblMedia.anchor = GridBagConstraints.WEST;
		gbc_lblMedia.insets = new Insets(0, 0, 5, 5);
		gbc_lblMedia.gridx = 1;
		gbc_lblMedia.gridy = 3;
		frame.getContentPane().add(lblMedia, gbc_lblMedia);
		
		JLabel lblNewLabel_3 = new JLabel("El mayor n\u00FAmero");
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_3.gridx = 0;
		gbc_lblNewLabel_3.gridy = 4;
		frame.getContentPane().add(lblNewLabel_3, gbc_lblNewLabel_3);
		
		lblMayor = new JLabel("");
		GridBagConstraints gbc_lblMayor = new GridBagConstraints();
		gbc_lblMayor.anchor = GridBagConstraints.WEST;
		gbc_lblMayor.insets = new Insets(0, 0, 5, 5);
		gbc_lblMayor.gridx = 1;
		gbc_lblMayor.gridy = 4;
		frame.getContentPane().add(lblMayor, gbc_lblMayor);
		
		JLabel lblNewLabel_4 = new JLabel("El menor n\u00FAmero");
		GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
		gbc_lblNewLabel_4.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_4.gridx = 0;
		gbc_lblNewLabel_4.gridy = 5;
		frame.getContentPane().add(lblNewLabel_4, gbc_lblNewLabel_4);
		
		lblMenor = new JLabel("");
		GridBagConstraints gbc_lblMenor = new GridBagConstraints();
		gbc_lblMenor.anchor = GridBagConstraints.WEST;
		gbc_lblMenor.insets = new Insets(0, 0, 5, 5);
		gbc_lblMenor.gridx = 1;
		gbc_lblMenor.gridy = 5;
		frame.getContentPane().add(lblMenor, gbc_lblMenor);
		
		JButton btnCalcular = new JButton("Calcular");
		btnCalcular.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String ruta = txtRuta.getText();
				
				if(ruta.isEmpty()) {
					return;
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
					
					
					
				} catch (IOException e) {
					JOptionPane.showMessageDialog(frame, "Error al leer el fichero");
				}
			
				
			}
		});
		GridBagConstraints gbc_btnCalcular = new GridBagConstraints();
		gbc_btnCalcular.insets = new Insets(0, 0, 0, 5);
		gbc_btnCalcular.gridx = 1;
		gbc_btnCalcular.gridy = 6;
		frame.getContentPane().add(btnCalcular, gbc_btnCalcular);
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
