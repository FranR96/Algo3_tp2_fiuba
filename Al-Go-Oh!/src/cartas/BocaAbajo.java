package cartas;

import alGoOh.Campo;
import alGoOh.Jugador;

public class BocaAbajo implements LadoCarta {

	private Carta carta;

	@Override
	public void setCarta(Carta carta) {
		this.carta=carta;
	}

	@Override
	public void invocar(Campo campo, Campo campoEnemigo, Jugador activo, Jugador oponente) {

	}

	@Override
	public boolean estaBocaAbajo() {
		return true;
	}
}
