package alGoOh;


import cartas.*;

public class Tablero {
	private static Tablero INSTANCE = null;
	private Campo campo1= new Campo();
	private Campo campo2= new Campo();
	
	private Tablero() {}
	
	private synchronized static void createInstance() {
		if (INSTANCE == null) { 
	       INSTANCE = new Tablero();
	    }
	}
	
	public static Tablero getInstance() {
	    if (INSTANCE == null) 
	    	createInstance();
	    return INSTANCE;
	}
	
	public void inicializarTablero(Jugador jugador1, Jugador jugador2) {
		campo1.setJugador(jugador1);
		campo2.setJugador(jugador2);
	}
	
	public Campo getCampo1() {
		return campo1;
	}
	
	public Campo getCampo2() {
		return campo2;
	}

	public void colocarCartaEnCampoJugador1(CartaMonstruo monstruo, PosicionCarta posicion,
			LadoCarta lado) {
		this.colocarCartaEnCampo(monstruo, posicion,lado,campo1);	
	}
	
	public void colocarCartaEnCampoJugador2(CartaMonstruo monstruo, PosicionCarta posicion,
			LadoCarta lado) {
		this.colocarCartaEnCampo(monstruo, posicion,lado,campo2);	
	}
	
	public void colocarCartaEnCampoJugador1(CartaEspecial especial, LadoCarta lado) {
		this.colocarCartaEnCampo(especial, lado, campo1);
	}
	
	public void colocarCartaEnCampoJugador2(CartaEspecial especial, LadoCarta lado) {
		this.colocarCartaEnCampo(especial, lado, campo2);
	}
	
	public void colocarCartaEnCampo(CartaMonstruo monstruo, PosicionCarta posicion,
			LadoCarta lado,Campo campo) {
		campo.colocarCarta(monstruo, posicion, lado);
	}

	public void colocarCartaEnCampo(CartaEspecial especial, LadoCarta lado, Campo campo) {
		campo.colocarCarta(especial, lado);
	}
	
	public void atacarACon(CartaMonstruo monstruo1, CartaMonstruo monstruo2) {
		monstruo2.atacar(monstruo1);
		
	}
	
	public void aplicarEfecto(CartaEspecial especial) {
		campo1.aplicarEfecto(especial);
		campo2.aplicarEfecto(especial);
	}
}
