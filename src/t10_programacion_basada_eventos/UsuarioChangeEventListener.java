package t10_programacion_basada_eventos;
/*
 * Enumera os eventos que pode lanzar o usuario
 */
import java.util.EventListener;

// nome por convención
public interface UsuarioChangeEventListener extends EventListener {
	// nome por consenso
	public abstract void onMenoriaIdade(UsuarioChangeEvent evento);
	public abstract void onMaioriaIdade(UsuarioChangeEvent evento);
	
}
