package exerciciosCasa07;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JTabbedPane;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import java.awt.GridBagConstraints;
import javax.swing.JLabel;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JSpinner;
import java.util.ResourceBundle;

public class Vista {

	private static final ResourceBundle BUNDLE = ResourceBundle.getBundle("exercicioSwing07.messages"); //$NON-NLS-1$

	private JFrame frame;
	private JLabel lblRandomNumber;
	private JSpinner textField;
	private JSpinner textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	
	Controlador controlador;

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
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(new BorderLayout(0, 0));
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		panel.add(tabbedPane);
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Xerar", null, panel_1, null);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[]{0, 0, 0};
		gbl_panel_1.rowHeights = new int[]{0, 0};
		gbl_panel_1.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		gbl_panel_1.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		panel_1.setLayout(gbl_panel_1);
		
		JButton btnGenSaveRandNum = new JButton(BUNDLE.getString("Vista.btnGenSaveRandNum.text")); //$NON-NLS-1$
		btnGenSaveRandNum.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int numeroAleatorio = controlador.xerarNumeroAleatorio();
				lblRandomNumber.setText(Integer.toString(numeroAleatorio));
				// TODO gardar o número aleatorio
				
			}
		});
		GridBagConstraints gbc_btnGenSaveRandNum = new GridBagConstraints();
		gbc_btnGenSaveRandNum.insets = new Insets(0, 0, 0, 5);
		gbc_btnGenSaveRandNum.gridx = 0;
		gbc_btnGenSaveRandNum.gridy = 0;
		panel_1.add(btnGenSaveRandNum, gbc_btnGenSaveRandNum);
		
		lblRandomNumber = new JLabel(BUNDLE.getString("Vista.lblRandomNumber.text")); //$NON-NLS-1$
		GridBagConstraints gbc_lblRandomNumber = new GridBagConstraints();
		gbc_lblRandomNumber.gridx = 1;
		gbc_lblRandomNumber.gridy = 0;
		panel_1.add(lblRandomNumber, gbc_lblRandomNumber);
		
		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("Listar", null, panel_2, null);
		panel_2.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		panel_2.add(scrollPane);
		
		JPanel panel_4 = new JPanel();
		scrollPane.setViewportView(panel_4);
		
		JPanel panel_3 = new JPanel();
		tabbedPane.addTab("Configuraci\u00F3n", null, panel_3, null);
		panel_3.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_5 = new JPanel();
		panel_3.add(panel_5, BorderLayout.NORTH);
		GridBagLayout gbl_panel_5 = new GridBagLayout();
		gbl_panel_5.columnWidths = new int[]{0, 0};
		gbl_panel_5.rowHeights = new int[]{0, 0};
		gbl_panel_5.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gbl_panel_5.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		panel_5.setLayout(gbl_panel_5);
		
		JLabel lblNewLabel = new JLabel(BUNDLE.getString("Vista.lblNewLabel.text")); //$NON-NLS-1$
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		panel_5.add(lblNewLabel, gbc_lblNewLabel);
		
		JPanel panel_6 = new JPanel();
		panel_3.add(panel_6, BorderLayout.CENTER);
		GridBagLayout gbl_panel_6 = new GridBagLayout();
		gbl_panel_6.columnWidths = new int[]{0, 0, 0};
		gbl_panel_6.rowHeights = new int[]{0, 0, 0, 0, 0, 0};
		gbl_panel_6.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_panel_6.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel_6.setLayout(gbl_panel_6);
		
		JLabel lblServidor = new JLabel(BUNDLE.getString("Vista.lblServidor.text")); //$NON-NLS-1$
		GridBagConstraints gbc_lblServidor = new GridBagConstraints();
		gbc_lblServidor.anchor = GridBagConstraints.EAST;
		gbc_lblServidor.insets = new Insets(0, 0, 5, 5);
		gbc_lblServidor.gridx = 0;
		gbc_lblServidor.gridy = 0;
		panel_6.add(lblServidor, gbc_lblServidor);
		
		textField_2 = new JTextField();
		GridBagConstraints gbc_textField_2 = new GridBagConstraints();
		gbc_textField_2.insets = new Insets(0, 0, 5, 0);
		gbc_textField_2.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_2.gridx = 1;
		gbc_textField_2.gridy = 0;
		panel_6.add(textField_2, gbc_textField_2);
		textField_2.setColumns(10);
		
		JLabel lblPorto = new JLabel(BUNDLE.getString("Vista.lblPorto.text")); //$NON-NLS-1$
		GridBagConstraints gbc_lblPorto = new GridBagConstraints();
		gbc_lblPorto.anchor = GridBagConstraints.EAST;
		gbc_lblPorto.insets = new Insets(0, 0, 5, 5);
		gbc_lblPorto.gridx = 0;
		gbc_lblPorto.gridy = 1;
		panel_6.add(lblPorto, gbc_lblPorto);
		
		textField_3 = new JTextField();
		GridBagConstraints gbc_textField_3 = new GridBagConstraints();
		gbc_textField_3.insets = new Insets(0, 0, 5, 0);
		gbc_textField_3.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_3.gridx = 1;
		gbc_textField_3.gridy = 1;
		panel_6.add(textField_3, gbc_textField_3);
		textField_3.setColumns(10);
		
		JLabel lblUsuario = new JLabel(BUNDLE.getString("Vista.lblUsuario.text")); //$NON-NLS-1$
		GridBagConstraints gbc_lblUsuario = new GridBagConstraints();
		gbc_lblUsuario.anchor = GridBagConstraints.EAST;
		gbc_lblUsuario.insets = new Insets(0, 0, 5, 5);
		gbc_lblUsuario.gridx = 0;
		gbc_lblUsuario.gridy = 2;
		panel_6.add(lblUsuario, gbc_lblUsuario);
		
		textField_4 = new JTextField();
		GridBagConstraints gbc_textField_4 = new GridBagConstraints();
		gbc_textField_4.insets = new Insets(0, 0, 5, 0);
		gbc_textField_4.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_4.gridx = 1;
		gbc_textField_4.gridy = 2;
		panel_6.add(textField_4, gbc_textField_4);
		textField_4.setColumns(10);
		
		JLabel lblPassword = new JLabel(BUNDLE.getString("Vista.lblPassword.text")); //$NON-NLS-1$
		GridBagConstraints gbc_lblPassword = new GridBagConstraints();
		gbc_lblPassword.anchor = GridBagConstraints.EAST;
		gbc_lblPassword.insets = new Insets(0, 0, 5, 5);
		gbc_lblPassword.gridx = 0;
		gbc_lblPassword.gridy = 3;
		panel_6.add(lblPassword, gbc_lblPassword);
		
		textField_5 = new JTextField();
		GridBagConstraints gbc_textField_5 = new GridBagConstraints();
		gbc_textField_5.insets = new Insets(0, 0, 5, 0);
		gbc_textField_5.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_5.gridx = 1;
		gbc_textField_5.gridy = 3;
		panel_6.add(textField_5, gbc_textField_5);
		textField_5.setColumns(10);
		
		JLabel lblSchemaDb = new JLabel(BUNDLE.getString("Vista.lblSchemaDb.text")); //$NON-NLS-1$
		GridBagConstraints gbc_lblSchemaDb = new GridBagConstraints();
		gbc_lblSchemaDb.anchor = GridBagConstraints.EAST;
		gbc_lblSchemaDb.insets = new Insets(0, 0, 0, 5);
		gbc_lblSchemaDb.gridx = 0;
		gbc_lblSchemaDb.gridy = 4;
		panel_6.add(lblSchemaDb, gbc_lblSchemaDb);
		
		textField_6 = new JTextField();
		GridBagConstraints gbc_textField_6 = new GridBagConstraints();
		gbc_textField_6.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_6.gridx = 1;
		gbc_textField_6.gridy = 4;
		panel_6.add(textField_6, gbc_textField_6);
		textField_6.setColumns(10);
		
		JPanel panel_7 = new JPanel();
		panel_3.add(panel_7, BorderLayout.SOUTH);
		GridBagLayout gbl_panel_7 = new GridBagLayout();
		gbl_panel_7.columnWidths = new int[]{0, 0, 0};
		gbl_panel_7.rowHeights = new int[]{0, 0, 0, 0};
		gbl_panel_7.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_panel_7.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel_7.setLayout(gbl_panel_7);
		
		JLabel lblParmetrosDeXeracin = new JLabel(BUNDLE.getString("Vista.lblParmetrosDeXeracin.text")); //$NON-NLS-1$
		GridBagConstraints gbc_lblParmetrosDeXeracin = new GridBagConstraints();
		gbc_lblParmetrosDeXeracin.insets = new Insets(0, 0, 5, 5);
		gbc_lblParmetrosDeXeracin.gridx = 0;
		gbc_lblParmetrosDeXeracin.gridy = 0;
		panel_7.add(lblParmetrosDeXeracin, gbc_lblParmetrosDeXeracin);
		
		JLabel lblValorMnimo = new JLabel(BUNDLE.getString("Vista.lblValorMnimo.text")); //$NON-NLS-1$
		GridBagConstraints gbc_lblValorMnimo = new GridBagConstraints();
		gbc_lblValorMnimo.anchor = GridBagConstraints.EAST;
		gbc_lblValorMnimo.insets = new Insets(0, 0, 5, 5);
		gbc_lblValorMnimo.gridx = 0;
		gbc_lblValorMnimo.gridy = 1;
		panel_7.add(lblValorMnimo, gbc_lblValorMnimo);
		
		textField = new JSpinner();
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.insets = new Insets(0, 0, 5, 0);
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 1;
		gbc_textField.gridy = 1;
		panel_7.add(textField, gbc_textField);
		
		JLabel lblValorMximo = new JLabel(BUNDLE.getString("Vista.lblValorMximo.text")); //$NON-NLS-1$
		GridBagConstraints gbc_lblValorMximo = new GridBagConstraints();
		gbc_lblValorMximo.anchor = GridBagConstraints.EAST;
		gbc_lblValorMximo.insets = new Insets(0, 0, 0, 5);
		gbc_lblValorMximo.gridx = 0;
		gbc_lblValorMximo.gridy = 2;
		panel_7.add(lblValorMximo, gbc_lblValorMximo);
		
		textField_1 = new JSpinner();
		GridBagConstraints gbc_textField_1 = new GridBagConstraints();
		gbc_textField_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_1.gridx = 1;
		gbc_textField_1.gridy = 2;
		panel_7.add(textField_1, gbc_textField_1);
	}

	public JLabel getLblRandomNumber() {
		return lblRandomNumber;
	}
	
	
}
