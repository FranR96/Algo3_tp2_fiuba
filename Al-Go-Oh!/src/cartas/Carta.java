package cartas;

import alGoOh.Campo;
import alGoOh.Jugador;
import alGoOh.efectos.Efecto;

public abstract class Carta {
	
	protected LadoCarta lado;
	protected Campo campo;
	protected Efecto efecto;
	Campo campoEnemigo;
	Jugador oponente;
	Jugador activo;
	
	public void aplicarEfecto(Campo campo, Campo campoEnemigo, Jugador activo, Jugador oponente){
		
	}

	public void voltear() {
		if(estaBocaAbajo()) {
			this.lado = new BocaArriba();
			lado.setCarta(this);
			lado.invocar(campo, campoEnemigo, activo, oponente);
		}
	}
	public boolean estaBocaAbajo(){
		return lado.estaBocaAbajo();
	}

	public Campo getCampo() {
		return campo;
	}

	public Efecto getEfecto() {
		return efecto;
	}

	public Campo getCampoEnemigo() {
		return campoEnemigo;
	}

}
