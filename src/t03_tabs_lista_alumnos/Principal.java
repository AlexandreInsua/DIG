package t03_tabs_lista_alumnos;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import javax.swing.JTextField;
import java.awt.Insets;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.BoxLayout;
import javax.swing.JScrollPane;
import javax.swing.JList;
import java.awt.GridLayout;

public class Principal {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;

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

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		frame.getContentPane().add(tabbedPane, BorderLayout.CENTER);

		JPanel panel = new JPanel();
		tabbedPane.addTab("Formulario alumnos", null, panel, null);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[] { 0, 0, 0 };
		gbl_panel.rowHeights = new int[] { 0, 0, 0, 0 };
		gbl_panel.columnWeights = new double[] { 0.0, 1.0, Double.MIN_VALUE };
		gbl_panel.rowWeights = new double[] { 0.0, 0.0, 0.0, Double.MIN_VALUE };
		panel.setLayout(gbl_panel);

		JLabel lblName = new JLabel("Nome e apelidos");
		lblName.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_lblName = new GridBagConstraints();
		gbc_lblName.insets = new Insets(0, 0, 5, 5);
		gbc_lblName.anchor = GridBagConstraints.EAST;
		gbc_lblName.gridx = 0;
		gbc_lblName.gridy = 0;
		panel.add(lblName, gbc_lblName);

		textField = new JTextField();
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.insets = new Insets(0, 0, 5, 0);
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 1;
		gbc_textField.gridy = 0;
		panel.add(textField, gbc_textField);
		textField.setColumns(10);

		JLabel lblNota = new JLabel("Nota");
		lblNota.setHorizontalAlignment(SwingConstants.RIGHT);
		GridBagConstraints gbc_lblNota = new GridBagConstraints();
		gbc_lblNota.anchor = GridBagConstraints.EAST;
		gbc_lblNota.insets = new Insets(0, 0, 5, 5);
		gbc_lblNota.gridx = 0;
		gbc_lblNota.gridy = 1;
		panel.add(lblNota, gbc_lblNota);

		textField_1 = new JTextField();
		GridBagConstraints gbc_textField_1 = new GridBagConstraints();
		gbc_textField_1.insets = new Insets(0, 0, 5, 0);
		gbc_textField_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_1.gridx = 1;
		gbc_textField_1.gridy = 1;
		panel.add(textField_1, gbc_textField_1);
		textField_1.setColumns(10);

		JButton btnAdd = new JButton("Engadir");
		GridBagConstraints gbc_btnAdd = new GridBagConstraints();
		gbc_btnAdd.gridx = 1;
		gbc_btnAdd.gridy = 2;
		panel.add(btnAdd, gbc_btnAdd);

		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Listado alumnos", null, panel_1, null);
		panel_1.setLayout(new BorderLayout(0, 0));

		JPanel panel_2 = new JPanel();
		panel_1.add(panel_2, BorderLayout.WEST);
		GridBagLayout gbl_panel_2 = new GridBagLayout();
		gbl_panel_2.columnWidths = new int[] { 127, 0 };
		gbl_panel_2.rowHeights = new int[] { 73, 73, 78, 0 };
		gbl_panel_2.columnWeights = new double[] { 0.0, Double.MIN_VALUE };
		gbl_panel_2.rowWeights = new double[] { 0.0, 0.0, 0.0, Double.MIN_VALUE };
		panel_2.setLayout(gbl_panel_2);

		JButton btnBorrarSeleccionado = new JButton("Borrar Seleccionado");
		GridBagConstraints gbc_btnBorrarSeleccionado = new GridBagConstraints();
		gbc_btnBorrarSeleccionado.fill = GridBagConstraints.BOTH;
		gbc_btnBorrarSeleccionado.insets = new Insets(0, 0, 5, 0);
		gbc_btnBorrarSeleccionado.gridx = 0;
		gbc_btnBorrarSeleccionado.gridy = 0;
		panel_2.add(btnBorrarSeleccionado, gbc_btnBorrarSeleccionado);

		JButton btnBorrarTodo = new JButton("Borrar todo");
		GridBagConstraints gbc_btnBorrarTodo = new GridBagConstraints();
		gbc_btnBorrarTodo.fill = GridBagConstraints.BOTH;
		gbc_btnBorrarTodo.insets = new Insets(0, 0, 5, 0);
		gbc_btnBorrarTodo.gridx = 0;
		gbc_btnBorrarTodo.gridy = 1;
		panel_2.add(btnBorrarTodo, gbc_btnBorrarTodo);

		JButton btnEditarSeleccionado = new JButton("Editar Seleccionado");
		GridBagConstraints gbc_btnEditarSeleccionado = new GridBagConstraints();
		gbc_btnEditarSeleccionado.fill = GridBagConstraints.BOTH;
		gbc_btnEditarSeleccionado.gridx = 0;
		gbc_btnEditarSeleccionado.gridy = 2;
		panel_2.add(btnEditarSeleccionado, gbc_btnEditarSeleccionado);

		JScrollPane scrollPane = new JScrollPane();
		panel_1.add(scrollPane, BorderLayout.CENTER);

		JList list = new JList();
		scrollPane.setViewportView(list);
	}

}
