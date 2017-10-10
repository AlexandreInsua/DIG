package t05_inteface_internacional;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import java.awt.GridBagConstraints;
import javax.swing.JLabel;
import java.awt.Insets;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import javax.swing.JTextField;

import java.util.Date;
import java.util.Locale;
import java.util.ResourceBundle;

public class Principal {
	private static final ResourceBundle BUNDLE = ResourceBundle.getBundle("t05_inteface_internacional.messages"); //$NON-NLS-1$

	private JFrame frame;
	private JLabel lblDate;
	private JLabel lblCurrentDate;

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
		Locale idiomaPorDefecto = Locale.getDefault();
		DateFormat df = new SimpleDateFormat(
		"dd/MM/yyyy", idiomaPorDefecto);
		String dataFormateada = df.format(new Date());
		lblCurrentDate.setText(dataFormateada);
		
		Locale [ ] lc = Locale.getAvailableLocales();
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		frame.getContentPane().setLayout(gridBagLayout);
		
		JButton btnBttn1 = new JButton(BUNDLE.getString("Principal.btnBttn1.text")); //$NON-NLS-1$
		GridBagConstraints gbc_btnBttn1 = new GridBagConstraints();
		gbc_btnBttn1.insets = new Insets(0, 0, 5, 5);
		gbc_btnBttn1.gridx = 0;
		gbc_btnBttn1.gridy = 0;
		frame.getContentPane().add(btnBttn1, gbc_btnBttn1);
		
		JButton btnBttn2 = new JButton(BUNDLE.getString("Principal.btnBttn2.text")); //$NON-NLS-1$
		GridBagConstraints gbc_btnBttn2 = new GridBagConstraints();
		gbc_btnBttn2.insets = new Insets(0, 0, 5, 0);
		gbc_btnBttn2.gridx = 2;
		gbc_btnBttn2.gridy = 0;
		frame.getContentPane().add(btnBttn2, gbc_btnBttn2);
		
		lblDate = new JLabel(BUNDLE.getString("Principal.lblDate.text")); //$NON-NLS-1$
		GridBagConstraints gbc_lblDate = new GridBagConstraints();
		gbc_lblDate.insets = new Insets(0, 0, 5, 5);
		gbc_lblDate.gridx = 0;
		gbc_lblDate.gridy = 1;
		frame.getContentPane().add(lblDate, gbc_lblDate);
		
		lblCurrentDate = new JLabel(BUNDLE.getString("Principal.lblCurrentDate.text")); //$NON-NLS-1$
		GridBagConstraints gbc_lblCurrentDate = new GridBagConstraints();
		gbc_lblCurrentDate.insets = new Insets(0, 0, 5, 0);
		gbc_lblCurrentDate.gridx = 2;
		gbc_lblCurrentDate.gridy = 1;
		frame.getContentPane().add(lblCurrentDate, gbc_lblCurrentDate);
	}

	public JLabel getLblDate() {
		return lblDate;
	}
	public JLabel getLblCurrentDate() {
		return lblCurrentDate;
	}
}
