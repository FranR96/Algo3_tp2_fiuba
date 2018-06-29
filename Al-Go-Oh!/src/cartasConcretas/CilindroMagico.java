package cartasConcretas;

import cartas.CartaTrampa;
import alGoOh.Campo;
import alGoOh.Jugador;
import alGoOh.efectos.EfectoCilindroMagico;

public class CilindroMagico extends CartaTrampa {

    public CilindroMagico() {
        this.efecto = new EfectoCilindroMagico();
    }

    @Override
    public void aplicarEfecto(Campo campo, Campo campoEnemigo, Jugador activo, Jugador oponente){
        this.efecto.aplicarEfectoSobreCampoOponente(campoEnemigo);
    }


}
