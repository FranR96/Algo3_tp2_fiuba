package Vista;

import javafx.geometry.Pos;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

public class PantallaFinDeJuego extends StackPane {

    private String ganador;

    public PantallaFinDeJuego(String ganador) {
        this.ganador = ganador;
        generarPantalla();
    }

    private void generarPantalla() {
        Button botonGanador = new Button("Fin del juego, el ganador es " + this.ganador);
        botonGanador.setTextFill(Color.web("#FFFFFF"));
        botonGanador.getStyleClass().add("botones-inicio");

        Canvas canvas = new Canvas(600, 250);

        GraphicsContext gc = canvas.getGraphicsContext2D();
        String imagePath = "Vista/Imagenes/GameOver.png";
        Image image = new Image(imagePath);

        gc.drawImage(image, 0, 0, 600, 250);

        HBox logo = new HBox(canvas);
        logo.setAlignment(Pos.CENTER);

        VBox cajaPrincipal = new VBox(logo, botonGanador);
        cajaPrincipal.setSpacing(20);
        cajaPrincipal.setAlignment(Pos.CENTER);

        this.setAlignment(Pos.CENTER);
        this.getChildren().add(cajaPrincipal);
        this.getStyleClass().add("ventana-inicio");
    }
}
