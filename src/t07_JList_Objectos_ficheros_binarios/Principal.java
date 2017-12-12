package t07_JList_Objectos_ficheros_binarios;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.awt.event.ActionEvent;
import javax.swing.JMenu;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JScrollPane;
import javax.swing.JList;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;

import t07_JList_Objectos_ficheros_binarios.Producto;

import javax.swing.DefaultListModel;
import javax.swing.JButton;

public class Principal {

	private JFrame frame;
	private JTextField textNombre;
	private JTextField textPrecio;

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

		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);

		JList listaProductos = new JList();
		listaProductos.setModel(new DefaultListModel());

		JMenuItem mntmSalir = new JMenuItem("Salir");
		mntmSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		menuBar.add(mntmSalir);

		JMenu mnNewMenu = new JMenu("Herramientas");
		menuBar.add(mnNewMenu);

		JMenuItem mntmCargar = new JMenuItem("Cargar");
		mntmCargar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultListModel<Producto> dlm = (DefaultListModel<Producto>) listaProductos.getModel();
				File fichero = new File("datos.obj");
				FileInputStream fis = null;
				try {
					fis = new FileInputStream(fichero);
					ObjectInputStream ois = new ObjectInputStream(fis);
					Producto p = (Producto) ois.readObject();
					while (p != null) {
						p = (Producto) ois.readObject();
						dlm.addElement(p);
					}

				} catch (IOException | ClassNotFoundException ex) {
					System.out.println("Error" + ex);
				} finally {
					try {
						fis.close();
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				}

			}
		});
		mnNewMenu.add(mntmCargar);

		JMenuItem mntmGuardar = new JMenuItem("Guardar");
		mntmGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultListModel<Producto> dlm = (DefaultListModel<Producto>) listaProductos.getModel();

				File fichero = new File("datos.obj");
				FileOutputStream fos = null;
				try {
					fos = new FileOutputStream(fichero);
					ObjectOutputStream oos = new ObjectOutputStream(fos);
					// recorrer la lista de producto
					for (int i = 0; i < dlm.size(); i++) {
						Producto producto = (Producto) dlm.getElementAt(i);
						oos.writeObject(producto);
					}

				} catch (IOException e1) {
					System.out.println("Error" + e1);
				} finally {
					try {
						fos.close();
					} catch (IOException e1) {
						System.out.println("Error" + e1);
					}
				}
			}
		});
		mnNewMenu.add(mntmGuardar);

		JMenuItem mntmLimpliar = new JMenuItem("Limpliar");
		mntmLimpliar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultListModel<Producto> dlm = (DefaultListModel<Producto>) listaProductos.getModel();
				dlm.clear();
			}
		});
		mnNewMenu.add(mntmLimpliar);

		JMenuItem mntmLimpiarSeleccionaro = new JMenuItem("Limpiar seleccionaro");
		mntmLimpiarSeleccionaro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultListModel<Producto> dlm = (DefaultListModel<Producto>) listaProductos.getModel();

				if (listaProductos.getSelectedIndex() == -1) {
					return;
				}

				int indiceSelecionado = listaProductos.getSelectedIndex();
				dlm.remove(indiceSelecionado);
			}
		});
		mnNewMenu.add(mntmLimpiarSeleccionaro);

		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.WEST);
		panel.setLayout(new GridLayout(0, 1, 0, 0));

		JLabel lblNombre = new JLabel("Nombre");
		panel.add(lblNombre);

		textNombre = new JTextField();
		panel.add(textNombre);
		textNombre.setColumns(10);

		JLabel lblPrecio = new JLabel("Precio");
		panel.add(lblPrecio);

		textPrecio = new JTextField();
		panel.add(textPrecio);
		textPrecio.setColumns(10);

		JButton btnAdd = new JButton("A\u00F1adir");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultListModel<Producto> dlm = (DefaultListModel<Producto>) listaProductos.getModel();
				if (textNombre.getText().isEmpty() || textPrecio.getText().isEmpty()) {
					return;
				}

				String nombre = textNombre.getText();
				float precio;
				try {
					precio = Float.parseFloat(textPrecio.getText());
				} catch (NumberFormatException ex) {
					precio = 0;
					textPrecio.setText("0");
					return;
				}

				Producto p = new Producto(nombre, precio);

				dlm.addElement(p);

			}
		});
		panel.add(btnAdd);

		JScrollPane scrollPane = new JScrollPane();
		frame.getContentPane().add(scrollPane, BorderLayout.CENTER);

		scrollPane.setViewportView(listaProductos);
	}

}
