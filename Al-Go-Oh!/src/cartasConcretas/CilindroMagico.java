package cartasConcretas;

import alGoOh.*;
import cartas.CartaTrampa;
import efectos.EfectoCilindroMagico;

public class CilindroMagico extends CartaTrampa {

    public CilindroMagico() {
        this.efecto = new EfectoCilindroMagico();
    }

    @Override
    public void aplicarEfecto(Campo campo, Campo campoEnemigo, Jugador activo, Jugador oponente){
        this.efecto.aplicarEfectoSobreCampoOponente(campoEnemigo);
    }


}
