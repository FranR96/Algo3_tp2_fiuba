package cartas;

import alGoOh.Campo;
import alGoOh.Jugador;
import efectos.Efecto;

public abstract class Carta {
	
	protected LadoCarta lado;
	protected Campo campo;
	protected Efecto efecto;
	protected Campo campoEnemigo;
	protected Jugador oponente;

	public Campo getCampoEnemigo() {
		return campoEnemigo;
	}


	public void aplicarEfecto(Campo campo, Campo campoEnemigo, Jugador activo, Jugador oponente){
		
	}

	public void voltear() {
		BocaArriba lado = new BocaArriba();
		lado.setCarta(this);
	}
	
	public Efecto getEfecto() {
		return efecto;
	}
	
	public boolean estaBocaAbajo(){
		return lado instanceof BocaAbajo;
	}

	public Campo getCampo() {
		return campo;
	}
}
