package exerciciosCasa04;

public class Participante {
	
	String nombre;
	boolean ocupado;
	String regalarA;

	public Participante() {
		ocupado = false;
	}

	public Participante(final String nombre, final boolean ocupado) {
		super();
		this.nombre = nombre;
		this.ocupado = ocupado;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(final String nombre) {
		this.nombre = nombre;
	}

	public boolean isOcupado() {
		return ocupado;
	}

	public void setOcupado(final boolean ocupado) {
		this.ocupado = ocupado;
	}
	
	public String getRegalarA() {
		return regalarA;
	}

	public void setRegalarA(final String regalarA) {
		this.regalarA = regalarA;
	}

	@Override
	public String toString() {
		return nombre;
	}
	
	

}
