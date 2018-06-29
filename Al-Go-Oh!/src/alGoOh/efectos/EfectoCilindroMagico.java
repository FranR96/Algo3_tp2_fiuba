package alGoOh.efectos;

import cartas.CartaMonstruo;
import alGoOh.Campo;

public class EfectoCilindroMagico extends Efecto {

	@Override
	public void aplicarEfectoSobreCampoOponente(Campo campoOponente) {
		CartaMonstruo atacante = campoOponente.cartaAtacante();
		campoOponente.atacarJugador(atacante.getPtsAtaque());
	}

	@Override
	public void aplicarEfectoSobreCampoActivo(Campo campoActivo){
		campoActivo.activarFiltroDeAtaque();
	}
}