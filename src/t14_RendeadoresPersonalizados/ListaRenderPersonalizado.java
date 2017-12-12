package t14_RendeadoresPersonalizados;

import java.awt.Color;
import java.awt.Component;
import java.util.Hashtable;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

public class ListaRenderPersonalizado 
				extends JLabel implements ListCellRenderer<String>{

	Hashtable<String, ImageIcon> iconos = null;
	
	public ListaRenderPersonalizado() {
		this.iconos = new Hashtable<String, ImageIcon> ();
		
		this.iconos.put("Perro", 
				new ImageIcon(Principal.class.getResource("dog.jpg")));
		this.iconos.put("Gato", 
				new ImageIcon(Principal.class.getResource("cat.jpg")));
		this.iconos.put("Loro", 
				new ImageIcon(Principal.class.getResource("parrot.png")));
	}
	@Override
	public Component getListCellRendererComponent(JList<? extends String> list, String value, int index,
			boolean isSelected, boolean cellHasFocus) {
		
		if(value.equals("Perro")) {
			setForeground(Color.ORANGE);
		}else if(value.equals("Gato")) {
			setForeground(Color.BLUE);
		}else if(value.equals("Loro")) {
			setForeground(Color.GREEN);
		}
		
		setIcon( this.iconos.get(value) );

		setText(value);
		return this;
	}
	

}
