package cartas;

public interface PosicionCarta {

	void setCarta(CartaMonstruo monstruo);
	int recibirDanio(int danio);
	void atacar(CartaMonstruo monstruo1, CartaMonstruo monstruo2);
}
