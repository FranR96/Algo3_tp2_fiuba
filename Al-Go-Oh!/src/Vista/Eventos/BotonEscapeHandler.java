package Vista.Eventos;

import javafx.event.EventHandler;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

public class BotonEscapeHandler implements EventHandler<KeyEvent> {
    private Stage stage;

    public BotonEscapeHandler(Stage stage) {
        this.stage = stage;
    }

    @Override
    public void handle(KeyEvent event) {
        stage.close();
    }
}
