package cartas;

import alGoOh.Campo;

public abstract class Carta {
	
	protected LadoCarta lado;
	protected Campo campo;
	
	public abstract void efecto();
}
