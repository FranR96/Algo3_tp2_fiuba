package cartas;

public class PosicionDefensa implements PosicionCarta {

	private CartaMonstruo carta;

	public void setCarta(CartaMonstruo monstruo) {
		this.carta = monstruo;
	}

	public int recibirDanio(int danio) {
		this.carta.getCampo().voltearCartaTrampa();
		int ptsDefensaAdicional = this.carta.campo.obtenerAdicionalDefAtacado() + this.carta.getCampoEnemigo().obtenerAdicionalDefAtacado();
		if (this.carta.getPtsDefensa() + ptsDefensaAdicional < danio) {
			this.carta.getCampo().eliminarMonstruo(this.carta);
		} else if (this.carta.getPtsDefensa() > danio) {
			int diferencia = (this.carta.getPtsDefensa() + ptsDefensaAdicional) - danio;
			return diferencia;
		}
		return -1;
	}


	public void atacar(CartaMonstruo monstruo1, CartaMonstruo monstruo2) {
		throw new MonstruoNoPuedeAtacarEstaEnPosicionDefensaException();
	}

	public PosicionCarta cambiarPosicion() {
		PosicionAtaque pos = new PosicionAtaque();
		pos.setCarta(this.carta);
		return pos;
	}

}