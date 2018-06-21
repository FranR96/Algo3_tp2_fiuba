package cartasConcretas;

import alGoOh.*;
import cartas.CartaTrampa;
import efectos.EfectoJustDesserts;

public class JustDesserts extends CartaTrampa {
	
	public JustDesserts() {
		
		this.efecto = new EfectoJustDesserts();
	}
	
	@Override
	public void aplicarEfecto(Campo campo, Campo campoEnemigo, Jugador activo, Jugador oponente) {
		
		this.efecto.aplicarEfectoSobreJugadorOponente(oponente);
		this.campo.eliminarCartaEspecial(this);
	}

}
