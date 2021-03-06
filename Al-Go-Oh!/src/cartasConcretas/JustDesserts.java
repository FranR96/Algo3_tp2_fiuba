package cartasConcretas;

import cartas.CartaTrampa;
import alGoOh.Campo;
import alGoOh.Jugador;
import alGoOh.efectos.EfectoJustDesserts;

public class JustDesserts extends CartaTrampa {
	
	public JustDesserts() {
		
		this.efecto = new EfectoJustDesserts();
	}
	
	@Override
	public void aplicarEfecto(Campo campo, Campo campoEnemigo, Jugador activo, Jugador oponente) {
		
		this.efecto.aplicarEfectoSobreJugadorOponente(oponente);
	}

}
