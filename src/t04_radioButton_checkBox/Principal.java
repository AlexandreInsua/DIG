package t04_radioButton_checkBox;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

import jdk.nashorn.internal.scripts.JO;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.JRadioButton;
import javax.swing.JSeparator;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Principal {

	private JFrame frame;
	private JTextField textNome;

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
		frame.setBounds(100, 100, 515, 348);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel lblFormularioParaViaxar = new JLabel("Formulario para viaxar a Marte");
		lblFormularioParaViaxar.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
		lblFormularioParaViaxar.setHorizontalAlignment(SwingConstants.CENTER);
		lblFormularioParaViaxar.setBounds(110, 11, 302, 25);
		frame.getContentPane().add(lblFormularioParaViaxar);

		JLabel lblNome = new JLabel("Nome: ");
		lblNome.setBounds(20, 58, 46, 14);
		frame.getContentPane().add(lblNome);

		textNome = new JTextField();
		textNome.setBounds(80, 55, 86, 20);
		frame.getContentPane().add(textNome);
		textNome.setColumns(10);

		JLabel lblAlerxias = new JLabel("Alerxias:");
		lblAlerxias.setBounds(20, 89, 46, 14);
		frame.getContentPane().add(lblAlerxias);

		JCheckBox chckbxAlimentarias = new JCheckBox("Alimentarias");
		chckbxAlimentarias.setBounds(90, 85, 97, 23);
		frame.getContentPane().add(chckbxAlimentarias);

		JCheckBox chckbxMedicamentos = new JCheckBox("Medicamentos");
		chckbxMedicamentos.setBounds(203, 85, 97, 23);
		frame.getContentPane().add(chckbxMedicamentos);

		JCheckBox chckbxAcaros = new JCheckBox("\u00C1caros");
		chckbxAcaros.setBounds(330, 85, 97, 23);
		frame.getContentPane().add(chckbxAcaros);

		JLabel lblSexo = new JLabel("Sexo");
		lblSexo.setBounds(20, 136, 46, 14);
		frame.getContentPane().add(lblSexo);

		JRadioButton rdbtnHome = new JRadioButton("Home");
		rdbtnHome.setBounds(78, 132, 88, 23);
		frame.getContentPane().add(rdbtnHome);

		JRadioButton rdbtnMuller = new JRadioButton("Muller");
		rdbtnMuller.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane.showMessageDialog(frame, "Ten en conta que se tes fillos, serán marcianos.");
			}
		});
		rdbtnMuller.setBounds(210, 132, 62, 23);
		frame.getContentPane().add(rdbtnMuller);

		JSeparator separator = new JSeparator();
		separator.setBounds(20, 114, 109, 11);
		frame.getContentPane().add(separator);

		JLabel lblDeterminacin = new JLabel("Determinaci\u00F3n");
		lblDeterminacin.setBounds(20, 173, 115, 14);
		frame.getContentPane().add(lblDeterminacin);

		JRadioButton rdbtnHeroe = new JRadioButton("Heroe");
		rdbtnHeroe.setBounds(110, 169, 97, 23);
		frame.getContentPane().add(rdbtnHeroe);

		JRadioButton rdbtnValente = new JRadioButton("Valente");
		rdbtnValente.setBounds(224, 169, 97, 23);
		frame.getContentPane().add(rdbtnValente);

		JRadioButton rdbtnCovarde = new JRadioButton("Covarde");
		rdbtnCovarde.setBounds(345, 169, 97, 23);
		frame.getContentPane().add(rdbtnCovarde);

		JButton btnCalcula = new JButton("Calcular permiso viaxe a Marte");
		btnCalcula.addActionListener(new ActionListener() {		
			public void actionPerformed(ActionEvent e) {
				
			}
		});

		btnCalcula.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				// mostra o dialogo auxiliar
				
				boolean permitido = true;
				boolean enfermo = false;

				if (chckbxAcaros.isSelected() || chckbxAlimentarias.isSelected() || chckbxMedicamentos.isSelected()) {
					permitido = false;
					enfermo = true;
				}
				if (rdbtnHeroe.isSelected() || rdbtnCovarde.isSelected()) {
					permitido = false;
				}
				
				Informe dialogo = new Informe(permitido);
				// faina modal
				
				
				// accede as etiquetas de Informe desde o principal 
				if (enfermo) {
					dialogo.getLblSPodenViaxar().setText("Estás enfermo");
					
				} else {
					dialogo.getLblSPodenViaxar().setText("Estás sano");
				}
				
				dialogo.setModal(true);
				dialogo.setVisible(true);
			}
		});
		btnCalcula.setBounds(149, 236, 221, 23);
		frame.getContentPane().add(btnCalcula);

		ButtonGroup grupoSexo = new ButtonGroup();
		grupoSexo.add(rdbtnHome);
		grupoSexo.add(rdbtnMuller);

		ButtonGroup grupoDeterminacion = new ButtonGroup();
		grupoDeterminacion.add(rdbtnCovarde);
		grupoDeterminacion.add(rdbtnHeroe);
		grupoDeterminacion.add(rdbtnValente);
	}
}
