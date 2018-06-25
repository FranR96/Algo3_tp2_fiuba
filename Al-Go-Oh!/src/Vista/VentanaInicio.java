package Vista;

import Vista.Eventos.BotonComenzarJuegoHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.control.Button;
import javafx.stage.Stage;


public class VentanaInicio extends HBox
{
    private Stage stage;

    public VentanaInicio(Stage stage, Scene proximaEscena) {

        super();

        this.stage = stage;

        Canvas canvas = new Canvas(500, 350);

        GraphicsContext gc = canvas.getGraphicsContext2D();
        String imagePath = "Vista/Imagenes/Al-Go-Oh-Logo.png";
        Image image = new Image(imagePath);

        gc.drawImage(image, 0, 0, 500, 350);

        HBox logo = new HBox(canvas);
        logo.setAlignment(Pos.CENTER);

        Button comenzarJuego = new Button();
        comenzarJuego.setText("Comenzar Partida");
        comenzarJuego.getStyleClass().add("botones-inicio");
        comenzarJuego.setOnAction(new BotonComenzarJuegoHandler(stage, proximaEscena));

        Button salir = new Button();
        salir.setText("Salir");
        salir.getStyleClass().add("botones-inicio");
        salir.setOnAction(event -> stage.close());

        // Para que los botones ocupen el ancho de el contenedor botonesInicioFin
        comenzarJuego.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        salir.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);

        VBox botonesInicioFin = new VBox(comenzarJuego, salir);
        botonesInicioFin.setSpacing(10);
        botonesInicioFin.setAlignment(Pos.CENTER);
        botonesInicioFin.setMaxWidth(180);

        VBox cajaPrincipal = new VBox(logo, botonesInicioFin);
        cajaPrincipal.setSpacing(20);
        cajaPrincipal.setAlignment(Pos.CENTER);

        this.setAlignment(Pos.CENTER);
        this.getChildren().add(cajaPrincipal);

        this.getStyleClass().add("ventana-inicio");
    }
}
