import java.util.Random;
import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Dígame un número entero: ");
		int puntos = 0;
		String numero = sc.nextLine();
		Integer numeroInt = Integer.parseInt(numero);
		Integer casilla;

		String[][] tabla = new String[numeroInt][numeroInt];

		Random rnd = new Random();
		for (int i = 0; i < tabla.length; i++) {
			for (int j = 0; j < tabla[i].length; j++) {
				casilla = rnd.nextInt(numeroInt + 1);
				tabla[i][j] = casilla.toString();
			}
			System.out.println();
		}

		for (int i = 0; i < tabla.length; i++) {
			for (int j = 0; j < tabla[i].length; j++) {

				System.out.print("| " + tabla[i][j] + " ");
			}
			System.out.println(" | ");
			System.out.println();
		}
		while (!comprobarTodasEquis(tabla)) {
			System.out.println("Dispara al pianista: ");
			System.out.println("Dime fila: ");
			int fila = sc.nextInt();
			System.out.println("Dime columna: ");
			int columna = sc.nextInt();
			if (tabla[fila][columna] =="X") {
				System.out.println("Antención en esa posición ya habías disparado");
				continue;
			}
			puntos += Integer.parseInt(tabla[fila][columna]);
			tabla[fila][columna] = "X";

			System.out.println("Tienes " + puntos + " puntos acumulados ");

			for (int i = 0; i < tabla.length; i++) {
				for (int j = 0; j < tabla[i].length; j++) {

					System.out.print("| " + tabla[i][j] + " ");
				}
				System.out.println(" | ");
				System.out.println();
			}
		}
		
		System.out.println("Fin de juego... has hecho: " + puntos + " puntos");

	}

	public static boolean comprobarTodasEquis(String[][] tablero) {
		for (int i = 0; i < tablero.length; i++) {
			for (int j = 0; j < tablero[i].length; j++) {

				if (tablero[i][j] != "X")
					return false;
			}
		}
		return true;
	}
}
