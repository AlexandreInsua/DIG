package teoria;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import java.awt.BorderLayout;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import javax.swing.JTextField;
import java.awt.Insets;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.ListSelectionModel;

public class Teoria13_TablaPuntuaciones {

	private JFrame frame;
	private JScrollPane scrollPane;
	private JTable table;
	private JPanel panel;
	private JLabel lblNewLabel;
	private JTextField txtNombre;
	private JLabel lblNewLabel_1;
	private JSpinner txtPuntuacion;
	private JButton btnAdd;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Teoria13_TablaPuntuaciones window = new Teoria13_TablaPuntuaciones();
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
	public Teoria13_TablaPuntuaciones() {
		initialize();
		rellenarDatosTabla();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				DefaultTableModel dtm = (DefaultTableModel) table.getModel();
				String dato = (String) dtm.getValueAt(1, 1);
				String mensaje = "El valor de la celda [1,1] es "+dato;
				JOptionPane.showMessageDialog(frame, mensaje);
				
			}
		});
		frame.getContentPane().add(btnNewButton, BorderLayout.SOUTH);
		
		scrollPane = new JScrollPane();
		frame.getContentPane().add(scrollPane, BorderLayout.CENTER);
		
		table = new JTable();
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane.setViewportView(table);
		
		panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.WEST);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 0};
		gbl_panel.rowHeights = new int[]{0, 0, 0, 0, 0, 0};
		gbl_panel.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		lblNewLabel = new JLabel("Nombre:");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(20, 0, 5, 0);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		panel.add(lblNewLabel, gbc_lblNewLabel);
		
		txtNombre = new JTextField();
		GridBagConstraints gbc_txtNombre = new GridBagConstraints();
		gbc_txtNombre.insets = new Insets(0, 0, 5, 0);
		gbc_txtNombre.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtNombre.gridx = 0;
		gbc_txtNombre.gridy = 1;
		panel.add(txtNombre, gbc_txtNombre);
		txtNombre.setColumns(10);
		
		lblNewLabel_1 = new JLabel("Puntuaci\u00F3n:");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 2;
		panel.add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		txtPuntuacion = new JSpinner();
		txtPuntuacion.setModel(new SpinnerNumberModel(5, 0, 10, 1));
		GridBagConstraints gbc_txtPuntuacion = new GridBagConstraints();
		gbc_txtPuntuacion.insets = new Insets(0, 0, 5, 0);
		gbc_txtPuntuacion.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtPuntuacion.gridx = 0;
		gbc_txtPuntuacion.gridy = 3;
		panel.add(txtPuntuacion, gbc_txtPuntuacion);
		
		btnAdd = new JButton("A\u00F1adir");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String nombre = txtNombre.getText();
				int puntuacion = (int) txtPuntuacion.getValue();
				
				// validaciones
				if(nombre.isEmpty()) {
					JOptionPane.showMessageDialog(frame, "Error, el nombre es obligatorio");
					return;
				}
				
				DefaultTableModel dtm = (DefaultTableModel) table.getModel();
				Object[] datos = new Object[] { nombre, puntuacion };
				dtm.addRow(datos);
				
				txtNombre.setText("");
				txtPuntuacion.setValue(5);
				
			}
		});
		GridBagConstraints gbc_btnAdd = new GridBagConstraints();
		gbc_btnAdd.gridx = 0;
		gbc_btnAdd.gridy = 4;
		panel.add(btnAdd, gbc_btnAdd);
	}
 
	void rellenarDatosTabla() {
		DefaultTableModel dtm = (DefaultTableModel) table.getModel();
		dtm.addColumn("Nombre");
		dtm.addColumn("Puntuacion");
		Object[] datos = {"Angel", "10"};
		dtm.addRow(datos);
	
		datos = new Object[] {"Manuel", "5"};
		dtm.addRow(datos);
	
	}
}
