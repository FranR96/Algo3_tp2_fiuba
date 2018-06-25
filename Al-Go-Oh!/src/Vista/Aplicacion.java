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

        InfoContainer informacion = new InfoContainer();

        TableroDeJuego tableroDeJuego = new TableroDeJuego(stage);
        Scene escenaTablero = new Scene(tableroDeJuego, 712, 680);
        escenaTablero.getStylesheets().add("Vista/Estilos/estilos.css");

        VentanaNombreJugadores ventanaNombreJugadores = new VentanaNombreJugadores(stage, escenaTablero, informacion, tableroDeJuego);
        Scene escenaNombreJugadores = new Scene(ventanaNombreJugadores, 712, 680);
        escenaNombreJugadores.getStylesheets().add("Vista/Estilos/estilos.css");

        VentanaInicio ventanaInicio = new VentanaInicio(stage, escenaNombreJugadores);
        Scene escenaVentanaInicio = new Scene(ventanaInicio, 712, 680);
        escenaVentanaInicio.getStylesheets().add("Vista/Estilos/estilos.css");

        stage.addEventHandler(KeyEvent.KEY_RELEASED, new BotonEscapeHandler(stage));

        stage.setScene(escenaVentanaInicio);
        stage.show();
    }
}
