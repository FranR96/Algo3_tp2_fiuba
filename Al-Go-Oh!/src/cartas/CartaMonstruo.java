package cartas;

import alGoOh.*;

public abstract class CartaMonstruo implements Carta{
	
	protected int ptsAtaque;
	protected int ptsDefensa;
	protected int estrellas;
	private PosicionCarta posicion;
	private LadoCarta lado;
	protected Campo campo;
	
	
	public CartaMonstruo() {
		
	}
	
	
	public void atacar(CartaMonstruo monstruo) {
		this.posicion.atacar(this,monstruo);
	}
	
	public int recibirDanio(int danio) {
		return (this.posicion.recibirDanio(danio));
	}
	
	
	public void invocar(PosicionCarta posicion,LadoCarta lado,Campo campo) {
		this.posicion= posicion;
		this.lado = lado;
		this.posicion.setCarta(this);
		this.lado.setCarta(this);
		this.campo=campo;
		if(this.estrellas >= 5) { //Requiere sacrificio
			this.campo.cartaRequiereSacrificio((this.estrellas-1)/3);
		}
		
	}


	public int getPtsAtaque() {
		return this.ptsAtaque;
	}
	
	public int getPtsDefensa() {
		return this.ptsDefensa;
	}
	
	public int getEstrellas() {
		return this.estrellas;
	}
}
