package ex03_gardar_nome_apelidos;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.GridLayout;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.JTextField;
import java.awt.Insets;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Alumno {

	private JFrame frame;
	private JTextField txtName;
	private JTextField textSurname;
	private JLabel lblCompleteName;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Alumno window = new Alumno();
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
	public Alumno() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new GridLayout(1, 0, 0, 0));

		JPanel panel = new JPanel();
		frame.getContentPane().add(panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[] { 0, 0, 0 };
		gbl_panel.rowHeights = new int[] { 0, 0, 0, 0, 0 };
		gbl_panel.columnWeights = new double[] { 0.0, 1.0, Double.MIN_VALUE };
		gbl_panel.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		panel.setLayout(gbl_panel);

		JLabel lblNome = new JLabel("Nome");
		GridBagConstraints gbc_lblNome = new GridBagConstraints();
		gbc_lblNome.insets = new Insets(0, 0, 5, 5);
		gbc_lblNome.anchor = GridBagConstraints.EAST;
		gbc_lblNome.gridx = 0;
		gbc_lblNome.gridy = 0;
		panel.add(lblNome, gbc_lblNome);

		txtName = new JTextField();
		GridBagConstraints gbc_txtName = new GridBagConstraints();
		gbc_txtName.insets = new Insets(0, 0, 5, 0);
		gbc_txtName.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtName.gridx = 1;
		gbc_txtName.gridy = 0;
		panel.add(txtName, gbc_txtName);
		txtName.setColumns(10);

		JLabel lblApelidos = new JLabel("Apelidos");
		GridBagConstraints gbc_lblApelidos = new GridBagConstraints();
		gbc_lblApelidos.anchor = GridBagConstraints.EAST;
		gbc_lblApelidos.insets = new Insets(0, 0, 5, 5);
		gbc_lblApelidos.gridx = 0;
		gbc_lblApelidos.gridy = 1;
		panel.add(lblApelidos, gbc_lblApelidos);

		textSurname = new JTextField();
		GridBagConstraints gbc_textSurname = new GridBagConstraints();
		gbc_textSurname.insets = new Insets(0, 0, 5, 0);
		gbc_textSurname.fill = GridBagConstraints.HORIZONTAL;
		gbc_textSurname.gridx = 1;
		gbc_textSurname.gridy = 1;
		panel.add(textSurname, gbc_textSurname);
		textSurname.setColumns(10);

		JButton btnSave = new JButton("Gardar");
		btnSave.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {

				StringBuffer sb = new StringBuffer();
				sb.append(txtName.getText());
				sb.append(" ");
				sb.append(textSurname.getText());

				String completeName = sb.toString();
				lblCompleteName.setText(sb.toString().toUpperCase());
				txtName.setText("");
				textSurname.setText("");

				addToFile(completeName);

			}

			private void addToFile(String text) {

				File f = new File("Nomes.txt"); // Apunta a un ficheiro
				FileWriter fw = null;
				BufferedWriter bw = null;
				try {
					fw = new FileWriter(f, true); // abre o fluxo en modo engadir
					bw = new BufferedWriter(fw);  // abre un wrapper para fw
					bw.write(text);
					bw.newLine();

				} catch (IOException e) {
					e.printStackTrace();
				} finally {
					try {
						if (fw != null) // Boa práctica
						bw.close();
						fw.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}

			}
		});
		GridBagConstraints gbc_btnSave = new GridBagConstraints();
		gbc_btnSave.insets = new Insets(0, 0, 5, 0);
		gbc_btnSave.gridx = 1;
		gbc_btnSave.gridy = 2;
		panel.add(btnSave, gbc_btnSave);

		lblCompleteName = new JLabel("---");
		GridBagConstraints gbc_lblCompleteName = new GridBagConstraints();
		gbc_lblCompleteName.gridx = 1;
		gbc_lblCompleteName.gridy = 3;
		panel.add(lblCompleteName, gbc_lblCompleteName);
	}

	public JLabel getLblCompleteName() {
		return lblCompleteName;
	}
}
