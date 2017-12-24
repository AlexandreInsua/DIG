package t09_comunicacionFormularios_ViaxeMarte;


import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Font;
import java.awt.Color;
import java.awt.Insets;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Informe extends JDialog {

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
