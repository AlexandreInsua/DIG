package teoria20EventosPersonalizadosUsuario;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Principal {

	private JFrame frame;
	private JLabel lblResultado;
	private Usuario user1 = new Usuario("Ana", 10);

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
		
		user1.addEventListener(new UsuarioChangeEventListener() {
			
			@Override
			public void onMinoriaEdad(UsuarioChangeEvent evento) {
				lblResultado.setText("Aun es menor de edad"+evento.user.getEdad());
			}
			
			@Override
			public void onMayoriaEdad(UsuarioChangeEvent evento) {
				lblResultado.setText("Ya es mayor de edad"+evento.user.getEdad());				
			}
		});
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 321, 195);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnCumplirAnnos = new JButton("CUMPLIR A\u00D1OS");
		btnCumplirAnnos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				user1.incrementarEdad();
				
			}
		});
		btnCumplirAnnos.setBounds(25, 96, 155, 23);
		frame.getContentPane().add(btnCumplirAnnos);
		
		lblResultado = new JLabel("New label");
		lblResultado.setBounds(25, 56, 155, 14);
		frame.getContentPane().add(lblResultado);
	}
}
