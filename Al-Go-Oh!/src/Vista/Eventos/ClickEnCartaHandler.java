package Vista.Eventos;

import Vista.VistaCarta;
import alGoOh.Jugador;
import alGoOh.Tablero;
import cartas.Carta;
import cartas.CartaEspecial;
import cartas.CartaMonstruo;
import javafx.event.EventHandler;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.MenuItem;
import javafx.scene.input.MouseEvent;

public class ClickEnCartaHandler implements EventHandler<MouseEvent> {
    private VistaCarta vistaCarta;
    private Tablero tablero;
    private Carta carta;
    private Jugador jugadorActivo;

    public ClickEnCartaHandler(VistaCarta vistaCarta, Tablero tablero) {
        this.vistaCarta = vistaCarta;
        this.tablero = tablero;
        this.carta = vistaCarta.getCarta();
        this.jugadorActivo = tablero.getJugadorActivo();
    }

    private ContextMenu crearContextMenu() {
        ContextMenu menuDeCarta = new ContextMenu();
        MenuItem colocarCarta = new MenuItem("Colocar carta");
        colocarCarta.setOnAction(new ColocarCartaHandler(this.carta, this.jugadorActivo));
        menuDeCarta.getItems().add(colocarCarta);

        if (CartaMonstruo.class.isInstance(carta))
            if (jugadorActivo.coloqueMonstruo() || !jugadorActivo.getCampo().puedoColocarMonstruo()) {
            colocarCarta.setDisable(true);
        }
        else if (CartaEspecial.class.isInstance(carta) && !jugadorActivo.getCampo().puedoColocarCartaEspecial()) {
            colocarCarta.setDisable(true);
        }

        return menuDeCarta;
    }

    @Override
    public void handle(MouseEvent event) {
        crearContextMenu().show(vistaCarta, event.getScreenX(), event.getScreenY());
    }
}
