package efectos;

import alGoOh.Campo;
import cartas.CartaMonstruo;

public class EfectoInsectoComeHombres extends Efecto {

	@Override
	public void aplicarEfectoSobreCampoOponente(Campo campo){
		
		if(campo.monstruosInvocados().size() != 0) {
			CartaMonstruo monstruoADestruir = campo.monstruosInvocados().get(0); //campo.elegirMonstruoObjetivo()
			campo.eliminarMonstruo(monstruoADestruir);
		}
    }
	
}
