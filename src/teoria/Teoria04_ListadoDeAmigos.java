package teoria;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import javax.swing.JTextField;
import java.awt.Insets;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.awt.event.ActionEvent;

public class Teoria04_ListadoDeAmigos {

	private JFrame frame;
	private JTextField txtNombre;
	private JButton btnAdd;
	private JScrollPane scrollPane;
	private JList<String> listaAmigos;
	private JButton btnLimpiar;
	private JButton btnGuardarDisco;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Teoria04_ListadoDeAmigos window = new Teoria04_ListadoDeAmigos();
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
	public Teoria04_ListadoDeAmigos() {
		initialize();
		
		
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 265, 231);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 1.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 1.0, 0.0, Double.MIN_VALUE};
		frame.getContentPane().setLayout(gridBagLayout);
		
		JLabel lblNewLabel = new JLabel("Nombre");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		frame.getContentPane().add(lblNewLabel, gbc_lblNewLabel);
		
		txtNombre = new JTextField();
		GridBagConstraints gbc_txtNombre = new GridBagConstraints();
		gbc_txtNombre.insets = new Insets(0, 0, 5, 5);
		gbc_txtNombre.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtNombre.gridx = 1;
		gbc_txtNombre.gridy = 0;
		frame.getContentPane().add(txtNombre, gbc_txtNombre);
		txtNombre.setColumns(10);
		
		btnAdd = new JButton("Añadir");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nombre = txtNombre.getText();
				
				DefaultListModel<String> dlm = (DefaultListModel<String>) listaAmigos.getModel();
				dlm.addElement(nombre);
				
				txtNombre.setText("");
			}
		});
		GridBagConstraints gbc_btnAdd = new GridBagConstraints();
		gbc_btnAdd.insets = new Insets(0, 0, 5, 0);
		gbc_btnAdd.gridx = 2;
		gbc_btnAdd.gridy = 0;
		frame.getContentPane().add(btnAdd, gbc_btnAdd);
		
		scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.insets = new Insets(0, 0, 5, 0);
		gbc_scrollPane.gridwidth = 2;
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 1;
		gbc_scrollPane.gridy = 1;
		frame.getContentPane().add(scrollPane, gbc_scrollPane);
		
		listaAmigos = new JList<String>();
		listaAmigos.setModel( new DefaultListModel<String>() );
		scrollPane.setViewportView(listaAmigos);
		
		btnLimpiar = new JButton("Limpiar");
		btnLimpiar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				DefaultListModel<String> dlm = (DefaultListModel<String>) listaAmigos.getModel();
				dlm.clear();
				
				txtNombre.setText("");
			}
		});
		GridBagConstraints gbc_btnLimpiar = new GridBagConstraints();
		gbc_btnLimpiar.insets = new Insets(0, 0, 0, 5);
		gbc_btnLimpiar.gridx = 1;
		gbc_btnLimpiar.gridy = 2;
		frame.getContentPane().add(btnLimpiar, gbc_btnLimpiar);
		
		btnGuardarDisco = new JButton("Guardar en disco");
		btnGuardarDisco.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				DefaultListModel<String> dlm = (DefaultListModel<String>) listaAmigos.getModel();
				
				File fichero = new File("amigos.txt");
				FileWriter fw=null;
				try {
					
					fw = new FileWriter(fichero);
					for(int i=0 ; i<dlm.getSize() ; i++) {
						String elemento = dlm.getElementAt(i);
						fw.write(elemento);
					}
					
				} catch (IOException e1) {
					JOptionPane.showMessageDialog(frame, "Error en el fichero");
				}finally {
					try {
						fw.close();
					} catch (IOException e1) {
						JOptionPane.showMessageDialog(frame, "Error en el fichero");
					}
				}
				
				
			}
		});
		GridBagConstraints gbc_btnGuardarDisco = new GridBagConstraints();
		gbc_btnGuardarDisco.gridx = 2;
		gbc_btnGuardarDisco.gridy = 2;
		frame.getContentPane().add(btnGuardarDisco, gbc_btnGuardarDisco);
	}

	public JList getList() {
		return listaAmigos;
	}
}
