package cartas;

import alGoOh.Campo;
import alGoOh.Jugador;

public abstract class CartaMagica extends CartaEspecial {



    public void voltear() {
        this.lado = new BocaArriba();

    }
}
