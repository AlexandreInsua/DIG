package ex06_exercicio_tabs_2;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import javax.swing.JLabel;
import javax.swing.JTabbedPane;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JToggleButton;
import java.awt.Font;
import java.awt.event.ItemListener;
import java.awt.peer.PanelPeer;
import java.awt.event.ItemEvent;

public class Principal {

	private JFrame frame;
	private JTabbedPane tabbedPane;
	private JPanel pnlTAB2;
	private JPanel pnlTAB1;

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

		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);

		JMenu mnNewMenu = new JMenu("Arquivo");
		menuBar.add(mnNewMenu);

		JMenuItem mntmNewMenuItem = new JMenuItem("Ir ao TAB1");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tabbedPane.setSelectedIndex(0);
			}
		});
		mnNewMenu.add(mntmNewMenuItem);

		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Sa\u00EDr");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		mnNewMenu.add(mntmNewMenuItem_1);

		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Maximizar xanela");
		menuBar.add(mntmNewMenuItem_2);

		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		frame.getContentPane().add(tabbedPane, BorderLayout.CENTER);

		pnlTAB1 = new JPanel();
		tabbedPane.addTab("TAB1", null, pnlTAB1, null);
		pnlTAB1.setLayout(new BorderLayout(0, 0));

		JPanel panel_2 = new JPanel();
		pnlTAB1.add(panel_2, BorderLayout.CENTER);
		panel_2.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		JToggleButton tglbtnSwitch = new JToggleButton("Mostrar TAB2");
		/*
		 * tglbtnSwitch.addItemListener(new ItemListener() { public void
		 * itemStateChanged(ItemEvent arg0) { if (tglbtnSwitch.isSelected()) { // mostra
		 * o tab pnlTAB2.setVisible(true); } else { // oculta o tab
		 * pnlTAB2.setVisible(false);
		 * 
		 * }
		 * 
		 * } });
		 */
		tglbtnSwitch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (tglbtnSwitch.isSelected()) {
					// mostra o tab
					tabbedPane.addTab("TAB2", pnlTAB2);
				} else {
					// oculta o tab

					tabbedPane.remove(pnlTAB2);

				}

			}
		});

		tglbtnSwitch.setSelected(true);
		panel_2.add(tglbtnSwitch);

		JButton btnNewButton_1 = new JButton("Ir a TAB2");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tabbedPane.setSelectedIndex(1);
			}
		});
		btnNewButton_1.setToolTipText("Serve para ir directamente a TAB2");
		panel_2.add(btnNewButton_1);

		JLabel lblNewLabel = new JLabel("Xanela maximizada");
		pnlTAB1.add(lblNewLabel, BorderLayout.SOUTH);

		pnlTAB2 = new JPanel();
		tabbedPane.addTab("TAB2", null, pnlTAB2, null);
		pnlTAB2.setLayout(new BorderLayout(0, 0));

		JLabel lblContidoDoSegundo = new JLabel("Este \u00E9 o contido do TAB2");
		lblContidoDoSegundo.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblContidoDoSegundo.setHorizontalAlignment(SwingConstants.CENTER);
		pnlTAB2.add(lblContidoDoSegundo, BorderLayout.CENTER);

		JLabel lblNewLabel_1 = new JLabel("Mensaxe de estado");
		pnlTAB2.add(lblNewLabel_1, BorderLayout.SOUTH);
	}

	public JTabbedPane getTabbedPane() {
		return tabbedPane;
	}

	public JPanel getPnlTAB2() {
		return pnlTAB2;
	}

	public JPanel getPnlTAB1() {
		return pnlTAB1;
	}
}
