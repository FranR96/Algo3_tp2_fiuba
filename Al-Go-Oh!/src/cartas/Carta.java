package cartas;

import alGoOh.Campo;
import alGoOh.Jugador;

public abstract class Carta {
	
	protected LadoCarta lado;
	protected Campo campo;
	protected Efecto efecto;

	public void aplicarEfecto(Campo campo, Campo campoEnemigo, Jugador activo, Jugador oponente){
	}
}
