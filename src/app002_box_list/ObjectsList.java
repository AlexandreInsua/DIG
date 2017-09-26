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
import java.awt.GridLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.io.Serializable;

import javax.swing.JButton;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class ObjectsList {

	private JFrame frame;
	private final JPanel panel = new JPanel();
	private JTextField textField;
	private JTextField textField_1;

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
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 521, 314);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		frame.getContentPane().add(scrollPane, BorderLayout.CENTER);
		frame.getContentPane().add(panel, BorderLayout.WEST);
		panel.setLayout(new GridLayout(5, 1, 0, 0));
		
		
		JLabel lblNewLabel = new JLabel("Nome");
		panel.add(lblNewLabel);
		
		textField = new JTextField();
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Prezo");
		panel.add(lblNewLabel_1);
		
		textField_1 = new JTextField();
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnNewButton = new JButton("Engadir");
		panel.add(btnNewButton);
		
		JPanel panel_1 = new JPanel();
		frame.getContentPane().add(panel_1, BorderLayout.NORTH);
		
		JMenuBar menuBar_1 = new JMenuBar();
		panel_1.add(menuBar_1);
		
		JMenuItem mntmNewMenuItem_5 = new JMenuItem("New menu item");
		menuBar_1.add(mntmNewMenuItem_5);
		
		JMenuItem mntmNewMenuItem_6 = new JMenuItem("New menu item");
		menuBar_1.add(mntmNewMenuItem_6);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("New menu item");
		menuBar_1.add(mntmNewMenuItem);
		
		JMenuBar menuBar_2 = new JMenuBar();
		panel_1.add(menuBar_2);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("New menu item");
		menuBar_2.add(mntmNewMenuItem_1);
		
		JMenuItem mntmNewMenuItem_4 = new JMenuItem("New menu item");
		menuBar_2.add(mntmNewMenuItem_4);
		
		JMenuItem mntmNewMenuItem_3 = new JMenuItem("New menu item");
		menuBar_2.add(mntmNewMenuItem_3);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("New menu item");
		menuBar_2.add(mntmNewMenuItem_2);
		
		JMenuBar menuBar = new JMenuBar();
		panel_1.add(menuBar);
	}

}

class Product implements Serializable{
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
	
	
	
}
