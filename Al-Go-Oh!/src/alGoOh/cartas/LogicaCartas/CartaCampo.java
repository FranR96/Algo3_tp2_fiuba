package alGoOh.cartas.LogicaCartas;

import alGoOh.efectos.EfectoNulo;

public class CartaCampo extends CartaEspecial {

    private int ptsAdicionalAtkPropio;
    private int ptsAdicionalAtkEnemigo;
    private int ptsAdicionalDefPropio;
    private int ptsAdicionalDefEnemigo;

    
    public CartaCampo(int ptsAdicionalAtkPropio, int ptsAdicionalAtkEnemigo, int ptsAdicionalDefPropio, int ptsAdicionalDefEnemigo){
        this.ptsAdicionalAtkPropio = ptsAdicionalAtkPropio;
        this.ptsAdicionalAtkEnemigo = ptsAdicionalAtkEnemigo;
        this.ptsAdicionalDefPropio = ptsAdicionalDefPropio;
        this.ptsAdicionalDefEnemigo = ptsAdicionalDefEnemigo;
        this.efecto = new EfectoNulo();
    }

    public int getPtsAdicionalAtkPropio() {
        return ptsAdicionalAtkPropio;
    }

    public int getPtsAdicionalAtkEnemigo() {
        return ptsAdicionalAtkEnemigo;
    }

    public int getPtsAdicionalDefPropio() {
        return ptsAdicionalDefPropio;
    }

    public int getPtsAdicionalDefEnemigo() {
        return ptsAdicionalDefEnemigo;
    }

}
