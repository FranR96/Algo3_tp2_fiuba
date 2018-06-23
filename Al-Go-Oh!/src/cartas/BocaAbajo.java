package cartas;

import alGoOh.Campo;
import alGoOh.Jugador;

public class BocaAbajo implements LadoCarta {

	private Carta carta;
	private Campo campoEnemigo;
	private Jugador oponente;
	
	@Override
	public void setCarta(Carta carta) {
		this.carta=carta;

	}

	@Override
	public void invocar(Campo campo, Campo campoEnemigo, Jugador activo, Jugador oponente) {
		this.campoEnemigo = campoEnemigo;
		this.oponente = oponente;
		
	}

	public Campo getCampoEnemigo() {
		return campoEnemigo;
	}
	
	public Jugador getJugadorOponente() {
		return oponente;
	}
}
