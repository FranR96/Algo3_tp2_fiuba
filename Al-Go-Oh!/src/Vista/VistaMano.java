package Vista;

import Vista.Eventos.ClickEnCartaHandler;
import cartas.Carta;
import alGoOh.Jugador;
import alGoOh.Tablero;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.Observable;
import java.util.Observer;


class VistaMano implements Observer {
    private VBox vistaDeCartas;
    private Tablero tablero;
    private Stage stage;

    public VistaMano(VBox vistaDeCartas, Tablero tablero, Stage stage) {
        this.vistaDeCartas = vistaDeCartas;
        this.tablero = tablero;
        this.stage = stage;
    }

    public void update() {
        vistaDeCartas.getChildren().clear();
        Jugador jugadorActivo = tablero.getJugadorActivo();

        for (Carta carta: jugadorActivo.cartasEnLaMano()) {
            Image imagenCarta = new Image("Vista/Imagenes/" + carta.getClass().toString().split("\\.")[1] + ".jpg");
            VistaCarta vistaDeCarta = new VistaCarta(carta);
            vistaDeCarta.setImage(imagenCarta);
            vistaDeCarta.setPreserveRatio(true);
            vistaDeCarta.setFitWidth(100);
            vistaDeCarta.addEventHandler(MouseEvent.MOUSE_CLICKED, new ClickEnCartaHandler(vistaDeCarta, tablero, stage));
            vistaDeCartas.getChildren().add(vistaDeCarta);
        }
    }

    @Override
    public void update(Observable o, Object arg) {
        this.update();
    }
}
