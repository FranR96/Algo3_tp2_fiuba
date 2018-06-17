package cartas;

import alGoOh.*;

public abstract class CartaMonstruo extends Carta{
	
	private int ptsAtaque;
	private int ptsDefensa;
	private int estrellas;
	private PosicionCarta posicion;
	
	
	public CartaMonstruo(int ataque,int defensa, int estrellas) {
		this.ptsAtaque= ataque;
		this.ptsDefensa= defensa;
		this.estrellas = estrellas;
	}
	
	public void atacar(CartaMonstruo monstruo) {
		this.posicion.atacar(this,monstruo);
	}
	
	public int recibirDanio(int danio) {
		return (this.posicion.recibirDanio(danio));
	}
	
	
	public int invocar(PosicionCarta posicion,LadoCarta lado,Campo campo) {
		this.posicion= posicion;
		this.lado = lado;
		this.posicion.setCarta(this);
		this.lado.setCarta(this);
		this.campo= campo;
		if(this.estrellas >= 5) { //Requiere sacrificio
			return ((this.estrellas-1)/3);
		}
		return 0;
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

	public Campo getCampo() {
		return campo;
	}
	
	public boolean enPosicionDeAtaque(){
		return this.posicion instanceof PosicionAtaque;
	}
}
