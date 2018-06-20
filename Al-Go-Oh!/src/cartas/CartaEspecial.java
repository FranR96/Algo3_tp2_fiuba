package cartas;

import alGoOh.*;

public abstract class CartaEspecial extends Carta{
	
	public void invocar(LadoCarta lado,Campo campo, Campo campoEnemigo, Jugador activo, Jugador oponente) {
		this.lado=lado;
		this.campo =campo;
		this.lado.setCarta(this);
		this.lado.invocar(campo, campoEnemigo, activo, oponente);
		
	}

	public void Voltear() {
		this.lado = new BocaArriba();
		this.efecto();
		this.campo.eliminarCartaEspecial(this); // El metodo va a ser utilizado en los hijos, pero java me
        // rompe los huevos porque estoy pasandole this aca, donde el this seria algo del tipo CartaEspecial
	}

	public boolean estaBocaAbajo(){
		return lado instanceof BocaAbajo;
	}

}
