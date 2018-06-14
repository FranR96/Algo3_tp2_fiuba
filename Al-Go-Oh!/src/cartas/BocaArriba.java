package cartas;

import alGoOh.Campo;

public class BocaArriba implements LadoCarta {

	private Carta carta;
	
	public void setCarta(Carta carta) {
		this.carta=carta;
	}
	public void invocar(Campo campo) {
		this.carta.efecto();
	}
}
