package Vista;

import alGoOh.Jugador;
import javafx.scene.control.Label;

import java.util.Observable;
import java.util.Observer;

public class VistaVida implements Observer {

    private Label vidaJugador1;
    private Label vidaJugador2;
    private Jugador jugador1;
    private Jugador jugador2;


    public VistaVida(Label vida1, Label vida2, Jugador jugador1, Jugador jugador2) {
        this.vidaJugador1 = vida1;
        this.vidaJugador2 = vida2;
        this.jugador1 = jugador1;
        this.jugador2 = jugador2;
    }

    public void update() {
        vidaJugador1.setText("LIFEPOINTS: " + jugador1.getPtsVida());
        vidaJugador2.setText("LIFEPOINTS: " + jugador2.getPtsVida());

    }

    @Override
    public void update(Observable o, Object arg) {
        this.update();
    }
}
