package t00_reenviadores_personalizados;

import java.awt.Color;
import java.awt.Component;
import java.util.ArrayList;
import java.util.Hashtable;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

import sun.applet.Main;

public class ComboRenderPersonalizado extends JLabel implements ListCellRenderer<String>{
	Hashtable <String, ImageIcon> iconos = null;
	

	
	public  ComboRenderPersonalizado() {
		this.iconos = new Hashtable<String, ImageIcon>();
		this.iconos.put("Perro", new ImageIcon(Principal.class.getResource("/dir/file.png")));
		this.iconos.put("Gato", new ImageIcon(Principal.class.getResource("/dir/file.png")));
		this.iconos.put("Loro", new ImageIcon(Principal.class.getResource("/dir/file.png")));
	}
	
	@Override
	public Component getListCellRendererComponent(JList<? extends String> list, String value, int index,
			boolean isSelected, boolean cellHasFocus) {
		if (isSelected) {
			setBackground(Color.PINK);
		} 
	
		if(value.equals("Gato")){
			setForeground(Color.BLUE);
		} else if (value.equals("Perro")) {
			setForeground(Color.ORANGE);
		} else if (value.equals("Loro")) {
			setForeground(Color.GREEN);
		}
		
		setIcon(this.iconos.get(value));
		
		return this;
	}

}
