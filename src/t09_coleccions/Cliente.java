package t09_coleccions;

public class Cliente implements Comparable {
	private int id;
	private String nombre;
	private String apellidos;
	private int edad;
	
		
	public Cliente(int id, String nombre, String apellidos, int edad) {
		super();
		this.setId(id);
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.edad = edad;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	
	@Override
	public String toString() {
		return nombre + " " + apellidos;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@Override
	public int compareTo(Object arg0) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	
	
}

