package efectos;

import java.util.ArrayList;

import alGoOh.Campo;
import cartas.CartaMonstruo;

public class EfectoSogen extends Efecto {

	@Override
	public void aplicarEfectoSobreCampoActivo(Campo campo) {
		
		int ptsDefensa = 500;
		ArrayList<CartaMonstruo> zonaMonstruos = campo.monstruosInvocados();
		for(CartaMonstruo monstruo : zonaMonstruos)
			monstruo.setPtsDefensa(monstruo.getPtsDefensa() + ptsDefensa);		
	}
	
	@Override
	public void aplicarEfectoSobreCampoOponente(Campo campo) {
		
		int ptsAtaque = 200;
		ArrayList<CartaMonstruo> zonaMonstruos = campo.monstruosInvocados();
		for(CartaMonstruo monstruo : zonaMonstruos)
			monstruo.setPtsAtaque(monstruo.getPtsAtaque() + ptsAtaque);	
	}
	
}
