/**
 * 
 */
/**
 * @author 2º DAM
 *
 */
package t10_programacion_basada_eventos;

/*
 * Para que o usuario poida lanzar enventos  hai que crear as dúas clases.
 */
import java.util.ArrayList;

public class Usuario {

	private String nome;
	private int idade;

	// creamos a lista de escoitadores
	ArrayList<UsuarioChangeEventListener> listeners = new ArrayList<UsuarioChangeEventListener>();

	public void addEventListener(UsuarioChangeEventListener listener) {
		listeners.add(listener);
	}

	public Usuario() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Usuario(String nome, int idade) {

		this.nome = nome;
		this.idade = idade;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getIdade() {
		return idade;

	}

	public void setIdade(int idade) {
		this.idade = idade;
		// modificamos se é maior de idade
		if (idade >= 18) {
			// envia o envento
			for (UsuarioChangeEventListener li : listeners) {
				UsuarioChangeEvent evento = new UsuarioChangeEvent(this, this, true);
				li.onMaioriaIdade(evento);
			}
		} else {
			for (UsuarioChangeEventListener li : listeners) {
				UsuarioChangeEvent evento = new UsuarioChangeEvent(this, this, false);
				li.onMenoriaIdade(evento);
			}
		}
	}

	public void IncrementarIdade() {
		setIdade(idade + 1);
	}

}