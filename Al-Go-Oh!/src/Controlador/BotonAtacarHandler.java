package Controlador;

import Vista.VistaCarta;
import alGoOh.cartas.LogicaCartas.CartaMonstruo;
import alGoOh.componentes.Tablero;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.util.HashMap;

public class BotonAtacarHandler implements EventHandler<ActionEvent> {

    private Tablero tablero;
    private VistaCarta vistaCarta;
    private CartaMonstruo cartaMonstruo;
    private Stage stage;

    public BotonAtacarHandler(VistaCarta vistaCarta, Tablero tablero, Stage stage) {
        this.tablero = tablero;
        this.vistaCarta = vistaCarta;
        this.stage = stage;
        this.cartaMonstruo = (CartaMonstruo)vistaCarta.getCarta();
    }

    @Override
    public void handle(ActionEvent event) {
        Stage ventana = new Stage();
        ventana.initOwner(stage);
        ventana.initModality(Modality.APPLICATION_MODAL);
        ventana.setTitle("Atacar");

        HBox contenedorOpciones = new HBox(5);

        ChoiceBox<String> elegirOponente = new ChoiceBox<>();
        HashMap<String, CartaMonstruo> monstruoAAtacar = new HashMap<>();
        for (CartaMonstruo monstruo: tablero.getOponente().getCampo().monstruosInvocados()) {
            String nombreMonstruo = monstruo.getClass().toString().split("\\.")[1];
            if (monstruo.estaBocaAbajo()) {
                nombreMonstruo = "Monstruo boca abajo";
            }
            elegirOponente.getItems().add(nombreMonstruo);
            monstruoAAtacar.put(nombreMonstruo, monstruo);
        }

        contenedorOpciones.getChildren().add(elegirOponente);

        Button botonAtacar = new Button("Atacar!");

        botonAtacar.setOnAction(event1 -> {
            cartaMonstruo.atacar(monstruoAAtacar.get(elegirOponente.getValue()));
            ventana.close();
        });

        HBox contenedorMonstruosLabel = new HBox(5);
        contenedorMonstruosLabel.setAlignment(Pos.CENTER);
        contenedorMonstruosLabel.getChildren().addAll(contenedorOpciones, new Label("Atk: 100  Def 200"));
        contenedorMonstruosLabel.setStyle("-fx-padding: 10px");

        VBox contenedor = new VBox(contenedorMonstruosLabel, botonAtacar);
        contenedor.setSpacing(10);
        contenedor.setAlignment(Pos.CENTER);

        Scene escena = new Scene(contenedor);
        ventana.setScene(escena);
        ventana.showAndWait();
    }
}
