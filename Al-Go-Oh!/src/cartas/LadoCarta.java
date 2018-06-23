package cartas;

import alGoOh.Campo;
import alGoOh.Jugador;

public interface LadoCarta {

	void setCarta(Carta carta);
	void invocar(Campo campo, Campo campoEnemigo, Jugador activo, Jugador oponente);
	Campo getCampoEnemigo();

}
