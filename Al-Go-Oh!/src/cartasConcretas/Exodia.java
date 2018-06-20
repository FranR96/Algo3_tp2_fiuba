package cartasConcretas;

import alGoOh.*;
import cartas.CartaMonstruo;
import efectos.EfectoNulo;

public class Exodia extends CartaMonstruo {

	public Exodia() {
		
		super(1000,1000,3, new EfectoNulo() /*new EfectoExodia())*/);
	}
	
	@Override
	public void aplicarEfecto(Campo campo, Campo campoEnemigo, Jugador activo, Jugador oponente) {
		
		
	}
}
