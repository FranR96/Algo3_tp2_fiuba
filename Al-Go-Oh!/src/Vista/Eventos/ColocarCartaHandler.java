package Vista.Eventos;

import Vista.VistaCarta;
import alGoOh.Jugador;
import cartas.CartaMonstruo;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class ColocarCartaHandler implements EventHandler<ActionEvent> {
    private VistaCarta vistaCarta;
    private Jugador jugadorActivo;
    private Stage stage;

    public ColocarCartaHandler(VistaCarta vistaCarta, Jugador jugadorActivo, Stage stage) {
        this.vistaCarta = vistaCarta;
        this.jugadorActivo = jugadorActivo;
        this.stage = stage;
    }

    @Override
    public void handle(ActionEvent event) {
        Stage ventana = new Stage();
        ventana.initOwner(stage);
        ventana.initModality(Modality.APPLICATION_MODAL);
        ventana.setTitle("Colocar carta");

        HBox contenedorOpciones = new HBox(5);

        ChoiceBox<String> elegirLado = new ChoiceBox<>(FXCollections.observableArrayList("Boca Arriba", "Boca Abajo"));
        elegirLado.setValue("Boca Arriba");
        contenedorOpciones.getChildren().add(elegirLado);

        if (CartaMonstruo.class.isInstance(vistaCarta.getCarta())) {
            ChoiceBox<String> elegirPosicion = new ChoiceBox<>(FXCollections.observableArrayList("Ataque", "Defensa"));
            elegirPosicion.setValue("Ataque");
            contenedorOpciones.getChildren().add(elegirPosicion);
        }

        Button botonOK = new Button("Aceptar");
        botonOK.setOnAction(event1 -> ventana.close());

        VBox contenedor = new VBox(5);
        contenedor.setAlignment(Pos.CENTER);
        contenedor.getChildren().addAll(contenedorOpciones, botonOK);
        contenedor.setStyle("-fx-padding: 10px");

        Scene escena = new Scene(contenedor);
        ventana.setScene(escena);
        ventana.showAndWait();
    }
}
