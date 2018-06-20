package cartas;

import alGoOh.*;

public class EfectoJinzo7 extends Efecto {
	
	@Override
	public void aplicarEfecto(Campo campo) {}

	@Override
	public void aplicarEfecto(Jugador jugador) {
		
		jugador.recibirDaniosVitales(/*this.carta.getPtsAtaques()*/ 500);
	}

	@Override
	public void aplicarEfecto() {}
	
}
