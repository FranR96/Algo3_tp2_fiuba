package alGoOh.cartas.cartasConcretas;

import alGoOh.cartas.LogicaCartas.CartaMonstruo;
import alGoOh.efectos.EfectoNulo;

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
