package teoria;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import java.awt.BorderLayout;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.GridLayout;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Teoria08_ListaDeObjetos {

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
					Teoria08_ListaDeObjetos window = new Teoria08_ListaDeObjetos();
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
	public Teoria08_ListaDeObjetos() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 515, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JScrollPane scrollPane = new JScrollPane();
		frame.getContentPane().add(scrollPane, BorderLayout.CENTER);
		
		JList listaProductos = new JList();
		listaProductos.setModel( new DefaultListModel() );
		
		scrollPane.setViewportView(listaProductos);
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.WEST);
		panel.setLayout(new GridLayout(5, 1, 0, 0));
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblNombre);
		
		txtNombre = new JTextField();
		panel.add(txtNombre);
		txtNombre.setColumns(10);
		
		JLabel lblPrecio = new JLabel("Precio");
		lblPrecio.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblPrecio);
		
		txtPrecio = new JTextField();
		txtPrecio.setText("");
		panel.add(txtPrecio);
		txtPrecio.setColumns(10);
		
		JButton btnAdd = new JButton("A\u00F1adir");
		btnAdd.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				DefaultListModel<Producto> dlm = (DefaultListModel<Producto> ) listaProductos.getModel();

				
				if(txtNombre.getText().isEmpty() || txtPrecio.getText().isEmpty()) {
					return;
				}
				
				
				String nombre = txtNombre.getText();
				float precio;
				try {
					precio = Float.parseFloat ( txtPrecio.getText() );
				}catch(NumberFormatException ex) {
					precio = 0;
					txtPrecio.setText("0");
					return;
				}

				Producto p = new Producto( nombre, precio );


				dlm.addElement ( p );

				
			}
		});
		panel.add(btnAdd);
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		JMenuItem mntmSalir = new JMenuItem("Salir");
		menuBar.add(mntmSalir);
		
		JMenu mnHerramientas = new JMenu("Herramientas");
		menuBar.add(mnHerramientas);
		
		JMenuItem mntmCargar = new JMenuItem("Cargar");
		mntmCargar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultListModel<Producto> dlm = (DefaultListModel<Producto> ) listaProductos.getModel();

				File fichero = new File("datos.obj");
				FileInputStream fis=null;
				try {
					fis = new FileInputStream (fichero);
					ObjectInputStream ois = new ObjectInputStream (fis);
					Producto p = (Producto)ois.readObject();
					while( p != null) {
						dlm.addElement( p );
						p =  (Producto) ois.readObject();
					}
					
				} catch (IOException | ClassNotFoundException ex) {
					System.out.println("Error"+ex);
				}finally {
					try {
						fis.close();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				
		
			}
		});
		mnHerramientas.add(mntmCargar);
		
		JMenuItem mntmGuardar = new JMenuItem("Guardar");
		mntmGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultListModel<Producto> dlm = (DefaultListModel<Producto> ) listaProductos.getModel();

				File fichero = new File("datos.obj");
				FileOutputStream fos = null;
				try {
					fos = new FileOutputStream(fichero);
					ObjectOutputStream oos = new ObjectOutputStream( fos );
					// recorrer la lista de producto
					for(int i=0;i<dlm.size();i++) {
						Producto producto = dlm.getElementAt(i);
						oos.writeObject( producto );
					}
										
				} catch (IOException e1) {
					System.out.println("Error"+e1);
				}finally {
					try {
						fos.close();
					} catch (IOException e1) {
						System.out.println("Error"+e1);
					}
				}
				
				
			}
		});
		mnHerramientas.add(mntmGuardar);
		
		JMenuItem mntmLimpiar = new JMenuItem("Limpiar");
		mntmLimpiar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				DefaultListModel<Producto> dlm = (DefaultListModel<Producto> ) listaProductos.getModel();
				dlm.clear();
			}
		});
		mnHerramientas.add(mntmLimpiar);
		
		JMenuItem mntmLimpiarSeleccionado = new JMenuItem("Limpiar seleccionado");
		mntmLimpiarSeleccionado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultListModel<Producto> dlm = (DefaultListModel<Producto> ) listaProductos.getModel();
				
				if(listaProductos.getSelectedIndex() == -1) {
					return;
				}
				
				int indiceSelecionado = listaProductos.getSelectedIndex();
				dlm.remove(indiceSelecionado);
			}
		});
		mnHerramientas.add(mntmLimpiarSeleccionado);
	}

}


class Producto implements Serializable{
	private String nombre;
	private Float precio;

	public Producto(String nombre, Float precio) {
		super();
		this.nombre = nombre;
		this.precio = precio;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Float getPrecio() {
		return precio;
	}

	public void setPrecio(Float precio) {
		this.precio = precio;
	}

	@Override
	public String toString() {
		return nombre+ ":" +precio;
	}
	
	

}
