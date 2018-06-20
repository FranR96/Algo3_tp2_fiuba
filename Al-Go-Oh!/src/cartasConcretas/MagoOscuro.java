package cartasConcretas;

import cartas.CartaMonstruo;
import efectos.EfectoNulo;

public class MagoOscuro extends CartaMonstruo {

	public MagoOscuro() {
		super(2500,2100,7, new EfectoNulo());
	}
	
}
