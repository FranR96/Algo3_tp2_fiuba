package cartas;

public class PosicionDefensa implements PosicionCarta {

	private CartaMonstruo carta;
	
	public void setCarta(CartaMonstruo monstruo) {
		this.carta=monstruo;

	}

	public int recibirDanio(int danio) {
		carta.voltear();
		this.carta.getCampo().voltearCartaTrampa();
		if(this.carta.getPtsDefensa()< danio) {
			this.carta.getCampo().eliminarMonstruo(this.carta);
		}else if(this.carta.getPtsDefensa()>danio) {
			int diferencia = this.carta.getPtsDefensa()- danio;
			return diferencia;
		}
		return -1;
	}

	
	public void atacar(CartaMonstruo monstruo1, CartaMonstruo monstruo2) {
		throw new MonstruoNoPuedeAtacarEstaEnPosicionDefensaException();

	}

}
