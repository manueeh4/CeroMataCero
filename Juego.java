package juego;

import java.util.Scanner;

public class Juego {
	
	public static int turno = 2;
	public static int ganador;
	
	public static void main(String[] args) {
		System.out.println("Cero mata cero");
		
		Tablero tablero = new Tablero();
		Jugador jugador = new Jugador(tablero);
		Computadora computadora = new Computadora(tablero, jugador);
		
		// Verifica que se han seleccionado los tipos de fichas adecuadamente.
		boolean partidaEmpezada = false;
		while (partidaEmpezada == false) {
			
			// Esta parte se encarga de darle el tipo de ficha que el jugador desea.
			Scanner s = new Scanner(System.in);
			System.out.println("Inserta el tipo el tipo de ficha que deseas O = 1 y X = 2");
			int tipoJugador = s.nextInt();
			jugador.setTipo(tipoJugador);
			
			if (tipoJugador == 1) {
				computadora.setTipo(2);
				partidaEmpezada = true;
			}
			
			else if (tipoJugador == 2) {
				computadora.setTipo(1);
				partidaEmpezada = true;
			}
			
			else {
				System.out.println("No has insertado un número válido");
			}
			
		}
		
		// Aquí es donde se desarrolla el juego.
		while (partidaAcabada(tablero) == false) {
			
			if (turno % 2 == 0) {
				
				Scanner s = new Scanner(System.in);
				System.out.println("Inserta la ficha que desees:");
				int posicion = s.nextInt();
				jugador.jugar(posicion);
			}
			
			else {
				computadora.jugar();
				System.out.println();
			}

		}
		
		if (ganador == 0) {
			System.out.println("Ambos jugadores han empatado.");
		}
		else if (ganador == 1) {
			System.out.println("O ha ganado la partida");
		}
		
		else if (ganador == 2){
			System.out.println("X ha ganado la partida");
		}
		
		
	}
	
	public static boolean partidaAcabada (Tablero t) {
		
		// Estas son las posibles combinaciones en la cual círculo podría resultar ganador.
		boolean circuloGanaColumna1 = t.getTipo(0) == 1 && t.getTipo(3) == 1 && t.getTipo(6) == 1;
		boolean circuloGanaColumna2 = t.getTipo(1) == 1 && t.getTipo(4) == 1 && t.getTipo(7) == 1;
		boolean circuloGanaColumna3 = t.getTipo(2) == 1 && t.getTipo(5) == 1 && t.getTipo(8) == 1;
		
		boolean circuloGanaFila1 =  t.getTipo(0) == 1 && t.getTipo(1) == 1 && t.getTipo(2) == 1;
		boolean circuloGanaFila2 =  t.getTipo(3) == 1 && t.getTipo(4) == 1 && t.getTipo(5) == 1;
		boolean circuloGanaFila3 =  t.getTipo(6) == 1 && t.getTipo(7) == 1 && t.getTipo(8) == 1;
		
		boolean circuloGanaDiagonal1 = t.getTipo(0) == 1 && t.getTipo(4) == 1 && t.getTipo(8) == 1;
		boolean circuloGanaDiagonal2 = t.getTipo(2) == 1 && t.getTipo(4) == 1 && t.getTipo(6) == 1;
		
		// Estas son las posibles combinaciones en la cual equis podría resultar ganador.
		boolean equisGanaColumna1 = t.getTipo(0) == 2 && t.getTipo(3) == 2 && t.getTipo(6) == 2;
		boolean equisGanaColumna2 = t.getTipo(1) == 2 && t.getTipo(4) == 2 && t.getTipo(7) == 2;
		boolean equisGanaColumna3 = t.getTipo(2) == 2 && t.getTipo(5) == 2 && t.getTipo(8) == 2;
		
		boolean equisGanaFila1 =  t.getTipo(0) == 2 && t.getTipo(1) == 2 && t.getTipo(2) == 2;
		boolean equisGanaFila2 =  t.getTipo(3) == 2 && t.getTipo(4) == 2 && t.getTipo(5) == 2;
		boolean equisGanaFila3 =  t.getTipo(6) == 2 && t.getTipo(7) == 2 && t.getTipo(8) == 2;
		
		boolean equisGanaDiagonal1 = t.getTipo(0) == 2 && t.getTipo(4) == 2 && t.getTipo(8) == 2;
		boolean equisGanaDiagonal2 = t.getTipo(2) == 2 && t.getTipo(4) == 2 && t.getTipo(6) == 2;
		
		// Esta variable indica que círculo ha ganado la partida.
		boolean circuloGana = circuloGanaColumna1 || circuloGanaColumna2 || circuloGanaColumna3 ||
				circuloGanaFila1 || circuloGanaFila2 || circuloGanaFila3 || circuloGanaDiagonal1|| circuloGanaDiagonal2;
		
		boolean equisGana = equisGanaColumna1 || equisGanaColumna2 || equisGanaColumna3 ||
				equisGanaFila1 || equisGanaFila2 || equisGanaFila3 || equisGanaDiagonal1|| equisGanaDiagonal2;
		
		// Esta variable se activa cuando el tablero está lleno y no hay ganador, osea; hay empate.
		boolean empate = t.getTipo(0) != 0 && t.getTipo(1) != 0 && t.getTipo(2) != 0 && t.getTipo(3) != 0
				&& t.getTipo(4) != 0 && t.getTipo(5) != 0 && t.getTipo(6) != 0 && t.getTipo(7) != 0 && t.getTipo(8) != 0;
		
		if (circuloGana) {
			ganador = 1;
			return true;
		}
		
		else if (equisGana) {
			ganador = 2;
			return true;
		}
		
		else if (empate) {
			ganador = 0;
			return true;
		}
		
		else {
			return false;
		}
		
	}
	
}
