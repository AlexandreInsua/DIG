package exerciciosCasa03.vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.JSplitPane;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JSlider;
import java.awt.FlowLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Toolkit;
import java.awt.Color;
import java.awt.Font;

public class ventantaprincipal {

	private JFrame frmGrelaCaf;
	private JLabel lblCantidad010;
	private double saldo, cambio, recaudacion;
	int saldoparacambio;
	private JLabel lblInfo;
	private int c010 = 50, c020 = 50, c050 = 20, c1 = 10, c2 = 10;
	private int i010, i020, i050, i1, i2;
	private int v010, v020, v050, v1, v2;
	private JLabel l010i;
	private JLabel l020i;
	private JLabel lblCantidad020;
	private JLabel l050i;
	private JLabel lblCantidad050;
	private JLabel l1i;
	private JLabel lblCantidad1;
	private JLabel l2i;
	private JLabel lblCantidad2;
	private boolean ocupada, producto, cambol;
	private JLabel lblCambio;
	private JLabel lblProductoARecoger;
	private JSlider sCafe;
	private JSlider sChoco;
	private JSlider sAgua;
	private JSlider sLeche;
	private JSlider sTe;
	private JLabel lblCafegramos;
	private JLabel lblChcolategramos;
	private JLabel lblAguaml;
	private JLabel lblLechegr;
	private JLabel lblTegr;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ventantaprincipal window = new ventantaprincipal();
					window.frmGrelaCaf.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ventantaprincipal() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmGrelaCaf = new JFrame();
		frmGrelaCaf.setForeground(Color.MAGENTA);
		frmGrelaCaf.setTitle("Grela caf\u00E9");
		frmGrelaCaf.setIconImage(Toolkit.getDefaultToolkit().getImage(ventantaprincipal.class.getResource("/exerciciosCasa03/img/Coffee-1.png")));
		frmGrelaCaf.setBounds(100, 100, 1149, 739);
		frmGrelaCaf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JSplitPane splitPane = new JSplitPane();
		frmGrelaCaf.getContentPane().add(splitPane, BorderLayout.CENTER);

		JPanel panel = new JPanel();
		splitPane.setLeftComponent(panel);
		panel.setLayout(new BorderLayout(0, 0));

		JPanel panel_1 = new JPanel();
		panel.add(panel_1, BorderLayout.CENTER);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[] { 0, 0, 0, 16, 0, 0, 0, 0, 0 };
		gbl_panel_1.columnWeights = new double[] { 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0 };
		gbl_panel_1.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0 };
		panel_1.setLayout(gbl_panel_1);

		JLabel lblImagenCaf = new JLabel("");
		lblImagenCaf.setIcon(new ImageIcon(ventantaprincipal.class.getResource("/exerciciosCasa03/img/cafe_ART_01.png")));
		lblImagenCaf.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_lblImagenCaf = new GridBagConstraints();
		gbc_lblImagenCaf.gridwidth = 2;
		gbc_lblImagenCaf.gridheight = 4;
		gbc_lblImagenCaf.insets = new Insets(0, 0, 5, 5);
		gbc_lblImagenCaf.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblImagenCaf.gridx = 0;
		gbc_lblImagenCaf.gridy = 0;
		panel_1.add(lblImagenCaf, gbc_lblImagenCaf);

		JLabel lblMonedas = new JLabel("Monedas");
		GridBagConstraints gbc_lblMonedas = new GridBagConstraints();
		gbc_lblMonedas.gridwidth = 6;
		gbc_lblMonedas.insets = new Insets(0, 0, 5, 0);
		gbc_lblMonedas.gridx = 3;
		gbc_lblMonedas.gridy = 4;
		panel_1.add(lblMonedas, gbc_lblMonedas);

		JButton bI010 = new JButton("10 cents");
		bI010.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				meter010();
			}
		});
		GridBagConstraints gbc_bI010 = new GridBagConstraints();
		gbc_bI010.gridwidth = 2;
		gbc_bI010.insets = new Insets(0, 0, 5, 5);
		gbc_bI010.gridx = 2;
		gbc_bI010.gridy = 5;
		panel_1.add(bI010, gbc_bI010);

		JButton bI1 = new JButton("1 \u20AC");
		bI1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				meter1();
			}
		});
		GridBagConstraints gbc_bI1 = new GridBagConstraints();
		gbc_bI1.fill = GridBagConstraints.HORIZONTAL;
		gbc_bI1.gridwidth = 3;
		gbc_bI1.insets = new Insets(0, 0, 5, 5);
		gbc_bI1.gridx = 4;
		gbc_bI1.gridy = 5;
		panel_1.add(bI1, gbc_bI1);

		lblInfo = new JLabel("Info");
		GridBagConstraints gbc_lblInfo = new GridBagConstraints();
		gbc_lblInfo.gridwidth = 2;
		gbc_lblInfo.insets = new Insets(0, 0, 5, 5);
		gbc_lblInfo.gridx = 0;
		gbc_lblInfo.gridy = 6;
		panel_1.add(lblInfo, gbc_lblInfo);

		JButton bI020 = new JButton("20 cents");
		bI020.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				meter020();
			}
		});
		GridBagConstraints gbc_bI020 = new GridBagConstraints();
		gbc_bI020.gridwidth = 2;
		gbc_bI020.insets = new Insets(0, 0, 5, 5);
		gbc_bI020.gridx = 2;
		gbc_bI020.gridy = 6;
		panel_1.add(bI020, gbc_bI020);

		JButton bI2 = new JButton("2 \u20AC");
		bI2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				meter2();
			}
		});
		GridBagConstraints gbc_bI2 = new GridBagConstraints();
		gbc_bI2.fill = GridBagConstraints.HORIZONTAL;
		gbc_bI2.gridwidth = 3;
		gbc_bI2.insets = new Insets(0, 0, 5, 5);
		gbc_bI2.gridx = 4;
		gbc_bI2.gridy = 6;
		panel_1.add(bI2, gbc_bI2);

		JButton bI050 = new JButton("50 cents");
		bI050.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				meter050();
			}
		});
		GridBagConstraints gbc_bI050 = new GridBagConstraints();
		gbc_bI050.gridwidth = 2;
		gbc_bI050.insets = new Insets(0, 0, 5, 5);
		gbc_bI050.gridx = 2;
		gbc_bI050.gridy = 7;
		panel_1.add(bI050, gbc_bI050);

		JButton bCancelar = new JButton("Cancelar");
		bCancelar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				cancelar();
			}
		});
		GridBagConstraints gbc_bCancelar = new GridBagConstraints();
		gbc_bCancelar.fill = GridBagConstraints.HORIZONTAL;
		gbc_bCancelar.gridwidth = 3;
		gbc_bCancelar.insets = new Insets(0, 0, 5, 5);
		gbc_bCancelar.gridx = 4;
		gbc_bCancelar.gridy = 7;
		panel_1.add(bCancelar, gbc_bCancelar);

		JLabel lblProducto = new JLabel("Producto");
		GridBagConstraints gbc_lblProducto = new GridBagConstraints();
		gbc_lblProducto.gridwidth = 2;
		gbc_lblProducto.insets = new Insets(0, 0, 5, 5);
		gbc_lblProducto.gridx = 0;
		gbc_lblProducto.gridy = 10;
		panel_1.add(lblProducto, gbc_lblProducto);

		JButton button = new JButton("Caf\u00E9 con Leche, 50 cents");
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				cafeconleche(0.5);
			}
		});
		GridBagConstraints gbc_button = new GridBagConstraints();
		gbc_button.fill = GridBagConstraints.HORIZONTAL;
		gbc_button.insets = new Insets(0, 0, 5, 5);
		gbc_button.gridx = 0;
		gbc_button.gridy = 11;
		panel_1.add(button, gbc_button);

		JButton btnAguaCaliente = new JButton("Agua caliente, 10 cents");
		btnAguaCaliente.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				aguacaliente(0.1);
			}
		});
		GridBagConstraints gbc_btnAguaCaliente = new GridBagConstraints();
		gbc_btnAguaCaliente.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnAguaCaliente.insets = new Insets(0, 0, 5, 5);
		gbc_btnAguaCaliente.gridx = 1;
		gbc_btnAguaCaliente.gridy = 11;
		panel_1.add(btnAguaCaliente, gbc_btnAguaCaliente);

		JButton btnNewButton_4 = new JButton("Cortado, 50 cents");
		btnNewButton_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				cafecortado(0.5);
			}
		});
		GridBagConstraints gbc_btnNewButton_4 = new GridBagConstraints();
		gbc_btnNewButton_4.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnNewButton_4.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_4.gridx = 0;
		gbc_btnNewButton_4.gridy = 12;
		panel_1.add(btnNewButton_4, gbc_btnNewButton_4);

		JButton btnChocolateALa = new JButton("Chocolate a la taza, 40 cents");
		btnChocolateALa.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				chocolate(0.4);
			}
		});
		GridBagConstraints gbc_btnChocolateALa = new GridBagConstraints();
		gbc_btnChocolateALa.insets = new Insets(0, 0, 5, 5);
		gbc_btnChocolateALa.gridx = 1;
		gbc_btnChocolateALa.gridy = 12;
		panel_1.add(btnChocolateALa, gbc_btnChocolateALa);

		JButton btnCafSolo = new JButton("Caf\u00E9 solo, 40 cents");
		btnCafSolo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				cafesolo(0.4);
			}
		});
		GridBagConstraints gbc_btnCafSolo = new GridBagConstraints();
		gbc_btnCafSolo.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnCafSolo.insets = new Insets(0, 0, 5, 5);
		gbc_btnCafSolo.gridx = 0;
		gbc_btnCafSolo.gridy = 13;
		panel_1.add(btnCafSolo, gbc_btnCafSolo);

		JButton btnCafGroumet = new JButton("Caf\u00E9 gourmet, 80 cents");
		btnCafGroumet.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				cafegourmet(0.8);
			}
		});
		GridBagConstraints gbc_btnCafGroumet = new GridBagConstraints();
		gbc_btnCafGroumet.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnCafGroumet.insets = new Insets(0, 0, 5, 5);
		gbc_btnCafGroumet.gridx = 1;
		gbc_btnCafGroumet.gridy = 13;
		panel_1.add(btnCafGroumet, gbc_btnCafGroumet);

		JButton btnTConLeche = new JButton("T\u00E9 con leche, 40 cents");
		btnTConLeche.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				teconleche(0.4);
			}
		});
		GridBagConstraints gbc_btnTConLeche = new GridBagConstraints();
		gbc_btnTConLeche.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnTConLeche.insets = new Insets(0, 0, 5, 5);
		gbc_btnTConLeche.gridx = 0;
		gbc_btnTConLeche.gridy = 14;
		panel_1.add(btnTConLeche, gbc_btnTConLeche);

		JButton btnVaco = new JButton("Vac\u00EDo");
		btnVaco.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lblInfo.setText("Nin�n producto pedido");
			}
		});
		GridBagConstraints gbc_btnVaco = new GridBagConstraints();
		gbc_btnVaco.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnVaco.insets = new Insets(0, 0, 5, 5);
		gbc_btnVaco.gridx = 1;
		gbc_btnVaco.gridy = 14;
		panel_1.add(btnVaco, gbc_btnVaco);

		lblCambio = new JLabel("2");
		GridBagConstraints gbc_lblCambio = new GridBagConstraints();
		gbc_lblCambio.gridwidth = 2;
		gbc_lblCambio.insets = new Insets(0, 0, 5, 5);
		gbc_lblCambio.gridx = 3;
		gbc_lblCambio.gridy = 16;
		panel_1.add(lblCambio, gbc_lblCambio);

		JButton bRecogerCambio = new JButton("Recoger");
		bRecogerCambio.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lblCambio.setText("");
				introducidasa0();
				cambol = false;
			}
		});
		GridBagConstraints gbc_bRecogerCambio = new GridBagConstraints();
		gbc_bRecogerCambio.insets = new Insets(0, 0, 5, 0);
		gbc_bRecogerCambio.gridwidth = 4;
		gbc_bRecogerCambio.gridx = 5;
		gbc_bRecogerCambio.gridy = 16;
		panel_1.add(bRecogerCambio, gbc_bRecogerCambio);

		lblProductoARecoger = new JLabel("Producto");
		GridBagConstraints gbc_lblProductoARecoger = new GridBagConstraints();
		gbc_lblProductoARecoger.anchor = GridBagConstraints.EAST;
		gbc_lblProductoARecoger.insets = new Insets(0, 0, 5, 5);
		gbc_lblProductoARecoger.gridx = 0;
		gbc_lblProductoARecoger.gridy = 17;
		panel_1.add(lblProductoARecoger, gbc_lblProductoARecoger);

		JButton bRecogerProducto = new JButton("Recoger");
		bRecogerProducto.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				recogerProducto();
			}
		});
		GridBagConstraints gbc_bRecogerProducto = new GridBagConstraints();
		gbc_bRecogerProducto.fill = GridBagConstraints.HORIZONTAL;
		gbc_bRecogerProducto.insets = new Insets(0, 0, 5, 5);
		gbc_bRecogerProducto.gridx = 1;
		gbc_bRecogerProducto.gridy = 17;
		panel_1.add(bRecogerProducto, gbc_bRecogerProducto);

		JLabel lblCents = new JLabel("");
		lblCents.setIcon(new ImageIcon(ventantaprincipal.class.getResource("/exerciciosCasa03/img/010.png")));
		GridBagConstraints gbc_lblCents = new GridBagConstraints();
		gbc_lblCents.insets = new Insets(0, 0, 5, 5);
		gbc_lblCents.gridx = 2;
		gbc_lblCents.gridy = 19;
		panel_1.add(lblCents, gbc_lblCents);

		JLabel lblCents_1 = new JLabel("");
		lblCents_1.setIcon(new ImageIcon(ventantaprincipal.class.getResource("/exerciciosCasa03/img/020.png")));
		GridBagConstraints gbc_lblCents_1 = new GridBagConstraints();
		gbc_lblCents_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblCents_1.gridx = 3;
		gbc_lblCents_1.gridy = 19;
		panel_1.add(lblCents_1, gbc_lblCents_1);

		JLabel lblCents_2 = new JLabel("");
		lblCents_2.setIcon(new ImageIcon(ventantaprincipal.class.getResource("/exerciciosCasa03/img/050.png")));
		GridBagConstraints gbc_lblCents_2 = new GridBagConstraints();
		gbc_lblCents_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblCents_2.gridx = 4;
		gbc_lblCents_2.gridy = 19;
		panel_1.add(lblCents_2, gbc_lblCents_2);

		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(ventantaprincipal.class.getResource("/exerciciosCasa03/img/1.png")));
		GridBagConstraints gbc_label = new GridBagConstraints();
		gbc_label.insets = new Insets(0, 0, 5, 5);
		gbc_label.gridx = 5;
		gbc_label.gridy = 19;
		panel_1.add(label, gbc_label);

		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(ventantaprincipal.class.getResource("/exerciciosCasa03/img/2.png")));
		GridBagConstraints gbc_label_1 = new GridBagConstraints();
		gbc_label_1.insets = new Insets(0, 0, 5, 5);
		gbc_label_1.gridx = 6;
		gbc_label_1.gridy = 19;
		panel_1.add(label_1, gbc_label_1);

		l010i = new JLabel("0");
		GridBagConstraints gbc_l010i = new GridBagConstraints();
		gbc_l010i.insets = new Insets(0, 0, 0, 5);
		gbc_l010i.gridx = 2;
		gbc_l010i.gridy = 20;
		panel_1.add(l010i, gbc_l010i);

		l020i = new JLabel("0");
		GridBagConstraints gbc_l020i = new GridBagConstraints();
		gbc_l020i.insets = new Insets(0, 0, 0, 5);
		gbc_l020i.gridx = 3;
		gbc_l020i.gridy = 20;
		panel_1.add(l020i, gbc_l020i);

		l050i = new JLabel("0");
		GridBagConstraints gbc_l050i = new GridBagConstraints();
		gbc_l050i.insets = new Insets(0, 0, 0, 5);
		gbc_l050i.gridx = 4;
		gbc_l050i.gridy = 20;
		panel_1.add(l050i, gbc_l050i);

		l1i = new JLabel("0");
		GridBagConstraints gbc_l1i = new GridBagConstraints();
		gbc_l1i.insets = new Insets(0, 0, 0, 5);
		gbc_l1i.gridx = 5;
		gbc_l1i.gridy = 20;
		panel_1.add(l1i, gbc_l1i);

		l2i = new JLabel("0");
		GridBagConstraints gbc_l2i = new GridBagConstraints();
		gbc_l2i.insets = new Insets(0, 0, 0, 5);
		gbc_l2i.gridx = 6;
		gbc_l2i.gridy = 20;
		panel_1.add(l2i, gbc_l2i);

		JPanel panel_2 = new JPanel();
		splitPane.setRightComponent(panel_2);
		panel_2.setLayout(new BorderLayout(0, 0));

		JPanel panel_3 = new JPanel();
		panel_2.add(panel_3, BorderLayout.NORTH);
		panel_3.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		JButton btnRellenar = new JButton("Rellenar");
		btnRellenar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				rellenarCambio();
			}
		});
		panel_3.add(btnRellenar);

		JLabel lblMonedasDeLa = new JLabel("Monedas de la M\u00E1quina");
		panel_3.add(lblMonedasDeLa);

		JButton btnRecoger = new JButton("Recoger");
		btnRecoger.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				recogerRecaudacion();
			}
		});
		panel_3.add(btnRecoger);

		JPanel panel_4 = new JPanel();
		panel_2.add(panel_4, BorderLayout.CENTER);
		panel_4.setLayout(new BorderLayout(0, 0));

		JPanel panel_5 = new JPanel();
		panel_4.add(panel_5, BorderLayout.NORTH);
		GridBagLayout gbl_panel_5 = new GridBagLayout();
		gbl_panel_5.columnWidths = new int[] { 0, 0, 0, 0, 0, 0 };
		gbl_panel_5.rowHeights = new int[] { 0, 0, 0, 0 };
		gbl_panel_5.columnWeights = new double[] { 1.0, 1.0, 1.0, 1.0, 1.0, Double.MIN_VALUE };
		gbl_panel_5.rowWeights = new double[] { 0.0, 0.0, 0.0, Double.MIN_VALUE };
		panel_5.setLayout(gbl_panel_5);

		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(ventantaprincipal.class.getResource("/exerciciosCasa03/img/050.png")));
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 0;
		panel_5.add(lblNewLabel_1, gbc_lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setIcon(new ImageIcon(ventantaprincipal.class.getResource("/exerciciosCasa03/img/020.png")));
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 1;
		gbc_lblNewLabel_2.gridy = 0;
		panel_5.add(lblNewLabel_2, gbc_lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setIcon(new ImageIcon(ventantaprincipal.class.getResource("/exerciciosCasa03/img/010.png")));
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_3.gridx = 2;
		gbc_lblNewLabel_3.gridy = 0;
		panel_5.add(lblNewLabel_3, gbc_lblNewLabel_3);

		JLabel lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setIcon(new ImageIcon(ventantaprincipal.class.getResource("/exerciciosCasa03/img/1.png")));
		GridBagConstraints gbc_lblNewLabel_5 = new GridBagConstraints();
		gbc_lblNewLabel_5.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_5.gridx = 3;
		gbc_lblNewLabel_5.gridy = 0;
		panel_5.add(lblNewLabel_5, gbc_lblNewLabel_5);

		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setIcon(new ImageIcon(ventantaprincipal.class.getResource("/exerciciosCasa03/img/2.png")));
		GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
		gbc_lblNewLabel_4.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblNewLabel_4.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel_4.gridx = 4;
		gbc_lblNewLabel_4.gridy = 0;
		panel_5.add(lblNewLabel_4, gbc_lblNewLabel_4);

		lblCantidad010 = new JLabel("50");
		GridBagConstraints gbc_lblCantidad010 = new GridBagConstraints();
		gbc_lblCantidad010.insets = new Insets(0, 0, 5, 5);
		gbc_lblCantidad010.gridx = 0;
		gbc_lblCantidad010.gridy = 1;
		panel_5.add(lblCantidad010, gbc_lblCantidad010);

		lblCantidad020 = new JLabel("20");
		GridBagConstraints gbc_lblCantidad020 = new GridBagConstraints();
		gbc_lblCantidad020.insets = new Insets(0, 0, 5, 5);
		gbc_lblCantidad020.gridx = 1;
		gbc_lblCantidad020.gridy = 1;
		panel_5.add(lblCantidad020, gbc_lblCantidad020);

		lblCantidad050 = new JLabel("10");
		GridBagConstraints gbc_lblCantidad050 = new GridBagConstraints();
		gbc_lblCantidad050.insets = new Insets(0, 0, 5, 5);
		gbc_lblCantidad050.gridx = 2;
		gbc_lblCantidad050.gridy = 1;
		panel_5.add(lblCantidad050, gbc_lblCantidad050);

		lblCantidad1 = new JLabel("1");
		GridBagConstraints gbc_lblCantidad1 = new GridBagConstraints();
		gbc_lblCantidad1.insets = new Insets(0, 0, 5, 5);
		gbc_lblCantidad1.gridx = 3;
		gbc_lblCantidad1.gridy = 1;
		panel_5.add(lblCantidad1, gbc_lblCantidad1);

		lblCantidad2 = new JLabel("2");
		GridBagConstraints gbc_lblCantidad2 = new GridBagConstraints();
		gbc_lblCantidad2.insets = new Insets(0, 0, 5, 0);
		gbc_lblCantidad2.gridx = 4;
		gbc_lblCantidad2.gridy = 1;
		panel_5.add(lblCantidad2, gbc_lblCantidad2);

		JPanel panel_6 = new JPanel();
		panel_4.add(panel_6, BorderLayout.CENTER);
		panel_6.setLayout(new BorderLayout(0, 0));

		JPanel panel_7 = new JPanel();
		panel_6.add(panel_7, BorderLayout.NORTH);

		JLabel lblNivelesDeProducto = new JLabel("Niveles de Producto en m\u00E1quina");
		lblNivelesDeProducto.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNivelesDeProducto.setForeground(Color.MAGENTA);
		panel_7.add(lblNivelesDeProducto);

		JPanel panel_8 = new JPanel();
		panel_6.add(panel_8, BorderLayout.CENTER);
		GridBagLayout gbl_panel_8 = new GridBagLayout();
		gbl_panel_8.columnWidths = new int[] { 0, 0, 0, 0, 0, 0 };
		gbl_panel_8.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gbl_panel_8.columnWeights = new double[] { 1.0, 0.0, 1.0, 1.0, 1.0, Double.MIN_VALUE };
		gbl_panel_8.rowWeights = new double[] { 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				Double.MIN_VALUE };
		panel_8.setLayout(gbl_panel_8);

		JLabel lblCaf = new JLabel("Caf\u00E9");
		GridBagConstraints gbc_lblCaf = new GridBagConstraints();
		gbc_lblCaf.insets = new Insets(0, 0, 5, 5);
		gbc_lblCaf.gridx = 0;
		gbc_lblCaf.gridy = 0;
		panel_8.add(lblCaf, gbc_lblCaf);

		JLabel lblChcocolate = new JLabel("Chcocolate");
		GridBagConstraints gbc_lblChcocolate = new GridBagConstraints();
		gbc_lblChcocolate.insets = new Insets(0, 0, 5, 5);
		gbc_lblChcocolate.gridx = 1;
		gbc_lblChcocolate.gridy = 0;
		panel_8.add(lblChcocolate, gbc_lblChcocolate);

		JLabel lblAgua = new JLabel("Agua");
		GridBagConstraints gbc_lblAgua = new GridBagConstraints();
		gbc_lblAgua.insets = new Insets(0, 0, 5, 5);
		gbc_lblAgua.gridx = 2;
		gbc_lblAgua.gridy = 0;
		panel_8.add(lblAgua, gbc_lblAgua);

		JLabel lblLeche = new JLabel("Leche");
		GridBagConstraints gbc_lblLeche = new GridBagConstraints();
		gbc_lblLeche.insets = new Insets(0, 0, 5, 5);
		gbc_lblLeche.gridx = 3;
		gbc_lblLeche.gridy = 0;
		panel_8.add(lblLeche, gbc_lblLeche);

		JLabel lblT = new JLabel("T\u00E9");
		GridBagConstraints gbc_lblT = new GridBagConstraints();
		gbc_lblT.insets = new Insets(0, 0, 5, 0);
		gbc_lblT.gridx = 4;
		gbc_lblT.gridy = 0;
		panel_8.add(lblT, gbc_lblT);

		sCafe = new JSlider();
		sCafe.setEnabled(false);
		sCafe.setValue(160);
		sCafe.setMaximum(300);
		sCafe.setOrientation(SwingConstants.VERTICAL);
		GridBagConstraints gbc_sCafe = new GridBagConstraints();
		gbc_sCafe.fill = GridBagConstraints.VERTICAL;
		gbc_sCafe.insets = new Insets(0, 0, 5, 5);
		gbc_sCafe.gridx = 0;
		gbc_sCafe.gridy = 2;
		panel_8.add(sCafe, gbc_sCafe);

		sChoco = new JSlider();
		sChoco.setEnabled(false);

		sChoco.setValue(200);
		sChoco.setMaximum(300);
		sChoco.setOrientation(SwingConstants.VERTICAL);
		GridBagConstraints gbc_sChoco = new GridBagConstraints();
		gbc_sChoco.fill = GridBagConstraints.VERTICAL;
		gbc_sChoco.insets = new Insets(0, 0, 5, 5);
		gbc_sChoco.gridx = 1;
		gbc_sChoco.gridy = 2;
		panel_8.add(sChoco, gbc_sChoco);

		sAgua = new JSlider();
		sAgua.setEnabled(false);

		sAgua.setMaximum(1000);
		sAgua.setValue(500);
		sAgua.setOrientation(SwingConstants.VERTICAL);
		GridBagConstraints gbc_sAgua = new GridBagConstraints();
		gbc_sAgua.fill = GridBagConstraints.VERTICAL;
		gbc_sAgua.insets = new Insets(0, 0, 5, 5);
		gbc_sAgua.gridx = 2;
		gbc_sAgua.gridy = 2;
		panel_8.add(sAgua, gbc_sAgua);

		sLeche = new JSlider();
		sLeche.setEnabled(false);

		sLeche.setValue(400);
		sLeche.setMaximum(800);
		sLeche.setOrientation(SwingConstants.VERTICAL);
		GridBagConstraints gbc_sLeche = new GridBagConstraints();
		gbc_sLeche.fill = GridBagConstraints.VERTICAL;
		gbc_sLeche.insets = new Insets(0, 0, 5, 5);
		gbc_sLeche.gridx = 3;
		gbc_sLeche.gridy = 2;
		panel_8.add(sLeche, gbc_sLeche);

		sTe = new JSlider();
		sTe.setEnabled(false);

		sTe.setValue(80);
		sTe.setMaximum(300);
		sTe.setOrientation(SwingConstants.VERTICAL);
		GridBagConstraints gbc_sTe = new GridBagConstraints();
		gbc_sTe.fill = GridBagConstraints.VERTICAL;
		gbc_sTe.insets = new Insets(0, 0, 5, 0);
		gbc_sTe.gridx = 4;
		gbc_sTe.gridy = 2;
		panel_8.add(sTe, gbc_sTe);

		lblCafegramos = new JLabel(sCafe.getValue() + " gramos");
		lblCafegramos.setVerticalAlignment(SwingConstants.TOP);
		GridBagConstraints gbc_lblCafegramos = new GridBagConstraints();
		gbc_lblCafegramos.gridheight = 7;
		gbc_lblCafegramos.insets = new Insets(0, 0, 5, 5);
		gbc_lblCafegramos.gridx = 0;
		gbc_lblCafegramos.gridy = 3;
		panel_8.add(lblCafegramos, gbc_lblCafegramos);

		lblChcolategramos = new JLabel(sChoco.getValue() + " gramos");
		GridBagConstraints gbc_lblChcolategramos = new GridBagConstraints();
		gbc_lblChcolategramos.insets = new Insets(0, 0, 5, 5);
		gbc_lblChcolategramos.gridx = 1;
		gbc_lblChcolategramos.gridy = 6;
		panel_8.add(lblChcolategramos, gbc_lblChcolategramos);

		lblAguaml = new JLabel(sAgua.getValue() + " ml");
		GridBagConstraints gbc_lblAguaml = new GridBagConstraints();
		gbc_lblAguaml.insets = new Insets(0, 0, 5, 5);
		gbc_lblAguaml.gridx = 2;
		gbc_lblAguaml.gridy = 6;
		panel_8.add(lblAguaml, gbc_lblAguaml);

		lblLechegr = new JLabel(sLeche.getValue() + " gramos");
		GridBagConstraints gbc_lblLechegr = new GridBagConstraints();
		gbc_lblLechegr.insets = new Insets(0, 0, 5, 5);
		gbc_lblLechegr.gridx = 3;
		gbc_lblLechegr.gridy = 6;
		panel_8.add(lblLechegr, gbc_lblLechegr);

		lblTegr = new JLabel(sTe.getValue() + " gramos");
		GridBagConstraints gbc_lblTegr = new GridBagConstraints();
		gbc_lblTegr.insets = new Insets(0, 0, 5, 0);
		gbc_lblTegr.gridx = 4;
		gbc_lblTegr.gridy = 6;
		panel_8.add(lblTegr, gbc_lblTegr);

		JButton bRellenarCafe = new JButton("Rellenar");
		bRellenarCafe.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				sCafe.setValue(300);
				lblCafegramos.setText(300 + " gramos");
			}
		});
		GridBagConstraints gbc_bRellenarCafe = new GridBagConstraints();
		gbc_bRellenarCafe.insets = new Insets(0, 0, 0, 5);
		gbc_bRellenarCafe.gridx = 0;
		gbc_bRellenarCafe.gridy = 10;
		panel_8.add(bRellenarCafe, gbc_bRellenarCafe);

		JButton bRellenarChoco = new JButton("Rellenar");
		bRellenarChoco.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				sChoco.setValue(300);
				lblChcolategramos.setText(300 + " gramos");
			}
		});
		GridBagConstraints gbc_bRellenarChoco = new GridBagConstraints();
		gbc_bRellenarChoco.anchor = GridBagConstraints.SOUTH;
		gbc_bRellenarChoco.insets = new Insets(0, 0, 0, 5);
		gbc_bRellenarChoco.gridx = 1;
		gbc_bRellenarChoco.gridy = 10;
		panel_8.add(bRellenarChoco, gbc_bRellenarChoco);

		JButton bRellenarAgua = new JButton("Rellenar");
		bRellenarAgua.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				sAgua.setValue(1000);
				lblAguaml.setText(1000 + " ml");
			}
		});
		GridBagConstraints gbc_bRellenarAgua = new GridBagConstraints();
		gbc_bRellenarAgua.insets = new Insets(0, 0, 0, 5);
		gbc_bRellenarAgua.gridx = 2;
		gbc_bRellenarAgua.gridy = 10;
		panel_8.add(bRellenarAgua, gbc_bRellenarAgua);

		JButton bRellenarLeche = new JButton("Rellenar");
		bRellenarLeche.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				sLeche.setValue(1000);
				lblLechegr.setText(1000 + " gramos");
			}
		});
		GridBagConstraints gbc_bRellenarLeche = new GridBagConstraints();
		gbc_bRellenarLeche.insets = new Insets(0, 0, 0, 5);
		gbc_bRellenarLeche.gridx = 3;
		gbc_bRellenarLeche.gridy = 10;
		panel_8.add(bRellenarLeche, gbc_bRellenarLeche);

		JButton bRellenarTe = new JButton("Rellenar");
		bRellenarTe.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				sTe.setValue(300);
				lblTegr.setText(300 + " gramos");
			}
		});
		GridBagConstraints gbc_bRellenarTe = new GridBagConstraints();
		gbc_bRellenarTe.anchor = GridBagConstraints.SOUTH;
		gbc_bRellenarTe.gridx = 4;
		gbc_bRellenarTe.gridy = 10;
		panel_8.add(bRellenarTe, gbc_bRellenarTe);
	}

	private void meter010() {
		ocupada = true;
		saldo = saldo + 0.1;
		c010++;
		lblCantidad010.setText(c010 + "");
		i010++;
		l010i.setText(i010 + "");
		imprimirInfo();
	}

	private void meter020() {
		ocupada = true;
		saldo = saldo + 0.2;
		c020++;
		lblCantidad020.setText(c020 + "");
		i020++;
		l020i.setText(i020 + "");
		imprimirInfo();
	}

	private void meter050() {
		ocupada = true;
		saldo = saldo + 0.5;
		c050++;
		lblCantidad050.setText(c050 + "");
		i050++;
		l050i.setText(i050 + "");
		imprimirInfo();
	}

	private void meter1() {
		ocupada = true;
		saldo = saldo + 1;
		c1++;
		lblCantidad1.setText(c1 + "");
		i1++;
		l1i.setText(i1 + "");
		imprimirInfo();
	}

	private void meter2() {
		ocupada = true;
		saldo = saldo + 2;
		c2++;
		lblCantidad2.setText(c2 + "");
		i2++;
		l2i.setText(i2 + "");
		imprimirInfo();
	}

	private void imprimirInfo() {
		saldo = Math.round(saldo * 100);
		saldo = saldo / 100;
		lblInfo.setText("Saldo: " + saldo + "�");
	}

	private void cancelar() {
		c010 = c010 - i010;
		c020 = c020 - i020;
		c050 = c050 - i050;
		c1 = c1 - i1;
		c2 = c2 - i2;
		lblInfo.setText("Operaci�n cancelada, retire su dinero");
		imprimirMonedas();
		cambol = true;
		l010i.setText(i010 + "");
		l020i.setText(i020 + "");
		l050i.setText(i050 + "");
		l1i.setText(i1 + "");
		l2i.setText(i2 + "");
		lblCambio.setText("Su dinero: "+saldo);
		saldo = 0;

	}

	private void introducidasa0() {
		i010 = 0;
		i020 = 0;
		i050 = 0;
		i1 = 0;
		i2 = 0;
		l010i.setText(0 + "");
		l020i.setText(0 + "");
		l050i.setText(0 + "");
		l1i.setText(0 + "");
		l2i.setText(0 + "");
	}

	private void imprimirMonedas() {
		lblCantidad010.setText(c010 + "");
		lblCantidad020.setText(c020 + "");
		lblCantidad050.setText(c050 + "");
		lblCantidad1.setText(c1 + "");
		lblCantidad2.setText(c2 + "");
	}

	private void calcularCambio() {
		saldo = Math.round(saldo * 100);
		saldo = saldo / 100;
		saldoparacambio = ((int) (saldo * 10));
		Cambio c = new Cambio(saldoparacambio, new int[] { 20, 10, 5, 2, 1 });

		v2 = c.getVectorSeleccion()[0];
		v1 = c.getVectorSeleccion()[1];
		v050 = c.getVectorSeleccion()[2];
		v020 = c.getVectorSeleccion()[3];
		v010 = c.getVectorSeleccion()[4];
		introducidasa0();

		c2 = c2 - v2;
		c1 = c1 - v1;
		c050 = c050 - v050;
		c020 = c020 - v020;
		c010 = c010 - v010;

		imprimirMonedas();
		saldo = 0;
		cambio = v2 * 2 + v1 + v050 * 0.5 + v020 * 0.2 + v010 * 0.1;
		if (cambio != 0) {
			lblCambio.setText("Recoja su cambio: " + cambio);
			l010i.setText(v010 + "");
			l020i.setText(v020 + "");
			l050i.setText(v050 + "");
			l1i.setText(v1 + "");
			l2i.setText(v2 + "");
			cambol = true;
		} else {
			cambol = false;
		}

		ocupada = false;

	}

	private void rellenarCambio() {
		if (ocupada) {
			lblInfo.setText("M�quina en uso, por favor, espere a que se libere");
		} else {
			if (c010 < 50) {
				c010 = 50;

			}
			if (c020 < 50) {
				c020 = 50;

			}
			if (c050 < 20) {
				c050 = 20;

			}
			if (c1 < 10) {
				c1 = 10;

			}
			if (c2 < 10) {
				c2 = 10;

			}

			lblCantidad010.setText(c010 + "");
			lblCantidad020.setText(c020 + "");
			lblCantidad050.setText(c050 + "");
			lblCantidad1.setText(c1 + "");
			lblCantidad2.setText(c2 + "");
		}
	}

	private void gasto(int cafe, int choco, int te, int agua, int leche) {
		if (cafe > sCafe.getValue() || choco > sChoco.getValue() || te > sTe.getValue() || agua > sAgua.getValue()
				|| leche > sLeche.getValue()) {
			lblInfo.setText("Recursos insuficientes, contacte con el t�cnico");
			cancelar();
		}

		sCafe.setValue(sCafe.getValue() - cafe);
		sChoco.setValue(sChoco.getValue() - choco);
		sTe.setValue(sTe.getValue() - te);
		sAgua.setValue(sAgua.getValue() - agua);
		sLeche.setValue(sLeche.getValue() - leche);

		lblCafegramos.setText(sCafe.getValue() + " gramos");
		lblChcolategramos.setText(sChoco.getValue() + " gramos");
		lblTegr.setText(sTe.getValue() + " gramos");
		lblAguaml.setText(sAgua.getValue() + " ml");
		lblLechegr.setText(sLeche.getValue() + " gramos");
	}

	private void cafeconleche(double precio) {
		if (faseVenta("Caf� con leche", precio)) {
			gasto(5, 0, 0, 25, 5);
		}
		;

	}

	private void aguacaliente(double precio) {
		if (faseVenta("Agua caliente", precio)) {
			gasto(0, 0, 0, 25, 0);
		}
		;
	}

	private void cafecortado(double precio) {
		if (faseVenta("Caf� cortado", precio)) {
			gasto(5, 0, 0, 25, 3);
		}
		;
	}

	private void chocolate(double precio) {
		if (faseVenta("Chocolate", precio)) {
			gasto(0, 15, 0, 0, 3);
		}
		;
	}

	private void cafesolo(double precio) {
		if (faseVenta("Caf� solo", precio)) {
			gasto(5, 0, 0, 25, 0);
		}
		;
	}

	private void cafegourmet(double precio) {
		if (faseVenta("Caf� gourmet", precio)) {
			gasto(10, 0, 0, 25, 3);
		}
		;
	}

	private void teconleche(double precio) {
		if (faseVenta("T� con leche", precio)) {
			gasto(0, 0, 15, 25, 3);
		}
		;
	}

	private void recogerProducto() {
		if (producto == false) {
			lblProductoARecoger.setText("No hay nada en la bandeja");
		} else {
			lblProductoARecoger.setText("");
			ocupada = false;
			producto = false;
			lblInfo.setText("Muchas Gracias!");
		}
	}

	private boolean faseVenta(String prod, double precio) {
		if (producto || cambol) {
			lblInfo.setText("Vacie la bandeja antes de hacer un nuevo pedido");
			return false;
		} else {
			if (calcularsillega(precio)) {
				venta(precio);
				lblProductoARecoger.setText("Su " + prod);
				producto = true;
				return true;
			} else {
				lblInfo.setText("Saldo insuficiente");
				return false;
			}
		}
	}

	private void recogerRecaudacion() {
		double inicial = 50 * 0.1 + 50 * 0.2 + 20 * 0.5 + 10 + 20;
		if (ocupada) {
			lblInfo.setText("M�quina en uso, por favor, espere a que se libere");
		} else {
			recaudacion = c010 * 0.1 + c020 * 0.2 + c050 * 0.5 + c1 + c2 * 2;
			recaudacion = recaudacion - inicial;
			recaudacion = Math.floor(recaudacion * 100);
			recaudacion = recaudacion / 100;
			lblInfo.setText("Retirados " + recaudacion + "�");
			lblCantidad010.setText(c010 + "");
			lblCantidad020.setText(c020 + "");
			lblCantidad050.setText(c050 + "");
			lblCantidad1.setText(c1 + "");
			lblCantidad2.setText(c2 + "");
		}
	}

	private void venta(double precio) {
		saldo = saldo - precio;
		calcularCambio();
	}

	private boolean calcularsillega(double precio) {
		if (saldo >= precio) {
			System.out.println("llega");
			return true;
		} else
			System.out.println("no llega");
		return false;
	}
}
