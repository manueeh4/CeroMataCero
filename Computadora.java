package juego;

public class Computadora {
	
	private Tablero tablero;
	private int tipo;
	private Jugador jugador;
	
	public Computadora(Tablero t, Jugador j) {
		tablero = t;
		jugador = j;
	}
	
	public void setTipo (int tipo) {
		this.tipo = tipo;
	}
	
	public int getTipo () {
		return tipo;
	}
	
	public void jugar () {
		int posicion = seleccionarPosicion();
		System.out.println("La computadora ha jugado:" + posicion);
		tablero.jugar(tipo, posicion);
		Juego.turno++;
	}

	// Pone una ficha en una determinada posición aleatoriamente.
	public int seleccionarPosicion () {
		
		if (Juego.turno == 3) {
			double numeroAleatorio = Math.random() * 8;
			return (int) numeroAleatorio;
		}
		
		if (posicionGanadora(tipo) != 10) {
				return posicionGanadora(tipo);
			}
			
		else if (posicionGanadora(jugador.getTipo()) != 10) {
				return posicionGanadora(jugador.getTipo());
			}
			
		else if (continuarSecuencia() != 10) {
				return continuarSecuencia();
			}
		
		double numeroAleatorio;
		int posicionAleatoria;
		
		while (true) {
			
			numeroAleatorio = Math.random() * 8;
			posicionAleatoria = (int) numeroAleatorio;
			
			if (posicionGanadora(tipo) != 10) {
				return posicionGanadora(tipo);
			}
			
			else if (tablero.getTipo(posicionAleatoria) == 0) {
				break;
			}
			
		}
		
		return posicionAleatoria;
		
	}
	
	int posicionGanadora (int tipo) {
		
		int[][] lineas = {{0, 3, 6}, {1, 4, 7}, {2, 5, 8}, {0, 1, 2}, {3, 4, 5}, {6, 7, 8}, {0, 4, 8}, {2, 4, 6}};
		int posicionGanadora;
		
		for (int i = 0; i < lineas.length;i++) {
			
			int[] linea = lineas[i];
			
			boolean casillaVacia = tablero.getTipo(linea[0]) == 0 || tablero.getTipo(linea[1]) == 0 || tablero.getTipo(linea[2]) == 0;
			boolean movimientoGanador = (tablero.getTipo(linea[0]) == tipo && tablero.getTipo(linea[1]) == tipo) || 
					(tablero.getTipo(linea[1]) == tipo && tablero.getTipo(linea[2]) == tipo) || 
						(tablero.getTipo(linea[0]) == tipo && tablero.getTipo(linea[2]) == tipo);
			
			if (casillaVacia && movimientoGanador) {
				
				if (tablero.getTipo(linea[0]) == 0)
					return linea[0];
				else if (tablero.getTipo(linea[1]) == 0)
					return linea[1];
				else if (tablero.getTipo(linea[2]) == 0);
					return linea[2];

			}
			
		}
		
		// Al retornar el número 10 indica que no se ha encontrado una posicionGanadora.
		return 10;
		
	}
	
	public int continuarSecuencia () {
		
		int[][] lineas = {{0,3,8}, {1, 4, 7}, {2, 5, 8}, {0, 1, 2}, {3, 4, 5}, {6, 7, 8}, {0, 4, 8}, {2, 4, 6}};
		
		for (int i = 0; i < lineas.length;i++) {
			
			int[] linea = lineas[i];
			boolean casillasVacias = (tablero.getTipo(linea[0]) == 0 && tablero.getTipo(linea[1]) == 0) || 
					(tablero.getTipo(linea[1]) == 0 && tablero.getTipo(linea[2]) == 0) || 
						(tablero.getTipo(linea[0]) == 0 && tablero.getTipo(linea[2]) == 0);
			
			boolean fichasComputadora = tablero.getTipo(linea[0]) == tipo || tablero.getTipo(linea[2]) == tipo || 
					tablero.getTipo(linea[2]) == tipo;
			
			boolean posicionCeroLineaVacia = tablero.getTipo(linea[0]) == 0;
			boolean posicionUnoLineaVacia = tablero.getTipo(linea[1]) == 0;
			boolean posicionDosLineaVacia = tablero.getTipo(linea[2]) == 0;
			
			// Estos números se utilizan para seleccionar alguna de las posiciones vacías, 0 y 1, 0 y 2, 0 1 y 2.
			double numeroAleatorio = Math.random() * 1;
			int posicionAleatoria = (int) numeroAleatorio;
			
			if (posicionCeroLineaVacia && posicionUnoLineaVacia) {
				
				if (posicionAleatoria == 0) {
					return linea[0];
				}
				
				else {
					return linea[1];
				}
				
			}
			
			else if (posicionUnoLineaVacia && posicionDosLineaVacia) {
				
				if (posicionAleatoria == 0) {
					return linea[1];
				}
				
				else if (posicionAleatoria == 1) {
					return linea[2];
				}
				
			}
			
			else if (posicionCeroLineaVacia && posicionDosLineaVacia) {
				
				if (posicionAleatoria == 0) {
					return linea[0];
				}
				
				else if (posicionAleatoria == 1) {
					return linea[2];
				}
			}
		}
		
		return 10;
	}
	
}
