package alGoOh.cartas.cartasConcretas;

import alGoOh.cartas.LogicaCartas.CartaMagica;
import alGoOh.componentes.Campo;
import alGoOh.componentes.Jugador;
import alGoOh.efectos.EfectoDianKetoLaCuranderas;

public class DianKetoLaCurandera extends CartaMagica{

	public DianKetoLaCurandera() {
		this.efecto = new EfectoDianKetoLaCuranderas();
	}
	
	@Override
	public void aplicarEfecto(Campo campo, Campo campoEnemigo, Jugador activo, Jugador oponente){

	    this.efecto.aplicarEfectoSobreJugadorActivo(activo);
        this.campo.eliminarCarta(this);
	}
}
