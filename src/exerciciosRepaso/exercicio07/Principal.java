package exerciciosRepaso.exercicio07;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JList;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Principal {

	private JFrame frame;
	private JTextField txtPuntuacion;
	private JList<Float> listPuntuaciones;
	private JLabel lblMedia;

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
		frame.setResizable(false);
		frame.setBounds(100, 100, 406, 297);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Puntuacion:");
		lblNewLabel.setBounds(10, 11, 79, 14);
		frame.getContentPane().add(lblNewLabel);
		
		txtPuntuacion = new JTextField();
		txtPuntuacion.setBounds(101, 8, 70, 20);
		frame.getContentPane().add(txtPuntuacion);
		txtPuntuacion.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Lista de puntuaciones:");
		lblNewLabel_1.setBounds(10, 36, 161, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		listPuntuaciones = new JList<Float>();
		listPuntuaciones.setModel(new DefaultListModel<Float>());
		listPuntuaciones.setBounds(10, 61, 119, 126);
		frame.getContentPane().add(listPuntuaciones);
		
		JButton btnNewButton = new JButton("A\u00F1adir puntuacion");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				String puntuacion = txtPuntuacion.getText();
				if(puntuacion == null || puntuacion.isEmpty())
					return;
				try{
					float puntuacionNumerica = Float.parseFloat(puntuacion);
					DefaultListModel<Float> dlm = (DefaultListModel<Float>) listPuntuaciones.getModel();
					dlm.addElement(puntuacionNumerica);
				}catch(NumberFormatException ex){
					
				}				
			}
		});
		btnNewButton.setBounds(189, 8, 160, 23);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Borrar puntuacion seleccionada");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				int indiceSeleccionado = listPuntuaciones.getSelectedIndex();
				if(indiceSeleccionado < 0)
					return;
				DefaultListModel<Float> dlm = (DefaultListModel<Float>) listPuntuaciones.getModel();
				dlm.remove(indiceSeleccionado);
			}
		});
		btnNewButton_1.setBounds(10, 198, 241, 23);
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Calcular media");
		btnNewButton_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				float suma = 0;
				DefaultListModel<Float> dlm = (DefaultListModel<Float>) listPuntuaciones.getModel();
				for(int i=0; i< dlm.getSize(); i++){
					float valor = dlm.get(i);
					suma = suma + valor;
				}
				float media =  suma / dlm.getSize();
				lblMedia.setText(media + "");
			}
		});
		btnNewButton_2.setBounds(10, 228, 119, 23);
		frame.getContentPane().add(btnNewButton_2);
		
		lblMedia = new JLabel("---");
		lblMedia.setBounds(139, 232, 46, 14);
		frame.getContentPane().add(lblMedia);
	}

	public JTextField getTextField() {
		return txtPuntuacion;
	}
	public JList<Float> getList() {
		return listPuntuaciones;
	}
	public JLabel getLblNewLabel_2() {
		return lblMedia;
	}
}
