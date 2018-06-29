package Vista;

import Vista.Eventos.BotonCambiarFaseHandler;
import alGoOh.Jugador;
import alGoOh.Tablero;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.*;
import javafx.stage.Stage;

class TableroDeJuego extends HBox {


    TableroDeJuego(Stage stage, Tablero tablero, Jugador jugador1, Jugador jugador2) {
        super();

        GridPane zonaCartasMonstruo = new GridPane();
        zonaCartasMonstruo.getRowConstraints().add(new RowConstraints(107));
        zonaCartasMonstruo.setGridLinesVisible(true);
        zonaCartasMonstruo.setStyle("-fx-padding: 0 0 26px 0");
        setGridConstraintsMonstruo(zonaCartasMonstruo);


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

        Label vida1 = new Label();
        vida1.setText(jugador1.getNombre() + jugador1.getPtsVida()); //+ nombre del jugador
        vida1.getStyleClass().add("botones-inicio");

        Label vida2 = new Label();
        vida2.setText(jugador2.getNombre() + jugador2.getPtsVida()); //+ nombre del jugador
        vida2.getStyleClass().add("botones-inicio");

        VistaVida vistaVida = new VistaVida(vida1, vida2, jugador1, jugador2);
        jugador1.agregarObserverVida(vistaVida);
        jugador2.agregarObserverVida(vistaVida);
        vistaVida.update();

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

        VistaZonaMonstruos vistaZonaMonstruos = new VistaZonaMonstruos(zonaCartasMonstruo, tablero, stage);
        tablero.getJugadorActivo().getCampo().agregarObserverZonaMonstruos(vistaZonaMonstruos);
        tablero.getOponente().getCampo().agregarObserverZonaMonstruos(vistaZonaMonstruos);

        tablero.agregarObserver(vistaMano);
        tablero.agregarObserver(vistaZonaEspecial);
        tablero.agregarObserver(vistaZonaMonstruos);

        Button botonCambiarFase = new Button("Cambiar fase");
        botonCambiarFase.setOnAction(new BotonCambiarFaseHandler(stage, botonCambiarFase, zonaCartasEspeciales, zonaCartasMonstruo, cartasDeMano, tablero));
        botonCambiarFase.getStyleClass().add("botones-inicio");

        botonCambiarFase.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        vida1.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        vida2.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);



        VBox faseYMano = new VBox(botonCambiarFase, vida1, vida2, panelScrolleableDeCartas);
        /*VBox VidaYMano = new VBox();
        VidaYMano.getChildren().add(vida2);
        VidaYMano.getChildren().add(panelScrolleableDeCartas);
        VidaYMano.getChildren().add(vida1);*/

        HBox boxTablero = new HBox(faseYMano, contenedorAux);
        zonaCartasEspeciales.setDisable(true);
        zonaCartasMonstruo.setDisable(true);

        this.setAlignment(Pos.CENTER);
        this.getChildren().add(boxTablero);
    }


    private void setGridConstraintsEspecial(GridPane grid) {

        // Defino el tamanio de cada columna y fila de la grilla sobre la que se colocan las cartas.LogicaCartas
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

        // Defino el tamanio de cada columna y fila de la grilla sobre la que se colocan las cartas.LogicaCartas
        grid.getColumnConstraints().add(new ColumnConstraints(75));
        grid.getColumnConstraints().add(new ColumnConstraints(110));
        grid.getColumnConstraints().add(new ColumnConstraints(110));
        grid.getColumnConstraints().add(new ColumnConstraints(110));
        grid.getColumnConstraints().add(new ColumnConstraints(110));
        grid.getColumnConstraints().add(new ColumnConstraints(110));
        grid.getColumnConstraints().add(new ColumnConstraints(75));
    }
}
