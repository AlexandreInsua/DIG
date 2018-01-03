package exerciciosCasa08;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTable;
import java.awt.BorderLayout;
import javax.swing.JScrollPane;

public class MainTable2 {

	private JFrame frame;

	
	private static Object[] columnName = {"Yes", "No"};
    private static Object[][] data = {
            {"Y", "N"},
            {"N", "Y"},
            {"Y", "N"}
    };
    private JTable table;
    
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainTable2 window = new MainTable2();
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
	public MainTable2() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JScrollPane scrollPane = new JScrollPane();
		frame.getContentPane().add(scrollPane, BorderLayout.CENTER);
		
		table = new JTable(data, columnName);
		scrollPane.setViewportView(table);
		 table.getColumnModel().getColumn(0).setCellRenderer(new TablePersonalRenderer());
         
	}

}
