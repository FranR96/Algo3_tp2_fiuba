package cartasConcretas;

import cartas.CartaMonstruo;
import alGoOh.efectos.EfectoNulo;

public class DragonDeAlexandrita extends CartaMonstruo{

	
	public DragonDeAlexandrita() {
		super(2000,100,4,new EfectoNulo());
	}

	public int resetPtsAtaque() {
		return 2000;
	}
	
	public int resetPtsDefensa() {
		return 100;
	}
}
