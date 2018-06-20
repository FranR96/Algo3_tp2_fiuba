package alGoOh;

import cartas.*;

public class Tablero {
	private static Tablero INSTANCE =null;
	private Campo campo1= new Campo();
	private Campo campo2= new Campo();
	private Jugador jugador1;
	private Jugador jugador2;
	private Juego juego;

	public Jugador getJugador2() {
		return jugador2;
	}
	
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
		campo1.setTablero(this);
		campo2.setTablero(this);
		this.jugador1 = jugador1;
		this.jugador2 = jugador2;

		//juego.sortearInicio(this,jugador1,jugador2);
	}
	
	public Campo getCampo1() {
		return campo1;
	}
	
	public Campo getCampo2() {
		return campo2;
	}
	
	
}
