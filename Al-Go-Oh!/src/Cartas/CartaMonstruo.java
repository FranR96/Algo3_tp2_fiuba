package Cartas;

public abstract class CartaMonstruo implements Carta{
	
	protected int ptsAtaque;
	protected int ptsDefensa;
	protected int estrellas;
	private PosicionCarta posicion;
	private LadoCarta lado;
	
	
	public CartaMonstruo() {
		
	}
	
	
	public void atacar(CartaMonstruo monstruo) {
		this.posicion.atacar(this,monstruo);
	}
	
	public void recibirDanio(int danio) {
		this.posicion.recibirDanio(this);
	}
	
	
	public void invocar(PosicionCarta posicion,LadoCarta lado) {
		this.posicion= posicion;
		this.lado = lado;
		
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
