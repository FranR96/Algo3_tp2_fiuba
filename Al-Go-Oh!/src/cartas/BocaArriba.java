package cartas;

import alGoOh.Campo;
import alGoOh.Jugador;

public class BocaArriba implements LadoCarta {

	private Carta carta;
	private Campo campoEnemigo;
	private Jugador oponente;
	
	public void setCarta(Carta carta) {
	    this.carta=carta;
	}

	public void invocar(Campo campo, Campo campoEnemigo, Jugador activo, Jugador oponente) {
		this.campoEnemigo = campoEnemigo;
		this.oponente = oponente;
		this.carta.aplicarEfecto(campo, campoEnemigo, activo, oponente);
		
	}

	@Override
	public Campo getCampoEnemigo() {
		return campoEnemigo;
	}

}
