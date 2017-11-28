package teoria17ListadoClientesBD;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class Vista {

	private JFrame frame;
	Connection con;
	private JList list;
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
		frame.setBounds(100, 100, 491, 307);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JScrollPane scrollPane = new JScrollPane();
		frame.getContentPane().add(scrollPane, BorderLayout.CENTER);
		
		list = new JList();
		list.setModel( new DefaultListModel<Cliente>() );
		scrollPane.setViewportView(list);
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.SOUTH);
		
		JButton btnConectar = new JButton("Conectar BD");
		btnConectar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try {
					//BDManager bd = new BDManager();
					
					con = BDManager.abrirBD();
					refrescarDatosBD();
					
				
				} catch (SQLException e) {
					JOptionPane.showMessageDialog(frame, "Erro el la BD");
					e.printStackTrace();
				}
				
			}
		});
		panel.add(btnConectar);
		
		JButton btnDesconectar = new JButton("DesconectarDB");
		btnDesconectar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try {
					if(con!=null) {
						BDManager.cerrarBD(con);
					}
				} catch (SQLException e) {
					JOptionPane.showMessageDialog(frame, "Error al cerrar la conexión");
					e.printStackTrace();
				}
			}
		});
		panel.add(btnDesconectar);
		
		JButton btnRefrescar = new JButton("Refrescar");
		btnRefrescar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				refrescarDatosBD();
			}
		});
		panel.add(btnRefrescar);
		
		JButton btnAdd = new JButton("A\u00F1adir");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FormularioCliente formulario = new FormularioCliente( con );
				formulario.setVisible(true);
			}
		});
		panel.add(btnAdd);
		
		JButton btnBorrar = new JButton("Borrar Selecc");
		btnBorrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					Cliente clienteSeleccionado = (Cliente) list.getSelectedValue();
					BDManager.borrarCliente(con, clienteSeleccionado.getId());
					refrescarDatosBD();
				} catch (SQLException e) {
					JOptionPane.showMessageDialog(frame, "ERROR Al borrar cliente");
					e.printStackTrace();
				}
			}
		});
		panel.add(btnBorrar);
	}
	
	
	private void refrescarDatosBD() {
		ArrayList<Cliente> listaClientes=null;
		try {
			listaClientes = BDManager.listarBD(con);
		
		
			DefaultListModel<Cliente> dlm = 
					(DefaultListModel<Cliente>)list.getModel();
			dlm.clear();
			for(Cliente c: listaClientes) {
				dlm.addElement(c);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(frame, "ERROR Al listar los datos");
		}
	}

}
