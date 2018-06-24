package cartasConcretas;

import alGoOh.Campo;
import alGoOh.Jugador;
import cartas.CartaTrampa;
import efectos.EfectoReinforcements;

public class Reinforcements extends CartaTrampa {
	
	public Reinforcements() {
		
		this.efecto = new EfectoReinforcements();
	}
	
	@Override
	public void aplicarEfecto(Campo campo, Campo campoEnemigo, Jugador activo, Jugador oponente) {
		
		this.efecto.aplicarEfectoSobreCampoActivo(campoEnemigo);
	}

}
