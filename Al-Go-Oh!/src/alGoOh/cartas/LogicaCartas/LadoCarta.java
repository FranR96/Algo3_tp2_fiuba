package alGoOh.cartas.LogicaCartas;

import alGoOh.componentes.Campo;
import alGoOh.componentes.Jugador;

public interface LadoCarta {

	void setCarta(Carta carta);
	void invocar(Campo campo, Campo campoEnemigo, Jugador activo, Jugador oponente);
	boolean estaBocaAbajo();
}
