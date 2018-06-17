package cartas;

import alGoOh.*;

public abstract class CartaEspecial extends Carta{
	
	public void invocar(LadoCarta lado,Campo campo) {
		this.lado=lado;
		this.campo =campo;
		this.lado.setCarta(this);
		this.lado.invocar();
		
	}

	public boolean estaBocaAbajo(){
		return lado instanceof BocaAbajo;
	}

}
