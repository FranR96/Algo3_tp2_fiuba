package cartas;

import alGoOh.Campo;
import alGoOh.Jugador;

public abstract class CartaEspecial extends Carta{

	public void invocar(LadoCarta lado, Campo campo, Campo campoEnemigo, Jugador activo, Jugador oponente) {
		this.lado=lado;
		this.campo =campo;
		this.campoEnemigo = campoEnemigo;
		this.oponente = oponente;
		this.activo = activo;
		this.lado.setCarta(this);
		this.lado.invocar(campo, campoEnemigo, activo, oponente);
	}

}
