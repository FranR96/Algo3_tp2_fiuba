package Vista.Eventos;

import Vista.PantallaFinDeJuego;
import alGoOh.Jugador;
import alGoOh.Tablero;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

class BotonCambiarDeTurnoHandler implements EventHandler<ActionEvent> {

    private Button botonCambiarTurno;
    private Tablero tablero;
    private GridPane zonaEspeciales;
    private GridPane zonaMonstruos;
    private VBox cartasDeMano;
    private Stage stage;

    public BotonCambiarDeTurnoHandler(Stage stage, Button botonCambiarTurno, Tablero tablero, GridPane zonaCartasEspeciales, GridPane zonaCartasMonstruo, VBox cartasDeMano) {
        this.botonCambiarTurno = botonCambiarTurno;
        this.tablero = tablero;
        this.stage = stage;
        this.zonaEspeciales = zonaCartasEspeciales;
        this.zonaMonstruos = zonaCartasMonstruo;
        this.cartasDeMano = cartasDeMano;
    }

    @Override
    public void handle(ActionEvent event) {
        Jugador ganador = tablero.terminarTurno();
        if (ganador != null) {
            PantallaFinDeJuego finDeJuego = new PantallaFinDeJuego(ganador.getNombre());
            Scene escenaFin = new Scene(finDeJuego, 842, 680);
            escenaFin.getStylesheets().add("Vista/Estilos/estilos.css");
            stage.setScene(escenaFin);
        }

        zonaMonstruos.setDisable(true);
        zonaEspeciales.setDisable(true);
        cartasDeMano.setDisable(false);


        botonCambiarTurno.setText("Cambiar fase");
        botonCambiarTurno.setOnAction(new BotonCambiarFaseHandler(stage, botonCambiarTurno, zonaEspeciales, zonaMonstruos, cartasDeMano, tablero));
    }
}
