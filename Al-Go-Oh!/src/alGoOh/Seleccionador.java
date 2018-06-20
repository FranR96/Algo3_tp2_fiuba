package alGoOh;

import java.util.Random;

public class Seleccionador {

	
    private Random random = new Random();
    
    public Jugador elegirEntre(Jugador jugador1, Jugador jugador2) {
    	return random.nextBoolean() ? jugador1 : jugador2;
    }
    
}
