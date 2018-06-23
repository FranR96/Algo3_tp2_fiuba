package cartasConcretas;

import alGoOh.Campo;
import alGoOh.Jugador;
import cartas.CartaTrampa;
import efectos.EfectoFisura;

public class Fisura extends CartaTrampa{

	public Fisura() {
		this.efecto= new EfectoFisura();
	}
	
	public void aplicarEfecto(Campo campo, Campo campoEnemigo, Jugador activo, Jugador oponente) {
		
		this.efecto.aplicarEfectoSobreCampoOponente(campoEnemigo);
	}
}
