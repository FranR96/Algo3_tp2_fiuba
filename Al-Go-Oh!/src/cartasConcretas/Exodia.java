package cartasConcretas;

import alGoOh.*;
import cartas.CartaMonstruo;
import efectos.EfectoCabezaDeExodia;

public class Exodia extends CartaMonstruo {

	public Exodia() {
		
		super(1000,1000,3, new EfectoCabezaDeExodia());
	}
	
}
