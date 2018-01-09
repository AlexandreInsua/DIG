package exerciciosRepaso.exercicio09;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JList;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Principal {

	private JFrame frame;
	private JTextField txtNombre;
	private JTextField txtApellidos;
	private JTextField txtTelefono;
	private JList listJugadores;

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
		frame.setResizable(false);
		frame.setBounds(100, 100, 280, 316);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nombre:");
		lblNewLabel.setBounds(10, 11, 86, 14);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Apellido:");
		lblNewLabel_1.setBounds(10, 36, 86, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Telefono:");
		lblNewLabel_2.setBounds(10, 61, 86, 14);
		frame.getContentPane().add(lblNewLabel_2);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(108, 8, 86, 20);
		frame.getContentPane().add(txtNombre);
		txtNombre.setColumns(10);
		
		txtApellidos = new JTextField();
		txtApellidos.setBounds(108, 33, 86, 20);
		frame.getContentPane().add(txtApellidos);
		txtApellidos.setColumns(10);
		
		txtTelefono = new JTextField();
		txtTelefono.setBounds(108, 58, 86, 20);
		frame.getContentPane().add(txtTelefono);
		txtTelefono.setColumns(10);
		
		JButton btnNewButton = new JButton("A\u00F1adir");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				String nombre = txtNombre.getText();
				if(nombre==null || nombre.isEmpty()){
					return;
				}
				String apellidos = txtApellidos.getText();
				String telefono = txtTelefono.getText();
				Jugador jugador = new Jugador(nombre, apellidos, telefono);
				DefaultListModel<Jugador> dlm = 
						(DefaultListModel<Jugador>) listJugadores.getModel();
				dlm.addElement(jugador);
			}
		});
		btnNewButton.setBounds(163, 90, 89, 23);
		frame.getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel_3 = new JLabel("Lista de jugadores");
		lblNewLabel_3.setBounds(10, 109, 141, 14);
		frame.getContentPane().add(lblNewLabel_3);
		
		listJugadores = new JList();
		listJugadores.setModel(new DefaultListModel<>());
		listJugadores.setBounds(10, 134, 242, 87);
		frame.getContentPane().add(listJugadores);
		
		JButton btnNewButton_1 = new JButton("Borrar seleccionado");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				int indiceSeleccionado = listJugadores.getSelectedIndex();
				if(indiceSeleccionado<0)
					return;
				
				DefaultListModel<Jugador> dlm = 
						(DefaultListModel<Jugador>) listJugadores.getModel();
				dlm.removeElementAt(indiceSeleccionado);
			}
		});
		btnNewButton_1.setBounds(10, 232, 193, 23);
		frame.getContentPane().add(btnNewButton_1);
	}
	public JTextField getTextField() {
		return txtNombre;
	}
	public JTextField getTextField_1() {
		return txtApellidos;
	}
	public JTextField getTextField_2() {
		return txtTelefono;
	}
	public JList getList() {
		return listJugadores;
	}
}
