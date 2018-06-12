package cartas;

public abstract class CartaEspecial implements Carta{

	private LadoCarta lado;
	
	public void invocar(LadoCarta lado) {
		this.lado=lado;
		this.lado.setCarta(this);
	}

}
