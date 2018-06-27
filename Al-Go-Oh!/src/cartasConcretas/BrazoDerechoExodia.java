package cartasConcretas;

import cartas.CartaMonstruo;
import efectos.EfectoBrazoDerechoExodia;

public class BrazoDerechoExodia extends CartaMonstruo {

	public BrazoDerechoExodia() {
		
		super(200,300,1, new EfectoBrazoDerechoExodia());
	}
	
	public int resetPtsAtaque() {
		return 200;
	}
	
	public int resetPtsDefensa() {
		return 300;
	}
}
