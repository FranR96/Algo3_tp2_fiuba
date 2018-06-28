package Vista;

import Controlador.ClickEnCartaMonstruoHandler;
import alGoOh.cartas.LogicaCartas.CartaMonstruo;
import alGoOh.componentes.Tablero;
import javafx.geometry.HPos;
import javafx.geometry.VPos;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

public class VistaZonaMonstruos implements Observer {

    private GridPane zonaMonstruos;
    private Tablero tablero;
    private Stage stage;

    public VistaZonaMonstruos(GridPane zonaMonstruos, Tablero tablero, Stage stage) {
        this.zonaMonstruos = zonaMonstruos;
        this.tablero = tablero;
        this.stage = stage;
    }

    @Override
    public void update(Observable o, Object arg) {
        zonaMonstruos.getChildren().clear();
        ArrayList<CartaMonstruo> cartasMonstruoEnCampo = tablero.getJugadorActivo().getCampo().monstruosInvocados();

        for (int i = 1; i <= cartasMonstruoEnCampo.size(); i++) {
            CartaMonstruo carta = cartasMonstruoEnCampo.get(i-1);
            Image imagenCarta = new Image("Vista/Imagenes/" + carta.getClass().toString().split("\\.")[1] + ".jpg");
            VistaCarta vistaDeCarta = new VistaCarta(carta);
            vistaDeCarta.setImage(imagenCarta);
            vistaDeCarta.setPreserveRatio(true);
            vistaDeCarta.setSmooth(true);
            vistaDeCarta.setFitHeight(110);
            vistaDeCarta.addEventHandler(MouseEvent.MOUSE_CLICKED, new ClickEnCartaMonstruoHandler(vistaDeCarta, tablero, stage));
            zonaMonstruos.add(vistaDeCarta, i, 0);
            GridPane.setHalignment(vistaDeCarta, HPos.CENTER);
            GridPane.setValignment(vistaDeCarta, VPos.CENTER);
        }
    }
}
