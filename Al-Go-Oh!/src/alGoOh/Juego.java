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
		
		//jugadorActivo.obtenerManoInicial();
		//oponente.obtenerManoInicial();
	
	}
	
	public void faseInicial() {
		jugadorActivo.tomarCartaDelMazo();
	}
	
	public Jugador hayGanador() {
		if(!jugadorActivo.estaVivo() || !jugadorActivo.tieneCartasEnMazo()) {
			return oponente;
		}
		if(!oponente.estaVivo() || !oponente.tieneCartasEnMazo()) {
			return jugadorActivo;
		}
		else {
			return null;
		}
	}
	
	public void terminarTurno() {
		this.cambiarJugadores();
	}

	private void cambiarJugadores() {
		Jugador anteriorJugadorActivo = jugadorActivo;
        jugadorActivo = oponente;
        oponente = anteriorJugadorActivo;
		
	}

	public Jugador getOponente() {
		return oponente;
	}

	public Jugador getJugadorActivo() {
		return jugadorActivo;
	}
	

}
