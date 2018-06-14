package cartas;

import alGoOh.Campo;

public class BocaAbajo implements LadoCarta {

	private Carta carta;
	
	@Override
	public void setCarta(Carta carta) {
		this.carta=carta;

	}

	public void invocar(Campo campo){};
}
