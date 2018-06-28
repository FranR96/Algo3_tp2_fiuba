package Vista;

import alGoOh.Jugador;
import alGoOh.Tablero;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
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

        GridPane zonaCartasMonstruo = new GridPane();
        zonaCartasMonstruo.getRowConstraints().add(new RowConstraints(107));
        zonaCartasMonstruo.setGridLinesVisible(true);
        zonaCartasMonstruo.setStyle("-fx-padding: 0 0 26px 0");
        setGridConstraintsMonstruo(zonaCartasMonstruo);

        Image imagenCarta = new Image("Vista/Imagenes/AbismoReluciente.jpg");
        VistaCarta vistaDeCarta = new VistaCarta(null);
        vistaDeCarta.setImage(imagenCarta);
        vistaDeCarta.setPreserveRatio(true);
        vistaDeCarta.setFitHeight(110);

        zonaCartasMonstruo.add(vistaDeCarta, 1, 0);
        GridPane.setHalignment(vistaDeCarta, HPos.CENTER);
        GridPane.setValignment(vistaDeCarta, VPos.CENTER);
        vistaDeCarta.setSmooth(true);
        vistaDeCarta.setRotate(90);


        GridPane zonaCartasEspeciales = new GridPane();
        zonaCartasEspeciales.getRowConstraints().add(new RowConstraints(107));
        zonaCartasEspeciales.setGridLinesVisible(true);
        setGridConstraintsEspecial(zonaCartasEspeciales);

        VBox zonaCartas = new VBox(zonaCartasMonstruo, zonaCartasEspeciales);
        zonaCartas.setMaxWidth(712);
        zonaCartas.setMinWidth(712);
        zonaCartas.setMaxHeight(241);
        zonaCartas.setMinHeight(241);
        zonaCartas.setStyle("-fx-padding: 0 0 0 5px");


        VBox zonaTablero = new VBox(zonaCartas);
        zonaTablero.setAlignment(Pos.BOTTOM_CENTER);
        zonaTablero.setMinHeight(624);
        zonaTablero.setMaxHeight(624);
        zonaTablero.setMinWidth(712);
        zonaTablero.setMaxWidth(712);

        VBox contenedorAux = new VBox(zonaTablero);
        contenedorAux.setAlignment(Pos.TOP_CENTER);
        contenedorAux.setMinHeight(680);
        contenedorAux.setMaxHeight(680);
        contenedorAux.setMinWidth(712);
        contenedorAux.setMaxWidth(712);
        contenedorAux.getStyleClass().add("grilla-tablero");

        VBox cartasDeMano = new VBox();
        ScrollPane panelScrolleableDeCartas = new ScrollPane();
        panelScrolleableDeCartas.setMinWidth(120);
        panelScrolleableDeCartas.setContent(cartasDeMano);
        VistaMano vistaMano = new VistaMano(cartasDeMano, tablero, stage);
        jugador1.agregarObserverMano(vistaMano);
        jugador2.agregarObserverMano(vistaMano);
        vistaMano.update();

        VistaZonaEspecial vistaZonaEspecial = new VistaZonaEspecial(zonaCartasEspeciales, tablero);
        tablero.getJugadorActivo().getCampo().agregarObserverZonaEspecial(vistaZonaEspecial);
        tablero.getOponente().getCampo().agregarObserverZonaEspecial(vistaZonaEspecial);

        HBox boxTablero = new HBox(panelScrolleableDeCartas, contenedorAux);


        this.setAlignment(Pos.CENTER);
        this.getChildren().add(boxTablero);
    }


    private void setGridConstraintsEspecial(GridPane grid) {

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
        grid.getColumnConstraints().add(new ColumnConstraints(73));

        /*grid.getRowConstraints().add(new RowConstraints(45));
        grid.getRowConstraints().add(new RowConstraints(107));
        grid.getRowConstraints().add(new RowConstraints(26));
        grid.getRowConstraints().add(new RowConstraints(107));
        grid.getRowConstraints().add(new RowConstraints(98));
        grid.getRowConstraints().add(new RowConstraints(107));
        grid.getRowConstraints().add(new RowConstraints(26));
        grid.getRowConstraints().add(new RowConstraints(108));*/
    }

    private void setGridConstraintsMonstruo(GridPane grid) {

        // Defino el tamanio de cada columna y fila de la grilla sobre la que se colocan las cartas
        grid.getColumnConstraints().add(new ColumnConstraints(75));
        grid.getColumnConstraints().add(new ColumnConstraints(110));
        grid.getColumnConstraints().add(new ColumnConstraints(110));
        grid.getColumnConstraints().add(new ColumnConstraints(110));
        grid.getColumnConstraints().add(new ColumnConstraints(110));
        grid.getColumnConstraints().add(new ColumnConstraints(110));
        grid.getColumnConstraints().add(new ColumnConstraints(75));

    }
}
