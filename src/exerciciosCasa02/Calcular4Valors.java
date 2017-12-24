package exerciciosCasa02;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import java.awt.FlowLayout;
import javax.swing.JScrollPane;
import javax.swing.ImageIcon;
import java.awt.GridLayout;
import javax.swing.JSpinner;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.JComboBox;
import java.awt.Insets;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JSlider;
import javax.swing.JTable;
import javax.swing.ListModel;
import javax.swing.SwingConstants;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.event.ChangeEvent;
import javax.swing.table.DefaultTableModel;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Calcular4Valors {

	private JFrame frame;
	private JTable tableNumerosTablas;
	private JPanel panel;
	private JLabel lblResultadoCalculadora;
	private JList<?> listNumerosListas;
	private JLabel lblDimensionTablas;
	private JSlider sliderColumnasTablas;
	private JSlider sliderFilasTablas;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Calcular4Valors window = new Calcular4Valors();
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
	public Calcular4Valors() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.LEFT);
		frame.getContentPane().add(tabbedPane);

		panel = new JPanel();
		tabbedPane.addTab("Combos", null, panel, null);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[] { 65, 53, 0, 0, 0 };
		gbl_panel.rowHeights = new int[] { 0, 0, 0, 0, 0, 0 };
		gbl_panel.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		gbl_panel.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		panel.setLayout(gbl_panel);

		JComboBox comboBoxOperacionCalculadora = new JComboBox<String>();
		comboBoxOperacionCalculadora
				.setModel(new DefaultComboBoxModel(new String[] { "sumar", "restar", "multiplicar" }));
		GridBagConstraints gbc_comboBoxOperacionCalculadora = new GridBagConstraints();
		gbc_comboBoxOperacionCalculadora.fill = GridBagConstraints.BOTH;
		gbc_comboBoxOperacionCalculadora.insets = new Insets(0, 0, 5, 5);
		gbc_comboBoxOperacionCalculadora.gridx = 2;
		gbc_comboBoxOperacionCalculadora.gridy = 1;
		panel.add(comboBoxOperacionCalculadora, gbc_comboBoxOperacionCalculadora);

		// comproba se o número do spinner é cero, en cuxo caso no permite
		// dividir
		JSpinner spinnerNumeroCalculadora = new JSpinner();
		spinnerNumeroCalculadora.addChangeListener(new javax.swing.event.ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				if ((Integer) spinnerNumeroCalculadora.getValue() == 0)
					comboBoxOperacionCalculadora.setModel(
							new DefaultComboBoxModel<String>(new String[] { "sumar", "restar", "multiplicar" }));
				else
					comboBoxOperacionCalculadora.setModel(new DefaultComboBoxModel<String>(
							new String[] { "sumar", "restar", "multiplicar", "dividir" }));
			}
		});
		GridBagConstraints gbc_spinnerNumeroCalculadora = new GridBagConstraints();
		gbc_spinnerNumeroCalculadora.fill = GridBagConstraints.BOTH;
		gbc_spinnerNumeroCalculadora.insets = new Insets(0, 0, 5, 5);
		gbc_spinnerNumeroCalculadora.gridx = 1;
		gbc_spinnerNumeroCalculadora.gridy = 1;
		// comproba, cando cambia de valor, se o número do spinner é 0 e cambia
		// as opcións do combo

		panel.add(spinnerNumeroCalculadora, gbc_spinnerNumeroCalculadora);

		JButton btnCalculaCalculadora = new JButton("Calcula");
		// Recupera o valor do comboBox, o núemero do spinner e o "total" da
		// label central
		// e realiza as operacións
		btnCalculaCalculadora.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String operacion = (String) comboBoxOperacionCalculadora.getSelectedItem();
				int numero = (Integer) spinnerNumeroCalculadora.getValue();
				int total = Integer.parseInt(lblResultadoCalculadora.getText());
				if (operacion.equals("sumar")) {
					total += numero;
				} else if (operacion.equals("restar")) {
					total -= numero;
				} else if (operacion.equals("multiplicar")) {
					total *= numero;
				} else if (operacion.equals("dividir")) {
					total /= numero;
				}
				lblResultadoCalculadora.setText(String.valueOf(total));
			}
		});
		btnCalculaCalculadora
				.setIcon(new ImageIcon(Calcular4Valors.class.getResource("/exerciciosCasa02/iconoCalculadora.png")));
		GridBagConstraints gbc_btnCalculaCalculadora = new GridBagConstraints();
		gbc_btnCalculaCalculadora.fill = GridBagConstraints.BOTH;
		gbc_btnCalculaCalculadora.insets = new Insets(0, 0, 5, 0);
		gbc_btnCalculaCalculadora.gridx = 3;
		gbc_btnCalculaCalculadora.gridy = 1;
		panel.add(btnCalculaCalculadora, gbc_btnCalculaCalculadora);

		lblResultadoCalculadora = new JLabel("0");
		GridBagConstraints gbc_lblResultadoCalculadora = new GridBagConstraints();
		gbc_lblResultadoCalculadora.insets = new Insets(0, 0, 0, 5);
		gbc_lblResultadoCalculadora.gridx = 2;
		gbc_lblResultadoCalculadora.gridy = 4;
		panel.add(lblResultadoCalculadora, gbc_lblResultadoCalculadora);

		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Listas", null, panel_1, null);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[] { 0, 0, 0 };
		gbl_panel_1.rowHeights = new int[] { 0, 0, 0 };
		gbl_panel_1.columnWeights = new double[] { 1.0, 0.0, Double.MIN_VALUE };
		gbl_panel_1.rowWeights = new double[] { 0.0, 1.0, Double.MIN_VALUE };
		panel_1.setLayout(gbl_panel_1);

		JComboBox comboBoxNumeroListas = new JComboBox();
		// enche so valaroes posibles para o numero de filas da lista do
		// comboBox
		for (int i = 1; i < 100; i++) {
			comboBoxNumeroListas.addItem(i);

		}
		GridBagConstraints gbc_comboBoxNumeroListas = new GridBagConstraints();
		gbc_comboBoxNumeroListas.insets = new Insets(0, 0, 5, 5);
		gbc_comboBoxNumeroListas.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBoxNumeroListas.gridx = 0;
		gbc_comboBoxNumeroListas.gridy = 0;
		panel_1.add(comboBoxNumeroListas, gbc_comboBoxNumeroListas);

		// Cando se pulsa o boton, recolle o número de filas do combobox e
		// enche a lista con núemeros aleatorios de 0 a 10
		JButton btnRellenarLista = new JButton("rellenar");
		btnRellenarLista.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int numeroFilas = (Integer) comboBoxNumeroListas.getSelectedItem();
				DefaultListModel<Integer> model = (DefaultListModel<Integer>) listNumerosListas.getModel();
				model.clear();
				for (int i = 1; i <= numeroFilas; i++) {
					model.addElement((int) Math.floor(Math.random() * 10));

				}
			}
		});
		GridBagConstraints gbc_btnRellenarLista = new GridBagConstraints();
		gbc_btnRellenarLista.insets = new Insets(0, 0, 5, 0);
		gbc_btnRellenarLista.gridx = 1;
		gbc_btnRellenarLista.gridy = 0;
		panel_1.add(btnRellenarLista, gbc_btnRellenarLista);

		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.insets = new Insets(0, 0, 0, 5);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 1;
		panel_1.add(scrollPane, gbc_scrollPane);

		listNumerosListas = new JList<Integer>();
		listNumerosListas.setModel(new DefaultListModel<>());
		scrollPane.setViewportView(listNumerosListas);

		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("Tablas",
				new ImageIcon(Calcular4Valors.class.getResource("/exerciciosCasa02/iconoTablas.png")), panel_2, null);
		GridBagLayout gbl_panel_2 = new GridBagLayout();
		gbl_panel_2.columnWidths = new int[] { 0, 0, 0 };
		gbl_panel_2.rowHeights = new int[] { 0, 0, 0, 0 };
		gbl_panel_2.columnWeights = new double[] { 1.0, 0.0, Double.MIN_VALUE };
		gbl_panel_2.rowWeights = new double[] { 0.0, 0.0, 1.0, Double.MIN_VALUE };
		panel_2.setLayout(gbl_panel_2);

		sliderColumnasTablas = new JSlider();
		// Cando solta o slider, o labde da dimensión da táboa cambia
		// usando os valores de ambos sliders
		sliderColumnasTablas.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent arg0) {
				JSlider source = (JSlider) arg0.getSource();
				if (!source.getValueIsAdjusting()) {
					int filas = (int) sliderColumnasTablas.getValue();
					int columnas = (int) sliderFilasTablas.getValue();
					lblDimensionTablas.setText(filas + " x " + columnas);
				}
			}
		});
		sliderColumnasTablas.setPaintLabels(true);
		sliderColumnasTablas.setValue(0);
		sliderColumnasTablas.setMinorTickSpacing(1);
		sliderColumnasTablas.setMajorTickSpacing(1);
		sliderColumnasTablas.setMaximum(10);
		sliderColumnasTablas.setSnapToTicks(true);
		sliderColumnasTablas.setPaintTicks(true);
		GridBagConstraints gbc_sliderColumnasTablas = new GridBagConstraints();
		gbc_sliderColumnasTablas.fill = GridBagConstraints.HORIZONTAL;
		gbc_sliderColumnasTablas.insets = new Insets(0, 0, 5, 5);
		gbc_sliderColumnasTablas.gridx = 0;
		gbc_sliderColumnasTablas.gridy = 0;
		panel_2.add(sliderColumnasTablas, gbc_sliderColumnasTablas);

		lblDimensionTablas = new JLabel("New label");
		GridBagConstraints gbc_lblDimensionTablas = new GridBagConstraints();
		gbc_lblDimensionTablas.insets = new Insets(0, 0, 5, 0);
		gbc_lblDimensionTablas.gridx = 1;
		gbc_lblDimensionTablas.gridy = 0;
		panel_2.add(lblDimensionTablas, gbc_lblDimensionTablas);

		// Recolle a dimensión do labre e crea un modelo co número de filas e
		// columnas das dimensións
		// e enche con números
		JButton btnGenerarTablas = new JButton("Generar");
		btnGenerarTablas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String[] dimensiones = lblDimensionTablas.getText().split(" x ");
				int columnas = Integer.parseInt(dimensiones[0]);
				int filas = Integer.parseInt(dimensiones[1]);
				Object[] nombreColumnas = new Object[columnas];
				Object[][] elementos = new Object[filas][columnas];
				for (int i = 0; i < filas; i++) {
					for (int j = 0; j < columnas; j++) {
						int numero = (int) Math.floor(Math.random() * 10);
						elementos[i][j] = String.valueOf(numero);
					}
				}
				for (int i = 0; i < columnas; i++) {
					nombreColumnas[i] = "Col " + i;
					DefaultTableModel model = new DefaultTableModel(elementos, nombreColumnas);
					tableNumerosTablas.setModel(model);
				}
			}
		});
		GridBagConstraints gbc_btnGenerarTablas = new GridBagConstraints();
		gbc_btnGenerarTablas.insets = new Insets(0, 0, 5, 0);
		gbc_btnGenerarTablas.gridx = 1;
		gbc_btnGenerarTablas.gridy = 1;
		panel_2.add(btnGenerarTablas, gbc_btnGenerarTablas);

		JScrollPane scrollPane_1 = new JScrollPane();
		GridBagConstraints gbc_scrollPane_1 = new GridBagConstraints();
		gbc_scrollPane_1.insets = new Insets(0, 0, 0, 5);
		gbc_scrollPane_1.fill = GridBagConstraints.BOTH;
		gbc_scrollPane_1.gridx = 0;
		gbc_scrollPane_1.gridy = 2;
		panel_2.add(scrollPane_1, gbc_scrollPane_1);

		tableNumerosTablas = new JTable();
		tableNumerosTablas.setModel(new DefaultTableModel());
		scrollPane_1.setViewportView(tableNumerosTablas);

		sliderFilasTablas = new JSlider();
		sliderFilasTablas.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				JSlider source = (JSlider) e.getSource();
				if (!source.getValueIsAdjusting()) {
					int filas = (int) sliderColumnasTablas.getValue();
					int columnas = (int) sliderFilasTablas.getValue();
					lblDimensionTablas.setText(filas + " x " + columnas);
				}
			}
		});
		sliderFilasTablas.setValue(0);
		sliderFilasTablas.setMajorTickSpacing(10);
		sliderFilasTablas.setSnapToTicks(true);
		sliderFilasTablas.setPaintTicks(true);
		sliderFilasTablas.setPaintLabels(true);
		sliderFilasTablas.setMinorTickSpacing(10);
		sliderFilasTablas.setMaximum(40);
		sliderFilasTablas.setOrientation(SwingConstants.VERTICAL);
		GridBagConstraints gbc_sliderFilasTablas = new GridBagConstraints();
		gbc_sliderFilasTablas.fill = GridBagConstraints.BOTH;
		gbc_sliderFilasTablas.gridx = 1;
		gbc_sliderFilasTablas.gridy = 2;
		panel_2.add(sliderFilasTablas, gbc_sliderFilasTablas);
	}

	public JPanel getPanel() {
		return panel;
	}

	public JLabel getLblResultadoCalculadora() {
		return lblResultadoCalculadora;
	}

	public JList getListNumerosListas() {
		return listNumerosListas;
	}

	public JLabel getLblNewLabel_1() {
		return lblDimensionTablas;
	}

	public JSlider getSlider() {
		return sliderColumnasTablas;
	}

	public JSlider getSlider_1() {
		return sliderFilasTablas;
	}
}
