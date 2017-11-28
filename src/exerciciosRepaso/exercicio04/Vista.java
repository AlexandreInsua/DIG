package exerciciosRepaso.exercicio04;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.GridLayout;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;

import java.awt.Insets;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.Rectangle;
import java.awt.event.ActionListener;
import java.io.File;
import java.awt.event.ActionEvent;

public class Vista {

	private JFrame frame;
	private JTextField txtSeleccioneUnFicheiro;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Vista window = new Vista();
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
	public Vista() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("Pasa a mai\u00FAsculas");
		frame.setBounds(100, 100, 450, 165);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		frame.getContentPane().setLayout(gridBagLayout);
		
		JLabel lblRutaFicheiro = new JLabel("Ruta ficheiro: ");
		GridBagConstraints gbc_lblRutaFicheiro = new GridBagConstraints();
		gbc_lblRutaFicheiro.insets = new Insets(0, 0, 5, 5);
		gbc_lblRutaFicheiro.gridx = 0;
		gbc_lblRutaFicheiro.gridy = 1;
		frame.getContentPane().add(lblRutaFicheiro, gbc_lblRutaFicheiro);
		
		txtSeleccioneUnFicheiro = new JTextField();
		txtSeleccioneUnFicheiro.setText("Seleccione un ficheiro");
		txtSeleccioneUnFicheiro.setMargin(new Insets(2, 5, 2, 5));
		GridBagConstraints gbc_txtSeleccioneUnFicheiro = new GridBagConstraints();
		gbc_txtSeleccioneUnFicheiro.gridwidth = 9;
		gbc_txtSeleccioneUnFicheiro.insets = new Insets(0, 0, 5, 5);
		gbc_txtSeleccioneUnFicheiro.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtSeleccioneUnFicheiro.gridx = 1;
		gbc_txtSeleccioneUnFicheiro.gridy = 1;
		frame.getContentPane().add(txtSeleccioneUnFicheiro, gbc_txtSeleccioneUnFicheiro);
		txtSeleccioneUnFicheiro.setColumns(10);
		
		JButton btnSelectFile = new JButton("Seleccionar ficheiro");
		btnSelectFile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			JFileChooser chooser = new JFileChooser();
			chooser.setFileSelectionMode(chooser.FILES_AND_DIRECTORIES);
			FileNameExtensionFilter filter = new FileNameExtensionFilter("*.TXT", "*.txt");
			chooser.setFileFilter(filter);
			int result = chooser.showOpenDialog(frame);
			
			
			}
		});
		GridBagConstraints gbc_btnSelectFile = new GridBagConstraints();
		gbc_btnSelectFile.insets = new Insets(0, 0, 5, 0);
		gbc_btnSelectFile.gridx = 10;
		gbc_btnSelectFile.gridy = 1;
		frame.getContentPane().add(btnSelectFile, gbc_btnSelectFile);
		
		JLabel lblMessageNewFile = new JLabel("");
		GridBagConstraints gbc_lblMessageNewFile = new GridBagConstraints();
		gbc_lblMessageNewFile.insets = new Insets(0, 0, 0, 5);
		gbc_lblMessageNewFile.gridx = 0;
		gbc_lblMessageNewFile.gridy = 2;
		frame.getContentPane().add(lblMessageNewFile, gbc_lblMessageNewFile);
	}

}
