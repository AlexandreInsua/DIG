package exerciciosCasa04;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class AmigoInvisible {
	
	String pass="1234";

	private JFrame frmAmigoInvisible;
	private JTextField textNombre;
	private JComboBox comboNombre;
	private JList list;
	private JTable table;
	private JTextField textUsuario;
	private JTextField textResultado;
	
	private ModeloTabla miModelo;
	private JScrollPane scrollPane_1;
	private JTextField textAdmin;
	private JButton btnDesconectar;
	private JCheckBox chckbxAcceso;

	/**
	 * Launch the application.
	 */
	public static void main(final String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					final AmigoInvisible window = new AmigoInvisible();
					window.frmAmigoInvisible.setVisible(true);
				} catch (final Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public AmigoInvisible() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmAmigoInvisible = new JFrame();
		frmAmigoInvisible.setTitle("Amigo invisible");
		frmAmigoInvisible.setBounds(100, 100, 613, 318);
		frmAmigoInvisible.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		final JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		frmAmigoInvisible.getContentPane().add(tabbedPane, BorderLayout.CENTER);

		final DefaultListModel< Participante> modelo = new DefaultListModel<Participante>();
		
		final JPanel panel_4 = new JPanel();
		tabbedPane.addTab("Usuario", null, panel_4, null);
		panel_4.setLayout(null);
		
		textUsuario = new JTextField();
		textUsuario.setBounds(173, 37, 86, 20);
		panel_4.add(textUsuario);
		textUsuario.setColumns(10);
		
		final JLabel lblNombreParticipante_1 = new JLabel("Nombre participante:");
		lblNombreParticipante_1.setBounds(10, 40, 152, 14);
		panel_4.add(lblNombreParticipante_1);
		
		final JButton btnComprobar = new JButton("Comprobar emparejamiento");
		btnComprobar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(final MouseEvent e) {
				usuarioComprueba();
			}
		});
		
		btnComprobar.setBounds(10, 68, 219, 23);
		panel_4.add(btnComprobar);
		
		final JLabel lblTienesQueRegalar = new JLabel("Tienes que regalar  a: ");
		lblTienesQueRegalar.setBounds(304, 14, 236, 14);
		panel_4.add(lblTienesQueRegalar);
		
		textResultado = new JTextField();
		textResultado.setEditable(false);
		textResultado.setBounds(304, 39, 123, 20);
		panel_4.add(textResultado);
		textResultado.setColumns(10);
		
		textAdmin = new JTextField();
		textAdmin.setBounds(10, 210, 130, 20);
		panel_4.add(textAdmin);
		textAdmin.setColumns(10);
		
		final JLabel lblAdministrador = new JLabel("Administrador: Pass=1234");
		lblAdministrador.setBounds(10, 184, 181, 14);
		panel_4.add(lblAdministrador);

		
		final JButton btnAcceder = new JButton("Acceder");
		btnAcceder.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(final MouseEvent arg0) {
				if(textAdmin.getText().equals(pass)){
					chckbxAcceso.setVisible(true);
					btnDesconectar.setVisible(true);
					textAdmin.setText("");
				}else{
					JOptionPane.showMessageDialog(null, "Pass incorrecta");
				}
			}
		});
		btnAcceder.setBounds(239, 202, 89, 23);
		panel_4.add(btnAcceder);
		
		final JPanel panel = new JPanel();
		tabbedPane.addTab("Administrador", null, panel, null);
		panel.setLayout(new BorderLayout(0, 0));
		tabbedPane.remove(panel);
		
		btnDesconectar = new JButton("Desconectar");
		btnDesconectar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(final MouseEvent e) {
				chckbxAcceso.setVisible(false);
				btnDesconectar.setVisible(false);
				chckbxAcceso.setSelected(false);
			}
		});
		btnDesconectar.setVisible(false);
		btnDesconectar.setBounds(338, 202, 89, 23);
		panel_4.add(btnDesconectar);
		
		final JButton btnLimpiarDatos = new JButton("Limpiar Datos");
		btnLimpiarDatos.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(final MouseEvent e) {
				textUsuario.setText("");
				textResultado.setText("");
			}
		});
		btnLimpiarDatos.setBounds(304, 68, 123, 23);
		panel_4.add(btnLimpiarDatos);
		
		chckbxAcceso = new JCheckBox("Acceso");
		chckbxAcceso.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(final ChangeEvent e) {
				if(chckbxAcceso.isSelected()){
					tabbedPane.addTab("Administrador", null, panel, null);
				}else{
					tabbedPane.remove(panel);
				}
			}
		});
		chckbxAcceso.setVisible(false);
		chckbxAcceso.setBounds(433, 202, 107, 23);
		panel_4.add(chckbxAcceso);
		
		
		final JPanel panel_1 = new JPanel();
		panel.add(panel_1, BorderLayout.NORTH);
		
		final JLabel lblNombreParticipante = new JLabel("Nombre participante");
		panel_1.add(lblNombreParticipante);
		
		textNombre = new JTextField();
		panel_1.add(textNombre);
		textNombre.setColumns(10);
		
		final JButton btnInsertar = new JButton("A\u00F1adir");
		btnInsertar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(final MouseEvent arg0) {
				if(!textNombre.getText().equals("")) insertarParticipante();
			}
		});
		panel_1.add(btnInsertar);
		
		comboNombre = new JComboBox();
		llenadoInicialCombo();
		comboNombre.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(final ActionEvent arg0) {
				insertarEnLista();
			}
		});
		panel_1.add(comboNombre);
		
		final JPanel panel_2 = new JPanel();
		panel.add(panel_2, BorderLayout.SOUTH);
		
		final JButton btnNewButton = new JButton("Realizar Sorteo");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(final MouseEvent arg0) {
				sorteo();
			}
		});
		
		final JButton btnLimpiar = new JButton("Limpiar datos");
		btnLimpiar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(final MouseEvent arg0) {
				modelo.removeAllElements();
			}
		});
		panel_2.add(btnLimpiar);
		panel_2.add(btnNewButton);
		
		final JPanel panel_3 = new JPanel();
		panel.add(panel_3, BorderLayout.CENTER);
		panel_3.setLayout(null);
		
		final JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(8, 31, 258, 130);
		panel_3.add(scrollPane);
		
		list = new JList();
		scrollPane.setViewportView(list);
		list.setModel(modelo);
		
		scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(278, 31, 216, 130);
		panel_3.add(scrollPane_1);
		
		miModelo = new ModeloTabla();
		table = new JTable(miModelo);
		scrollPane_1.setViewportView(table);
		
		final JLabel lblListadoDeParticipantes = new JLabel("Listado de participantes");
		lblListadoDeParticipantes.setFont(new Font("Tahoma", Font.ITALIC, 14));
		lblListadoDeParticipantes.setBounds(23, 6, 173, 14);
		panel_3.add(lblListadoDeParticipantes);
		
		final JLabel lblResultadoDelEmparejamiento = new JLabel("Resultado del emparejamiento");
		lblResultadoDelEmparejamiento.setFont(new Font("Tahoma", Font.ITALIC, 14));
		lblResultadoDelEmparejamiento.setBounds(278, 6, 216, 14);
		panel_3.add(lblResultadoDelEmparejamiento);
	}
	
	public void insertarParticipante(){
		
		final Participante participante = new Participante(); 
		participante.setNombre(textNombre.getText());
		comboNombre.addItem(participante);
		textNombre.setText("");
	}
	
	public void insertarEnLista(){
		final Participante participante = (Participante) comboNombre.getSelectedItem();
		final DefaultListModel<Participante> modelo = (DefaultListModel<Participante>) list.getModel();
		modelo.addElement(participante);
		list.setModel(modelo);
		
	}

	public void llenadoInicialCombo(){
		Participante a = new Participante("Ana", false);
		comboNombre.addItem(a);
		a = new Participante("Andres", false);
		comboNombre.addItem(a);
		a = new Participante("Isabel", false);
		comboNombre.addItem(a);
		a = new Participante("Juan", false);
		comboNombre.addItem(a);
		a = new Participante("Paula", false);
		comboNombre.addItem(a);
		a = new Participante("Pedro", false);
		comboNombre.addItem(a);
	}
	
	public void sorteo(){

		final ArrayList<Participante> listado = new ArrayList<Participante>();
		
		int aleatorio;
		int contadorNum=0;
		final DefaultListModel<Participante> modelo = (DefaultListModel<Participante>) list.getModel();
		final int tam = modelo.getSize();

		Participante parti;
		Participante elegido;

		//reseteamos los valores de los participantes
		for(int j=0; j<tam;j++){
			parti = modelo.getElementAt(j);
			parti.setOcupado(false);
		}

		//comienza el sorteo
		for(int i=0; i<tam;i++){
			parti = modelo.getElementAt(i);
			System.out.println(parti.isOcupado());
			System.out.println("el regalador: " + parti.toString() );
			do{
				do{
					aleatorio = (int) (Math.random()*(tam+1)-1);
					System.out.println("Numero aleatorio -->" + aleatorio);
					contadorNum++;
					System.out.println("contador--> "+contadorNum);
				}while(aleatorio == i && contadorNum < 50);

				elegido = modelo.getElementAt(aleatorio);

			}while(elegido.isOcupado() && contadorNum < 50);

			if(contadorNum == 50){
				JOptionPane.showMessageDialog(null, "Repetir sorteo, nadie se regala as� mismo");
				System.out.println("salida");
				return;

			}else{
				elegido.setOcupado(true);
				parti.setRegalarA(elegido.getNombre());
				contadorNum=0;
				System.out.println(parti.getNombre() +" le regala a: "+ parti.getRegalarA());
				listado.add(parti);
			}
		}// fin del for
		
		miModelo.cargarDatos(listado);
		table = new JTable(miModelo);
		scrollPane_1.setViewportView(table);
	}
	
	public void usuarioComprueba(){
		
		final String usuario = textUsuario.getText();
		
		
		DefaultListModel<Participante> modelo = new DefaultListModel<Participante>();
		modelo = (DefaultListModel<Participante>) list.getModel();
		
		
		for(int i=0;i<modelo.getSize(); i++){
			final Participante par = modelo.getElementAt(i);
			if(usuario.equals(par.getNombre())){
				textResultado.setText(par.getRegalarA());
				return;
			}
		}
		JOptionPane.showMessageDialog(null, "No est�s en el sorteo");
	}
}

