package cartas;

public class PosicionAtaque implements PosicionCarta {
	
	private CartaMonstruo carta;
	
	public void atacar(CartaMonstruo monstruo1, CartaMonstruo monstruo2) {
		monstruo1.voltear();
		monstruo2.voltear();
		int diferencia = monstruo2.recibirDanio(this.carta.getPtsAtaque());
		if(diferencia >=0) {
			this.carta.getCampo().eliminarMonstruo(this.carta);
			this.carta.getCampo().atacarJugador(diferencia);
		}
	}
	
	public int recibirDanio(int danio) {
		this.carta.getCampo().voltearCartaTrampa();
		if(this.carta.getPtsAtaque()< danio) {
			int diferencia= danio-this.carta.getPtsAtaque();
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
}
