package t07_JList_Objectos_ficheros_binarios;

import java.io.Serializable;

public class Producto implements Serializable {
	private String nombre;
	private Float precio;

	public Producto(String nombre, Float precio) {
		this.nombre = nombre;
		this.precio = precio;
	}

	public String getNombre() {
		return nombre;
	}

	public Float getPrecio() {
		return precio;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setPrecio(Float precio) {
		this.precio = precio;
	}

	@Override
	public String toString() {
		return nombre + ":" + precio;
	}

}
