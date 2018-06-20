package alGoOh;

public class Juego {
	
	private Jugador jugadorActivo;
	private Jugador oponente;
	private Tablero tablero;

	public void sortearInicio(Tablero tablero, Jugador jugador1, Jugador jugador2) {
		this.tablero = tablero;
		Seleccionador seleccionador = new Seleccionador();
		jugadorActivo = seleccionador.elegirEntre(jugador1,jugador2);
		
		if(jugadorActivo == jugador1) {
			oponente=jugador2;
		}
		else {
			oponente = jugador1;
		}
		
		jugadorActivo.obtenerManoInicial();
		oponente.obtenerManoInicial();
	
	}
	
	
	

}
