package alGoOh.cartas.LogicaCartas;

import alGoOh.componentes.Campo;
import alGoOh.componentes.Jugador;

public class BocaArriba implements LadoCarta {

	private Carta carta;

	public void setCarta(Carta carta) {
	    this.carta=carta;
	}

	public void invocar(Campo campo, Campo campoEnemigo, Jugador activo, Jugador oponente) {
		this.carta.aplicarEfecto(campo, campoEnemigo, activo, oponente);
	}

	@Override
	public boolean estaBocaAbajo() {
		return false;
	}
	
}
