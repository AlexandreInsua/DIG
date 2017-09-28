package lista_productos;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.GridLayout;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Principal {

	private JFrame frame;
	private JTextField txtNombre;
	private JTextField txtPrecio;

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
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		frame.getContentPane().add(scrollPane, BorderLayout.CENTER);
		
		JList<Producto> listaProductos = new JList();
		listaProductos.setModel(new DefaultListModel<Producto>());
		scrollPane.setViewportView(listaProductos);
		
		JPanel panel_1 = new JPanel();
		frame.getContentPane().add(panel_1, BorderLayout.WEST);
		panel_1.setLayout(new GridLayout(5, 1, 0, 0));
		
		JLabel lblNewLabel = new JLabel("Nome:");
		panel_1.add(lblNewLabel);
		
		txtNombre = new JTextField();
		panel_1.add(txtNombre);
		txtNombre.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Precio:");
		panel_1.add(lblNewLabel_1);
		
		txtPrecio = new JTextField();
		panel_1.add(txtPrecio);
		txtPrecio.setColumns(10);
		
		JButton btnAdd = new JButton("Engadir");
		btnAdd.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				DefaultListModel <Producto>dlm=(DefaultListModel<Producto>) listaProductos.getModel();
				String nombre=txtNombre.getText();
				float precio=Float.parseFloat(txtPrecio.getText());
				Producto p = new Producto(nombre,precio);
				dlm.addElement(p);
				
			}
		});
		panel_1.add(btnAdd);
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		JMenuItem mntmSalir = new JMenuItem("Salir");
		menuBar.add(mntmSalir);
		
		JMenu mnHerramientas = new JMenu("Herramientas");
		menuBar.add(mnHerramientas);
		
		JMenuItem mntmLimpiar = new JMenuItem("Limpiar");
		mnHerramientas.add(mntmLimpiar);
		
		JMenuItem mntmGuardar = new JMenuItem("Guardar");
		mnHerramientas.add(mntmGuardar);
	}

}
