package cartasConcretas;

import cartas.CartaMonstruo;
import alGoOh.efectos.EfectoNulo;

public class HombreFrijolJerry extends CartaMonstruo{

	public HombreFrijolJerry() {
		super(1750,0,3, new EfectoNulo());
	}

	public int resetPtsAtaque() {
		return 1750;
	}
	
	public int resetPtsDefensa() {
		return 0;
	}
}
