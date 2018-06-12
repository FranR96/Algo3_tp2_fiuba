package cartas;

public class PosicionDefensa implements PosicionCarta {

	private CartaMonstruo carta;
	
	@Override
	public void setCarta(CartaMonstruo monstruo) {
		this.carta=monstruo;

	}

	@Override
	public void recibirDanio(int danio) {
		if(this.carta.getPtsDefensa()< danio) {
			throw new MonstruoEstaMuertoException();
		}
	}

	@Override
	public void atacar(CartaMonstruo monstruo1, CartaMonstruo monstruo2) {
		throw new MonstruoNoPuedeAtacarEstaEnPosicionDefensaException();

	}

}
