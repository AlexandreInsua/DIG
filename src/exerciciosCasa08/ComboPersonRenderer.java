package exerciciosCasa08;

import java.awt.Color;
import java.awt.Component;
import java.util.Hashtable;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

public class ComboPersonRenderer extends JLabel implements ListCellRenderer<String> {

	private static final long serialVersionUID = 1L;
	Hashtable<String, ImageIcon> icons = null;

	public ComboPersonRenderer() {
		this.icons = new Hashtable<String, ImageIcon>();
		this.icons.put("Hombre", new ImageIcon(Main.class.getResource("male.png")));
		this.icons.put("Mujer", new ImageIcon(Main.class.getResource("female.png")));
	}

	@Override
	public Component getListCellRendererComponent(JList<? extends String> list, String value, int index,
			boolean isSelected, boolean cellHasFocus) {

		if (isSelected) {
			setBackground(list.getSelectionBackground());
		} else {
			setBackground(list.getBackground());
		}

		if (value.equals("Hombre")) {
			setForeground(Color.blue);
		} else if (value.equals("Mujer")) {
			setForeground(Color.pink);
		}

		setIcon(icons.get(value));
		setText(value.toString());

		setEnabled(list.isEnabled());
		setOpaque(true);
		
		return this;
	}
}
