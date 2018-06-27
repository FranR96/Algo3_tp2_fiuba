package Vista;

import alGoOh.Jugador;
import alGoOh.Tablero;
import cartas.Carta;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;


public class VistaMano {
    private VBox vistaDeCartas;
    private Tablero tablero;

    public VistaMano(VBox vistaDeCartas, Tablero tablero) {
        this.vistaDeCartas = vistaDeCartas;
        this.tablero = tablero;
    }

    public void update() {
        vistaDeCartas.getChildren().clear();
        Jugador jugadorActivo = tablero.getJugadorActivo();

        for (Carta carta: jugadorActivo.cartasEnLaMano()) {
            Image imagenCarta = new Image("Vista/Imagenes/" + carta.getClass().toString().split("\\.")[1] + ".jpg");
            ImageView vistaDeCarta = new ImageView(imagenCarta);
            vistaDeCarta.setPreserveRatio(true);
            vistaDeCarta.setFitWidth(100);
            vistaDeCartas.getChildren().add(vistaDeCarta);
        }
    }

}
