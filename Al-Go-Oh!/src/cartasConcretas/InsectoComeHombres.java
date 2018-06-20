package cartasConcretas;

import alGoOh.Campo;
import alGoOh.Jugador;
import cartas.CartaMonstruo;
import efectos.EfectoInsectoComeHombres;

public class InsectoComeHombres extends CartaMonstruo {

	public InsectoComeHombres() {
		super(450,600,2, new EfectoInsectoComeHombres());
	}
	
	@Override
	public void aplicarEfecto(Campo campo, Campo campoEnemigo, Jugador activo, Jugador oponente){
		
		this.efecto.aplicarEfectoSobreCampoOponente(campoEnemigo);
	}
}
