package cartas;

import alGoOh.Campo;
import alGoOh.Jugador;
import efectos.Efecto;

public abstract class Carta {
	
	protected LadoCarta lado;
	protected Campo campo;
	protected Efecto efecto;

	public void aplicarEfecto(Campo campo, Campo campoEnemigo, Jugador activo, Jugador oponente){
		
	}
	public abstract void voltear();
}
