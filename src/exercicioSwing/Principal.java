package exercicioSwing;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.AbstractListModel;
import javax.swing.DefaultListModel;

public class Principal {

	private JFrame frame;
	private JTextField textNumero;
	private JLabel lblIntroducidos;
	private JLabel lblSuma;
	private static ArrayList<String> listaNumeros = new ArrayList<String>();
	private static ArrayList<Integer> numeros = new ArrayList<Integer>();
	DefaultListModel<String> model;

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

		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.NORTH);

		JLabel lblIntroduceUnNmero = new JLabel("Introduce un n\u00FAmero");
		panel.add(lblIntroduceUnNmero);

		textNumero = new JTextField();
		panel.add(textNumero);
		textNumero.setColumns(10);

		JScrollPane scrollPane = new JScrollPane();
		frame.getContentPane().add(scrollPane, BorderLayout.CENTER);

		JPanel panel_2 = new JPanel();
		scrollPane.setColumnHeaderView(panel_2);

		lblIntroducidos = new JLabel("0");
		panel_2.add(lblIntroducidos);

		JLabel lblNmerosIntroducidos = new JLabel("n\u00FAmeros introducidos. Suman: ");
		panel_2.add(lblNmerosIntroducidos);

		lblSuma = new JLabel("0");
		panel_2.add(lblSuma);

		model = new DefaultListModel<String>();
		JList<String> list = new JList<String>();
		list.setModel(model);
		scrollPane.setViewportView(list);

		JPanel panel_1 = new JPanel();
		frame.getContentPane().add(panel_1, BorderLayout.SOUTH);

		JButton btnAddNumero = new JButton("Adicionar n\u00FAmero");
		btnAddNumero.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					String elemento = textNumero.getText();
					model.addElement(elemento);
					Integer numero = Integer.parseInt(textNumero.getText());
					numeros.add(numero);
					lblIntroducidos.setText(numeros.size() + "");
					textNumero.setText("");
				} catch (NumberFormatException nfe) {
					JOptionPane.showMessageDialog(frame, "Debes introducir un número", "Erro de entrada",
							JOptionPane.ERROR_MESSAGE);
				}

			}
		});
		panel_1.add(btnAddNumero);

		JButton btnSumarNmeros = new JButton("Sumar n\u00FAmeros");
		btnSumarNmeros.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int suma = 0;
				for (Integer i : numeros) {
					suma += i;
				}
				lblSuma.setText(String.valueOf(suma) + " ");
			}
		});

		panel_1.add(btnSumarNmeros);

		JButton btnBorrarTodo = new JButton("Borrar todo");
		btnBorrarTodo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textNumero.setText("");
				lblNmerosIntroducidos.setText("0");
				lblNmerosIntroducidos.setText("n\u00FAmeros introducidos. Suman: ");
				lblSuma.setText("");
				model.removeAllElements();
			}
		});

		panel_1.add(btnBorrarTodo);
	}

	public JLabel getLabel() {
		return lblIntroducidos;
	}

	public JLabel getLabel_1() {
		return lblSuma;
	}

	public DefaultListModel modelList(String element) {
		DefaultListModel<String> model = new DefaultListModel<>();
		model.addElement(element);
		return model;
	}
}
