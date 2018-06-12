package alGoOh;

import java.util.ArrayList;
import java.util.Collection;

import cartas.*;

public class Campo {
	private Collection<CartaMonstruo> zonaMonstruos = new ArrayList<CartaMonstruo>();
	private Collection<CartaEspecial> zonaEspeciales = new ArrayList<CartaEspecial>();
	
	
	public void colocarCarta(CartaMonstruo monstruo, PosicionCarta posicion,LadoCarta lado) {
		if(this.zonaMonstruos.size()<5) {
			this.zonaMonstruos.add(monstruo);
			monstruo.invocar(posicion, lado);
		}
		else {
			throw new CapacidadMaximaEnZonaMontruosException();
		}
		
	}

	public void colocarCarta(CartaEspecial carta, LadoCarta lado) {
		if(this.zonaEspeciales.size()< 5) {
			this.zonaEspeciales.add(carta);
			carta.invocar(lado);
		}
		else {
			throw new CapacidadMaximaEnZonaEspecialesException();
		}
	}
	
}
