package cartasConcretas;

import cartas.CartaMagica;
import alGoOh.Campo;
import alGoOh.Jugador;
import alGoOh.efectos.EfectoFisura;

public class Fisura extends CartaMagica{

	public Fisura() {
		this.efecto= new EfectoFisura();
	}
	
	public void aplicarEfecto(Campo campo, Campo campoEnemigo, Jugador activo, Jugador oponente) {
		
		this.efecto.aplicarEfectoSobreCampoOponente(campoEnemigo);
		this.campo.eliminarCarta(this);
	}
}
