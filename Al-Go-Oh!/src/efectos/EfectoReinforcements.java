package efectos;

import alGoOh.Campo;
import cartas.CartaMonstruo;

public class EfectoReinforcements extends Efecto {

	@Override
	public void aplicarEfectoSobreCampoActivo(Campo campo){
		
		CartaMonstruo monstruo = campo.obtenerUltimoMonstruoAtacado();
		monstruo.setPtsAtaque(monstruo.getPtsAtaque() + 500);
    }
}
