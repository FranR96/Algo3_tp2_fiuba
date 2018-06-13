package cartas;

import alGoOh.*;

public abstract class CartaEspecial implements Carta{

	private LadoCarta lado;
	private Campo campo;
	
	public void invocar(LadoCarta lado) {
		this.lado=lado;
		this.lado.setCarta(this);
		this.campo=campo;
	}

	
}
