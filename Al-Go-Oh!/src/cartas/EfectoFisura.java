package cartas;

import java.util.ArrayList;

import alGoOh.*;


public class EfectoFisura extends Efecto {

	@Override
	public void aplicarEfecto(Campo campo) {
		
		Tablero tablero = Tablero.getInstance();
		if(campo == tablero.getCampo1()) {
			ArrayList<CartaMonstruo> zonaMonstruos = tablero.getCampo2().monstruosInvocados();
			if(zonaMonstruos.size() != 0) {
				CartaMonstruo monstruoConMenorAtaque = zonaMonstruos.get(0);
				for(CartaMonstruo monstruo : zonaMonstruos)
					if(monstruoConMenorAtaque.getPtsAtaque() > monstruo.getPtsAtaque())
							monstruoConMenorAtaque = monstruo;
				zonaMonstruos.remove(monstruoConMenorAtaque);
			}
		}
		
		if(campo == tablero.getCampo2()) {
			ArrayList<CartaMonstruo> zonaMonstruos = tablero.getCampo1().monstruosInvocados();
			if(zonaMonstruos.size() != 0) {
				CartaMonstruo monstruoConMenorAtaque = zonaMonstruos.get(0);
				for(CartaMonstruo monstruo : zonaMonstruos)
					if(monstruoConMenorAtaque.getPtsAtaque() > monstruo.getPtsAtaque())
							monstruoConMenorAtaque = monstruo;
				zonaMonstruos.remove(monstruoConMenorAtaque);
			}
		}
		
	}

	@Override
	public void aplicarEfecto(Jugador jugador) {}

	@Override
	public void aplicarEfecto() {}

}
