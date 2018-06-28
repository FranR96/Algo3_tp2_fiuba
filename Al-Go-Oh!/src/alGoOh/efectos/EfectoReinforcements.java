package alGoOh.efectos;

import alGoOh.cartas.LogicaCartas.CartaMonstruo;
import alGoOh.componentes.Campo;

public class EfectoReinforcements extends Efecto {

	@Override
	public void aplicarEfectoSobreCampoActivo(Campo campo){
		
		CartaMonstruo monstruo = campo.obtenerUltimoMonstruoAtacado();
		monstruo.setPtsAtaque(monstruo.getPtsAtaque() + 500);
    }
}
