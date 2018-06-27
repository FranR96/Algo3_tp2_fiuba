package cartasConcretas;

import cartas.CartaMonstruo;
import efectos.EfectoNulo;

public class KappaPsiquico extends CartaMonstruo{

	public KappaPsiquico() {
		super(400,100,2, new EfectoNulo());
	}

	public int resetPtsAtaque() {
		return 400;
	}
	
	public int resetPtsDefensa() {
		return 100;
	}
	
}
