package Vista.Eventos;

import Vista.VistaCarta;
import cartas.CartaMonstruo;
import alGoOh.Tablero;
import javafx.event.EventHandler;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.MenuItem;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class ClickEnCartaMonstruoHandler implements EventHandler<MouseEvent> {

    private VistaCarta vistaCarta;
    private CartaMonstruo cartaMonstruo;
    private Tablero tablero;
    private Stage stage;

    public ClickEnCartaMonstruoHandler(VistaCarta vistaCarta, Tablero tablero, Stage stage) {
        this.vistaCarta = vistaCarta;
        this.cartaMonstruo = (CartaMonstruo)vistaCarta.getCarta();
        this.tablero = tablero;
        this.stage = stage;
    }

    @Override
    public void handle(MouseEvent event) {
        ContextMenu menuDeCarta = new ContextMenu();
        MenuItem voltearCarta = new MenuItem("Voltear");
        MenuItem girarCarta = new MenuItem("Cambiar posicion");
        MenuItem atacar = new MenuItem("Atacar");
        menuDeCarta.getItems().add(atacar);
        menuDeCarta.getItems().add(voltearCarta);
        menuDeCarta.getItems().add(girarCarta);

        if (!cartaMonstruo.estaBocaAbajo()) {
            voltearCarta.setDisable(true);
        }
        else {
            atacar.setDisable(true);
        }

        if (this.cartaMonstruo.getCampo().monstruoYaAtaco(this.cartaMonstruo)) {
            atacar.setDisable(true);
        }

        voltearCarta.setOnAction(event1 -> cartaMonstruo.voltear());
        girarCarta.setOnAction(event1 -> cartaMonstruo.cambiarPosicion());
        atacar.setOnAction(new BotonAtacarHandler(vistaCarta, tablero, stage));

        menuDeCarta.show(vistaCarta, event.getScreenX(), event.getScreenY());



    }
}
