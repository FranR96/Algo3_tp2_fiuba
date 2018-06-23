package cartasConcretas;

import cartas.CartaMonstruo;
import efectos.EfectoPiernaDerechaExodia;

public class PiernaDerechaExodia extends CartaMonstruo {

	public PiernaDerechaExodia() {
		
		super(200,300,1, new EfectoPiernaDerechaExodia());
	}

}
