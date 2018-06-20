package cartasConcretas;

import cartas.CartaMonstruo;
import efectos.EfectoNulo;

public class HuevoMonstruoso extends CartaMonstruo{

	public HuevoMonstruoso() {
		super(600,900,3,new EfectoNulo());
	}
}
