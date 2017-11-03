package t10_programacion_basada_eventos;
/*
 * A interface está á escoita dun cambio no estado do usuario
 * atributo idade
 * cando cumpre 18 anos lanza un aviso.
 * 
 * 
 */
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Principal {

	private JFrame frame;
	private JLabel lblResultado;

	/**
	 * Launch the application.
	 */
	private Usuario user1 = new Usuario("Ana", 10);
	
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
		// Este código non se vai executar sempre, só se executa no caso de ter
		user1.addEventListener(new UsuarioChangeEventListener() {
			@Override
			public void onMenoriaIdade(UsuarioChangeEvent evento) {
				lblResultado.setText("Ainda é menor de idade: "+ evento.user.getIdade());
			}
			@Override
			public void onMaioriaIdade(UsuarioChangeEvent evento) {
				lblResultado.setText("Xa é maior de idade: "+ evento.user.getIdade());
			}
		});
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnCumprirAnos = new JButton("Cumprir anos");
		btnCumprirAnos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				user1.IncrementarIdade();
			}
		});
		btnCumprirAnos.setBounds(112, 37, 182, 23);
		frame.getContentPane().add(btnCumprirAnos);
		
		lblResultado = new JLabel("Resultado");
		lblResultado.setBounds(112, 103, 182, 14);
		frame.getContentPane().add(lblResultado);
	}
	public JLabel getLblResultado() {
		return lblResultado;
	}
}
