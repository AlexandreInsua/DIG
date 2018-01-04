package exerciciosRepaso.exercicio06;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Principal {

	private static String leerFichero(String rutaFichero){
		String textoCompleto = "";
		FileReader fr = null; 
		try {
			File fichero = new File(rutaFichero);			
			fr = new FileReader(fichero);			
			BufferedReader br = new BufferedReader(fr);
			String linea;
			while( (linea = br.readLine()) != null){
				textoCompleto = textoCompleto + linea;
			}												
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			try {
				fr.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return textoCompleto;
	}
	public static float calcularSuma(String[] textos){
		float total = 0;
		for(int i = 0;i<textos.length;i++){
			float valor = Float.parseFloat(textos[i]); 
			total = total + valor;
		}
		return total;
	}
	
	public static float calcularMedia(String[] textos){
		float suma = calcularSuma(textos);
		return suma / textos.length;		
	}
	
	public static float calcularMaximo(String[] textos){
		float elMaximo = -999999;
		for(int i = 0;i<textos.length;i++){
			float valor = Float.parseFloat(textos[i]); 
			if(valor > elMaximo)
				elMaximo = valor;
		}
		return elMaximo;
	}

	public static float calcularMinimo(String[] textos){
		float elMinimo = 999999;
		for(int i = 0;i<textos.length;i++){
			float valor = Float.parseFloat(textos[i]); 
			if(valor < elMinimo)
				elMinimo = valor;
		}
		return elMinimo;
	}
	public static void main(String[] args) {
		String contenido = leerFichero("fichero.txt");
		System.out.println(contenido);
		String[] textos = contenido.split(";");
		
		float laSuma = calcularSuma (textos);
		System.out.println("SUMA:" + laSuma);
		
		float laMedia = calcularMedia(textos);
		System.out.println("MEDIA:" + laMedia);
		
		float elMaximo = calcularMaximo(textos);
		System.out.println("MAX:" + elMaximo);
		
		float elMinimo = calcularMinimo(textos);
		System.out.println("MIN:" + elMinimo);
	}

}
