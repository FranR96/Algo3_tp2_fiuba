package alGoOh.cartas.cartasConcretas;

import alGoOh.cartas.LogicaCartas.CartaMonstruo;
import alGoOh.efectos.EfectoNulo;

public class LoboGigaTecnologico extends CartaMonstruo {

	public LoboGigaTecnologico() {
		super(1200,1400,4, new EfectoNulo());
	}
	
	public int resetPtsAtaque() {
		return 1200;
	}
	
	public int resetPtsDefensa() {
		return 1400;
	}
	
}
