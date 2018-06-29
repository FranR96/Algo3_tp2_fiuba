package Vista.Eventos;

import Vista.VistaCarta;
import cartas.CartaTrampa;
import javafx.event.EventHandler;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.MenuItem;
import javafx.scene.input.MouseEvent;

public class ClickEnCartaEspecialHandler implements EventHandler<MouseEvent> {

    private VistaCarta vistaCarta;

    public ClickEnCartaEspecialHandler(VistaCarta vistaCarta) {
        this.vistaCarta = vistaCarta;
    }
    @Override
    public void handle(MouseEvent event) {
        ContextMenu menuDeCarta = new ContextMenu();
        MenuItem voltearCarta = new MenuItem("Voltear carta");
        voltearCarta.setOnAction(event1 -> vistaCarta.getCarta().voltear());
        menuDeCarta.getItems().add(voltearCarta);
        if (CartaTrampa.class.isInstance(vistaCarta.getCarta())) {
            voltearCarta.setDisable(true);
        }

        menuDeCarta.show(vistaCarta, event.getScreenX(), event.getScreenY());
    }

}
