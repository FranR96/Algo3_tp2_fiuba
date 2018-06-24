package Vista;

import javafx.geometry.Pos;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class TableroDeJuego extends HBox {
    private Stage stage;

    public TableroDeJuego(Stage stage) {
        super();
        this.stage = stage;

        Canvas canvas = new Canvas(640, 480);
        GraphicsContext gc = canvas.getGraphicsContext2D();
        String imagePath = "Vista/Imagenes/Tablero-Juego.png";
        Image image = new Image(imagePath);

        gc.drawImage(image, 0, 0, 640, 480);

        HBox tablero = new HBox(canvas);
        tablero.setAlignment(Pos.CENTER);

        this.setAlignment(Pos.CENTER);
        this.getChildren().add(tablero);
    }
}
