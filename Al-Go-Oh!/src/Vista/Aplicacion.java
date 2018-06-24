package Vista;

import Vista.Eventos.BotonEscapeHandler;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;



public class Aplicacion extends Application
{
    public static void main(String[] args)
    {
        Application.launch(args);
    }
    @Override
    public void start(Stage stage)
    {
        stage.setTitle("Al-Go-Oh!");

        TableroDeJuego tableroDeJuego = new TableroDeJuego(stage);
        Scene escenaTablero = new Scene(tableroDeJuego, 640, 480);

        VentanaInicio ventanaInicio = new VentanaInicio(stage, escenaTablero);
        Scene escenaVentanaInicio = new Scene(ventanaInicio, 640, 480);
        escenaVentanaInicio.getStylesheets().add("file:src/estilos/estilos.css");

        stage.addEventHandler(KeyEvent.KEY_RELEASED, new BotonEscapeHandler(stage));

        stage.setScene(escenaVentanaInicio);
        stage.show();
    }
}
