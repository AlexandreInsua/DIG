package exerciciosCasa08;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import actividad8.ListPersonRenderer;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Main {

	private JFrame frame;
	private JTextField textFieldName;
	private JComboBox<String> comboBoxPersons;
	private JList<Person> listPersons;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main window = new Main();
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
	public Main() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 562, 307);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel panelAddPersons = new JPanel();
		frame.getContentPane().add(panelAddPersons, BorderLayout.NORTH);

		JLabel lblAddPerson = new JLabel("Añadir persona:");
		panelAddPersons.add(lblAddPerson);

		comboBoxPersons = new JComboBox<String>();
		comboBoxPersons.setModel(new DefaultComboBoxModel<String>(new String[] { "Hombre", "Mujer" }));
		comboBoxPersons.setRenderer(new ComboPersonRenderer());
		panelAddPersons.add(comboBoxPersons);

		textFieldName = new JTextField();
		panelAddPersons.add(textFieldName);
		textFieldName.setColumns(10);

		JButton btnAdd = new JButton("A\u00F1adir");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				addPersona();
			}
		});
		panelAddPersons.add(btnAdd);

		JScrollPane scrollPanePersons = new JScrollPane();
		frame.getContentPane().add(scrollPanePersons, BorderLayout.CENTER);

		listPersons = new JList<Person>();
		listPersons.setModel(new DefaultListModel<Person>());
		listPersons.setCellRenderer(new ListPersonRenderer());
		scrollPanePersons.setViewportView(listPersons);
	}

	public JComboBox<String> getComboBoxPersons() {
		return comboBoxPersons;
	}

	public JList<Person> getListPersons() {
		return listPersons;
	}
	
	public JTextField getTextFieldName() {
		return textFieldName;
	}

	private void addPersona() {

		DefaultListModel<Person> model = (DefaultListModel<Person>) listPersons.getModel();
		Person person = new Person();
		
		String sex = (String) comboBoxPersons.getSelectedItem();
		person.setSex(sex);
		String name = textFieldName.getText();
		if(name.length() == 0 && sex.equals("Hombre")) name = "Anonimo";
		else if(name.length() == 0 && sex.equals("Mujer")) name = "Anonima";
		person.setName(name);
		
		model.addElement(person);
	}
}
