package alGoOh.cartas.cartasConcretas;

import alGoOh.cartas.LogicaCartas.CartaMonstruo;
import alGoOh.efectos.EfectoNulo;

public class Ansatsu extends CartaMonstruo{

	public Ansatsu() {
		super(1700,1200,5, new EfectoNulo());
	}
	
	public int resetPtsAtaque() {
		return 1700;
	}
	
	public int resetPtsDefensa() {
		return 1200;
	}
}
