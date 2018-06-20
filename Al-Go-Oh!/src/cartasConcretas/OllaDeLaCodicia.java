package cartasConcretas;

import alGoOh.Jugador;
import alGoOh.Campo;
import cartas.CartaMagica;
import efectos.EfectoOllaDeLaCodicia;

public class OllaDeLaCodicia extends CartaMagica {

	public OllaDeLaCodicia() {
		
		this.efecto = new EfectoOllaDeLaCodicia();
	}
	
	@Override
	public void aplicarEfecto(Campo campo, Campo campoEnemigo, Jugador activo, Jugador oponente){
		
		this.efecto.aplicarEfectoSobreJugadorActivo(activo);
		this.campo.eliminarCartaEspecial(this);
		
	}
}
