package exerciciosRepaso.exercicio09;

public class Jugador {
	String nombre;
	String apellido;
	String telefono;
	
	public Jugador(String nombre, String apellido, String telefono) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.telefono = telefono;
	}

	@Override
	public String toString() {
		return  nombre + " " + apellido ;
	}	
	
	
}
