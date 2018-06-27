package cartas;

public class PosicionAtaque implements PosicionCarta {
	
	private CartaMonstruo carta;
	
	public void atacar(CartaMonstruo monstruo1, CartaMonstruo monstruo2) {
		int diferencia = monstruo2.recibirDanio(this.carta.getPtsAtaque());
		if(diferencia >=0) {
			this.carta.getCampo().eliminarMonstruo(this.carta);
			this.carta.getCampo().atacarJugador(diferencia);
		}
	}
	
	public int recibirDanio(int danio) {		
		this.carta.getCampo().voltearCartaTrampa();
		if(!this.carta.getCampo().verificarFiltro()) {
			if (this.carta.getPtsAtaque() < danio) {
				int diferencia = danio - (this.carta.getPtsAtaque());
				this.carta.getCampo().eliminarMonstruo(this.carta);
				this.carta.getCampo().atacarJugador(diferencia);
			} else if (this.carta.getPtsAtaque() > danio) {
				return this.carta.getPtsAtaque() - danio;
			} else {
				this.carta.getCampo().eliminarMonstruo(this.carta);
				return 0;
			}
		}
		this.carta.getCampo().desactivarFiltroDeAtaque();
		return -1;
	}
	
	public void setCarta(CartaMonstruo carta) {
		this.carta=carta;
	}

	public PosicionCarta cambiarPosicion() {
		PosicionDefensa pos = new PosicionDefensa();
		pos.setCarta(this.carta);
		return pos;
	}
}
