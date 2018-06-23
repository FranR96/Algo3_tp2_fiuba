package cartasConcretas;

import cartas.CartaMonstruo;
import efectos.EfectoNulo;
import efectos.EfectoPiernaIzquierdaExodia;

public class PiernaIzquierdaExodia extends CartaMonstruo {

	public PiernaIzquierdaExodia() {
		
		super(200,300,1, new EfectoPiernaIzquierdaExodia());
	}

}
