package cartas;

import alGoOh.*;

public class EfectoOllaDeLaCodicia extends Efecto {

	@Override
	public void aplicarEfecto(Jugador jugador) {
		
		for(int i=0; i<2; i++) {
			jugador.tomarCartaDelMazo();
			jugador.tomarCartaDelMazo();
		}
	}

	@Override
	public void aplicarEfecto(Campo campo) {}

	@Override
	public void aplicarEfecto() {}
	
}
