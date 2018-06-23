package cartas;



public abstract class CartaMagica extends CartaEspecial {



    public void voltear() {
        this.lado = new BocaArriba();

    }
}
