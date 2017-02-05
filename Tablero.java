package juego;

// Esta clase se encarga del tablero del juego. El tipo uno es c�rculo y el tipo dos es equis.
public class Tablero {
	
	/* Aqu� est�n cada una de las nueve posiciones del tablero, 0 es cuando la casilla est�
	*  vac�a, 1 cuando tiene un c�rculo y 2 cuando tiene una equis. Todas las casillas se iniciaizan en 0;
	*/
	
	private int[] tablero = new int[9];
	
	// Este m�todo se encarga de poner una ficha en alguna posici�n del tablero, las fichas pueden ser O u X.
	public void jugar(int tipo, int posicion) {
		if (posicion < 9 && posicion > -1 && (tipo == 1 || tipo == 2)) {
			tablero[posicion] = tipo;
		}
	}
	
	// Este m�todo se encarga de darte el tipo de ficha que hay en una posici�n determinada del tablero O = 1 y X = 2.
	public int getTipo (int posicion) throws IndexOutOfBoundsException {
		return tablero[posicion];
	}
	
}
