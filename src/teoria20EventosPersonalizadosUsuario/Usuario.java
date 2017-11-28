package teoria20EventosPersonalizadosUsuario;

import java.util.ArrayList;

public class Usuario {
	private String nombre;
	private int edad;
	//...
	ArrayList<UsuarioChangeEventListener> listeners = 
			new ArrayList<UsuarioChangeEventListener>();
	
	
	public void addEventListener(UsuarioChangeEventListener listener) {
		listeners.add(listener); 
	}
	
	public Usuario(String nombre, int edad) {
		super();
		this.nombre = nombre;
		this.edad = edad;
	}
	
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
		if(edad >=18) {
			for(UsuarioChangeEventListener li: listeners) {
				UsuarioChangeEvent evento = 
						new UsuarioChangeEvent(this, this, true);
				li.onMayoriaEdad(evento);
			}
		}else {
			for(UsuarioChangeEventListener li: listeners) {
				UsuarioChangeEvent evento = 
						new UsuarioChangeEvent(this, this, false);
				li.onMinoriaEdad(evento);
			}			
		}
	}
	
	public String getNombre() {
		return nombre;
	}	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	
	public void incrementarEdad() {
		setEdad(edad + 1);		
	}
	
	

}
