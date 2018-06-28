package Vista.Eventos;

import Vista.VistaCarta;
import alGoOh.Tablero;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class BotonAtacarHandler implements EventHandler<ActionEvent> {

    private Tablero tablero;
    private VistaCarta vistaCarta;

    public BotonAtacarHandler(VistaCarta vistaCarta, Tablero tablero) {
        this.tablero = tablero;
        this.vistaCarta = vistaCarta;
    }

    @Override
    public void handle(ActionEvent event) {

    }
}
