package cartas;

public class PosicionAtaque implements PosicionCarta {
	
	private CartaMonstruo carta;
	
	@Override
	public void atacar(CartaMonstruo monstruo1, CartaMonstruo monstruo2) {
		monstruo2.recibirDanio(this.carta.getPtsAtaque());
	}
	
	public void recibirDanio(int danio) {
		if(this.carta.getPtsAtaque()< danio) {
			throw new MonstruoEstaMuertoException();
		}
	}
	
	public void setCarta(CartaMonstruo carta) {
		this.carta=carta;
	}
}
