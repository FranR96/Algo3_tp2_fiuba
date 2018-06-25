package Vista;

import javafx.geometry.Pos;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class TableroDeJuego extends HBox {
    private Stage stage;
    private Label jugador1;
    private Label jugador2;

    public TableroDeJuego(Stage stage) {
        super();
        this.stage = stage;
        this.jugador1 = new Label();
        this.jugador2 = new Label();

        Canvas canvas = new Canvas(712, 680);
        GraphicsContext gc = canvas.getGraphicsContext2D();
        String imagePath = "Vista/Imagenes/Tablero_de_juego.jpg";
        Image image = new Image(imagePath);

        gc.drawImage(image, 0, 0, 712, 680);

        HBox tablero = new HBox(canvas, jugador1, jugador2);
        tablero.setAlignment(Pos.CENTER);

        this.setAlignment(Pos.CENTER);
        this.getChildren().add(tablero);
    }

    public void actualizarInfo(InfoContainer informacion) {
        this.jugador1.setText(informacion.getNombreJugador1());
        this.jugador2.setText(informacion.getNombreJugador2());
    }
}
