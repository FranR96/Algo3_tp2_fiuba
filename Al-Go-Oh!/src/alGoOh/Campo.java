package alGoOh;

import java.util.ArrayList;
import java.util.Collection;

import cartas.CartaMonstruo;
import cartas.LadoCarta;
import cartas.PosicionCarta;

public class Campo {
	private Collection<CartaMonstruo> zonaMonstruos = new ArrayList();
	
	public void colocarCarta(CartaMonstruo monstruo, PosicionCarta posicion,LadoCarta lado) {
		if(this.zonaMonstruos.size()<5) {
			this.zonaMonstruos.add(monstruo);
			monstruo.invocar(posicion, lado);
		}
		else {
			throw new CapacidadMaximaEnZonaMontruosException();
		}
		
	}
	
}
