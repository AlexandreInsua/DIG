package teoria;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JScrollPane;

import java.awt.BorderLayout;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class Teoria17_listadoClienteBD_Vista<Cliente> {

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
					Teoria17_listadoClienteBD_Vista window = new Teoria17_listadoClienteBD_Vista();
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
	public Teoria17_listadoClienteBD_Vista() {
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
		list.setModel(new DefaultListModel<Cliente>());
		scrollPane.setViewportView(list);

		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.SOUTH);

		JButton btnConectar = new JButton("Conectar BD");
		btnConectar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				try {
					// BDManager bd = new BDManager();

					con = Teoria17_listadoClienteBD_controlador.abrirBD();
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
					if (con != null) {
						Teoria17_listadoClienteBD_controlador.cerrarBD(con);
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
				Teoria17_listadoClienteBD_FormulariosCliente formulario = new Teoria17_listadoClienteBD_FormulariosCliente(
						con);
				formulario.setVisible(true);
			}
		});
		panel.add(btnAdd);

		JButton btnBorrar = new JButton("Borrar Selecc");
		btnBorrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					Teoria17_listadoClienteBD_Cliente clienteSeleccionado = (Teoria17_listadoClienteBD_Cliente) list
							.getSelectedValue();
					Teoria17_listadoClienteBD_controlador.borrarCliente(con, clienteSeleccionado.getId());
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
		ArrayList<Cliente> listaClientes = null;
		try {
			listaClientes = (ArrayList<Cliente>) Teoria17_listadoClienteBD_controlador.listarBD(con);

			DefaultListModel<Cliente> dlm = (DefaultListModel<Cliente>) list.getModel();
			dlm.clear();
			for (Cliente c : listaClientes) {
				dlm.addElement(c);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(frame, "ERROR Al listar los datos");
		}
	}

}
