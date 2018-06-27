package cartasConcretas;

import alGoOh.Campo;
import alGoOh.Jugador;
import cartas.CartaMagica;
import efectos.EfectoFisura;

public class Fisura extends CartaMagica{

	public Fisura() {
		this.efecto= new EfectoFisura();
	}
	
	public void aplicarEfecto(Campo campo, Campo campoEnemigo, Jugador activo, Jugador oponente) {
		
		this.efecto.aplicarEfectoSobreCampoOponente(campoEnemigo);
		this.campo.eliminarCarta(this);
	}
}
