package alGoOh.efectos;

import alGoOh.cartas.cartasConcretas.ExodiaCompleto;

public class EfectoBrazoIzquierdoExodia extends Efecto {

	@Override
	public void aplicarEfectoExodia(ExodiaCompleto exodia) {
		exodia.brazoIzquierdo();
	}
}
