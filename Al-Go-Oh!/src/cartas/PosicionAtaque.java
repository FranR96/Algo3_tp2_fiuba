package cartas;

public class PosicionAtaque implements PosicionCarta {
	
	private CartaMonstruo carta;
	
	public void atacar(CartaMonstruo monstruo1, CartaMonstruo monstruo2) {
		int ptsAtaqueAdicional = this.carta.campo.obtenerAdicionalAtkAtacante() + this.carta.getCampoEnemigo().obtenerAdicionalAtkAtacante();
		int diferencia = monstruo2.recibirDanio(this.carta.getPtsAtaque() + ptsAtaqueAdicional);
		if(diferencia >=0) {
			this.carta.getCampo().eliminarMonstruo(this.carta);
			this.carta.getCampo().atacarJugador(diferencia);
		}
	}
	
	public int recibirDanio(int danio) {		
		this.carta.getCampo().voltearCartaTrampa();
		int ptsAtaqueAdicional = this.carta.campo.obtenerAdicionalAtkAtacado() + this.carta.getCampoEnemigo().obtenerAdicionalAtkAtacado();
		if(this.carta.getPtsAtaque() + ptsAtaqueAdicional  < danio) {
			int diferencia= danio- (this.carta.getPtsAtaque() + ptsAtaqueAdicional);
			this.carta.getCampo().eliminarMonstruo(this.carta);
			this.carta.getCampo().atacarJugador(diferencia);
		}
		else if(this.carta.getPtsAtaque()>danio) {
			return this.carta.getPtsAtaque()- danio;
		}
		else {
			this.carta.getCampo().eliminarMonstruo(this.carta);
			return 0;
		}
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
