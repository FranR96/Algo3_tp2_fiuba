package cartasConcretas;

import alGoOh.Campo;
import alGoOh.Jugador;
import cartas.CartaCampo;
import efectos.EfectoSogen;

public class Sogen extends CartaCampo {
	
	public Sogen() {
		
		this.efecto = new EfectoSogen();
	}
	
	@Override
	public void aplicarEfecto(Campo campo, Campo campoEnemigo, Jugador activo, Jugador oponente) {
		
		this.efecto.aplicarEfectoSobreCampoActivo(campo);
		this.efecto.aplicarEfectoSobreCampoOponente(campoEnemigo);
	}
}
