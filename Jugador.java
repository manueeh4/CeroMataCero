package juego;

public class Jugador {
	
	private Tablero tablero;
	private int tipo;
	
	public void setTipo (int tipo) {
		this.tipo = tipo;
	}
	
	public int getTipo () {
		return tipo;
	}
	
	public Jugador (Tablero t) {
		tablero = t;
	}
	
	public void jugar (int posicion) {
		tablero.jugar(tipo, posicion);
		Juego.turno++;
	}
	
}
