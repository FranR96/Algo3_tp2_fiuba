package alGoOh.efectos;

import alGoOh.cartas.LogicaCartas.CartaMonstruo;
import alGoOh.componentes.Campo;

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