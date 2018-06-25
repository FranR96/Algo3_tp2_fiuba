package Vista.Eventos;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.util.Duration;

public class BotonComenzarJuegoHandler implements EventHandler<ActionEvent> {

    private Stage stage;
    private Scene proximaEscena;

    public BotonComenzarJuegoHandler(Stage stage, Scene proximaEscena) {
        this.stage = stage;
        this.proximaEscena = proximaEscena;
    }
    @Override
    public void handle(ActionEvent event) {
        // Efecto de transicion luego de la pantalla de inicio
        Timeline timeline = new Timeline();
        KeyFrame key = new KeyFrame(Duration.millis(1300), new KeyValue(stage.getScene().getRoot().opacityProperty(), 0.1));
        timeline.getKeyFrames().add(key);
        timeline.setOnFinished((ae) -> stage.setScene(proximaEscena));
        timeline.play();
    }
}
