package alGoOh.efectos;

import alGoOh.cartas.LogicaCartas.CartaMonstruo;
import alGoOh.componentes.Campo;

public class EfectoInsectoComeHombres extends Efecto {

	@Override
	public void aplicarEfectoSobreCampoOponente(Campo campo){
		
		if(campo.monstruosInvocados().size() != 0) {
			CartaMonstruo monstruoADestruir = campo.cartaAtacante(); 
			campo.eliminarCarta(monstruoADestruir);
		}
    }
	
}
