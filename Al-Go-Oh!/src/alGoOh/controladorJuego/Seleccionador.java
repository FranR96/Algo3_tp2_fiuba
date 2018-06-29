package alGoOh.controladorJuego;

import alGoOh.Jugador;

import java.util.Random;

class Seleccionador {

	
    private Random random = new Random();
    
    public Jugador elegirEntre(Jugador jugador1, Jugador jugador2) {
    	return random.nextBoolean() ? jugador1 : jugador2;
    }
    
}
