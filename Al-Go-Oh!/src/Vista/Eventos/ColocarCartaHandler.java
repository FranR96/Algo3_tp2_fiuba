package Vista.Eventos;

import Vista.VistaCarta;
import alGoOh.Jugador;
import cartas.*;
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

import java.util.HashMap;

public class ColocarCartaHandler implements EventHandler<ActionEvent> {
    private VistaCarta vistaCarta;
    private Jugador jugadorActivo;
    private Stage stage;
    private Carta carta;

    public ColocarCartaHandler(VistaCarta vistaCarta, Jugador jugadorActivo, Stage stage) {
        this.vistaCarta = vistaCarta;
        this.jugadorActivo = jugadorActivo;
        this.stage = stage;
        this.carta = vistaCarta.getCarta();
    }

    @Override
    public void handle(ActionEvent event) {
        if (CartaTrampa.class.isInstance(carta)) {
            jugadorActivo.getCampo().colocarCarta((CartaTrampa)carta, new BocaAbajo());
        }
        else {
            Stage ventana = new Stage();
            ventana.initOwner(stage);
            ventana.initModality(Modality.APPLICATION_MODAL);
            ventana.setTitle("Colocar carta");

            HBox contenedorOpciones = new HBox(5);

            ChoiceBox<String> elegirLado = new ChoiceBox<>(FXCollections.observableArrayList("Boca Arriba", "Boca Abajo"));
            elegirLado.setValue("Boca Arriba");
            contenedorOpciones.getChildren().add(elegirLado);

            // Inicializo para poder chequear despues, pero no agrego nada
            HashMap<String, PosicionCarta> posiciones = new HashMap<>();
            ChoiceBox<String> elegirPosicion = null;

            if (CartaMonstruo.class.isInstance(vistaCarta.getCarta())) {
                posiciones.put("Ataque", new PosicionAtaque());
                posiciones.put("Defensa", new PosicionDefensa());

                elegirPosicion = new ChoiceBox<>(FXCollections.observableArrayList("Ataque", "Defensa"));
                elegirPosicion.setValue("Ataque");
                contenedorOpciones.getChildren().add(elegirPosicion);
            }

            HashMap<String, LadoCarta> lados = new HashMap<>();
            lados.put("Boca Arriba", new BocaArriba());
            lados.put("Boca Abajo", new BocaAbajo());

            Button botonOK = new Button("Aceptar");
            ChoiceBox<String> finalElegirPosicion = elegirPosicion; // Java se queja sino hago esto

            botonOK.setOnAction(event1 -> {
                if (posiciones.isEmpty()) {
                    colocarEnZonaEspecial(lados.get(elegirLado.getValue()));
                }
                else {
                    jugadorActivo.getCampo().colocarCarta((CartaMonstruo) carta, posiciones.get(finalElegirPosicion.getValue()), lados.get(elegirLado.getValue()));

                }
                ventana.close();
            });

            VBox contenedor = new VBox(5);
            contenedor.setAlignment(Pos.CENTER);
            contenedor.getChildren().addAll(contenedorOpciones, botonOK);
            contenedor.setStyle("-fx-padding: 10px");

            Scene escena = new Scene(contenedor);
            ventana.setScene(escena);
            ventana.showAndWait();
        }
    }

    private void colocarEnZonaEspecial(LadoCarta ladoCarta) {
        if (CartaMagica.class.isInstance(carta)) {
            jugadorActivo.getCampo().colocarCarta((CartaMagica) carta, ladoCarta);
        }

        else {
            jugadorActivo.getCampo().colocarCarta((CartaCampo) carta, ladoCarta);

        }
    }
}
