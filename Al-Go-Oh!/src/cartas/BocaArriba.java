package cartas;

import alGoOh.Campo;
import alGoOh.Jugador;

public class BocaArriba implements LadoCarta {

	private Carta carta;
	
	public void setCarta(Carta carta) {
	    this.carta=carta;
	}

	public void invocar(Campo campo, Campo campoEnemigo, Jugador activo, Jugador oponente) {
		this.carta.aplicarEfecto(campo, campoEnemigo, activo, oponente);
	}
}
