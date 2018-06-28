package alGoOh.efectos;

import alGoOh.cartas.cartasConcretas.ExodiaCompleto;

public class EfectoCabezaDeExodia extends Efecto {

	@Override
	public void aplicarEfectoExodia(ExodiaCompleto exodia) {
		exodia.cabeza();
	}
}
