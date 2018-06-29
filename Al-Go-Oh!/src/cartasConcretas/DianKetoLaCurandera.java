package cartasConcretas;

import cartas.CartaMagica;
import alGoOh.Campo;
import alGoOh.Jugador;
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
