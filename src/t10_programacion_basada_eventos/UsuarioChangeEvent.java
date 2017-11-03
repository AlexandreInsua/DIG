package t10_programacion_basada_eventos;

import java.util.EventObject;

/* 
 * Isto vai mandar a informaci�n dun lugar a outro.
 * Herda de EventObject e forza crear o construtor, completatamos con 
 * 
 * Cando ocorra o evento enviar� a informaci�n de UsuarioChangeEvent � vista.
 */
public class UsuarioChangeEvent extends EventObject {

	Usuario user;
	boolean eMaiorIdade;

	public UsuarioChangeEvent(Object source, Usuario user, boolean eMaiorIdade) {
		super(source);
		this.user = user;
		this.eMaiorIdade = eMaiorIdade;

	}
}
