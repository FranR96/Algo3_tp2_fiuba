package alGoOh.efectos;

import cartas.CartaMonstruo;
import alGoOh.Campo;

public class EfectoInsectoComeHombres extends Efecto {

	@Override
	public void aplicarEfectoSobreCampoOponente(Campo campo){
		
		if(campo.monstruosInvocados().size() != 0) {
			CartaMonstruo monstruoADestruir = campo.cartaAtacante(); 
			campo.eliminarCarta(monstruoADestruir);
		}
    }
	
}
