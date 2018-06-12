package alGoOh;

import java.util.ArrayList;

public class Tablero {

	private static Tablero tablero = new Tablero();
	public Campo[] campos = new Campo[2];
	
	private Tablero(){
		
	}
	
	public static Tablero getTablero() {
		return tablero;
	}
	
}
