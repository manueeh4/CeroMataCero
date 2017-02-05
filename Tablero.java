package juego;

// Esta clase se encarga del tablero del juego. El tipo uno es círculo y el tipo dos es equis.
public class Tablero {
	
	/* Aquí están cada una de las nueve posiciones del tablero, 0 es cuando la casilla está
	*  vacía, 1 cuando tiene un círculo y 2 cuando tiene una equis. Todas las casillas se iniciaizan en 0;
	*/
	
	private int[] tablero = new int[9];
	
	// Este método se encarga de poner una ficha en alguna posición del tablero, las fichas pueden ser O u X.
	public void jugar(int tipo, int posicion) {
		if (posicion < 9 && posicion > -1 && (tipo == 1 || tipo == 2)) {
			tablero[posicion] = tipo;
		}
	}
	
	// Este método se encarga de darte el tipo de ficha que hay en una posición determinada del tablero O = 1 y X = 2.
	public int getTipo (int posicion) throws IndexOutOfBoundsException {
		return tablero[posicion];
	}
	
}
