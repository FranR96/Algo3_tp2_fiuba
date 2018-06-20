package cartas;

import alGoOh.Campo;
import alGoOh.Jugador;

public class EfectoNulo extends Efecto {

	@Override
	public void aplicarEfecto(Jugador jugador) {}

	@Override
	public void aplicarEfecto(Campo campo) {}

	@Override
	public void aplicarEfecto() {}

}
