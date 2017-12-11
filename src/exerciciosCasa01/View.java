package exerciciosCasa01;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JTabbedPane;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.FlowLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ResourceBundle;

public class View {
	private static final ResourceBundle BUNDLE = ResourceBundle.getBundle("exerciciosCasa01.messages"); //$NON-NLS-1$

	private JFrame frame;
	JTabbedPane tabbedPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					View window = new View();
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
	public View() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JMenuBar menuBar = new JMenuBar();
		frame.getContentPane().add(menuBar, BorderLayout.NORTH);
		
		JMenu mnFicheiro = new JMenu(BUNDLE.getString("View.mnFicheiro.text")); //$NON-NLS-1$
		menuBar.add(mnFicheiro);
		
		JMenuItem mntmIrTab = new JMenuItem(BUNDLE.getString("View.mntmIrTab.text")); //$NON-NLS-1$
		mntmIrTab.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tabbedPane.setSelectedIndex(1);
			}
		});
		mnFicheiro.add(mntmIrTab);
		
		JMenuItem mntmSar = new JMenuItem(BUNDLE.getString("View.mntmSar.text")); //$NON-NLS-1$
		mntmSar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		mnFicheiro.add(mntmSar);
		
		JMenuItem mntmMaximizarXanela = new JMenuItem(BUNDLE.getString("View.mntmMaximizarXanela.text")); //$NON-NLS-1$
		menuBar.add(mntmMaximizarXanela);
		
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		frame.getContentPane().add(tabbedPane, BorderLayout.CENTER);
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("TAB1", null, panel_1, null);
		
		JButton btnNewButton = new JButton(BUNDLE.getString("View.btnNewButton.text")); //$NON-NLS-1$
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				tabbedPane.setSelectedIndex(1);
			}
		});
		panel_1.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton(BUNDLE.getString("View.btnNewButton_1.text")); //$NON-NLS-1$
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tabbedPane.setSelectedIndex(1);
			}
		});
		panel_1.add(btnNewButton_1);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("TAB2", null, panel, null);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblEsteO = new JLabel(BUNDLE.getString("View.lblEsteO.text")); //$NON-NLS-1$
		panel.add(lblEsteO);
		
		JLabel lblNewLabel = new JLabel(BUNDLE.getString("View.lblNewLabel.text")); //$NON-NLS-1$
		frame.getContentPane().add(lblNewLabel, BorderLayout.SOUTH);
	}

}
