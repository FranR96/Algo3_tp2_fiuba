package alGoOh.efectos;

import alGoOh.cartas.cartasConcretas.ExodiaCompleto;

public class EfectoPiernaIzquierdaExodia extends Efecto {

	@Override
	public void aplicarEfectoExodia(ExodiaCompleto exodia) {
		exodia.piernaIzquierda();
	}
}
