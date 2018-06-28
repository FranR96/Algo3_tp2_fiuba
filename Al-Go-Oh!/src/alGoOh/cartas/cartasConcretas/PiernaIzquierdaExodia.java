package alGoOh.cartas.cartasConcretas;

import alGoOh.cartas.LogicaCartas.CartaMonstruo;
import alGoOh.efectos.EfectoPiernaIzquierdaExodia;

public class PiernaIzquierdaExodia extends CartaMonstruo {

	public PiernaIzquierdaExodia() {
		
		super(200,300,1, new EfectoPiernaIzquierdaExodia());
	}

	public int resetPtsAtaque() {
		return 200;
	}
	
	public int resetPtsDefensa() {
		return 300;
	}
}
