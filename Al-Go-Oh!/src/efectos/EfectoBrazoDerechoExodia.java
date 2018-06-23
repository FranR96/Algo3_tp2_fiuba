package efectos;

import cartasConcretas.ExodiaCompleto;

public class EfectoBrazoDerechoExodia extends Efecto {

	@Override
	public void aplicarEfectoExodia(ExodiaCompleto exodia) {
		exodia.brazoDerecho();
	}
}
