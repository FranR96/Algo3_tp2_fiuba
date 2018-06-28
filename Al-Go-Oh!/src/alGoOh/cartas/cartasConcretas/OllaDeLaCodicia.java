package alGoOh.cartas.cartasConcretas;

import alGoOh.cartas.LogicaCartas.CartaMagica;
import alGoOh.componentes.Campo;
import alGoOh.componentes.Jugador;
import alGoOh.efectos.EfectoOllaDeLaCodicia;

public class OllaDeLaCodicia extends CartaMagica {

	public OllaDeLaCodicia() {
		
		this.efecto = new EfectoOllaDeLaCodicia();
	}
	
	@Override
	public void aplicarEfecto(Campo campo, Campo campoEnemigo, Jugador activo, Jugador oponente){
		
		this.efecto.aplicarEfectoSobreJugadorActivo(activo);
		this.campo.eliminarCarta(this);
		
	}
}
