package exerciciosCasa05;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Main {

	private JFrame frame;
	private JTextField textFieldPath;
	private JTextPane textPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main window = new Main();
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
	public Main() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel panelSelectFile = new JPanel();
		frame.getContentPane().add(panelSelectFile, BorderLayout.NORTH);

		JLabel lblPath = new JLabel("Ruta del fichero");
		lblPath.setFont(new Font("Tahoma", Font.BOLD, 11));
		panelSelectFile.add(lblPath);

		textFieldPath = new JTextField();
		// Listener para tecla do teclado
		textFieldPath.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					String path = textFieldPath.getText();
					File file = new File(path);
					readFile(file);
				}
			}
		});
		panelSelectFile.add(textFieldPath);
		textFieldPath.setColumns(10);

		JButton btnSelectFile = new JButton("Seleccionar...");
		
		// Evento que chama a JFileChooser.
		btnSelectFile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser fc = new JFileChooser();

				FileNameExtensionFilter filter = new FileNameExtensionFilter("*.txt", "txt");
				fc.setFileFilter(filter);

				int option = fc.showOpenDialog(null);
				if (option == JFileChooser.APPROVE_OPTION) {
					File file = fc.getSelectedFile();
					readFile(file);
				}
			}
		});
		panelSelectFile.add(btnSelectFile);

		JScrollPane scrollPane = new JScrollPane();
		frame.getContentPane().add(scrollPane, BorderLayout.CENTER);

		textPane = new JTextPane();
		textPane.setEditable(false);
		scrollPane.setViewportView(textPane);
	}

	public JTextPane getTextPane() {
		return textPane;
	}
	
	private void readFile(File file) {
		String fileType = file.getName();
		fileType = fileType.substring(fileType.length() - 3, fileType.length());
		char[] fileTypeChar = fileType.toCharArray();
		if (!((fileTypeChar[0] == 'T' || fileTypeChar[0] == 't') && (fileTypeChar[1] == 'X' || fileTypeChar[1] == 'x') && (fileTypeChar[2] == 'T' || fileTypeChar[2] == 't'))){
			int option = JOptionPane.showConfirmDialog(null, "El archivo no parece tratarse de un *.txt.\n�Continuar de todas formas?", "Alerta", JOptionPane.YES_NO_OPTION);
			if (option == JOptionPane.CANCEL_OPTION) return;
		}
		if(file.length() > 200){
			int option = JOptionPane.showConfirmDialog(null, "El archivo es demasiado grande, y leerlo podr�a llevar un buen rato.\n�Continuar de todas formas?", "Alerta", JOptionPane.YES_NO_OPTION);
			if (option == JOptionPane.CANCEL_OPTION) return;
		}
		FileReader fr;
		try {
			fr = new FileReader(file);
			String text = "";
			int pointer = fr.read();
			while (pointer != -1) {
				text += (char) pointer;
				pointer = fr.read();
			}

			textPane.setText(text);
		} catch (FileNotFoundException e) {
			JOptionPane.showMessageDialog(null, "No se ha encontrado el fichero", "Error", JOptionPane.ERROR_MESSAGE,
					null);
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Error al leer el fichero " + file.getName(), "Error",
					JOptionPane.ERROR_MESSAGE, null);
		}
	}
}
