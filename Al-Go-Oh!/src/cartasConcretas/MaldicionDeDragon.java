package cartasConcretas;

import cartas.CartaMonstruo;
import efectos.EfectoNulo;

public class MaldicionDeDragon extends CartaMonstruo{

	public MaldicionDeDragon() {
		super(2000,1500,5, new EfectoNulo());
	}

}
