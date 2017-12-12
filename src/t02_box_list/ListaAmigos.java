package t02_box_list;

import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class ListaAmigos {

	private JFrame frame;
	private JTextField textName;
	private JList<String> lstFriends;
	DefaultListModel<String> dlm ;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ListaAmigos window = new ListaAmigos();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ListaAmigos() {
		initialize();
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 0, 0, 0, 0 };
		gridBagLayout.rowHeights = new int[] { 0, 0, 0, 0 };
		gridBagLayout.columnWeights = new double[] { 0.0, 1.0, 0.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, 1.0, 0.0, Double.MIN_VALUE };
		frame.getContentPane().setLayout(gridBagLayout);

		JLabel lblFriend = new JLabel("Amigo");
		GridBagConstraints gbc_lblFriend = new GridBagConstraints();
		gbc_lblFriend.insets = new Insets(0, 0, 5, 5);
		gbc_lblFriend.anchor = GridBagConstraints.EAST;
		gbc_lblFriend.gridx = 0;
		gbc_lblFriend.gridy = 0;
		frame.getContentPane().add(lblFriend, gbc_lblFriend);

		textName = new JTextField();
		GridBagConstraints gbc_textName = new GridBagConstraints();
		gbc_textName.insets = new Insets(0, 0, 5, 5);
		gbc_textName.fill = GridBagConstraints.HORIZONTAL;
		gbc_textName.gridx = 1;
		gbc_textName.gridy = 0;
		frame.getContentPane().add(textName, gbc_textName);
		textName.setColumns(10);

		JButton btnAddFriend = new JButton("Engadir");
		btnAddFriend.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				String name = textName.getText();
				DefaultListModel<String> dlm = (DefaultListModel<String>) lstFriends.getModel();
				dlm.addElement(name);
				textName.setText("");
			}
		});
		btnAddFriend.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});
		GridBagConstraints gbc_btnAddFriend = new GridBagConstraints();
		gbc_btnAddFriend.insets = new Insets(0, 0, 5, 0);
		gbc_btnAddFriend.gridx = 2;
		gbc_btnAddFriend.gridy = 0;
		frame.getContentPane().add(btnAddFriend, gbc_btnAddFriend);

		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.insets = new Insets(0, 0, 5, 0);
		gbc_scrollPane.gridwidth = 2;
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 1;
		gbc_scrollPane.gridy = 1;
		frame.getContentPane().add(scrollPane, gbc_scrollPane);

		dlm = new DefaultListModel<>(); 
		lstFriends = new JList<String>();
		lstFriends.setModel(dlm);

		scrollPane.setViewportView(lstFriends);

		JButton btnClean = new JButton("Limpar");
		btnClean.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				DefaultListModel<String> dlm = (DefaultListModel<String>) lstFriends.getModel();
				dlm.clear();
			}
		});
		btnClean.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		GridBagConstraints gbc_btnClean = new GridBagConstraints();
		gbc_btnClean.insets = new Insets(0, 0, 0, 5);
		gbc_btnClean.gridx = 1;
		gbc_btnClean.gridy = 2;
		frame.getContentPane().add(btnClean, gbc_btnClean);

		JButton btnSaveOnDisk = new JButton("Gardar");
		btnSaveOnDisk.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				File f = new File("Amigos.txt");
				FileWriter fw = null;
				DefaultListModel<String> dlm = (DefaultListModel<String>) lstFriends.getModel();
				try {
					fw = new FileWriter(f);
					for (int i = 0; i < dlm.getSize(); i++) {
						String element = dlm.getElementAt(i);
						fw.write(element +"\n");
					}
					fw.close();
				} catch (IOException e1) {
					JOptionPane popup = new JOptionPane("Erro ao abrir o ficheiro.");
				} finally {
					try {
						fw.close();
					} catch (IOException e1) {
						JOptionPane popup = new JOptionPane("Erro ao pechar o ficheiro.");
					}
				}

			}
		});
		
		GridBagConstraints gbc_btnSaveOnDisk = new GridBagConstraints();
		gbc_btnSaveOnDisk.gridx = 2;
		gbc_btnSaveOnDisk.gridy = 2;
		frame.getContentPane().add(btnSaveOnDisk, gbc_btnSaveOnDisk);
	}

	public JList<String> getLstFriends() {
		return lstFriends;
	}
}
