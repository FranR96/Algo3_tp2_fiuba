package Vista.Eventos;

import alGoOh.Tablero;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class BotonCambiarFaseHandler implements EventHandler<ActionEvent> {

    private Button botonCambiarFase;
    private GridPane zonaEspeciales;
    private GridPane zonaMonstruos;
    private VBox cartasDeMano;
    private Tablero tablero;
    private Stage stage;

    public BotonCambiarFaseHandler(Stage stage, Button botonCambiarFase, GridPane zonaCartasEspeciales, GridPane zonaCartasMonstruo, VBox cartasDeMano, Tablero tablero) {
        this.botonCambiarFase = botonCambiarFase;
        this.zonaEspeciales = zonaCartasEspeciales;
        this.zonaMonstruos = zonaCartasMonstruo;
        this.cartasDeMano = cartasDeMano;
        this.tablero = tablero;
        this.stage = stage;
    }

    @Override
    public void handle(ActionEvent event) {
        zonaMonstruos.setDisable(false);
        zonaEspeciales.setDisable(false);
        cartasDeMano.setDisable(true);

        botonCambiarFase.setText("Cambiar de turno");
        botonCambiarFase.setOnAction(new BotonCambiarDeTurnoHandler(stage, botonCambiarFase, tablero, zonaEspeciales, zonaMonstruos, cartasDeMano));
    }
}
