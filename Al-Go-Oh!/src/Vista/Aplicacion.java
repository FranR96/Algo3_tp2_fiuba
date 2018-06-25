package Vista;

import Vista.Eventos.BotonEscapeHandler;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

import java.io.File;


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

        File f = new File( "Al-Go-Oh!/src/Vista/Sonidos/9fe8a8ba.mp3");
        Media media = new Media(f.toURI().toString());
        MediaPlayer player = new MediaPlayer(media);
        player.setAutoPlay(true);

        TableroDeJuego tableroDeJuego = new TableroDeJuego(stage);
        Scene escenaTablero = new Scene(tableroDeJuego, 722, 690);
        escenaTablero.getStylesheets().add("Vista/Estilos/estilos.css");

        VentanaNombreJugadores ventanaNombreJugadores = new VentanaNombreJugadores(stage, escenaTablero, informacion, tableroDeJuego);
        Scene escenaNombreJugadores = new Scene(ventanaNombreJugadores, 722, 690);
        escenaNombreJugadores.getStylesheets().add("Vista/Estilos/estilos.css");

        VentanaInicio ventanaInicio = new VentanaInicio(stage, escenaNombreJugadores);
        Scene escenaVentanaInicio = new Scene(ventanaInicio, 722, 690);

        escenaVentanaInicio.getStylesheets().add("Vista/Estilos/estilos.css");

        stage.addEventHandler(KeyEvent.KEY_RELEASED, new BotonEscapeHandler(stage));

        stage.setScene(escenaVentanaInicio);
        stage.show();
    }
}
