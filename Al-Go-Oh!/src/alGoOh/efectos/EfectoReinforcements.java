package alGoOh.efectos;

import cartas.CartaMonstruo;
import alGoOh.Campo;

public class EfectoReinforcements extends Efecto {

	@Override
	public void aplicarEfectoSobreCampoActivo(Campo campo){
		
		CartaMonstruo monstruo = campo.obtenerUltimoMonstruoAtacado();
		monstruo.setPtsAtaque(monstruo.getPtsAtaque() + 500);
    }
}
