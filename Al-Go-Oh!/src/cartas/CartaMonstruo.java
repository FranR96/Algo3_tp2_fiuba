package cartas;

import alGoOh.*;

public abstract class CartaMonstruo implements Carta{
	
	private int ptsAtaque;
	private int ptsDefensa;
	private int estrellas;
	private PosicionCarta posicion;
	private LadoCarta lado;
	private Campo campo;
	
	
	public CartaMonstruo(int ataque,int defensa, int estrellas) {
		this.ptsAtaque= ataque;
		this.ptsDefensa= defensa;
		this.estrellas = estrellas;
	}
	
	public Campo getCampo() {
		return campo;
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
