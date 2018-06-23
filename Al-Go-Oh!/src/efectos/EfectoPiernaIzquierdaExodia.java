package efectos;

import cartasConcretas.ExodiaCompleto;

public class EfectoPiernaIzquierdaExodia extends Efecto {

	@Override
	public void aplicarEfectoExodia(ExodiaCompleto exodia) {
		exodia.piernaIzquierda();
	}
}
