package Vista;

import javafx.geometry.Point2D;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class VentanaNombreJugadores extends VBox {

    public VentanaNombreJugadores(Stage stage, Scene escenaProxima, InfoContainer info, TableroDeJuego tablero) {
        super();

        Label ingresarNombre = new Label();
        ingresarNombre.setText("Ingrese un nombre para el primer jugador");
        ingresarNombre.setTextFill(Color.web("#FFFFFF"));

        TextField obtenerNombre = new TextField();
        obtenerNombre.setPromptText("Escribe aqui:");

        Button botonEnviar = new Button();
        botonEnviar.setText("Enviar");
        botonEnviar.getStyleClass().add("botones-inicio");
        botonEnviar.setOnAction(event -> { // Este codigo monstruoso guarda el input de los dos nombres y cambia el scene
            if (obtenerNombre.getText().trim().equals("")) {
                mostrarToolTip(stage, obtenerNombre, "Nombre no valido");
            }
            else {
                info.setNombreJugador1(obtenerNombre.getText());
                ingresarNombre.setText("Ingrese un nombre para el segundo jugador");
                obtenerNombre.setText("");
                botonEnviar.setOnAction(event1 -> {
                    if (obtenerNombre.getText().trim().equals("")) {
                        mostrarToolTip(stage, obtenerNombre, "Nombre no valido");
                    }
                    else {
                        info.setNombreJugador2(obtenerNombre.getText());
                        obtenerNombre.setText("");
                        obtenerNombre.requestFocus();
                        tablero.actualizarInfo(info);
                        stage.setScene(escenaProxima);
                    }
                });
            }
        });


        HBox containerIngresarNombre = new HBox(ingresarNombre, obtenerNombre);
        containerIngresarNombre.setSpacing(20);
        containerIngresarNombre.setAlignment(Pos.CENTER);

        VBox caja = new VBox(containerIngresarNombre, botonEnviar);
        caja.getStyleClass().add("ventana-inicio");
        caja.setAlignment(Pos.CENTER);
        caja.setMaxWidth(500);

        this.getChildren().add(caja);
        this.setSpacing(10);
        this.setAlignment(Pos.CENTER);
        this.getStyleClass().add("ventana-inicio");
    }

    public static void mostrarToolTip(Stage owner, Control control, String tooltipText) {
        Point2D p = control.localToScene(0.0, 0.0);

        final Tooltip customTooltip = new Tooltip();
        customTooltip.setText(tooltipText);
        customTooltip.getStyleClass().add("tooltip");

        control.setTooltip(customTooltip);
        customTooltip.setAutoHide(true);

        customTooltip.show(owner, p.getX()
                + control.getScene().getX() + control.getScene().getWindow().getX(), p.getY()
                + control.getScene().getY() + control.getScene().getWindow().getY() + control.getHeight());
    }
}
