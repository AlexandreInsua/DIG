package t04_radioButton_checkBox;

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
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class Informe extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JLabel lblAdmitido;
	private JLabel lblNonPodenViaxar;

	/**
	 * Launch the application.
	 */
	// Nunca se chama ao dialogo a través deste main
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
		gbl_contentPanel.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPanel.rowHeights = new int[]{0, 0, 0, 0};
		gbl_contentPanel.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_contentPanel.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPanel.setLayout(gbl_contentPanel);
		{
			lblAdmitido = new JLabel("Admitido");
			lblAdmitido.setForeground(new Color(34, 139, 34));
			lblAdmitido.setFont(new Font("Tahoma", Font.BOLD, 14));
			GridBagConstraints gbc_lblAdmitido = new GridBagConstraints();
			gbc_lblAdmitido.insets = new Insets(0, 0, 5, 5);
			gbc_lblAdmitido.gridx = 0;
			gbc_lblAdmitido.gridy = 0;
			contentPanel.add(lblAdmitido, gbc_lblAdmitido);
		}
		{
			lblNonPodenViaxar = new JLabel("Non poden viaxar");
			GridBagConstraints gbc_lblNonPodenViaxar = new GridBagConstraints();
			gbc_lblNonPodenViaxar.insets = new Insets(0, 0, 0, 5);
			gbc_lblNonPodenViaxar.gridx = 0;
			gbc_lblNonPodenViaxar.gridy = 2;
			contentPanel.add(lblNonPodenViaxar, gbc_lblNonPodenViaxar);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton cancelButton = new JButton("Aceptar");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						// fecha a ventana auxiliar
						setVisible(false);
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
		if (permiso) {
			lblAdmitido.setText("Permiso concedido");
			lblAdmitido.setForeground(Color.green);
			
		} else {
			lblAdmitido.setText("Permiso non concedido");
			lblAdmitido.setForeground(Color.red);
		}
	}

	public JLabel getLblAdmitido() {
		return lblAdmitido;
	}
	public JLabel getLblSPodenViaxar() {
		return lblNonPodenViaxar;
	}
}
