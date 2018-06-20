package cartasConcretas;

import alGoOh.Campo;
import alGoOh.Jugador;
import cartas.CartaCampo;
import efectos.EfectoWasteland;

public class Wasteland extends CartaCampo {

	public Wasteland() {
		
		this.efecto = new EfectoWasteland();
	}
	
	@Override
	public void aplicarEfecto(Campo campo, Campo campoEnemigo, Jugador activo, Jugador oponente) {
		
		this.efecto.aplicarEfectoSobreCampoActivo(campo);
		this.efecto.aplicarEfectoSobreCampoOponente(campoEnemigo);
	}
}
