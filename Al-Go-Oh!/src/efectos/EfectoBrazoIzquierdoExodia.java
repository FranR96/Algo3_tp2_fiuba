package efectos;

import cartasConcretas.ExodiaCompleto;

public class EfectoBrazoIzquierdoExodia extends Efecto {

	@Override
	public void aplicarEfectoExodia(ExodiaCompleto exodia) {
		exodia.brazoIzquierdo();
	}
}
