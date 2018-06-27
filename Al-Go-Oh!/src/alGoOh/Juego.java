package alGoOh;

public class Juego {
	
	private Jugador jugadorActivo;
	private Jugador oponente;

	public void sortearInicio(Jugador jugador1, Jugador jugador2) {
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
	
	public void faseInicial() {
		jugadorActivo.tomarCartaDelMazo();
	}
	
	public Jugador hayGanador() {
		if(jugadorActivo.completoAExodia() ||!oponente.estaVivo()) {
			return jugadorActivo;
		}
		else if( !jugadorActivo.estaVivo() || !jugadorActivo.tieneCartasEnMazo()) {
			return oponente;
		}
		else {
			return null;
		}
	}
	
	public Jugador terminarTurno() {
		Jugador ganador = this.hayGanador();
		if(ganador != null) {
			return ganador;
		}
		this.cambiarJugadores();
		return null;
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
