package cartas;

import alGoOh.Campo;
import alGoOh.Jugador;

public class CilindroMagico extends CartaTrampa {

    public CilindroMagico() {
        this.efecto = new EfectoCilindroMagico();
    }

    @Override
    public void aplicarEfecto(Campo campo, Campo campoEnemigo, Jugador activo, Jugador oponente){
        /*Aca faltaría hacer this.efecto. y hacer lo que hace el efecto cilindro magico al atacante
        no lo implemento porque tiene que ver con el tema fase ataque fase trampa */
    }


}
