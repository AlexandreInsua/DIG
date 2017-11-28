package teoria;

import java.awt.BorderLayout;
import java.awt.Color;

import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;



public class Teoriak09_ViajeAMarte {

	private JFrame frame;
	private JTextField txtNombre;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Teoriak09_ViajeAMarte window = new Teoriak09_ViajeAMarte();
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
	public Teoriak09_ViajeAMarte() {
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


 class Informe extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JLabel lblAdmitido;
	private JLabel lblNoPuedenViajar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Informe dialog = new Informe(false);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Informe(boolean permiso) {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[]{0, 0};
		gbl_contentPanel.rowHeights = new int[]{0, 0, 0, 0, 0, 0};
		gbl_contentPanel.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gbl_contentPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPanel.setLayout(gbl_contentPanel);
		{
			lblAdmitido = new JLabel("ADMITIDO");
			lblAdmitido.setForeground(Color.GREEN);
			lblAdmitido.setFont(new Font("Tahoma", Font.BOLD, 18));
			GridBagConstraints gbc_lblAdmitido = new GridBagConstraints();
			gbc_lblAdmitido.insets = new Insets(0, 0, 5, 0);
			gbc_lblAdmitido.gridx = 0;
			gbc_lblAdmitido.gridy = 0;
			contentPanel.add(lblAdmitido, gbc_lblAdmitido);
		}
		{
			lblNoPuedenViajar = new JLabel("No pueden viajar personas con alergias");
			GridBagConstraints gbc_lblNoPuedenViajar = new GridBagConstraints();
			gbc_lblNoPuedenViajar.insets = new Insets(0, 0, 5, 0);
			gbc_lblNoPuedenViajar.gridx = 0;
			gbc_lblNoPuedenViajar.gridy = 1;
			contentPanel.add(lblNoPuedenViajar, gbc_lblNoPuedenViajar);
		}
		{
			JLabel lblSoloPuedenViajar = new JLabel("Solo pueden viajar las personas  valientes");
			GridBagConstraints gbc_lblSoloPuedenViajar = new GridBagConstraints();
			gbc_lblSoloPuedenViajar.insets = new Insets(0, 0, 5, 0);
			gbc_lblSoloPuedenViajar.gridx = 0;
			gbc_lblSoloPuedenViajar.gridy = 2;
			contentPanel.add(lblSoloPuedenViajar, gbc_lblSoloPuedenViajar);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton cancelButton = new JButton("Aceptar");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						setVisible(false);
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
		
		if(permiso == true) {
			lblAdmitido.setText("PERMISO CONCEDIDO");
			lblAdmitido.setForeground(Color.GREEN);
		}else {
			lblAdmitido.setText("PERMISO DENEGADO");
			lblAdmitido.setForeground(Color.RED);
		}
	}

	public JLabel getLblAdmitido() {
		return lblAdmitido;
	}
	public JLabel getLblNoPuedenViajar() {
		return lblNoPuedenViajar;
	}
}

