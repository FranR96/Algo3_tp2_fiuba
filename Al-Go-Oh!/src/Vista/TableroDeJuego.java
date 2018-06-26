package Vista;

import alGoOh.Jugador;
import javafx.geometry.Pos;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class TableroDeJuego extends HBox {
    private Stage stage;
    private Label jugador1;
    private Label jugador2;


    public TableroDeJuego(Stage stage) {
        super();
        this.stage = stage;
        this.jugador1 = new Label();
        this.jugador2 = new Label();

        GridPane cuadriculaTablero = new GridPane();
        cuadriculaTablero.getStyleClass().add("grilla-tablero");
        cuadriculaTablero.setGridLinesVisible(true);
        this.setGridConstraints(cuadriculaTablero);

        jugador1.getStyleClass().add("nombre-usuario");
        jugador2.getStyleClass().add("nombre-usuario");

        HBox tablero = new HBox(cuadriculaTablero);

        tablero.setAlignment(Pos.CENTER);

        this.setAlignment(Pos.CENTER);
        this.getChildren().add(tablero);
    }

    public void actualizarInfo(Jugador jugador1, Jugador jugador2) {
        this.jugador1.setText(jugador1.getNombre());
        this.jugador2.setText(jugador2.getNombre());
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
