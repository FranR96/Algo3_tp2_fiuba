package Vista.Eventos;

import alGoOh.Jugador;
import cartas.Carta;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class ColocarCartaHandler implements EventHandler<ActionEvent> {
    private Carta carta;
    private Jugador jugadorActivo;

    public ColocarCartaHandler(Carta carta, Jugador jugadorActivo) {
        this.carta = carta;
        this.jugadorActivo = jugadorActivo;
    }

    @Override
    public void handle(ActionEvent event) {
        //jugadorActivo.getCampo()
    }
}
