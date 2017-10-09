package ex07_calculosListaNumerosFicheros;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.GridLayout;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.sun.scenario.effect.LinearConvolveCoreEffect;

import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.Font;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Principal {

	private JFrame frame;
	private JLabel lblSum;
	private JLabel lblAvg;
	private JLabel lblMrthn;
	private JLabel lblLssthn;
	private JTextField txtFilePath;

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
		frame.getContentPane().setLayout(new BorderLayout(0, 0));

		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.NORTH);

		JLabel lblClculoConNmeros = new JLabel("C\u00E1lculo con n\u00FAmeros");
		lblClculoConNmeros.setBackground(Color.GRAY);
		lblClculoConNmeros.setForeground(Color.BLACK);
		lblClculoConNmeros.setFont(new Font("Tahoma", Font.BOLD, 12));
		panel.add(lblClculoConNmeros);

		JPanel panel_1 = new JPanel();
		frame.getContentPane().add(panel_1, BorderLayout.CENTER);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[] { 0, 0, 0, 0 };
		gbl_panel_1.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0 };
		gbl_panel_1.columnWeights = new double[] { 0.0, 1.0, 0.0, Double.MIN_VALUE };
		gbl_panel_1.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		panel_1.setLayout(gbl_panel_1);

		JLabel lblFilePath = new JLabel("Ruta do ficheiro");
		GridBagConstraints gbc_lblFilePath = new GridBagConstraints();
		gbc_lblFilePath.anchor = GridBagConstraints.EAST;
		gbc_lblFilePath.insets = new Insets(0, 0, 5, 5);
		gbc_lblFilePath.gridx = 0;
		gbc_lblFilePath.gridy = 0;
		panel_1.add(lblFilePath, gbc_lblFilePath);

		txtFilePath = new JTextField();
		GridBagConstraints gbc_txtFilePath = new GridBagConstraints();
		gbc_txtFilePath.insets = new Insets(0, 0, 5, 5);
		gbc_txtFilePath.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtFilePath.gridx = 1;
		gbc_txtFilePath.gridy = 0;
		panel_1.add(txtFilePath, gbc_txtFilePath);
		txtFilePath.setColumns(10);
		
		JButton btnSeleccionar = new JButton("Seleccionar ...");
		btnSeleccionar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				JFileChooser fc = new JFileChooser();
				fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
			}
		});
		GridBagConstraints gbc_btnSeleccionar = new GridBagConstraints();
		gbc_btnSeleccionar.insets = new Insets(0, 0, 5, 0);
		gbc_btnSeleccionar.gridx = 2;
		gbc_btnSeleccionar.gridy = 0;
		panel_1.add(btnSeleccionar, gbc_btnSeleccionar);

		JLabel lblSuma = new JLabel("Suma");
		GridBagConstraints gbc_lblSuma = new GridBagConstraints();
		gbc_lblSuma.insets = new Insets(0, 0, 5, 5);
		gbc_lblSuma.gridx = 0;
		gbc_lblSuma.gridy = 1;
		panel_1.add(lblSuma, gbc_lblSuma);

		lblSum = new JLabel("sum");
		GridBagConstraints gbc_lblSum = new GridBagConstraints();
		gbc_lblSum.anchor = GridBagConstraints.WEST;
		gbc_lblSum.insets = new Insets(0, 0, 5, 5);
		gbc_lblSum.gridx = 1;
		gbc_lblSum.gridy = 1;
		panel_1.add(lblSum, gbc_lblSum);

		JLabel lblMedia = new JLabel("Media");
		GridBagConstraints gbc_lblMedia = new GridBagConstraints();
		gbc_lblMedia.insets = new Insets(0, 0, 5, 5);
		gbc_lblMedia.gridx = 0;
		gbc_lblMedia.gridy = 2;
		panel_1.add(lblMedia, gbc_lblMedia);

		lblAvg = new JLabel("avg");
		GridBagConstraints gbc_lblAvg = new GridBagConstraints();
		gbc_lblAvg.anchor = GridBagConstraints.WEST;
		gbc_lblAvg.insets = new Insets(0, 0, 5, 5);
		gbc_lblAvg.gridx = 1;
		gbc_lblAvg.gridy = 2;
		panel_1.add(lblAvg, gbc_lblAvg);

		JLabel lblMaior = new JLabel("Maior");
		GridBagConstraints gbc_lblMaior = new GridBagConstraints();
		gbc_lblMaior.insets = new Insets(0, 0, 5, 5);
		gbc_lblMaior.gridx = 0;
		gbc_lblMaior.gridy = 3;
		panel_1.add(lblMaior, gbc_lblMaior);

		lblMrthn = new JLabel("mrthn");
		GridBagConstraints gbc_lblMrthn = new GridBagConstraints();
		gbc_lblMrthn.anchor = GridBagConstraints.WEST;
		gbc_lblMrthn.insets = new Insets(0, 0, 5, 5);
		gbc_lblMrthn.gridx = 1;
		gbc_lblMrthn.gridy = 3;
		panel_1.add(lblMrthn, gbc_lblMrthn);

		JLabel lblMenor = new JLabel("Menor");
		GridBagConstraints gbc_lblMenor = new GridBagConstraints();
		gbc_lblMenor.insets = new Insets(0, 0, 5, 5);
		gbc_lblMenor.gridx = 0;
		gbc_lblMenor.gridy = 4;
		panel_1.add(lblMenor, gbc_lblMenor);

		lblLssthn = new JLabel("lssthn");
		GridBagConstraints gbc_lblLssthn = new GridBagConstraints();
		gbc_lblLssthn.anchor = GridBagConstraints.WEST;
		gbc_lblLssthn.insets = new Insets(0, 0, 5, 5);
		gbc_lblLssthn.gridx = 1;
		gbc_lblLssthn.gridy = 4;
		panel_1.add(lblLssthn, gbc_lblLssthn);

		JButton btnCalculate = new JButton("Calcular");
		btnCalculate.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				String filePath = txtFilePath.getText();
				if (filePath.isEmpty()) {
					return;
				}

				try {
					// Método que le o ficheiro e devolve a liña lida
					String linea = readFirsLineFile(filePath);
					// Crea un array de strings
					int[] listaEnteiros = extraerNumerosDeTexto(linea, ";");

					float suma = 0, media, max, min;

					suma = sumarElementosArray(listaEnteiros);
					media = mediaElementosArray(listaEnteiros);
					max = maximoElementosArray(listaEnteiros);
							min = minimoElementosArray(listaEnteiros);
							
						lblSum.setText(suma+"");
						lblAvg.setText(media+"");
						lblMrthn.setText(max+"");
						lblLssthn.setText(suma+"");

				} catch (IOException e) {
					JOptionPane.showMessageDialog(frame, "Produciuse un erro lendo o ficheiro");
				}

			}

		});
		GridBagConstraints gbc_btnCalculate = new GridBagConstraints();
		gbc_btnCalculate.insets = new Insets(0, 0, 0, 5);
		gbc_btnCalculate.gridx = 1;
		gbc_btnCalculate.gridy = 5;
		panel_1.add(btnCalculate, gbc_btnCalculate);

		JScrollPane scrollPane = new JScrollPane();
		frame.getContentPane().add(scrollPane, BorderLayout.SOUTH);
	}

	public JLabel getLblSum() {
		return lblSum;
	}

	public JLabel getLblAvg() {
		return lblAvg;
	}

	public JLabel getLblMrthn() {
		return lblMrthn;
	}

	public JLabel getLblLssthn() {
		return lblLssthn;
	}

	private float sumarElementosArray(int[] listaEnteiros) {
		float suma = 0;
		for (int i = 0; i < listaEnteiros.length; i++) {
			suma += listaEnteiros[i];
		}
		return suma;
	}

	private float mediaElementosArray(int[] listaEnteiros) {
		float suma = sumarElementosArray(listaEnteiros);
		return suma / listaEnteiros.length;
	}

	private float maximoElementosArray(int[] elementos) {
		float max = -999999;

		for (int i = 0; i < elementos.length; i++) {
			if (max < elementos[i])
				max = elementos[i];
		}
		return max;

	}

	private float minimoElementosArray(int[] elementos) {
		float min = 999999;

		for (int i = 0; i < elementos.length; i++) {
			if (min > elementos[i])
				min = elementos[i];
		}
		return min;

	}

	private int[] extraerNumerosDeTexto(String linea, String separador) {
		String[] listaTextos = linea.split(separador);
		// Crea un array de ints
		int[] listaEnteiros = new int[listaTextos.length];
		// Asigna valores1
		for (int i = 0; i < listaEnteiros.length; i++) {
			listaEnteiros[i] = Integer.parseInt(listaTextos[i]);
		}
		return listaEnteiros;
	}

	private String readFirsLineFile(String filePath) throws IOException {
		File f = new File(filePath);
		// abre o fluxo
		FileReader fr = null;
		if (!f.exists()) {
			return null;
		} else {
			try {
				fr = new FileReader(f);
				// abre o wrapper apra o fluxo
				BufferedReader br = new BufferedReader(fr);
				return br.readLine();
			} catch (IOException e) {
				throw new IOException("Erro de L/E");
			} finally {
				try {
					fr.close();
				} catch (IOException e) {
					throw new IOException("Erro ao cerrar o ficheiro");
				}
			}
		}
	}
}
