package Vista.Eventos;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.File;

public class BotonComenzarJuegoHandler implements EventHandler<ActionEvent> {

    private Stage stage;
    private Scene proximaEscena;
    private MediaPlayer player;

    public BotonComenzarJuegoHandler(Stage stage, Scene proximaEscena, MediaPlayer player) {
        this.stage = stage;
        this.proximaEscena = proximaEscena;
        this.player = player;
    }
    @Override
    public void handle(ActionEvent event) {
        // Efecto de transicion luego de la pantalla de inicio
        Timeline timeline = new Timeline();
        KeyFrame key = new KeyFrame(Duration.millis(1300), new KeyValue(stage.getScene().getRoot().opacityProperty(), 0.1));
        timeline.getKeyFrames().add(key);
        timeline.setOnFinished((ae) -> stage.setScene(proximaEscena));
        timeline.play();

        File f = new File( "Al-Go-Oh!/src/Vista/Sonidos/30493c7c.mp3");
        Media media = new Media(f.toURI().toString());
        player.stop();
        player = new MediaPlayer(media);
        player.setAutoPlay(true);
        player.setVolume(0.2);
        player.setCycleCount(MediaPlayer.INDEFINITE);
    }
}
