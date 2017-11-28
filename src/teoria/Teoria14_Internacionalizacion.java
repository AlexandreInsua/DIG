package teoria;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import java.awt.GridBagConstraints;
import javax.swing.JLabel;
import java.awt.Insets;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.ResourceBundle;

public class Teoria14_Internacionalizacion {
	private static final ResourceBundle BUNDLE = ResourceBundle.getBundle("com.angel.messages"); //$NON-NLS-1$
  JFrame frame;
	private JLabel lblFechaActual;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Teoria14_Internacionalizacion window = new Teoria14_Internacionalizacion();
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
	public Teoria14_Internacionalizacion() {
		initialize();
		
		Locale idiomaPorDefecto = Locale.getDefault();
		System.out.println(idiomaPorDefecto.toString());
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy", idiomaPorDefecto);
		String fechaFormateada = df.format(new Date() );
		lblFechaActual.setText(fechaFormateada);
		
		Locale[] idiomasDisponibles = Locale.getAvailableLocales();
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 266, 184);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		frame.getContentPane().setLayout(gridBagLayout);
		
		JButton btnBoton1 = new JButton(BUNDLE.getString("Principal.btnBoton1.text")); //$NON-NLS-1$
		GridBagConstraints gbc_btnBoton1 = new GridBagConstraints();
		gbc_btnBoton1.insets = new Insets(0, 0, 5, 5);
		gbc_btnBoton1.gridx = 0;
		gbc_btnBoton1.gridy = 0;
		frame.getContentPane().add(btnBoton1, gbc_btnBoton1);
		
		JButton btnBoton2 = new JButton(BUNDLE.getString("Principal.btnBoton2.text")); //$NON-NLS-1$
		GridBagConstraints gbc_btnBoton2 = new GridBagConstraints();
		gbc_btnBoton2.insets = new Insets(0, 0, 5, 0);
		gbc_btnBoton2.gridx = 1;
		gbc_btnBoton2.gridy = 0;
		frame.getContentPane().add(btnBoton2, gbc_btnBoton2);
		
		JLabel lblFecha = new JLabel(BUNDLE.getString("Principal.lblFecha.text")); //$NON-NLS-1$
		GridBagConstraints gbc_lblFecha = new GridBagConstraints();
		gbc_lblFecha.insets = new Insets(0, 0, 0, 5);
		gbc_lblFecha.gridx = 0;
		gbc_lblFecha.gridy = 1;
		frame.getContentPane().add(lblFecha, gbc_lblFecha);
		
		lblFechaActual = new JLabel("-");
		GridBagConstraints gbc_lblFechaActual = new GridBagConstraints();
		gbc_lblFechaActual.gridx = 1;
		gbc_lblFechaActual.gridy = 1;
		frame.getContentPane().add(lblFechaActual, gbc_lblFechaActual);
	}

}
