package cartas;

public interface Carta {
	
	void efecto();
	void invocar(PosicionCarta posicion, LadoCarta lado);
}
