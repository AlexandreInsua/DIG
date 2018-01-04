package exerciciosRepaso.exercicio05;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JList;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Principal {

	private JFrame frame;
	private JTextField txtNombre;
	private JList listNombres;

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
		frame.setBounds(100, 100, 304, 287);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nombre");
		lblNewLabel.setBounds(10, 11, 58, 14);
		frame.getContentPane().add(lblNewLabel);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(66, 8, 98, 20);
		frame.getContentPane().add(txtNombre);
		txtNombre.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Lista de nombres de personas:");
		lblNewLabel_1.setBounds(10, 47, 220, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		listNombres = new JList();
		// Estábleceselle un model
		listNombres.setModel(new DefaultListModel());
		listNombres.setBounds(10, 72, 173, 131);
		frame.getContentPane().add(listNombres);
		
		JButton btnAadirNombre = new JButton("A\u00F1adir nombre");
		btnAadirNombre.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				String nombre = txtNombre.getText();
				if (nombre==null || nombre.isEmpty())
					return;
				// Recupera o model da lista
				DefaultListModel dlm = (DefaultListModel) listNombres.getModel();
				// Engádelle un nome
				dlm.addElement(nombre);
			}
		});
		btnAadirNombre.setBounds(162, 7, 136, 23);
		frame.getContentPane().add(btnAadirNombre);
		
		JButton btnBorrarNombreSeleccionado = new JButton("Borrar nombre seleccionado");
		btnBorrarNombreSeleccionado.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// Recupera o elemento seleccionado
				int indiceSeleccionado = listNombres.getSelectedIndex();
				if(indiceSeleccionado<0)
					return;
				//String valorSeleccionado = (String) listNombres.getSelectedValue();
				// Recupera o modelo
				DefaultListModel dlm = (DefaultListModel) listNombres.getModel();
				// Borra o elemento seleccionado
				dlm.remove(indiceSeleccionado);
				//dlm.removeElement(valorSeleccionado);
			}
		});
		btnBorrarNombreSeleccionado.setBounds(10, 222, 220, 23);
		frame.getContentPane().add(btnBorrarNombreSeleccionado);
	}
	public JTextField getTxtNombre() {
		return txtNombre;
	}
	public JList getListNombres() {
		return listNombres;
	}
}
