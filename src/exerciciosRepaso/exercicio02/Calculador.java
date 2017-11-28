package exerciciosRepaso.exercicio02;

public abstract class Calculador {
	
	

	public static float calcularNumeros(int option, float num1, float num2, float num3, float num4) {
		switch (option) {
		case 1:
			return num1 + num2 + num3 + num4;

		case 2:
			return num1 - num2 - num3 - num4;

		case 3:
			return num1 * num2 * num3 * num4;

		case 4:
			return num1 / num2 / num3 / num4;

		default:
			return 0;
		}

	}
}
