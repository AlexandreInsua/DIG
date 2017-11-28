package teoria20EventosPersonalizadosUsuario;
import java.util.EventListener;
public interface UsuarioChangeEventListener extends EventListener {
	public abstract void onMayoriaEdad(UsuarioChangeEvent evento);
	//public abstract void onUsuarioTipoChica();
	public abstract void onMinoriaEdad(UsuarioChangeEvent evento);
 
}
