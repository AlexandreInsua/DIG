package teoria20EventosPersonalizadosUsuario;

import java.util.EventObject;

public class UsuarioChangeEvent extends EventObject{
	Usuario user;
	boolean esMayorEdad;
	
	public UsuarioChangeEvent(Object source, Usuario user, boolean esMayorEdad) {
		super(source);
		this.user = user;
		this.esMayorEdad = esMayorEdad;
		
	}
	
	
	

}
