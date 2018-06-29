package cartasConcretas;

import cartas.CartaMonstruo;
import alGoOh.efectos.EfectoNulo;

public class DragonBlancoDeOjosAzules extends CartaMonstruo {
	
	public DragonBlancoDeOjosAzules() {
		super(3000,2000,8, new EfectoNulo());
	}

	public int resetPtsAtaque() {
		return 3000;
	}
	
	public int resetPtsDefensa() {
		return 2000;
	}
	
}
