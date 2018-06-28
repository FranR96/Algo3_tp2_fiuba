package alGoOh.cartas.LogicaCartas;

import alGoOh.componentes.Campo;
import alGoOh.componentes.Jugador;
import alGoOh.efectos.Efecto;

public abstract class Carta {
	
	protected LadoCarta lado;
	protected Campo campo;
	protected Efecto efecto;
	protected Campo campoEnemigo;
	protected Jugador oponente;
	protected Jugador activo;
	
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
