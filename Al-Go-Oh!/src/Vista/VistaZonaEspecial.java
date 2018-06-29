package Vista;

import Vista.Eventos.ClickEnCartaEspecialHandler;
import cartas.CartaEspecial;
import alGoOh.Tablero;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

class VistaZonaEspecial implements Observer {

    private GridPane zonaEspecial;
    private Tablero tablero;

    public VistaZonaEspecial(GridPane zonaEspecial, Tablero tablero) {
        this.zonaEspecial = zonaEspecial;
        this.tablero = tablero;
    }
    @Override
    public void update(Observable o, Object arg) {
        zonaEspecial.getChildren().clear();
        ArrayList<CartaEspecial> cartasEspecialesEnCampo = tablero.getJugadorActivo().getCampo().zonaEspecial();

        for (int i = 0; i < cartasEspecialesEnCampo.size(); i++) {
            CartaEspecial carta = cartasEspecialesEnCampo.get(i);
            Image imagenCarta = new Image("Vista/Imagenes/" + carta.getClass().toString().split("\\.")[1] + ".jpg");
            VistaCarta vistaDeCarta = new VistaCarta(carta);
            vistaDeCarta.setImage(imagenCarta);
            vistaDeCarta.setPreserveRatio(true);
            vistaDeCarta.setSmooth(true);
            vistaDeCarta.setFitHeight(110);
            vistaDeCarta.addEventHandler(MouseEvent.MOUSE_CLICKED, new ClickEnCartaEspecialHandler(vistaDeCarta));
            zonaEspecial.add(vistaDeCarta, 2*(i+1), 0);
        }
    }

}
