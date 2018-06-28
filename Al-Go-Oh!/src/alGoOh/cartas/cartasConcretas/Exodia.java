package alGoOh.cartas.cartasConcretas;

import alGoOh.cartas.LogicaCartas.CartaMonstruo;
import alGoOh.efectos.EfectoCabezaDeExodia;

public class Exodia extends CartaMonstruo {

	public Exodia() {
		
		super(1000,1000,3, new EfectoCabezaDeExodia());
	}
	
	public int resetPtsAtaque() {
		return 1000;
	}
	
	public int resetPtsDefensa() {
		return 1000;
	}
}
