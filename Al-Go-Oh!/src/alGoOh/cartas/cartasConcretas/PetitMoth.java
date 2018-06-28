package alGoOh.cartas.cartasConcretas;

import alGoOh.cartas.LogicaCartas.CartaMonstruo;
import alGoOh.efectos.EfectoNulo;

public class PetitMoth extends CartaMonstruo{

	public PetitMoth() {
		super(300,200,1, new EfectoNulo());
	}
	
	public int resetPtsAtaque() {
		return 300;
	}
	
	public int resetPtsDefensa() {
		return 200;
	}
}
