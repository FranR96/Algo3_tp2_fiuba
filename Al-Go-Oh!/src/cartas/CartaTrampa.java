package cartas;
import alGoOh.*;

public abstract class CartaTrampa extends CartaEspecial {


    public void voltear() {
        this.lado = new BocaArriba();
    }

}
