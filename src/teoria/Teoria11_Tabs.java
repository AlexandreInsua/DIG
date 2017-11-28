package teoria;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JTabbedPane;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JToggleButton;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;

public class Teoria11_Tabs {

	private JFrame frame;
	private JTabbedPane tabbedPane;
	private JPanel panelTab2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Teoria11_Tabs window = new Teoria11_Tabs();
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
	public Teoria11_Tabs() {
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
		
		JMenu mnNewMenu = new JMenu("Archivo");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Ir al tab1");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tabbedPane.setSelectedIndex(0);	
			}
		});
		mnNewMenu.add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Salir");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		mnNewMenu.add(mntmNewMenuItem_1);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Maximizar ventana");
		menuBar.add(mntmNewMenuItem_2);
		
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		frame.getContentPane().add(tabbedPane, BorderLayout.CENTER);
		
		JPanel panelTab1 = new JPanel();
		tabbedPane.addTab("TAB1", null, panelTab1, null);
		
		JToggleButton tglbtnSwitch = new JToggleButton("Mostrar TAB2");
		tglbtnSwitch.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
			System.out.println("aaa");
				if( tglbtnSwitch.isSelected() ) {
					// el boton está activado (pulsado)
					//panelTab2.setVisible(true);
					tabbedPane.addTab("Tab2",panelTab2);
				}else {
					// el boton no esta activado(despulsado)
					//panelTab2.setVisible(false);
					tabbedPane.remove(panelTab2);
				}
			}
		});
		tglbtnSwitch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("aaa3");
			}
		});
		tglbtnSwitch.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				System.out.println("aaa2");
			}
		});
		
		panelTab1.add(tglbtnSwitch);
		
		JButton btnNewButton = new JButton("Ir al TAB2");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				tabbedPane.setSelectedIndex(1);
			}
		});
		btnNewButton.setToolTipText("Sirve para ir directamente al tab2");
		panelTab1.add(btnNewButton);
		
		panelTab2 = new JPanel();
		tabbedPane.addTab("TAB2", null, panelTab2, null);
		panelTab2.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel_1 = new JLabel("ESTE ES EL CONTENIDO DEL TAB2");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		panelTab2.add(lblNewLabel_1, BorderLayout.CENTER);
		
		JLabel lblNewLabel = new JLabel("Este es un mensaje a modo de barra de estado");
		frame.getContentPane().add(lblNewLabel, BorderLayout.SOUTH);
		tglbtnSwitch.setSelected(true);
	}

	public JTabbedPane getTabbedPane() {
		return tabbedPane;
	}
	public JPanel getPanel_tab_2() {
		return panelTab2;
	}
}
