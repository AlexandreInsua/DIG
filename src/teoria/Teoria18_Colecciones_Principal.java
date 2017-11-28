package teoria;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.TreeMap;
import java.util.TreeSet;

import javax.naming.ldap.HasControls;

import org.xml.sax.HandlerBase;

public class Teoria18_Colecciones_Principal {

	Cliente c1 = new Cliente(10, "Pepe", "Dieguez", 38);
	Cliente c2 = new Cliente(50, "Bea", "Perez", 41);
	Cliente c3 = new Cliente(80, "Angel", "Gonzalez", 38);
	Cliente c4 = new Cliente(90, "Jesus", "Davila", 55);
	
	

	public Teoria18_Colecciones_Principal(){
		//ejemploArrayList();  //# en python lista[] o tupla()
		//ejemploHashSet();    //# en python a un set() {}
		//ejemploTreeSet();   
		//ejemploHashMap();     //#  en python a un diccionario {}
		ejemploTreeMap();
		// TODO LAMBDAS  Y DE LOS STREAMS
	}
	
	// almacena los elemento en forma de clave valor
	// Almacene los elementos en el orden en el que tu le digas
	// necesita que los valores(cliente) implemente la interfaz comparable
	// es más lento qeu el HashMap
	// guarda los datos en forma de arbol binario
	private void ejemploTreeMap() {
		TreeMap<Float, Cliente> tm = new TreeMap<Float, Cliente>();
		tm.put(11.3f, c1);
		tm.put(12.3f, c2);
		tm.put(19.1f, c3);
		tm.put(21.6f, c4);
	}

	//Almacena los elemntos en forma de clave-valor
	// de entre todos los tipos map es el que mejor rendimiento tiene
	// no se garantiza el orden de inserción de los elementos
	// usa una tabla hash para almacenar la información
	// es importante indicar el tamaño de los datos cuando se crea el hashmap
	private void ejemploHashMap() {
		HashMap<Integer, Cliente> hm = new HashMap<Integer, Cliente>();
		hm.put( 7 ,  c1 );
		hm.put( 9 ,  c2 );
		hm.put( 14 ,  c3 );
		hm.put( 21 ,  c4 );
		
		// recorrer las claves
		for(Integer clave: hm.keySet()) {
			System.out.println(clave);   // 7  9  14 21
		}
		
		// recorrer los valores
		for(Cliente valor: hm.values()) {
			System.out.println(valor);  // c1, c2, c3, c4
		}
		
		// recorremos las claves y lo valores a la vez
		hm.forEach( (k,v)->System.out.println(k+"-"+v)  );
		
		//buscar algo por clave
		hm.get(14); // me da el cliente con clave 14, es decir el c3 
		
	}
	/*Es más lento que el HashSet
	 * Usa una estructura en forma de arbol binario
	 * Almacen la información en el orden que tu le indiques
	 * Es obligaatorio que los objetos que almacenes en él 
	 *    implementen la interfaz Comparable
	 * No pueden contener elementos repetidos
	 * */
	private void ejemploTreeSet() {
		TreeSet<Cliente> ts =  new TreeSet<Cliente>();
		ts.add(c1);
		ts.add(c2);
		ts.add(c3);
		ts.add(c4);
		
		for(Cliente c: ts) {
			System.out.println(c);
		}
		
		ts.size(); // tamaño
		ts.contains(c4);  // true
		ts.clear(); // borra todo el treeset
		Cliente primero = ts.first(); // me da el primer cliente
		Cliente ultimo = ts.last(); // me da el ultimo cliente
		ts.remove(c2); // elimina un cliente determinado
				
	}
	/*Es el más rapido de todas las colecciones
	 * No garantiza el orden de inserción de los elementos
	 * Usa como medio de almacenamiento tablas HASH
	 * No permite insertar elementos repetidos
	 * Es muy importante definir el tamaño que va a tener
	 * 
	 * */
	private void ejemploHashSet() {
		HashSet<Cliente> hs = new HashSet<Cliente>(4);
		hs.add(c1);
		hs.add(c2);
		hs.add(c3);
		hs.add(c4);
		
		System.out.println(hs.size());
		
		for(Cliente c: hs) {
			System.out.println(c);
		}
	}
	/*Los elementos se guardan en el orden en el que los introduces
	 *Se permite insertar  elementos reptidos
	 * */
	private void ejemploArrayList() {
		ArrayList<Cliente> al = new  ArrayList<Cliente>();
		al.add(c1);
		al.add(c2);
		al.add(c3);
		al.add(c4);
		
				
		int tamanno = al.size();
		for(int i=0;i<tamanno;i++) {
			System.out.println( al.get(i) );
		}
		
		System.out.println( "--------------------------" );
		
		for(Cliente c : al) {
			System.out.println(c);
		}
		
		System.out.println( "--------------------------" );
		Iterator<Cliente> it = al.iterator();
		while(it.hasNext()) {
			Cliente c = it.next();
			System.out.println(c);
		}
		
		System.out.println( "--------------------------" );
		
		al.forEach(  (c) -> { System.out.println(c); }  );
		
		System.out.println( "--------------------------" );
		
		al.forEach( System.out::println );
	}
	

	public static void main(String[] args) {
		new Teoria18_Colecciones_Principal();

	}

}



class Cliente implements Comparable<Cliente> {
	private int id;
	private String nombre;
	private String apellidos;
	private int edad;
	
	
	
	public Cliente(int id, String nombre, String apellidos, int edad) {
		super();
		this.id = id;
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
	
	// 0 sin son iguales
	// 1 si este cliente(this) es mayor que el que se pasa como parametro
	// -1 si este cliente(this) es menor que el que se pasa como parametro
	@Override
	public int compareTo(Cliente o) {
		return this.nombre.compareTo(o.nombre);
	}
	
	
	
	
}
