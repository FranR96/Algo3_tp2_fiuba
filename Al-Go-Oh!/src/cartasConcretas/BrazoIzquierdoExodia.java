package cartasConcretas;

import cartas.CartaMonstruo;
import efectos.EfectoBrazoIzquierdoExodia;

public class BrazoIzquierdoExodia extends CartaMonstruo {

	public BrazoIzquierdoExodia() {
		
		super(200,300,1, new EfectoBrazoIzquierdoExodia());
	}

}
