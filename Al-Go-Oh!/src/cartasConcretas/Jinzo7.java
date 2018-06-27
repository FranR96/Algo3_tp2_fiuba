package cartasConcretas;

import alGoOh.Campo;
import alGoOh.Jugador;
import cartas.CartaMonstruo;
import efectos.EfectoJinzo7;

public class Jinzo7 extends CartaMonstruo{

	public Jinzo7() {
		super(500,400,2, new EfectoJinzo7(500));
	}
	
	@Override
	public void aplicarEfecto(Campo campo, Campo campoEnemigo, Jugador activo, Jugador oponente) {
		
		this.efecto.aplicarEfectoSobreJugadorOponente(oponente);
	}

	public int resetPtsAtaque() {
		return 500;
	}
	
	public int resetPtsDefensa() {
		return 400;
	}
	
}
