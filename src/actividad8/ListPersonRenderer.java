package actividad8;

import java.awt.Color;
import java.awt.Component;
import java.util.Hashtable;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

import exerciciosCasa08.Main;
import exerciciosCasa08.Person;

public class ListPersonRenderer extends JLabel implements ListCellRenderer<Person> {
	
	private static final long serialVersionUID = 1L;
	Hashtable<Object, ImageIcon> icons = null;

	public ListPersonRenderer() {
		this.icons = new Hashtable<Object, ImageIcon>();
		this.icons.put("Hombre", new ImageIcon(Main.class.getResource("male.png")));
		this.icons.put("Mujer", new ImageIcon(Main.class.getResource("female.png")));
	}

	public Component getListCellRendererComponent(JList<? extends Person> list, Person value, int index, boolean isSelected,
			boolean cellHasFocus) {
		
		Person person = value;
		
		if (person.getSex().equals("Hombre")) {
			setForeground(Color.blue);
			setIcon((Icon) this.icons.get("Hombre"));
			setText(person.getName());
		} else {
			setForeground(Color.pink);
			setIcon((Icon) this.icons.get("Mujer"));
			setText(person.getName());
		}
		
		if (isSelected) {
			setBackground(list.getSelectionBackground());
		} else {
			setBackground(list.getBackground());
		}
		
		setEnabled(list.isEnabled());
		setOpaque(true);

		return this;
	}
}