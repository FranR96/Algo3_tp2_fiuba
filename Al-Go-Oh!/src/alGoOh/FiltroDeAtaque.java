package alGoOh;

class FiltroDeAtaque {
    private boolean bloqueo;

    public FiltroDeAtaque(){
        this.bloqueo = false;
    }

    public  void desactivarFiltro(){
        bloqueo = false;
    }

    public void activarFiltro(){
        bloqueo = true;
    }

    public boolean estaActivo(){
        return bloqueo;
    }
}
