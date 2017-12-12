package t11_coleccions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.TreeMap;
import java.util.TreeSet;

public class Principal {

	Cliente c1 = new Cliente(10, "Pepe", "Dieguez", 38);
	Cliente c2 = new Cliente(20, "Jesus", "Perez", 33);
	Cliente c3 = new Cliente(40, "Bea", "Davila", 41);
	Cliente c4 = new Cliente(50, "Angel", "Gonzalez", 38);
	Cliente c5 = new Cliente(50, "Alexandre", "Vilass", 31);

	public Principal() {

		// exemploArrayList(); // # en python lista[] ou tupla ()
		// exemploHashSet(); // # en python set() {}
		// exemploTreeSet();
		// exemploHassMap(); //# en python dicionario {:}

	}

	// almacena os elementos en fomra de clave valor
	// na orde que se lle indique
	// necesita que os valore implemente a interface Comparable
	// é máis lento que o HashMap
	// garda os datos en forma de árbore binario
	private void exemploTreeMap() {
		TreeMap<Float, Cliente> tm = new TreeMap<Float, Cliente>();
		tm.put(11.3f, c1);
		tm.put(12.3f, c2);
		tm.put(19.1f, c3);
		tm.put(21.6f, c4);
	}

	/*
	 * 
	 * Máis lento que o hashse. Usa unha estrutura en forma de árbore binaria.
	 * Almacena a información na orde segundo un criterio dado. Os obxectos que
	 * almacena deben implementar a interface Comparable. Non poden conter
	 * elementos repetidos.
	 */
	private void exemploTreeSet() {
		TreeSet<Cliente> ts = new TreeSet<Cliente>();
		ts.add(c1);
		ts.add(c2);
		ts.add(c3);
		ts.add(c4);
		ts.add(c5);

		for (Cliente c : ts) {
			System.out.println(c);
		}
		ts.forEach((a) -> {
			System.out.println(a);
		});

		ts.size(); // tamaño
		ts.contains(c4); // true
		ts.clear(); // borra todo o contido
		Cliente primeiro = ts.first(); // devolve o primiero
		Cliente ultimo = ts.last(); // devolve o último
		ts.remove(c2); // elimina o obxecto
	}

	// Almacena os elementos en forma de clave-valor
	// de entre todos os tipos map é o que mellor rendemeto ten
	// no se garantiza a orde de inserción dos elementos
	// usa unha táboa hash para almacenar a información
	// é importante indicar o tamaño dos datos cando se crea o hashmap
	private void ejemploHashMap() {
		HashMap<Integer, Cliente> hm = new HashMap<Integer, Cliente>();
		hm.put(7, c1);
		hm.put(9, c2);
		hm.put(14, c3);
		hm.put(21, c4);

		// recorrer as claves
		for (Integer clave : hm.keySet()) {
			System.out.println(clave); // 7 9 14 21
		}

		// recorrer os valores
		for (Cliente valor : hm.values()) {
			System.out.println(valor); // c1, c2, c3, c4
		}

		// recorremos as claves e os valores á vez
		hm.forEach((k, v) -> System.out.println(k + "-" + v));

		// buscar algo por clave
		hm.get(14); // dáme o cliente con clave 14, é dicir o c3
	}

	/*
	 * A máis rápida de todas as coleccións, pero non garante a orde de
	 * insercion de elementos. Usa como medio de almacenaxe táboas hash. nono
	 * permite inserir elementos repetidos. É moi importante definir o tamaño
	 * que vai ter (ou aprox.)
	 */
	private void exemploHashSet() {
		HashSet<Cliente> hs = new HashSet<Cliente>(4);
		hs.add(c1);
		hs.add(c2);
		hs.add(c3);
		hs.add(c4);
		hs.add(c4);
		hs.add(c4);
		hs.add(c4);
		System.out.println(hs.size()); // devolve 4

		hs.forEach((a) -> {
			System.out.println(a);
		});

		for (Cliente c : hs) {
			System.out.println(c);
		}
		hs.add(c5);
		hs.forEach((a) -> {
			System.out.println(a);
		});

	}

	private void exemploArrayList() {
		/*
		 * Os elementos insírense na orde en que se meteron. Permítes inserir
		 * elementos repetidos. Lento
		 */
		ArrayList<Cliente> al = new ArrayList<Cliente>();
		al.add(c1);
		al.add(c2);
		al.add(c3);
		al.add(c4);
		// lonxitude
		int tamanho = al.size();

		// método funcional pero ineficiente
		System.out.println("For tradicional");
		for (int i = 0; i < tamanho; i++) {
			System.out.println(al.get(i));
		}

		// for each
		System.out.println("\nFor each");
		for (Cliente c : al) {
			System.out.println(c);
		}

		// iterator
		System.out.println("\nCon iterador");
		Iterator<Cliente> it = al.iterator();
		while (it.hasNext()) {
			Cliente c = it.next();
			System.out.println(c);
		}

		// con función lambda
		// método que se chama tanta veces como elementos hai no arraylist
		System.out.println("\nCunha función lambda.");
		// Método - obxecto - sentenzas
		al.forEach((c) -> {
			System.out.println(c);
		});

		// simplificación
		al.forEach(System.out::println);

	}

	public static void main(String[] args) {
		new Principal();

	}

}
