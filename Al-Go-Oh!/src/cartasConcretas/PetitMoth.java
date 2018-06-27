package cartasConcretas;

import cartas.CartaMonstruo;
import efectos.EfectoNulo;

public class PetitMoth extends CartaMonstruo{

	public PetitMoth() {
		super(300,200,1, new EfectoNulo());
	}
	
	public int resetPtsAtaque() {
		return 300;
	}
	
	public int resetPtsDefensa() {
		return 200;
	}
}
