package t09_MVC;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import java.awt.BorderLayout;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

public class Vista {

	private JFrame frame;

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

		JScrollPane scrollPane = new JScrollPane();
		frame.getContentPane().add(scrollPane, BorderLayout.CENTER);

		JList list = new JList();
		list.setModel(new DefaultListModel<Cliente>());
		scrollPane.setViewportView(list);

		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.SOUTH);

		JButton btnConectar = new JButton("Conectar BD");
		btnConectar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				BDManager bd = new BDManager();
				Connection con;
				try {
					con = bd.abrirBD();
					ArrayList<Cliente> listaClientes;
					listaClientes = bd.listarBD(con);
					DefaultListModel<Cliente> dlm = (DefaultListModel<Cliente>) list.getModel();
					for (Cliente c : listaClientes) {
						dlm.addElement(c);
	
					}

				} catch (SQLException e) {
					JOptionPane.showMessageDialog(frame, "Error");

				}

			}
		});
		panel.add(btnConectar);

		JButton btnDesconectar = new JButton("DesconectarDB");
		btnDesconectar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
			}
		});
		panel.add(btnDesconectar);

		JButton btnRefrescar = new JButton("Refrescar");
		btnRefrescar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		panel.add(btnRefrescar);

		JButton btnAdd = new JButton("A\u00F1adir");
		btnAdd.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		panel.add(btnAdd);

		JButton btnBorrar = new JButton("Borrar Selecc");
		panel.add(btnBorrar);
	}

}
