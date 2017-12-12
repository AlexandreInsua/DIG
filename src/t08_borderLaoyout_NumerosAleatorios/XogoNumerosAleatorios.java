package t08_borderLaoyout_NumerosAleatorios;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JSpinner;
import javax.swing.JButton;
import javax.swing.SpinnerNumberModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class XogoNumerosAleatorios {

	private JFrame frame;
	private JSpinner spinnerNumero;
	private int numeroAleatorio;
	private final static int MAX_NUMERO_INTENTOS = 3;
	private int numeroIntentos;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					XogoNumerosAleatorios window = new XogoNumerosAleatorios();
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
	public XogoNumerosAleatorios() {
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
		gridBagLayout.rowHeights = new int[] { 0, 0, 0 };
		gridBagLayout.columnWeights = new double[] { 0.0, 0.0, 0.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, Double.MIN_VALUE };
		frame.getContentPane().setLayout(gridBagLayout);

		JLabel lblEnQueNmero = new JLabel("En que n\u00FAmero estou a pensar?");
		GridBagConstraints gbc_lblEnQueNmero = new GridBagConstraints();
		gbc_lblEnQueNmero.insets = new Insets(0, 0, 5, 5);
		gbc_lblEnQueNmero.gridx = 0;
		gbc_lblEnQueNmero.gridy = 0;
		frame.getContentPane().add(lblEnQueNmero, gbc_lblEnQueNmero);

		JLabel lblInsertaUnNmero = new JLabel("Inserta un n\u00FAmero: ");
		GridBagConstraints gbc_lblInsertaUnNmero = new GridBagConstraints();
		gbc_lblInsertaUnNmero.insets = new Insets(0, 0, 0, 5);
		gbc_lblInsertaUnNmero.gridx = 0;
		gbc_lblInsertaUnNmero.gridy = 1;
		frame.getContentPane().add(lblInsertaUnNmero, gbc_lblInsertaUnNmero);

		spinnerNumero = new JSpinner();
		spinnerNumero.setModel(new SpinnerNumberModel(0, 0, 10, 1));
		GridBagConstraints gbc_spinnerNumero = new GridBagConstraints();
		gbc_spinnerNumero.insets = new Insets(0, 0, 0, 5);
		gbc_spinnerNumero.gridx = 1;
		gbc_spinnerNumero.gridy = 1;
		frame.getContentPane().add(spinnerNumero, gbc_spinnerNumero);

		JButton btnProbar = new JButton("Probar");
		btnProbar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int numero = (Integer) spinnerNumero.getValue();
				if (numero == numeroAleatorio) {
					JOptionPane.showMessageDialog(frame, "HAS ACERTADO");
				} else {
					numeroIntentos++;
					if (numeroIntentos == 3) {
						JOptionPane.showMessageDialog(frame, "HAS FALLADO  VUELVE A INTENTARLO");
						System.exit(0);
					} else {
						JOptionPane.showMessageDialog(frame, "HAS FALLADO  VUELVE A INTENTARLO");

					}
				}
			}
		});
		GridBagConstraints gbc_btnProbar = new GridBagConstraints();
		gbc_btnProbar.gridx = 2;
		gbc_btnProbar.gridy = 1;
		frame.getContentPane().add(btnProbar, gbc_btnProbar);
	}

}
