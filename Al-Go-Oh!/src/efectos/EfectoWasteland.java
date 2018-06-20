package efectos;

import java.util.ArrayList;

import alGoOh.*;
import cartas.CartaMonstruo;

public class EfectoWasteland extends Efecto {
	
	@Override
	public void aplicarEfectoSobreCampoActivo(Campo campo) {
		
		int ptsAtaque = 200;
		ArrayList<CartaMonstruo> zonaMonstruos = campo.monstruosInvocados();
		for(CartaMonstruo monstruo : zonaMonstruos)
			monstruo.setPtsAtaque(monstruo.getPtsAtaque() + ptsAtaque);					
	}
		
	@Override
	public void aplicarEfectoSobreCampoOponente(Campo campo) {
		
		int ptsDefensa = 300;
		ArrayList<CartaMonstruo> zonaMonstruos = campo.monstruosInvocados();
		for(CartaMonstruo monstruo : zonaMonstruos)
			monstruo.setPtsDefensa(monstruo.getPtsDefensa() + ptsDefensa);
	}
	
	
}
