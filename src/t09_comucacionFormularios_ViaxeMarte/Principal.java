package t09_comucacionFormularios_ViaxeMarte;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Principal {

	private JFrame frame;
	private JTextField txtNombre;

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
		frame.setBounds(100, 100, 450, 360);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblFormularioParaViajar = new JLabel("Formulario para viajar a Marte");
		lblFormularioParaViajar.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblFormularioParaViajar.setBounds(26, 11, 252, 14);
		frame.getContentPane().add(lblFormularioParaViajar);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(36, 36, 46, 14);
		frame.getContentPane().add(lblNombre);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(95, 33, 215, 20);
		frame.getContentPane().add(txtNombre);
		txtNombre.setColumns(10);
		
		JLabel lblAlergias = new JLabel("Alergias:");
		lblAlergias.setBounds(26, 74, 46, 14);
		frame.getContentPane().add(lblAlergias);
		
		JCheckBox chckbxAlimentarias = new JCheckBox("Alimentarias");
		chckbxAlimentarias.setBounds(98, 70, 97, 23);
		frame.getContentPane().add(chckbxAlimentarias);
		
		JCheckBox chckbxMedicamentos = new JCheckBox("Medicamentos");
		chckbxMedicamentos.setBounds(95, 96, 97, 23);
		frame.getContentPane().add(chckbxMedicamentos);
		
		JCheckBox chckbxAcaros = new JCheckBox("Acaros");
		chckbxAcaros.setBounds(95, 122, 97, 23);
		frame.getContentPane().add(chckbxAcaros);
		
		JLabel lblSexo = new JLabel("Sexo");
		lblSexo.setBounds(26, 162, 46, 14);
		frame.getContentPane().add(lblSexo);
		
		JRadioButton rdbtnHombre = new JRadioButton("Hombre");
		rdbtnHombre.setBounds(86, 158, 70, 23);
		frame.getContentPane().add(rdbtnHombre);
		
		JRadioButton rdbtnMujer = new JRadioButton("Mujer");
		rdbtnMujer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane.showMessageDialog(frame, "Si ha tenido hijos, le acompañará un medico.");
				
			}
		});
		rdbtnMujer.setBounds(169, 158, 63, 23);
		frame.getContentPane().add(rdbtnMujer);
		
		JLabel lblDerminacin = new JLabel("Derminaci\u00F3n:");
		lblDerminacin.setBounds(10, 207, 82, 14);
		frame.getContentPane().add(lblDerminacin);
		
		JRadioButton rdbtnHeroe = new JRadioButton("Heroe");
		rdbtnHeroe.setBounds(83, 203, 109, 23);
		frame.getContentPane().add(rdbtnHeroe);
		
		JRadioButton rdbtnValiente = new JRadioButton("Valiente");
		rdbtnValiente.setBounds(70, 228, 109, 23);
		frame.getContentPane().add(rdbtnValiente);
		
		JRadioButton rdbtnCobarde = new JRadioButton("Cobarde");
		rdbtnCobarde.setBounds(70, 258, 109, 23);
		frame.getContentPane().add(rdbtnCobarde);
		
		JButton btnCalcular = new JButton("CALCULAR PERMISO VIAJE A MARTE");
		btnCalcular.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean permitido = true;
				boolean enfermo = false;
				if (chckbxAcaros.isSelected() ||
					chckbxAlimentarias.isSelected() ||
					chckbxMedicamentos.isSelected() ) {
					permitido = false;
					enfermo = true;
				}
				
				if(rdbtnHeroe.isSelected() || 
				   rdbtnCobarde.isSelected()) {
					permitido = false;
				}
				
								
				Informe dialogo = new Informe(permitido);
				if(enfermo == true) {
					dialogo.getLblNoPuedenViajar().setText("No puedes viajar con alergias");
				}else {
					dialogo.getLblNoPuedenViajar().setText("Estas 100% sano");
				}
				dialogo.setModal(true);
				dialogo.setVisible(true);
				
			}
		});
		btnCalcular.setBounds(70, 288, 240, 23);
		frame.getContentPane().add(btnCalcular);
		
		ButtonGroup grupoSexo = new ButtonGroup();
		grupoSexo.add(rdbtnHombre);
		grupoSexo.add(rdbtnMujer);
		
		ButtonGroup grupoDeterminacion = new ButtonGroup();
		grupoDeterminacion.add(rdbtnCobarde);
		grupoDeterminacion.add(rdbtnValiente);
		grupoDeterminacion.add(rdbtnHeroe);
		
	}
	
}
