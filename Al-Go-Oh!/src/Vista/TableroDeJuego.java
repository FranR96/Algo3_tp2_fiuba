package Vista;

import alGoOh.Jugador;
import alGoOh.Tablero;
import javafx.geometry.Pos;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class TableroDeJuego extends HBox {
    private Stage stage;
    private Jugador jugador1;
    private Jugador jugador2;


    public TableroDeJuego(Stage stage, Tablero tablero, Jugador jugador1, Jugador jugador2) {
        super();
        this.stage = stage;
        this.jugador1 = jugador1;
        this.jugador2 = jugador2;

        GridPane cuadriculaTablero = new GridPane();
        cuadriculaTablero.getStyleClass().add("grilla-tablero");
        cuadriculaTablero.setGridLinesVisible(true);
        this.setGridConstraints(cuadriculaTablero);

        VBox cartasDeMano = new VBox();
        ScrollPane panelScrolleableDeCartas = new ScrollPane();
        panelScrolleableDeCartas.setMinWidth(120);
        panelScrolleableDeCartas.setContent(cartasDeMano);
        VistaMano vistaMano = new VistaMano(cartasDeMano, tablero, stage);
        jugador1.agregarObserverMano(vistaMano);
        jugador1.agregarObserverMano(vistaMano);
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
    }
}
