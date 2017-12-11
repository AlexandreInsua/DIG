package exerciciosRepaso.exercicio03;

/*
 * Pide o nome e apelidos e a idade. Se é maior de idade mostra mensaxe de
 * benvida, se non mostra que o permiso non foi concedido.
 */
import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Vista {

	private JFrame frame;
	private JTextField textName;
	private JTextField textSurname;
	private JTextField textAge;
	private JLabel lblMessage;

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
		frame.setBounds(100, 100, 213, 199);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 0, 0, 0 };
		gridBagLayout.rowHeights = new int[] { 0, 0, 0, 0, 0, 0 };
		gridBagLayout.columnWeights = new double[] { 0.0, 0.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		frame.getContentPane().setLayout(gridBagLayout);

		JLabel lblNome = new JLabel("Nome");
		GridBagConstraints gbc_lblNome = new GridBagConstraints();
		gbc_lblNome.anchor = GridBagConstraints.EAST;
		gbc_lblNome.insets = new Insets(0, 0, 5, 5);
		gbc_lblNome.gridx = 0;
		gbc_lblNome.gridy = 0;
		frame.getContentPane().add(lblNome, gbc_lblNome);

		textName = new JTextField();
		GridBagConstraints gbc_textName = new GridBagConstraints();
		gbc_textName.insets = new Insets(0, 0, 5, 0);
		gbc_textName.fill = GridBagConstraints.HORIZONTAL;
		gbc_textName.gridx = 1;
		gbc_textName.gridy = 0;
		frame.getContentPane().add(textName, gbc_textName);
		textName.setColumns(10);

		JLabel lblApelidos = new JLabel("Apelidos");
		GridBagConstraints gbc_lblApelidos = new GridBagConstraints();
		gbc_lblApelidos.anchor = GridBagConstraints.EAST;
		gbc_lblApelidos.insets = new Insets(0, 0, 5, 5);
		gbc_lblApelidos.gridx = 0;
		gbc_lblApelidos.gridy = 1;
		frame.getContentPane().add(lblApelidos, gbc_lblApelidos);

		textSurname = new JTextField();
		textSurname.setText("");
		GridBagConstraints gbc_textSurname = new GridBagConstraints();
		gbc_textSurname.insets = new Insets(0, 0, 5, 0);
		gbc_textSurname.fill = GridBagConstraints.HORIZONTAL;
		gbc_textSurname.gridx = 1;
		gbc_textSurname.gridy = 1;
		frame.getContentPane().add(textSurname, gbc_textSurname);
		textSurname.setColumns(10);

		JLabel lblIdade = new JLabel("Idade");
		GridBagConstraints gbc_lblIdade = new GridBagConstraints();
		gbc_lblIdade.anchor = GridBagConstraints.EAST;
		gbc_lblIdade.insets = new Insets(0, 0, 5, 5);
		gbc_lblIdade.gridx = 0;
		gbc_lblIdade.gridy = 2;
		frame.getContentPane().add(lblIdade, gbc_lblIdade);

		textAge = new JTextField();
		GridBagConstraints gbc_textAge = new GridBagConstraints();
		gbc_textAge.insets = new Insets(0, 0, 5, 0);
		gbc_textAge.fill = GridBagConstraints.HORIZONTAL;
		gbc_textAge.gridx = 1;
		gbc_textAge.gridy = 2;
		frame.getContentPane().add(textAge, gbc_textAge);
		textAge.setColumns(10);

		JButton btnSignIn = new JButton("Entrar");
		btnSignIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String name = textName.getText();
				String surname = textSurname.getText();
				int age = Integer.parseInt(textAge.getText());

				verifyAge(name, surname, age, lblMessage);

			}
		});
		GridBagConstraints gbc_btnSignIn = new GridBagConstraints();
		gbc_btnSignIn.insets = new Insets(0, 0, 5, 0);
		gbc_btnSignIn.gridx = 1;
		gbc_btnSignIn.gridy = 3;
		frame.getContentPane().add(btnSignIn, gbc_btnSignIn);

		lblMessage = new JLabel("");
		GridBagConstraints gbc_lblMessage = new GridBagConstraints();
		gbc_lblMessage.gridx = 1;
		gbc_lblMessage.gridy = 4;
		frame.getContentPane().add(lblMessage, gbc_lblMessage);
	}

	public JLabel getLblMessage() {
		return lblMessage;
	}

	public void verifyAge(String name, String surname, int age, JLabel label) {

		String permissionGranted = "Benvido " + name + " " + surname;
		String permissionoDenied = "Síntoo, " + name + " " + surname + " non tes idade suficiente.";
		if (age >= 18) {
			label.setText(permissionGranted);
			JOptionPane.showMessageDialog(null, permissionGranted);
		} else {
			label.setText(permissionoDenied);
			JOptionPane.showMessageDialog(null, permissionoDenied);
		}
		textName.setText("");
		textSurname.setText("");
		textAge.setText("");
	}
}
