package cartas;

import alGoOh.*;

public abstract class CartaEspecial extends Carta{
	
	public void invocar(LadoCarta lado,Campo campo, Campo campoEnemigo, Jugador activo, Jugador oponente) {
		this.lado=lado;
		this.campo =campo;
		this.lado.setCarta(this);
		this.lado.invocar(campo, campoEnemigo, activo, oponente);
	}

	public boolean estaBocaAbajo(){
		return lado instanceof BocaAbajo;
	}

}
