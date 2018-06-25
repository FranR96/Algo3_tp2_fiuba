package cartas;

public class CartaCampo extends CartaEspecial {

    private int ptsAdicionalAtkAtacante;
    private int ptsAdicionalAtkAtacado;
    private int ptsAdicionalDefAtacante;

    //Al hacer esto no tiene sentido que las cartas campo tengan un atributo Efecto.

    public int getPtsAdicionalAtkAtacante() {
        return ptsAdicionalAtkAtacante;
    }

    public int getPtsAdicionalAtkAtacado() {
        return ptsAdicionalAtkAtacado;
    }

    public int getPtsAdicionalDefAtacante() {
        return ptsAdicionalDefAtacante;
    }

    public int getPtsAdicionalDefAtacado() {
        return ptsAdicionalDefAtacado;
    }

    private int ptsAdicionalDefAtacado;

    public CartaCampo(int ptsAdicionalAtkAtacado, int ptsAdicionalAtkAtacante, int ptsAdicionalDefAtacado, int ptsAdicionalDefAtacante){
        this.ptsAdicionalAtkAtacado = ptsAdicionalAtkAtacado;
        this.ptsAdicionalAtkAtacante = ptsAdicionalAtkAtacante;
        this.ptsAdicionalDefAtacado = ptsAdicionalDefAtacado;
        this.ptsAdicionalDefAtacante = ptsAdicionalDefAtacante;
    }
}
