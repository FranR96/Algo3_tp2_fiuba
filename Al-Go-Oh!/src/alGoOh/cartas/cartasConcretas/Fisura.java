package alGoOh.cartas.cartasConcretas;

import alGoOh.cartas.LogicaCartas.CartaMagica;
import alGoOh.componentes.Campo;
import alGoOh.componentes.Jugador;
import alGoOh.efectos.EfectoFisura;

public class Fisura extends CartaMagica{

	public Fisura() {
		this.efecto= new EfectoFisura();
	}
	
	public void aplicarEfecto(Campo campo, Campo campoEnemigo, Jugador activo, Jugador oponente) {
		
		this.efecto.aplicarEfectoSobreCampoOponente(campoEnemigo);
		this.campo.eliminarCarta(this);
	}
}
