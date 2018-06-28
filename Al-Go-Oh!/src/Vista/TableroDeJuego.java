package Vista;

import alGoOh.Jugador;
import alGoOh.Tablero;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

import static javafx.scene.paint.Color.*;


public class TableroDeJuego extends HBox {
    private Stage stage;
    private Jugador jugador1;
    private Jugador jugador2;


    public TableroDeJuego(Stage stage, Tablero tablero, Jugador jugador1, Jugador jugador2) {
        super();
        this.stage = stage;
        this.jugador1 = jugador1;
        this.jugador2 = jugador2;

        Label vida1 = new Label();
        vida1.setText("LIFEPOINTS: " + jugador1.getPtsVida()); //+ nombre del jugador
        vida1.setTextFill(DARKRED);
        vida1.setFont(Font.font ("Verdana",FontWeight.BOLD, 26));

        Label vida2 = new Label();
        vida2.setText("LIFEPOINTS: " + jugador2.getPtsVida()); //+ nombre del jugador
        vida2.setTextFill(DARKRED);
        vida2.setFont(Font.font ("Verdana",FontWeight.BOLD, 26));

        VistaVida vistaVida = new VistaVida(vida1, vida2, jugador1, jugador2);
        jugador1.agregarObserverVida(vistaVida);
        jugador2.agregarObserverVida(vistaVida);
        vistaVida.update();

        GridPane cuadriculaTablero = new GridPane();
        cuadriculaTablero.getStyleClass().add("grilla-tablero");
        cuadriculaTablero.setGridLinesVisible(true);
        this.setGridConstraints(cuadriculaTablero);
        GridPane.setColumnSpan(vida1, 12);
        GridPane.setColumnSpan(vida2, 12);

        cuadriculaTablero.add(vida1, 0,8);
        cuadriculaTablero.add(vida2, 0,0);

        VBox cartasDeMano = new VBox();
        ScrollPane panelScrolleableDeCartas = new ScrollPane();
        panelScrolleableDeCartas.setMinWidth(120);
        panelScrolleableDeCartas.setContent(cartasDeMano);
        VistaMano vistaMano = new VistaMano(cartasDeMano, tablero, stage);

        jugador1.agregarObserverMano(vistaMano);
        jugador2.agregarObserverMano(vistaMano);
        vistaMano.update();

        HBox boxTablero = new HBox(panelScrolleableDeCartas, cuadriculaTablero);

        boxTablero.setAlignment(Pos.CENTER);

        this.setAlignment(Pos.CENTER);
        this.getChildren().add(boxTablero);
    }


    private void setGridConstraints(GridPane grid) {
        grid.setMinWidth(712);
        grid.setMaxWidth(712);
        grid.setMinHeight(680);
        grid.setMaxHeight(680);

        // Defino el tamanio de cada columna y fila de la grilla sobre la que se colocan las cartas
        grid.getColumnConstraints().add(new ColumnConstraints(75));
        grid.getColumnConstraints().add(new ColumnConstraints(19));
        grid.getColumnConstraints().add(new ColumnConstraints(75));
        grid.getColumnConstraints().add(new ColumnConstraints(33));
        grid.getColumnConstraints().add(new ColumnConstraints(75));
        grid.getColumnConstraints().add(new ColumnConstraints(37));
        grid.getColumnConstraints().add(new ColumnConstraints(75));
        grid.getColumnConstraints().add(new ColumnConstraints(36));
        grid.getColumnConstraints().add(new ColumnConstraints(75));
        grid.getColumnConstraints().add(new ColumnConstraints(35));
        grid.getColumnConstraints().add(new ColumnConstraints(74));
        grid.getColumnConstraints().add(new ColumnConstraints(19));
        grid.getColumnConstraints().add(new ColumnConstraints(74));

        grid.getRowConstraints().add(new RowConstraints(45));
        grid.getRowConstraints().add(new RowConstraints(107));
        grid.getRowConstraints().add(new RowConstraints(26));
        grid.getRowConstraints().add(new RowConstraints(107));
        grid.getRowConstraints().add(new RowConstraints(98));
        grid.getRowConstraints().add(new RowConstraints(107));
        grid.getRowConstraints().add(new RowConstraints(26));
        grid.getRowConstraints().add(new RowConstraints(108));
        grid.getRowConstraints().add(new RowConstraints(45));
    }
}
