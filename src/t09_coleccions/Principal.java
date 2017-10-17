package t09_coleccions;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.TreeSet;

public class Principal {

	Cliente c1 = new Cliente(10, "Pepe", "Dieguez", 38);
	Cliente c2 = new Cliente(20, "Jesus", "Perez", 33);
	Cliente c3 = new Cliente(40, "Bea", "Davila", 41);
	Cliente c4 = new Cliente(50, "Angel", "Gonzalez", 38);
	Cliente c5 = new Cliente(50, "Alexandre", "Vilass", 31);

	public Principal() {

		// exemploArrayList();
		//exemploHashSet();
		exemploTreeSet();
	}

	/*
	 * 
	 * Máis lento que o hashse.
	 * Usa unha estrutura en forma de árbore binaria.
	 * Almacena a información na orde  segundo un criterio dado.
	 * Os obxectos que almacena deben implementar a interface Comparable.
	 * Non poden conter elementos repetidos.
	 */
	private void exemploTreeSet() {
	TreeSet<Cliente> ts = new TreeSet<Cliente>();
	ts.add(c1);
	ts.add(c2);ts.add(c3);ts.add(c4);ts.add(c5);
	
	ts.forEach((a)-> {System.out.println(a);});
	}

	
	/*
	 * A máis rápida de todas as coleccións, pero non garante a orde de insercion de elementos.
	 * Usa como medio de almacenaxe táboas hash.
	 * nono permite inserir elementos repetidos.
	 * É moi importante definir o tamaño que vai ter (ou aprox.)
	 */
	private void exemploHashSet() {
		HashSet<Cliente> hs = new HashSet<Cliente>(4);
		hs.add(c1);
		hs.add(c2);
		hs.add(c3);
		hs.add(c4);	hs.add(c4);	hs.add(c4);	hs.add(c4);
		System.out.println(hs.size()); // devolve 4
		
		hs.forEach((a)-> {System.out.println(a);});
		hs.add(c5);
		hs.forEach((a)-> {System.out.println(a);});
		
		
	}

	private void exemploArrayList() {
		/*
		 * Os elementos insírense na orde en que se meteron.
		 * Permítes inserir elementos repetidos.
		 * Lento 
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
		al.forEach((c)->{System.out.println(c);});
		
		// simplificación
		al.forEach(System.out::println);
		
	}

	public static void main(String[] args) {
		new Principal();

	}

}
