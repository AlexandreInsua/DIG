package app002_box_list;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JList;
import javax.swing.JTextField;
import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;

import java.awt.GridLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import javax.swing.JButton;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.SwingConstants;

import com.sun.org.apache.xerces.internal.xs.datatypes.ObjectList;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JMenu;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ListSelectionModel;

public class ObjectsList {

	private JFrame frame;
	private final JPanel panel = new JPanel();
	private JTextField txtName;
	private JTextField txtPrice;
	protected DefaultListModel<Product> productList;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ObjectsList window = new ObjectsList();
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
	public ObjectsList() {
		panel.setLayout(new BorderLayout(0, 0));
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 375, 316);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));

		JScrollPane scrollPane = new JScrollPane();
		frame.getContentPane().add(scrollPane, BorderLayout.CENTER);

		JList list = new JList();
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		list.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			
				
			}
		});
		scrollPane.setViewportView(list);
		frame.getContentPane().add(panel, BorderLayout.WEST);
		panel.setLayout(new GridLayout(6, 1, 0, 0));

		JLabel lblNewLabel = new JLabel("Nome");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblNewLabel);

		txtName = new JTextField();
		panel.add(txtName);
		txtName.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("Prezo");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblNewLabel_1);

		txtPrice = new JTextField();
		panel.add(txtPrice);
		txtPrice.setColumns(10);

		JButton btnNewButton = new JButton("Engadir");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnNewButton.addMouseListener(new MouseAdapter() {

			public void mouseClicked(MouseEvent arg0) {
				DefaultListModel<Product> dlm = (DefaultListModel<Product>) Product.getModel;
				String name = txtName.getText();
				Float price = Float.parseFloat(txtPrice.getText());
				Product p = new Product(name, price);
				dlm.addElement(p);
				txtName.setText("");
				txtPrice.setText("");
				
				
			}
		});
		panel.add(btnNewButton);
		
		JButton btnModify = new JButton("Modificar");
		btnModify.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
			}
		});
		panel.add(btnModify, BorderLayout.NORTH);

		JPanel panel_1 = new JPanel();
		frame.getContentPane().add(panel_1, BorderLayout.NORTH);

		JMenuBar menuBar_1 = new JMenuBar();
		panel_1.add(menuBar_1);

		JMenuItem mntmExit = new JMenuItem("Sa\u00EDr");
		mntmExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		menuBar_1.add(mntmExit);

		JMenu mnNewMenu = new JMenu("Menu");
		mnNewMenu.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// Toma o modelo da lista
				DefaultListModel<Product> dlm = (DefaultListModel<Product>) productList;
				File f = new File("Datos.obj");
				FileOutputStream fos = null;
				ObjectOutputStream oos;
				try {
					fos = new FileOutputStream(f);
					oos = new ObjectOutputStream(fos);

					for (int i = 0; i < dlm.size(); i++) {
						Product p = dlm.getElementAt(i);
						oos.writeObject(p);
					}
				} catch (FileNotFoundException fne) {

				} catch (IOException ioe) {

				} finally {
					try {
						fos.close();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		});
		mnNewMenu.setHorizontalAlignment(SwingConstants.LEFT);
		menuBar_1.add(mnNewMenu);

		JMenuItem mntmSave = new JMenuItem("Gardar");
		mnNewMenu.add(mntmSave);

		JMenuItem mntmClean = new JMenuItem("Limpar");
		mnNewMenu.add(mntmClean);

		JMenuItem mntmCleanSelected = new JMenuItem("Borrar seleccionado");
		mnNewMenu.add(mntmCleanSelected);

		JMenuItem mntmOpen = new JMenuItem("Abrir");
		mntmOpen.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				File f = new File("datos.obj");
				FileInputStream fis = null;
				ObjectInputStream ois = null;
				try {
					fis = new FileInputStream(f);
					ois = new ObjectInputStream(fis);
					Product p = (Product) ois.readObject();
					while (p != null) {
						System.out.println(p.getName()); // prova
						p = (Product) ois.readObject();
					}

				} catch (ClassNotFoundException cnf) {

				} catch (EOFException eof) {

				} catch (FileNotFoundException fnf) {

				} catch (IOException ioe) {

				} finally {
					try {
						fis.close();
					} catch (IOException ioe) {

					}
				}

			}
		});
		mnNewMenu.add(mntmOpen);
	}

}

class Product implements Serializable {
	protected static DefaultListModel<Product> getModel;
	private String name;
	private Float price;

	public Product(String name, Float price) {
		super();
		this.name = name;
		this.price = price;
	}

	public Product() {

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Float getPrice() {
		return price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "name:" + name + ":\t " + price + "€";
	}

}
