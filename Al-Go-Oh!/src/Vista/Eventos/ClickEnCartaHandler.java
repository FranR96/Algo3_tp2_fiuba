package Vista.Eventos;

import Vista.VistaCarta;
import alGoOh.Jugador;
import alGoOh.Tablero;
import cartas.CartaEspecial;
import cartas.CartaMonstruo;
import javafx.event.EventHandler;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.MenuItem;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class ClickEnCartaHandler implements EventHandler<MouseEvent> {
    private VistaCarta vistaCarta;
    private Tablero tablero;
    private Stage stage;
    private Jugador jugadorActivo;

    public ClickEnCartaHandler(VistaCarta vistaCarta, Tablero tablero, Stage stage) {
        this.vistaCarta = vistaCarta;
        this.tablero = tablero;
        this.jugadorActivo = tablero.getJugadorActivo();
        this.stage = stage;
    }

    private ContextMenu crearContextMenu() {
        ContextMenu menuDeCarta = new ContextMenu();
        MenuItem colocarCarta = new MenuItem("Colocar carta");
        colocarCarta.setOnAction(new ColocarCartaHandler(this.vistaCarta, this.jugadorActivo, this.stage));
        menuDeCarta.getItems().add(colocarCarta);

        if (CartaMonstruo.class.isInstance(vistaCarta.getCarta())) {
            if (jugadorActivo.coloqueMonstruo() || !jugadorActivo.getCampo().puedoColocarMonstruo()) {
            colocarCarta.setDisable(true);
            }
        }
        else if (CartaEspecial.class.isInstance(vistaCarta.getCarta()) && !jugadorActivo.getCampo().puedoColocarCartaEspecial()) {
            colocarCarta.setDisable(true);
        }

        return menuDeCarta;
    }

    @Override
    public void handle(MouseEvent event) {
        crearContextMenu().show(vistaCarta, event.getScreenX(), event.getScreenY());
    }
}
