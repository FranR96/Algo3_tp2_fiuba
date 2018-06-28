package alGoOh.cartas.cartasConcretas;

import alGoOh.cartas.LogicaCartas.CartaMonstruo;
import alGoOh.efectos.EfectoNulo;

public class MaldicionDeDragon extends CartaMonstruo{

	public MaldicionDeDragon() {
		super(2000,1500,5, new EfectoNulo());
	}

	public int resetPtsAtaque() {
		return 2000;
	}
	
	public int resetPtsDefensa() {
		return 1500;
	}
}
