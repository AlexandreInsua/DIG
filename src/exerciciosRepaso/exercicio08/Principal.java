package exerciciosRepaso.exercicio08;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Principal {
	
	public static void guardarEnFichero(ArrayList frases){
		FileWriter pw = null;
		try {
			File fichero = new File("frases.txt");
			
			pw = new FileWriter(fichero);
			for(Object frase : frases){
				pw.write(frase.toString());
				pw.write("\n");
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				if(pw!=null) pw.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) {
		ArrayList frases = new ArrayList();
		Scanner lector = new Scanner(System.in);
		String frase = lector.nextLine();
		frases.add(frase);
		while( ! frase.equals("salir") ){
			frase = lector.nextLine();
			if( ! frase.equals("salir") )
				frases.add(frase);
		}
		guardarEnFichero(frases);
	}

}
