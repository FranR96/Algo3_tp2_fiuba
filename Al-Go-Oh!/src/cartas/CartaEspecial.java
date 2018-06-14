package cartas;

import alGoOh.*;

public abstract class CartaEspecial implements Carta{

	private LadoCarta lado;
	private Campo campo;
	
	public void invocar(LadoCarta lado, Campo campo) {
		this.lado=lado;
		this.lado.setCarta(this);
		this.campo=campo;
	}
	
	public void aplicarEfecto(Campo campo) {
		
		this.lado.invocar(campo);
	}

}
