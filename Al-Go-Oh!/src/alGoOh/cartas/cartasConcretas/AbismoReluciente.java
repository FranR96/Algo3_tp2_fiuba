package alGoOh.cartas.cartasConcretas;

import alGoOh.cartas.LogicaCartas.CartaMonstruo;
import alGoOh.efectos.EfectoNulo;

public class AbismoReluciente extends CartaMonstruo {

	public AbismoReluciente () {
		super(1600,1800,4,new EfectoNulo());
	}
	
	public int resetPtsAtaque() {
		return 1600;
	}
	
	public int resetPtsDefensa() {
		return 1800;
	}
}
