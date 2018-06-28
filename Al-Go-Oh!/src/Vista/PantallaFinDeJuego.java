package Vista;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

public class PantallaFinDeJuego extends StackPane {

    private String ganador;

    public PantallaFinDeJuego(String ganador) {
        this.ganador = ganador;
        generarPantalla();
    }

    private void generarPantalla() {
        Label nombreGanador = new Label("Fin del juego, el ganador es " + this.ganador);
        VBox contenedor = new VBox(nombreGanador);
        contenedor.setAlignment(Pos.CENTER);
        this.getChildren().add(contenedor);
        this.setAlignment(Pos.CENTER);
        contenedor.getStyleClass().add("botones-inicio");
        this.getStyleClass().add("ventana-inicio");
        this.setMaxHeight(680);
        this.minHeight(680);
        this.maxWidth(842);
        this.minWidth(842);
    }
}
