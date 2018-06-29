package cartasConcretas;

import cartas.CartaMonstruo;
import alGoOh.efectos.EfectoNulo;

public class HuevoMonstruoso extends CartaMonstruo{

	public HuevoMonstruoso() {
		super(600,900,3,new EfectoNulo());
	}
	
	public int resetPtsAtaque() {
		return 600;
	}
	
	public int resetPtsDefensa() {
		return 900;
	}

}
