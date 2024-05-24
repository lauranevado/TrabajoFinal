package com.example.pruebafinal_.intento1;

import com.example.pruebafinal_.intento1.grafo.Grafo;
import com.example.pruebafinal_.intento1.grafo.Arista;
import com.example.pruebafinal_.intento1.grafo.Vertice;
import com.example.pruebafinal_.intento1.grafo.Camino;
import com.example.pruebafinal_.intento1.Listas.ListaSimple;


import com.example.pruebafinal_.intento1.Listas.ListaEnlazada;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.beans.property.IntegerProperty;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import javafx.util.Duration;

import java.util.Random;

import java.net.URL;
import java.util.ResourceBundle;


import static com.example.pruebafinal_.intento1.JuegoDeLaVida.cargarObjetoDesdeArchivo;
import static com.example.pruebafinal_.intento1.JuegoDeLaVida.guardarPartidaEnArchivo;
import static com.example.pruebafinal_.intento1.ParametrosProperties.*;
import static com.example.pruebafinal_.intento1.Tablero.*;

import com.example.pruebafinal_.intento1.grafo.*;


public class TableroControllers implements Initializable {

    //Necesitamos
    private TableroProperties modelo;
    private Stage scene;


    //Asociadas a la vista
    @FXML
    private GridPane tableroJuego;

    @FXML
    private GridPane informacionGridPane;



    private Timeline control;


    private static Celdas celdasDatos = new Celdas();
    private static CeldasProperties celdasCompartir = new CeldasProperties(celdasDatos);


    //quitar; no pueden ser atributos
    private IntegerProperty valorAltura = alturaProperty();
    private IntegerProperty valorLado = ladoProperty();




    private Grafo<Integer> grafo = new Grafo<>();
    //grafo =creamosGrafo2();


    public Grafo creamosGrafo2() {////Necesitaremos la celda en la cual se encuentra el individuo
        Grafo<Integer> grafo = new Grafo<>();
        for (int i = 0; i < ladoProperty().intValue(); i++) {
            for (int j = 0; j < alturaProperty().intValue(); j++) {
                int celdaActual = celdas.getElemento(getPosCelda(i, j)).getData().getIdentificadorCelda();
                Vertice v1 = new Vertice<>(celdaActual);
                grafo.addVertices(v1);

                if (i > 0) {
                    int celdaAdy = celdas.getElemento(getPosCelda(i - 1, j)).getData().getIdentificadorCelda();
                    Vertice v2 = new Vertice<>(celdaAdy);
                    grafo.addArco(new Arista<>(v1, v2, 1));

                }
                if (j > 0) {
                    int celdaAdy = celdas.getElemento(getPosCelda(i, j - 1)).getData().getIdentificadorCelda();
                    Vertice v2 = new Vertice<>(celdaAdy);
                    grafo.addArco(new Arista<>(v1, v2, 1));
                }
                if (j > 0 && i > 0) {
                    int celdaAdy = celdas.getElemento(getPosCelda(i - 1, j - 1)).getData().getIdentificadorCelda();
                    Vertice v2 = new Vertice<>(celdaAdy);
                    grafo.addArco(new Arista<>(v1, v2, 1));
                }
                if (i > 0 && j < alturaProperty().getValue() - 1) {
                    int celdaAdy = celdas.getElemento(getPosCelda(i - 1, j + 1)).getData().getIdentificadorCelda();
                    Vertice v2 = new Vertice<>(celdaAdy);
                    grafo.addArco(new Arista<>(v1, v2, 1));
                }
            }
        }
        return grafo;
    }
    // Los vértices no los metemos directamente, sino que nos quedamos con ellos en variables


    // Los vértices no los metemos directamente, sino que nos quedamos con ellos en variables
    // para poder jugar después.
//    Vertice<String> v1 = new Vertice<>("A");
//    Vertice<String> v2 = new Vertice<>("B");
//    Vertice<String> v3 = new Vertice<>("C");
//    Vertice<String> v4 = new Vertice<>("D");
//    Vertice<String> v5 = new Vertice<>("E");
//    Vertice<String> v6 = new Vertice<>("F");
//    Vertice<String> v7 = new Vertice<>("G");
//    Vertice<String> v8 = new Vertice<>("H");
//
//    public void añadir() {
//        //Añadimos los vértices
//        graph.addVertices(v1);
//        graph.addVertices(v2);
//        graph.addVertices(v3);
//        graph.addVertices(v4);
//        graph.addVertices(v5);
//        graph.addVertices(v6);
//        graph.addVertices(v7);
//        graph.addVertices(v8);
//
//        //Añadimos las aristas
//        graph.addArco(new Arista<>(v1, v2, 1.0));
//        graph.addArco(new Arista<>(v2, v3, 1.5));
//        graph.addArco(new Arista<>(v3, v4, 2.0));
//        graph.addArco(new Arista<>(v4, v5, 1.0));
//        graph.addArco(new Arista<>(v5, v6, 0.5));
//        graph.addArco(new Arista<>(v6, v7, 1.0));
//        graph.addArco(new Arista<>(v7, v8, 1.5));
//        graph.addArco(new Arista<>(v8, v1, 2.5));
//        graph.addArco(new Arista<>(v1, v3, 1.8));
//        graph.addArco(new Arista<>(v2, v4, 2.2));
//        graph.addArco(new Arista<>(v3, v5, 0.9));
//        graph.addArco(new Arista<>(v4, v6, 1.1));
//        graph.addArco(new Arista<>(v5, v7, 2.0));
//        graph.addArco(new Arista<>(v6, v8, 1.7));
//    }
//    public void añadirTodosLosVertices(){
//        for(Integer i=0;i<celdas.getNumeroElementos();i++){
//            Vertice =
//        }
//    }
    @FXML
    private void crearNuevoTablero(){
        tableroJuego.setVisible(true);

        //Vaciamos el gridpane
        informacionGridPane.getChildren().clear();
        informacionGridPane.setAlignment(Pos.CENTER);
        informacionGridPane.setMinSize(400, 700);


        ///Vaciamos el gridPane en el que vamos a crear los el tablero de botones
        tableroJuego.getChildren().clear();
        tableroJuego.setPadding(new Insets(valorAltura.getValue() * valorLado.getValue()));
        tableroJuego.setGridLinesVisible(true);
        tableroJuego.setHgap(0);
        tableroJuego.setVgap(0);
        tableroJuego.setMinSize(800, 800);
        tableroJuego.setAlignment(Pos.CENTER);
        Integer ident = 0;
        for (Integer i = 0; i < valorAltura.getValue(); i++) {
            for (Integer j = 0; j < valorLado.getValue(); j++) {
                Button celdaButton = new Button();
                celdaButton.setId(String.valueOf(ident));
                GridPane.setRowIndex(celdaButton, i);
                GridPane.setColumnIndex(celdaButton, j);
                celdaButton.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
                celdaButton.setStyle("-fx-background-color: #cef18c");
                celdaButton.setOnAction((ActionEvent event) -> {
                    System.out.println("EL BOTÓN " + celdaButton.getId() + " HA SIDO PULSADO");
                    onCeldaButtonClick(celdaButton, event);
                });
                GridPane fondoCelda = new GridPane();
                fondoCelda.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
                ListaEnlazada<StackPane> listaCuadraditos = new ListaEnlazada<>();
                for (Integer p1 = 0; p1 < 3; p1++) {
                    for (Integer p2 = 0; p2 < 2; p2++) {
                        StackPane cuadraditoanadir = createRectangle(Color.LIGHTGRAY);
                        cuadraditoanadir.resize(Double.MAX_VALUE, Double.MAX_VALUE);
                        listaCuadraditos.add(cuadraditoanadir);
                        fondoCelda.add(cuadraditoanadir, p1, p2);
                    }
                }
                celdaButton.setGraphic(fondoCelda);

                tableroJuego.getChildren().add(celdaButton);
                GridPane.setHgrow(celdaButton, Priority.ALWAYS);
                GridPane.setVgrow(celdaButton, Priority.ALWAYS);
                tableroJuego.setDisable(false);

                ListaEnlazada<Individuo> inds = new ListaEnlazada<>();
                ListaEnlazada<Recurso> recs = new ListaEnlazada<>();
                Celdas cel = new Celdas(inds, recs, ident, i, j,listaCuadraditos);
                celdas.add(cel);
                ident++;
            }
        }
        crearIndividuosIniciales();
        actualizarPaneLateral();
        crearRecursos();
        updateTablero();
    }

    @FXML
    private void cargarTablero(){
        //setpartidaCargada false??

//        String rutaArchivo = "partidas.json";
//
//        DatosCargados datosCargadosPartida1 = cargarObjetoDesdeArchivo(rutaArchivo, DatosCargados.class);
//
//        if (datosCargadosPartida1 != null){
//            System.out.println("Partida cargada:(num individuos totales) " + datosCargadosPartida1.getNumIndividuosTotales());
//        }
        //celdas= datosCargadosPartida1.getCeldas();

        tableroJuego.setVisible(true);

        //Vaciamos el gridpane
        informacionGridPane.getChildren().clear();
        informacionGridPane.setAlignment(Pos.CENTER);
        informacionGridPane.setMinSize(400, 700);


        ///Vaciamos el gridPane en el que vamos a crear los el tablero de botones
        tableroJuego.getChildren().clear();
        tableroJuego.setPadding(new Insets(valorAltura.getValue() * valorLado.getValue()));
        tableroJuego.setGridLinesVisible(true);
        tableroJuego.setHgap(0);
        tableroJuego.setVgap(0);
        tableroJuego.setMinSize(800, 800);
        tableroJuego.setAlignment(Pos.CENTER);
        Integer ident = 0;
        for (Integer i = 0; i < valorAltura.getValue(); i++) {
            for (Integer j = 0; j < valorLado.getValue(); j++) {
                Button celdaButton = new Button();
                celdaButton.setId(String.valueOf(ident));
                GridPane.setRowIndex(celdaButton, i);
                GridPane.setColumnIndex(celdaButton, j);
                celdaButton.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
                celdaButton.setStyle("-fx-background-color: #cef18c");
                celdaButton.setOnAction((ActionEvent event) -> {
                    System.out.println("EL BOTÓN " + celdaButton.getId() + " HA SIDO PULSADO");
                    onCeldaButtonClick(celdaButton, event);
                });
                GridPane fondoCelda = new GridPane();
                fondoCelda.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
                ListaEnlazada<StackPane> listaCuadraditos = new ListaEnlazada<>();
                for (Integer p1 = 0; p1 < 3; p1++) {
                    for (Integer p2 = 0; p2 < 2; p2++) {
                        StackPane cuadraditoanadir = createRectangle(Color.LIGHTGRAY);
                        cuadraditoanadir.resize(Double.MAX_VALUE, Double.MAX_VALUE);
                        listaCuadraditos.add(cuadraditoanadir);
                        fondoCelda.add(cuadraditoanadir, p1, p2);
                    }
                }
                celdaButton.setGraphic(fondoCelda);

                tableroJuego.getChildren().add(celdaButton);
                GridPane.setHgrow(celdaButton, Priority.ALWAYS);
                GridPane.setVgrow(celdaButton, Priority.ALWAYS);
                tableroJuego.setDisable(false);

//                ListaEnlazada<Individuo> inds = new ListaEnlazada<>();
//                ListaEnlazada<Recurso> recs = new ListaEnlazada<>();
//                Celdas cel = new Celdas(inds, recs, ident, i, j,listaCuadraditos);
//                celdas.add(cel);
                ident++;
            }
        }
        //crearIndividuosIniciales();
        actualizarPaneLateral();
//        crearRecursos();
        updateTablero();
    }
















        ///////////////////////Funciones///////////////////////////////////

    //Función para añadir los individuos iniciales al tablero aleatoriamente

    public void crearIndividuosIniciales() { //Los individuos iniciales que aparecen en el juego en casillas aleatorias segun el número de individuos que haya elegido el usuario
        for (Integer i = 0; i < numIndividuosInicialProperty().getValue(); i++) {
            Random random = new Random();
            int randomTipoIndividuo = random.nextInt(3);
            if(celdas.getElemento(i).getData().individuos.getNumeroElementos() <= 3 ) {
                if (randomTipoIndividuo == 0 ) {
                    Individuo individuoBasico = new Individuo(0, numIndividuosTotales, turnosDeVidaProperty().getValue(), turnosJuego, pRepProperty().getValue(), pClonProperty().getValue(), new Cola<>());
                    numIndividuosTotales++;
                    int randomCasilla = random.nextInt(valorAltura.getValue() * valorLado.getValue());
                    celdas.getElemento(randomCasilla).getData().getIndividuos().add(individuoBasico);
                } else if (randomTipoIndividuo == 1 ) {
                    Individuo individuoNormal = new Individuo(1, numIndividuosTotales, turnosDeVidaProperty().getValue(), turnosJuego, pRepProperty().getValue(), pClonProperty().getValue(), celdaAleatoria(i), new Cola<>());
                    numIndividuosTotales++;
                    int randomCasilla = random.nextInt(valorAltura.getValue() * valorLado.getValue());
                    celdas.getElemento(randomCasilla).getData().getIndividuos().add(individuoNormal);
                } else if (randomTipoIndividuo == 2 ) {
                    Individuo individuoAvanzado = new Individuo(2, numIndividuosTotales, turnosDeVidaProperty().getValue(), turnosJuego, pRepProperty().getValue(), pClonProperty().getValue(),new Cola<>());
                    numIndividuosTotales++;
                    int randomCasilla = random.nextInt(valorAltura.getValue() * valorLado.getValue());
                    celdas.getElemento(randomCasilla).getData().getIndividuos().add(individuoAvanzado);
                }
            }
        }
    }

    public void crearRecursos() {
        Random random = new Random();
        for (Integer i = 0; i < celdas.getNumeroElementos(); i++) {
            int numAleatorio = random.nextInt(101);
            if (numAleatorio <= probabilidadDeAparicionProperty().getValue()) {
                int numAleatorioAgua = random.nextInt(101);
                if (numAleatorioAgua <= pAgua().getValue() && celdas.getElemento(i).getData().recursos.getNumeroElementos() < 4) {
                    if (celdas.getElemento(i).getData().getRecursos().getNumeroElementos() < 3) {
                        Recurso agua = new Recurso(0, tiempoDeAparicionProperty().getValue(), i, probabilidadDeAparicionProperty().getValue(), pAgua().getValue(), 1);
                        celdas.getElemento(i).getData().recursos.add(agua);
                    }

                }
                int numAleatorioComida = random.nextInt(101);
                if (numAleatorioComida <= pComida().getValue() && celdas.getElemento(i).getData().recursos.getNumeroElementos() <= 3) {
                    if (celdas.getElemento(i).getData().getRecursos().getNumeroElementos() < 3) {
                        Recurso comida = new Recurso(1, tiempoDeAparicionProperty().getValue(), i, probabilidadDeAparicionProperty().getValue(), pComida().getValue(), 1);
                        celdas.getElemento(i).getData().recursos.add(comida);
                    }

                }
                int numAleatorioMontana = random.nextInt(101);
                if (numAleatorioMontana <= pMontana().getValue() && celdas.getElemento(i).getData().recursos.getNumeroElementos() <= 3) {
                    if (celdas.getElemento(i).getData().getRecursos().getNumeroElementos() < 3) {
                        Recurso montana = new Recurso(2, tiempoDeAparicionProperty().getValue(), i, probabilidadDeAparicionProperty().getValue(), pMontana().getValue(), 1);
                        celdas.getElemento(i).getData().recursos.add(montana);
                    }

                }
                int numAleatorioTesoro = random.nextInt(101);
                if (numAleatorioTesoro <= pTesoro().getValue() && celdas.getElemento(i).getData().recursos.getNumeroElementos() <= 3) {
                    if (celdas.getElemento(i).getData().getRecursos().getNumeroElementos() < 3) {
                        Recurso tesoro = new Recurso(3, tiempoDeAparicionProperty().getValue(), i, probabilidadDeAparicionProperty().getValue(), pTesoro().getValue(), 1);
                        celdas.getElemento(i).getData().recursos.add(tesoro);
                    }

                }
                int numAleatorioBiblioteca = random.nextInt(101);
                if (numAleatorioBiblioteca <= pBiblioteca().getValue() && celdas.getElemento(i).getData().recursos.getNumeroElementos() <= 3) {
                    if (celdas.getElemento(i).getData().getRecursos().getNumeroElementos() < 3) {
                        Recurso biblioteca = new Recurso(4, tiempoDeAparicionProperty().getValue(), i, probabilidadDeAparicionProperty().getValue(), pBiblioteca().getValue(), 1);
                        celdas.getElemento(i).getData().recursos.add(biblioteca);
                    }

                }
                int numAleatorioPozo = random.nextInt(101);
                if (numAleatorioPozo <= pPozo().getValue() && celdas.getElemento(i).getData().recursos.getNumeroElementos() <= 3) {
                    if (celdas.getElemento(i).getData().getRecursos().getNumeroElementos() < 3) {
                        Recurso pozo = new Recurso(5, tiempoDeAparicionProperty().getValue(), i, probabilidadDeAparicionProperty().getValue(), pPozo().getValue(), 1);
                        celdas.getElemento(i).getData().recursos.add(pozo);
                    }
                }
            }
        }
    }


    private void actualizarPorcentajesIndividuos() {
        double bas = 0;
        double nor = 0;
        double av = 0;
        for (int i = 0; i < celdas.getNumeroElementos(); i++) {
            if (celdas.getElemento(i).getData().individuos != null) {
                for (int j = 0; j < celdas.getElemento(i).getData().individuos.getNumeroElementos(); j++) {
                    if (celdas.getElemento(i).getData().individuos.getElemento(j).getData().getTipo() == 0) {
                        bas++;
                    } else if (celdas.getElemento(i).getData().individuos.getElemento(j).getData().getTipo() == 1) {
                        nor++;
                    } else if (celdas.getElemento(i).getData().individuos.getElemento(j).getData().getTipo() == 2) {
                        av++;
                    }

                }
            }
        }
        double total = bas + nor + av;
        if (total > 0) {
            pBasicoProperty().set(bas / total);
            pNormalProperty().set(nor / total);
            pAvanzadoProperty().set(av / total);
        } else if (total == 0) {
            pBasicoProperty().set(0);
            pNormalProperty().set(0);
            pAvanzadoProperty().set(0);
        }

    }

    private String toCssColor(Color color) {
        int r = (int) (color.getRed() * 255);
        int g = (int) (color.getGreen() * 255);
        int b = (int) (color.getBlue() * 255);
        int a = (int) (color.getOpacity() * 255);

        // Formato CSS rgba(r, g, b, a)
        return String.format("rgba(%d, %d, %d, %.2f)", r, g, b, a / 255.0);
    }


    @FXML
    public GridPane actualizarPaneLateral() {
        actualizarPorcentajesIndividuos();

        VBox cajaInformacion = new VBox(10); //10 es el espacio entre cada caja que haya dentro
        cajaInformacion.setBackground(new Background(new BackgroundFill(Color.LIGHTGREY, CornerRadii.EMPTY, Insets.EMPTY)));
        cajaInformacion.setPadding(new Insets(10));
        cajaInformacion.setAlignment(Pos.CENTER);

        Label titulo = new Label("Información de la partida");
        titulo.setFont(new Font("Century Schoolbook", 14));

        Label separador = new Label("___________________________________________________");
        separador.setFont(new Font("Century Schoolbook", 10));

        Label turnos = new Label();
        turnos.setFont(new Font("Century Schoolbook", 14));
        turnos.setText("Turnos: " + turnosJuego);

        Label ind = new Label();
        ind.setFont(new Font("Century Schoolbook", 14));
        ind.setText("Individuos vivos: " + Tablero.getIndividuosActuales().getNumeroElementos());

        Label separador2 = new Label("___________________________________________________");
        separador2.setFont(new Font("Century Schoolbook", 10));

        Label porcNormalLabel = new Label((pNormalProperty().getValue() * 100) + "%");
        porcNormalLabel.textProperty().bind(pNormalProperty().multiply(100).asString("%.1f%%"));

        Label calidadPoblacion = new Label("Calidad de mi población");
        calidadPoblacion.setFont(new Font("Century Schoolbook", 14));

        HBox cajaSlidersCalidadPoblacion = new HBox(); //el 5 de que?
        cajaSlidersCalidadPoblacion.setAlignment(Pos.CENTER);


        //Basico
        VBox cajaBasico = new VBox(40);
        cajaBasico.setAlignment(Pos.CENTER);
        Label basico = new Label("Básico");
        basico.setFont(new Font("Century Schoolbook", 10));
        Label porcBasicoLabel = new Label((pBasicoProperty().getValue() * 100) + "%");
        porcBasicoLabel.textProperty().bind(pBasicoProperty().multiply(100).asString("%.1f%%"));
        ProgressBar barBasico = new ProgressBar();
        barBasico.setRotate(-90);
        barBasico.progressProperty().bind(pBasicoProperty());
        barBasico.maxHeight(10);
        String colorB = toCssColor(Color.YELLOWGREEN);
        barBasico.setStyle("-fx-accent: " + colorB + ";");
        cajaBasico.getChildren().addAll(basico, barBasico, porcBasicoLabel);
        //Normal
        VBox cajaNormal = new VBox(40);
        cajaNormal.setAlignment(Pos.CENTER);
        Label normal = new Label("Normal");
        normal.setFont(new Font("Century Schoolbook", 10));
        ProgressBar barNormal = new ProgressBar();
        barNormal.setRotate(-90);
        barNormal.progressProperty().bind(pNormalProperty());
        Label porcAvanzadoLabel = new Label((pAvanzadoProperty().getValue() * 100) + "%");
        porcAvanzadoLabel.textProperty().bind(pAvanzadoProperty().multiply(100).asString("%.1f%%"));
        String colorN = toCssColor(Color.FORESTGREEN);
        barNormal.setStyle("-fx-accent: " + colorN + ";");
        cajaNormal.getChildren().addAll(normal, barNormal, porcNormalLabel);
        //Avanzado
        VBox cajaAvanzado = new VBox(40);
        cajaAvanzado.setAlignment(Pos.CENTER);
        Label avanzado = new Label("Avanzado");
        avanzado.setFont(new Font("Century Schoolbook", 10));
        ProgressBar barAvanzado = new ProgressBar();
        barAvanzado.setRotate(-90);
        barAvanzado.progressProperty().bind(pAvanzadoProperty());
        String colorA = toCssColor(Color.LAWNGREEN);
        barAvanzado.setStyle("-fx-accent: " + colorA + ";");
        cajaAvanzado.getChildren().addAll(avanzado, barAvanzado, porcAvanzadoLabel);
        //Añadir todos al de la población
        cajaSlidersCalidadPoblacion.getChildren().addAll(cajaBasico, cajaNormal, cajaAvanzado);



        Button configuracion= new Button("Configuración");
        if(tableroJuego.isDisabled()){ configuracion.setDisable(true);
        } else { configuracion.setDisable(false);}
        configuracion.setOnAction(actionEvent -> onConfiguracionButtonClick(actionEvent));
        informacionGridPane.add(configuracion, 0, 0);


        Button guardar= new Button("Guardar");
        if(tableroJuego.isDisabled()){ guardar.setDisable(true);
        } else { guardar.setDisable(false);}
        guardar.setOnAction(actionEvent -> onGuardarButtonClick());
        informacionGridPane.add( guardar, 0,0);




        ToolBar herramientasBotones = new ToolBar();
        informacionGridPane.add(herramientasBotones, 0, 1);


        Button pauseButton = new Button("Pausa");
        pauseButton.setOnAction(actionEvent -> {
            configuracion.setDisable(false);
            guardar.setDisable(false);
            onPauseButtonClick();
        });
        herramientasBotones.getItems().add(pauseButton);

        Button playButton = new Button("Play");
        playButton.setOnAction(actionEvent -> {
            configuracion.setDisable(true);
            guardar.setDisable(true);
            onPlayButtonClick();
        });
        herramientasBotones.getItems().add(playButton);

        Button turnoButton = new Button("Turno");
        turnoButton.setOnAction(actionEvent -> onTurnoButtonCLick());
        herramientasBotones.getItems().add(turnoButton);

        Button stopButton = new Button("Stop");
        stopButton.setOnAction(actionEvent -> {
            onStopButtonClick();
        });
        herramientasBotones.getItems().add(stopButton);




        //cajaInformacion.getChildren().addAll(titulo, separador, turnos, ind, separador2, individuos, cajaSliderTurnosDeVida, miniSep, cajaSliderPRep, cajaSliderPMuerte, cajaSliderPClon, miniSep2, calidadPoblacion, cajaSlidersCalidadPoblacion, separador3, recursos, cajaSliderTiempoDeAparicion, cajaSliderProbabilidadDeAparicion, herramientasBotones);
        cajaInformacion.getChildren().addAll(titulo, separador, turnos, ind, separador2, calidadPoblacion, cajaSlidersCalidadPoblacion, configuracion, guardar,herramientasBotones);

        informacionGridPane.add(cajaInformacion, 0, 0);
        return informacionGridPane;
    }


    private Parametros parametros = new Parametros(turnosDeVidaProperty().getValue(), numIndividuosInicialProperty().getValue(), pRepProperty().getValue(), pMuerteProperty().getValue(), pClonProperty().getValue(), pBasicoProperty().getValue(), pNormalProperty().getValue(), pAvanzadoProperty().getValue(), ladoProperty().getValue(), alturaProperty().getValue(), tiempoDeAparicionProperty().getValue(), probabilidadDeAparicionProperty().getValue(), vidaAguaSumaProperty().getValue(), pAgua().getValue(), vidaComidaSumaProperty().getValue(), pComida().getValue(), vidaMontanaRestaProperty().getValue(), pMontana().getValue(), pReproTesoroSumaProperty().getValue(), pTesoro().getValue(), pClonacionBibliotecaSumaProperty().getValue(), pBiblioteca().getValue(), 0, pPozo().getValue());
    private ParametrosProperties parametrosCompartir = new ParametrosProperties(parametros);






    private StackPane createRectangle(Color color) {
        StackPane rectangle = new StackPane();
        rectangle.setPrefHeight(100);
        rectangle.setPrefWidth(100);
        rectangle.setBorder(new Border(new BorderStroke(Color.GRAY, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
        rectangle.setBackground(new Background(new BackgroundFill(color, CornerRadii.EMPTY, Insets.EMPTY)));
        return rectangle;
    }


    @FXML
    private void onCeldaButtonClick(Button celdaButton, ActionEvent event) {
        System.out.println("Se ha abierto la celda " + celdaButton.getId());
        Stage celdaStage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(Parametros.class.getResource("/com/example/pruebafinal_/juego-celda.fxml"));
        try {
            Scene scene = new Scene(fxmlLoader.load(), 600, 400);
            celdaStage.setTitle("Celda " + celdaButton.getId());
            celdaStage.setScene(scene);
            CeldasControllers celdasControllers = fxmlLoader.getController();
            celdasControllers.loadCeldasData(celdasCompartir, Integer.valueOf(celdaButton.getId()));
            celdasControllers.showCelda(Integer.valueOf(celdaButton.getId()));
            celdaStage.initModality(Modality.APPLICATION_MODAL);
            Stage stageAnterior = (Stage) ((Button) event.getSource()).getScene().getWindow();
            celdaStage.initOwner(stageAnterior);
            celdasControllers.setStage(celdaStage);
            celdaStage.setResizable(false);
            celdaStage.setOnHidden(evento -> {
                System.out.println("Se cerró la ventana de la celda " + celdaButton.getId());
//                ListaEnlazada<Celdas> listaCeldas = CeldasControllers.getListaDeCeldas();
//                celdas = listaCeldas;
                actualizarPaneLateral();
            });
            celdaStage.showAndWait();
            updateTablero();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }




    @FXML
    public void updateCelda(Integer idCelda) {
        Integer contador = 0;
        Integer contador2 = 0;
        if (celdas.getElemento(idCelda).getData().recursos != null) {
            for (Integer i = 0; i < celdas.getElemento(idCelda).getData().recursos.getNumeroElementos(); i++) {
                if (celdas.getElemento(idCelda).getData().recursos.getElemento(contador) != null) {
                    Color color1 = celdas.getElemento(idCelda).getData().recursos.getElemento(contador).getData().getColor();
                    celdas.getElemento(idCelda).getData().getListaRectangulos().getElemento(contador).getData().setBackground(Background.fill(color1));
                    contador++;
                }
            }
        }
        if (celdas.getElemento(idCelda).getData().individuos != null) {
            for (Integer i = 0; i < celdas.getElemento(idCelda).getData().individuos.getNumeroElementos(); i++) {
                if (celdas.getElemento(idCelda).getData().individuos.getElemento(contador2) != null) {
                    Color color2 = celdas.getElemento(idCelda).getData().individuos.getElemento(contador2).getData().getColor();
                    if (contador < 6) {
                        celdas.getElemento(idCelda).getData().getListaRectangulos().getElemento(contador).getData().setBackground(Background.fill(color2));
                        contador2++;
                        contador++;
                    }
                }
            }

        }
        int numTot = celdas.getElemento(idCelda).getData().recursos.getNumeroElementos() + celdas.getElemento(idCelda).getData().individuos.getNumeroElementos();
        if (numTot != 6) {
            int restantes = 6 - numTot;
            for (Integer i = 0; i < restantes; i++) {
                celdas.getElemento(idCelda).getData().getListaRectangulos().getElemento(numTot + i).getData().setBackground(Background.fill(Color.LIGHTGREY));
            }
        }
    }


    ///////////////////////////////Botones de control del bucle///////////////////////////////////
    @FXML
    protected void onPauseButtonClick() {
        tableroJuego.setDisable(false);
        System.out.println("Se ha pausado el juego");
        setPausa(true);
    }

    @FXML
    protected void onPlayButtonClick() {
        tableroJuego.setDisable(true);
        System.out.println("Se ha reanudado el juego");
        setPausa(false);
        bucleDeControlIniciar();
    }

    @FXML
    protected void onTurnoButtonCLick() {
        turnoPasa();
    }

    @FXML
    protected void onConfiguracionButtonClick(ActionEvent event) {
        System.out.println("Se ha clicado el botón de configuración");
        Stage stageConfig = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(JuegoDeLaVida.class.getResource("/com/example/pruebafinal_/juego-parametros-partida.fxml"));
        try {
            Scene scene = new Scene(fxmlLoader.load());
            stageConfig.setTitle("Parámetros partida");
            stageConfig.setScene(scene);
            ParametrosPartidaControllers pParamPart = fxmlLoader.getController();
            pParamPart.loadUserData(this.parametrosCompartir);
            stageConfig.initModality(Modality.APPLICATION_MODAL);
            Stage stageAnterior = (Stage) ((Button) event.getSource()).getScene().getWindow();
            stageConfig.initOwner(stageAnterior);
            pParamPart.setStage(stageConfig);
            stageConfig.setResizable(false);
            stageConfig.setOnHidden(evento -> {
                System.out.println("Se cerró la ventana de parámetros abierta durante la partida");
                actualizarPaneLateral();
            });
            stageConfig.showAndWait();
            updateTablero();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @FXML
    protected void onStopButtonClick(){
        System.out.println("Se ha pulsado el botón de stop");
        //onPauseButtonClick();
        Stage guardarStage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(Parametros.class.getResource("/com/example/pruebafinal_/juego-guardar.fxml"));
        try {
            Scene scene= new Scene(fxmlLoader.load(), 600,400);
            guardarStage.setTitle("Guardado");
//            log.info()
            guardarStage.setScene(scene);
            GuardarControllers guardarControllers = fxmlLoader.getController();
            guardarControllers.loadGuardarData(new DatosCargados(turnosDeVidaProperty().getValue().intValue(), pRepProperty().getValue().intValue(),pMuerteProperty().getValue().intValue(), pClonProperty().getValue().intValue(),ladoProperty().getValue().intValue(), alturaProperty().getValue().intValue(),tiempoDeAparicionProperty().getValue().intValue(), probabilidadDeAparicionProperty().getValue().intValue(),vidaAguaSumaProperty().getValue().intValue(),pAgua().getValue().intValue(),vidaComidaSumaProperty().getValue().intValue(),pComida().getValue().intValue(),vidaMontanaRestaProperty().getValue().intValue(),pMontana().getValue().intValue(),pReproTesoroSumaProperty().getValue().intValue(),pTesoro().getValue().intValue(),pClonacionBibliotecaSumaProperty().getValue().intValue(),pBiblioteca().getValue().intValue(),0,pPozo().getValue().intValue(), celdas, getNumIndividuosTotales(), getTurnosJuego()));
//            guardarStage.initModality(Modality.APPLICATION_MODAL);
//            Stage stageAnterior = (Stage) ((Button) event.getSource()).getScene().getWindow();
//            guardarStage.initOwner(stageAnterior);
            guardarControllers.setStage(guardarStage);
            //guardarStage.setResizable(false);
//            guardarStage.setOnHidden(evento -> {
//                System.out.println("Se cerró la ventana de guardado");
//            });
            guardarStage.show();
//            updateTablero();
            guardarStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
                @Override
                public void handle(WindowEvent windowEvent) {
                    System.out.println("Se ha cerrado la ventana de guardado.");
                }
            });

        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void onGuardarButtonClick(){
        guardarPartida();
        System.out.println("Se ha guardado la partida");
    }


    public void guardarPartida(){
        DatosCargados datosPartida1= new DatosCargados(turnosDeVidaProperty().getValue().intValue(), pRepProperty().getValue().intValue(),pMuerteProperty().getValue().intValue(), pClonProperty().getValue().intValue(),ladoProperty().getValue().intValue(), alturaProperty().getValue().intValue(),tiempoDeAparicionProperty().getValue().intValue(), probabilidadDeAparicionProperty().getValue().intValue(),vidaAguaSumaProperty().getValue().intValue(),pAgua().getValue().intValue(),vidaComidaSumaProperty().getValue().intValue(),pComida().getValue().intValue(),vidaMontanaRestaProperty().getValue().intValue(),pMontana().getValue().intValue(),pReproTesoroSumaProperty().getValue().intValue(),pTesoro().getValue().intValue(),pClonacionBibliotecaSumaProperty().getValue().intValue(),pBiblioteca().getValue().intValue(),0,pPozo().getValue().intValue(), celdas, getNumIndividuosTotales(), getTurnosJuego());
        setPartidaCargada(true);
        String rutaArchivo = "partidas.json";

        guardarPartidaEnArchivo(rutaArchivo, datosPartida1);
        System.out.println("guardada: " + isPartidaCargada());

        DatosCargados datosCargadosPartida1 = cargarObjetoDesdeArchivo(rutaArchivo, DatosCargados.class);

        if (datosPartida1 != null){
            System.out.println("Partida cargada: (num turnos)" + datosCargadosPartida1.getTurnosJuego());
        }
    }
    /////////////////////////////////////Bucle de control////////////////////////////////////////////

    @FXML
    public void updateTablero() {
        for (Integer i = 0; i < celdas.getNumeroElementos(); i++) {
            updateCelda(i);
        }
    }

    @FXML
    public void actualizarTurnoIndividuos() {
        for (Integer i = 0; i < celdas.getNumeroElementos(); i++) {
            for (Integer j = 0; j < celdas.getElemento(i).getData().individuos.getNumeroElementos(); j++) {
                Individuo ind = celdas.getElemento(i).getData().individuos.getElemento(j).getData();
                ind.setTurnosDeVida(ind.getTurnosDeVida() - 1);
                ind.colaIndividuo.add(ind.getTurnosDeVida());
                if (ind.getpReproCadaIndividuo() > 0) {
                    ind.setpReproCadaIndividuo(ind.getpReproCadaIndividuo() - 10);
                }
                if (ind.getpClonacionCadaIndividuo() > 0) {
                    ind.setpClonacionCadaIndividuo(ind.getpClonacionCadaIndividuo() - 10);
                }
                System.out.println("Se ha restado un turno de vida al indviduo " + ind.getId());
                ind.colaIndividuo.add(ind.getTurnosDeVida());
                if (ind.getTurnosDeVida() == 0) {
                    celdas.getElemento(i).getData().individuos.getElemento(j).getData().colaIndividuo.add("Se le ha restado un turno de vida al indviduo ");
                    if (ind.getTurnosDeVida() == 0) {
                        Individuo ind2 = celdas.getElemento(i).getData().individuos.getElemento(j).getData();
                        ind2.colaIndividuo.add("Se ha muerto el individuo ");
                        ind2.colaIndividuo.add(turnosJuego - ind2.getGeneracion());

                        Vertice v = new Vertice<>(celdas.getElemento(i).getData().individuos.getElemento(j).getData().colaIndividuo);  //Añadimso la cola en un vertice para así poder
                        grafoColaIndividuos.addVertices(v);
                        celdas.getElemento(i).getData().individuos.del(j);
                        j--;
                    }
                }
            }
        }
    }

    @FXML
    public void actualizarTurnoVidaRecursos() {
        for (Integer i = 0; i < celdas.getNumeroElementos(); i++) {
            for (Integer j = 0; j < celdas.getElemento(i).getData().recursos.getNumeroElementos(); j++) {
                Recurso rec = celdas.getElemento(i).getData().recursos.getElemento(j).getData();
                rec.setTurnosDeVida(rec.getTurnosDeVida() - 1);
                System.out.println("Se ha restado un turno de vida al recurso " + rec.getColor());
                if (rec.getTurnosDeVida() == 0) {
                    celdas.getElemento(i).getData().recursos.del(j);
                    System.out.println("Se ha muerto el recurso " + rec.getColor());
                    j--;
                }
            }
        }
    }

    @FXML
    public void mejorasIndividuosRecursos() {
        for (Integer i = 0; i < celdas.getNumeroElementos(); i++) {
            if (celdas.getElemento(i).getData().recursos != null) {
                for (Integer j = 0; j < celdas.getElemento(i).getData().recursos.getNumeroElementos(); j++) {
                    if (celdas.getElemento(i).getData().recursos.getElemento(j).getData().getColor() == Color.TURQUOISE) {
                        for (Integer m = 0; m < celdas.getElemento(i).getData().individuos.getNumeroElementos(); m++) {
                            Individuo ind = celdas.getElemento(i).getData().individuos.getElemento(m).getData();
                            ind.setTurnosDeVida(ind.getTurnosDeVida() + celdas.getElemento(i).getData().recursos.getElemento(j).getData().getPropiedad());
                            // System.out.println("Se sumaron "+vidaAguaSumaProperty().getValue()+"por el agua ");

                            ind.colaIndividuo.add("agua");
                        }
                    }
                    if (celdas.getElemento(i).getData().recursos.getElemento(j).getData().getColor() == Color.TOMATO) {
                        for (Integer m = 0; m < celdas.getElemento(i).getData().individuos.getNumeroElementos(); m++) {
                            Individuo ind = celdas.getElemento(i).getData().individuos.getElemento(m).getData();
                            ind.setTurnosDeVida(ind.getTurnosDeVida() + celdas.getElemento(i).getData().recursos.getElemento(j).getData().getPropiedad());
                            //  System.out.println("Se sumaron "+vidaAguaSumaProperty().getValue()+" vidas por la comida ");
                            ind.colaIndividuo.add(ind.getTurnosDeVida());
                            ind.colaIndividuo.add("comida");
                        }
                    }
                    if (celdas.getElemento(i).getData().recursos.getElemento(j).getData().getColor() == Color.BURLYWOOD) {
                        for (Integer m = 0; m < celdas.getElemento(i).getData().individuos.getNumeroElementos(); m++) {
                            Individuo ind = celdas.getElemento(i).getData().individuos.getElemento(m).getData();
                            ind.setTurnosDeVida(ind.getTurnosDeVida() - celdas.getElemento(i).getData().recursos.getElemento(j).getData().getPropiedad());

                            ind.colaIndividuo.add(ind.getTurnosDeVida());
                            ind.colaIndividuo.add("montaña");
                        }
                    }
                    if (celdas.getElemento(i).getData().recursos.getElemento(j).getData().getColor() == Color.YELLOW) {
                        for (Integer m = 0; m < celdas.getElemento(i).getData().individuos.getNumeroElementos(); m++) {
                            Individuo ind = celdas.getElemento(i).getData().individuos.getElemento(m).getData();
                            ind.setpReproCadaIndividuo(ind.getpReproCadaIndividuo() + celdas.getElemento(i).getData().recursos.getElemento(j).getData().getPropiedad());

                            ind.colaIndividuo.add(ind.getTurnosDeVida());
                            ind.colaIndividuo.add("tesoro");
                        }
                    }
                    if (celdas.getElemento(i).getData().recursos.getElemento(j).getData().getColor() == Color.HOTPINK) {
                        for (Integer m = 0; m < celdas.getElemento(i).getData().individuos.getNumeroElementos(); m++) {
                            Individuo ind = celdas.getElemento(i).getData().individuos.getElemento(m).getData();
                            // ind.setTurnosDeVida(ind.getTurnosDeVida()+pClonacionBibliotecaSumaProperty().getValue());  //Debe poder subir el tipo de individuo
                            ind.setpClonacionCadaIndividuo(ind.getpClonacionCadaIndividuo() + celdas.getElemento(i).getData().recursos.getElemento(j).getData().getPropiedad());
                            // System.out.println("Se sumaron "+pClonacionBibliotecaSumaProperty().getValue()+" vidas y aumentó en un "+pClonacionBibliotecaSumaProperty().getValue());

                            ind.colaIndividuo.add(ind.getTurnosDeVida());
                            ind.colaIndividuo.add("biblioteca");
                        }
                    }
                    if (celdas.getElemento(i).getData().recursos.getElemento(j).getData().getColor() == Color.DARKGREY) {
                        for (Integer m = 0; m < celdas.getElemento(i).getData().individuos.getNumeroElementos(); m++) {
                            Individuo ind = celdas.getElemento(i).getData().individuos.getElemento(m).getData();
                            ind.colaIndividuo.add("pozo");
                        }
                        celdas.getElemento(i).getData().individuos.vaciar();
                    }
                }
            }
        }
    }


    //////////Tipos de movimientos según el tipo del individuo//////////////////////
    /////////////Movimiento del tipo básico///////////////
    @FXML
    public void moverIndividuoBasico(Individuo indBasico, int celda, int posIndividuo) {
        ListaEnlazada<Integer> listaCoordX = calcularCoordenadasAdyacentesX(celda);
        ListaEnlazada<Integer> listaCoordY = calcularCoordenadasAdyacentesY(celda);

        //  ListaEnlazada<Integer> nuevasCoordenadas = nuevaCelda(listaCoordX, listaCoordY);
        ListaEnlazada<Integer> nuevasCoordenadas = nuevaCelda(listaCoordX, listaCoordY);

        // Verificar que se obtuvieron nuevas coordenadas válidas
        if (!nuevasCoordenadas.isVacia() && nuevasCoordenadas.getNumeroElementos() == 2) {
            int nuevaCoordX = nuevasCoordenadas.getElemento(0).getData();
            int nuevaCoordY = nuevasCoordenadas.getElemento(1).getData();
            int nuevaCeldaPos = getPosCelda(nuevaCoordX, nuevaCoordY);

            // Mover el individuo a la nueva celda
            celdas.getElemento(nuevaCeldaPos).getData().individuos.add(indBasico);
            indBasico.colaIndividuo.add("Se movió el individuo de la celda" + celda + " a la " + nuevaCeldaPos);
            celdas.getElemento(celda).getData().individuos.del(posIndividuo);


        } else {
            System.out.println("No se encontraron coordenadas válidas para mover el individuo.");
        }
    }

    public ListaEnlazada<Integer> nuevaCelda(ListaEnlazada<Integer> listaX, ListaEnlazada<Integer> listaY) {
        ListaEnlazada<Integer> nuevasCoordenadas = new ListaEnlazada<>();
        Random random = new Random();

        if (!listaX.isVacia() && !listaY.isVacia()) {
            int aleatorioX = random.nextInt(listaX.getNumeroElementos());
            int aleatorioY = random.nextInt(listaY.getNumeroElementos());
            nuevasCoordenadas.add(listaX.getElemento(aleatorioX).getData());
            nuevasCoordenadas.add(listaY.getElemento(aleatorioY).getData());
        }

        return nuevasCoordenadas;
    }

    public ListaEnlazada<Integer> calcularCoordenadasAdyacentesX(int posCelda) {
        ListaEnlazada<Integer> listaX = new ListaEnlazada<>();
        int coordX = celdas.getElemento(posCelda).getData().getCoordX();

        // Arriba
        if (coordX > 0) {
            listaX.add(coordX - 1);
        }
        // Abajo
        if (coordX < ladoProperty().getValue() - 1) {
            listaX.add(coordX + 1);
        }
        // Coordenada actual
        listaX.add(coordX);

        return listaX;
    }

    public ListaEnlazada<Integer> calcularCoordenadasAdyacentesY(int posCelda) {
        ListaEnlazada<Integer> listaY = new ListaEnlazada<>();
        int coordY = celdas.getElemento(posCelda).getData().getCoordY();

        // Izquierda
        if (coordY > 0) {
            listaY.add(coordY - 1);
        }
        // Derecha
        if (coordY < alturaProperty().getValue() - 1) {
            listaY.add(coordY + 1);
        }
        // Coordenada actual
        listaY.add(coordY);

        return listaY;
    }

    /////////////Movimiento del tipo normal///////////////

//    public int  busquedaRecursoCercano(int celdaPos){ ////Primero buscamos el recurso más cercano
//        int coordX=celdas.getElemento(celdaPos).getData().getCoordX();
//        int coordY=celdas.getElemento(celdaPos).getData().getCoordY();
//        for(Integer i=coordX-1;i<ladoProperty().getValue();i++){
//            for(Integer j=coordY-1;j<alturaProperty().getValue();j++){
//                if( celdas.getElemento(getPosCelda(i,j)).getData().recursos!=null){
//                    return celdas.getElemento(getPosCelda(i,j)).getData().getIdentificadorCelda();
//                }
//            }
//        }
//
//        return 0;
//    }

    public int busquedaRecursoDestino(int celdaPos) {   ///Recorremos el tablero en forma de espiral desde la celda origen.

        int celdaDestino = -1;

        int[] directions = {0, 1, 0, -1, 0}; // Right, Down, Left, Up (x, y) movements
        int dir = 0; // start with direction 'Right'

        int lado = celdas.getElemento(celdaPos).getData().getCoordX();
        int altura = celdas.getElemento(celdaPos).getData().getCoordY();
        int totalCells = lado * altura;

        for (int i = 0; i < totalCells; i++) {
            if (lado >= 0 && lado < ladoProperty().getValue() && altura >= 0 && altura < alturaProperty().getValue()) {
                if (celdas.getElemento(getPosCelda(lado, altura)).getData().recursos != null && celdaDestino == -1) {
                    Integer contador = 0; ///////Hacemos un contadro para comprobar que ningun recurso es el pozo
                    for (Integer j = 0; j < celdas.getElemento(getPosCelda(lado, altura)).getData().recursos.getNumeroElementos(); j++) {
                        if (celdas.getElemento(getPosCelda(lado, altura)).getData().recursos.getElemento(j).getData().getColor() != Color.DARKGREY) {
                            contador++;
                        }
                    }
                    if (contador != 6) {
                        return celdas.getElemento(getPosCelda(lado, altura)).getData().getIdentificadorCelda();

                    }
                }
            }

            int newR = lado + directions[dir];
            int newC = altura + directions[dir + 1];

            if (newR >= 0 && newR < ladoProperty().getValue() && newC >= 0 && newC < alturaProperty().getValue()) {
                lado = newR;
                altura = newC;
            } else {
                dir = (dir + 1) % 4; // change direction
                lado += directions[dir];
                altura += directions[dir + 1];
            }
        }

        return celdaDestino;
    }


    public void moverAvanzado(Vertice origen, Vertice destino, int individuo) {




//        System.out.println("El numero de elementos que hayyyyyyy   "+grafo.getVertices().getNumeroElementos());
//
//
//
//        System.out.println("Uns arista "+grafo.getAristas().getElementoLS(1).getData().toString());
//        System.out.println("El bveeertiiiiceeee origen "+origen);
//        System.out.println("El destinooooo"+ destino);
//
//        System.out.println("Los vertices "+grafo.toPrintV());
//
//        Mapa<Vertice<Integer>, Camino<Integer>> caminos= grafo.dijkstra( origen);
//        if(caminos!=null) {
//            System.out.println("Numero de caminos"+caminos.getNumElem());
//            if(grafo.isPosible(origen,destino)) {   //Comprobamos que exissten los vertices
//                if(grafo.caminoMinimo(origen,destino)!=null) {  //Comprobamos que exisgte camino desde el vértice origen hasta el vértice destino
//                    ListaSimple<Vertice<Integer>> caminoV1V2 = grafo.caminoMinimo(origen, destino).getCamino();
//                    System.out.println("El camino más corto desde el vertice 2 hasta el 7:");
//                    if (caminoV1V2 != null) {
//                        Integer contador = 0;
//                        while (caminoV1V2.getNumeroElementos() > contador) {    //imprimimos por pantalla todos los vertices
//                            System.out.println(caminoV1V2.getElementoLS(contador).getData().getData());
//                            contador++;
//                        }
//                    }
//                }else{
//                    System.out.println("El camino no existe o es nulo");
//                }
//            }else {
//                System.out.println("No existe dicho camino");
//            }
//
//
//            if(caminos.getValue( destino)!=null) { //Comprobamos que existe camino desde el vértice origen hasta el vértice destino
//                ListaSimple<Vertice<String>> caminoHastaV6 = caminos.getValue(destino).getCamino();
//                System.out.println("El camino más corto desde el vertice 1 hasta el 8:");
//                if (caminoHastaV6 != null) {
//                    Integer contador1 = 0;
//                    while (caminoHastaV6.getNumeroElementos() > contador1) { //imprimimos por pantalla todos los vertices
//                        System.out.println(caminoHastaV6.getElementoLS(contador1).getData().getData());
//                        contador1++;
//                    }
//                }
//                System.out.println("El coste del camino más corto desde A hasta H es: " + caminos.getValue(destino).getCoste());
//
//            }else{
//                System.out.println("El camino es nulo o no existe");
//            }
//        }
    }
//    private  static  void mostrar_caminos(Mapa<Vertice<String>,Camino<String>> todosloscaminos){
//        Integer contador=0;
//        while(contador<todosloscaminos.getIndice().getNumeroElementos()){
//            System.out.println(todosloscaminos.getIndice2().getElementoLS(contador).getData());
//            contador++;
//        }
//
//
//    }


    ////Necesitaremos la celda en la cual se encuentra el individuo

    public Grafo creamosGrafo() {////Necesitaremos la celda en la cual se encuentra el individuo
        Grafo<Integer> grafo = new Grafo<>();

        for (Integer i = 0; i < celdas.getNumeroElementos(); i++) {
            Vertice v = new Vertice<>(celdas.getElemento(i).getData().getIdentificadorCelda());  //Añadimos todos los vertices en orden
            grafo.addVertices(v);
            for (Integer m = 0; m < alturaProperty().getValue(); m++) {
                for (int j = 0; j < ladoProperty().getValue(); j++) {
                    Vertice verticeOri = new Vertice<>(celdas.getElemento(getPosCelda(i, j)));
                    if (m > 0) { // celda de arriba
                        Vertice verticeDest = new Vertice<>(celdas.getElemento(getPosCelda(i - 1, j)));
                        Arista<Integer> arista = new Arista<>(verticeOri, verticeDest, 1);
                        grafo.addArco(arista);

                    }
                    if (m < alturaProperty().getValue() - 1) { // celda de abajo
                        Vertice verticeDest = new Vertice<>(celdas.getElemento(getPosCelda(i + 1, j)));
                        Arista<Integer> arista = new Arista<>(verticeOri, verticeDest, 1);
                        grafo.addArco(arista);

                    }
                    if (j > 0) { // celda de la izquierda
                        Vertice verticeDest = new Vertice<>(celdas.getElemento(getPosCelda(i, j - 1)));
                        Arista<Integer> arista = new Arista<>(verticeOri, verticeDest, 1);
                        grafo.addArco(arista);

                    }
                    if (j < ladoProperty().getValue() - 1) { // celda de la derecha
                        Vertice verticeDest = new Vertice<>(celdas.getElemento(getPosCelda(i, j + 1)));
                        Arista<Integer> arista = new Arista<>(verticeOri, verticeDest, 1);
                        grafo.addArco(arista);

                    }
                }
            }

        }
        return grafo;



    }

    public static int celdaAleatoria(int celdaAnterior) {  //Celda aleatoria con recurso
        Random random = new Random();
        int nuevaCelda = -1;

        if (nuevaCelda == -1) {
            int lado = random.nextInt(ladoProperty().getValue());
            int altura = random.nextInt(alturaProperty().getValue());
            if (celdas.getElemento(getPosCelda(lado, altura)).getData().recursos != null && getPosCelda(lado, altura) != celdaAnterior) {
                nuevaCelda = getPosCelda(lado, altura);


            } else {
                return celdaAleatoria(celdaAnterior);
            }
        }
        return nuevaCelda;



    }

    public void moverNormal(int celdaOriginal, int individuo) {

        //Necesitamos la celda origen y destino
        //Coordenadas de la celda origen
        int coordOriX = celdas.getElemento(celdaOriginal).getData().getCoordX();
        int coordOriY = celdas.getElemento(celdaOriginal).getData().getCoordY();

        //Coordenadas de la celda destino

        int coordDestX = celdas.getElemento(celdas.getElemento(celdaOriginal).getData().individuos.getElemento(individuo).getData().getCeldaObjetivoNormal()).getData().getCoordX();
        int coordDestY = celdas.getElemento(celdas.getElemento(celdaOriginal).getData().individuos.getElemento(individuo).getData().getCeldaObjetivoNormal()).getData().getCoordY();
        Individuo ind = celdas.getElemento(celdaOriginal).getData().individuos.getElemento(individuo).getData();
        System.out.println("LAAAA XXXX" + celdas.getElemento(celdas.getElemento(celdaOriginal).getData().individuos.getElemento(individuo).getData().getCeldaObjetivoNormal()).getData().getCoordX());
        System.out.println("LAAAA yyyyy" + celdas.getElemento(celdas.getElemento(celdaOriginal).getData().individuos.getElemento(individuo).getData().getCeldaObjetivoNormal()).getData().getCoordY());

        if (coordDestX == coordOriX && coordDestY == coordOriY) {
            celdas.getElemento(celdaOriginal).getData().individuos.getElemento(individuo).getData().setCeldaObjetivoNormal(celdaAleatoria(celdaOriginal));
            ///moverNormal(celdaOriginal, individuo);
        }

        if (coordOriX != coordDestX || coordOriY != coordDestY) {


            if (coordDestX < coordOriX) {

                coordOriX--;
                celdas.getElemento(getPosCelda(coordOriX, coordOriY)).getData().individuos.add(celdas.getElemento(celdaOriginal).getData().individuos.getElemento(individuo).getData());
                celdas.getElemento(celdaOriginal).getData().individuos.getElemento(individuo).getData().colaIndividuo.add("El individuo se movio a la celda " + getPosCelda(coordOriX, coordOriY));
                celdas.getElemento(celdaOriginal).getData().individuos.del(individuo);
                updateTablero();

            } else if (coordDestX > coordOriX) {


                coordOriX++;
                celdas.getElemento(getPosCelda(coordOriX, coordOriY)).getData().individuos.add(celdas.getElemento(celdaOriginal).getData().individuos.getElemento(individuo).getData());
                celdas.getElemento(celdaOriginal).getData().individuos.getElemento(individuo).getData().colaIndividuo.add("El individuo se movio a la celda " + getPosCelda(coordOriX, coordOriY));

                celdas.getElemento(celdaOriginal).getData().individuos.del(individuo);
                updateTablero();

            } else if (coordDestY < coordOriY) {


                coordOriY--;
                celdas.getElemento(getPosCelda(coordOriX, coordOriY)).getData().individuos.add(celdas.getElemento(celdaOriginal).getData().individuos.getElemento(individuo).getData());
                celdas.getElemento(celdaOriginal).getData().individuos.getElemento(individuo).getData().colaIndividuo.add("El individuo se movio a la celda " + getPosCelda(coordOriX, coordOriY));

                celdas.getElemento(celdaOriginal).getData().individuos.del(individuo);


            } else if (coordDestY > coordOriY) {
                coordOriY++;
                celdas.getElemento(getPosCelda(coordOriX, coordOriY)).getData().individuos.add(celdas.getElemento(celdaOriginal).getData().individuos.getElemento(individuo).getData());
                celdas.getElemento(celdaOriginal).getData().individuos.getElemento(individuo).getData().colaIndividuo.add("El individuo se movio a la celda " + getPosCelda(coordOriX, coordOriY));
                celdas.getElemento(celdaOriginal).getData().individuos.del(individuo);

            }



        }
        updateTablero();

    }




    ///////////////Movimiento del avanzado////////////////
    public void moverAvanzado1(int celdaOriginal, int l) {
        ListaEnlazada<Integer> recursosDeseables = new ListaEnlazada<>();
        for (Integer i = 0; i < celdas.getNumeroElementos(); i++) {
            Integer contador = 0;
            if (celdas.getElemento(i).getData().recursos != null) {
                for (Integer j = 0; j < celdas.getElemento(i).getData().recursos.getNumeroElementos(); j++) {
                    if (celdas.getElemento(i).getData().recursos.getElemento(j).getData().getColor() != Color.DARKGREY && celdas.getElemento(i).getData().recursos.getElemento(j).getData().getColor() != Color.BURLYWOOD) {
                        contador++;

                    }
                    if (contador == celdas.getElemento(i).getData().recursos.getNumeroElementos()) {
                        recursosDeseables.add(i);

                    }

                }
            }
        }
        if (!recursosDeseables.isVacia()) {
            //Grafo<Integer> grafo1 = creamosGrafo();
//
//            Camino<Integer> caminoMinimo= new Camino<>(new ListaSimple<>(), Integer.MAX_VALUE);
//            for(Integer m=0;m<recursosDeseables.getNumeroElementos();m++){
//                Vertice<Integer> celdaActual= grafo1.getVertices().getElementoLS(celdaOriginal).getData();
//                Vertice<Integer> celdaDestino = grafo1.getVertices().getVertice(recursosDeseables.getElemento(m).getData());
//                Mapa<Vertice<Integer>, Camino<Integer>> caminos = grafo1.dijkstra(celdaActual);
//                System.out.println("LOOOOOOOsssss "+caminos.getIndice().getNumeroElementos());
//                Camino<Integer> caminoRecurso= grafo1.caminoMinimo(celdaActual,celdaDestino);
//
//                System.out.println("El caminooo "+caminoRecurso.getCamino() + "y el peso "+ caminoRecurso.getCoste());
//                if(caminoRecurso.getCoste()<=caminoMinimo.getCoste()){
//                    caminoMinimo=caminoRecurso;
//                }
//            }
//            int posDestino= caminoMinimo.getCamino().getElementoLS(1).getData().getData();
//            celdas.getElemento(posDestino).getData().individuos.add(celdas.getElemento(celdaOriginal).getData().individuos.getElemento(l).getData()); ///Añadimso el individuo a la celda destino
//            celdas.getElemento(celdaOriginal).getData().individuos.del(l);///Y lo eliminamos de su celda anterior


        }
    }


    public void moverAvanzado(int posCelda, int individuo) {
        ListaSimple<Integer> recursosPositivos = new ListaSimple<>();
        for (Integer i = 0; i < celdas.getNumeroElementos(); i++) {
            for (Integer j = 0; j < celdas.getElemento(i).getData().recursos.getNumeroElementos(); j++) {
                if (celdas.getElemento(i).getData().recursos.getElemento(j).getData().getColor() != Color.DARKGREY && celdas.getElemento(i).getData().recursos.getElemento(j).getData().getColor() != Color.BURLYWOOD) {
                    recursosPositivos.add(i);
                }
            }
        }
        if (recursosPositivos.isVacia()) {
            moverNormal(posCelda, individuo);
        } else {
            ListaEnlazada<Celdas> camino = buscarRecorridoAvanzado(recursosPositivos, posCelda, individuo);
            // ListaEnlazada<Celdas> recorrido= traducirCamino(camino);
            realizarCaminoAvanzado(camino, individuo);
            ;
        }

    }

    public void realizarCaminoAvanzado(ListaEnlazada<Celdas> recorrido, int individuo) {
        //Para recorrer cada celda por turno
        celdas.getElemento(recorrido.getElemento(0).getData().getIdentificadorCelda()).getData().individuos.del(individuo);
        Individuo ind = celdas.getElemento(recorrido.getElemento(0).getData().getIdentificadorCelda()).getData().individuos.getElemento(individuo).getData();

        celdas.getElemento(recorrido.getElemento(1).getData().getIdentificadorCelda()).getData().individuos.add(ind);
        recorrido.del(0);


    }


    public ListaEnlazada<Celdas> buscarRecorridoAvanzado(ListaSimple<Integer> recursosPositivos, int celda, int individuo) {
        Grafo<Celdas> grafoT = crearGrafo();
        System.out.println("Vertices" + grafoT.toPrintV());
        System.out.println("Aristas" + grafoT.toPrintA());
        ListaSimple<Camino<Celdas>> caminosMinimos = new ListaSimple<>();

        for (Integer i = 0; i < recursosPositivos.getNumeroElementos(); i++) {
//            Celdas celda1 = new Celdas(celdas.getElemento(celda).getData().individuos,celdas.getElemento(celda).getData().recursos,celdas.getElemento(celda).getData().getIdentificadorCelda(),celdas.getElemento(celda).getData().getCoordX(), celdas.getElemento(celda).getData().getCoordY(),celdas.getElemento(celda).getData().getListaRectangulos());
//            Celdas celda2 = new Celdas(celdas.getElemento(i).getData().individuos,celdas.getElemento(i).getData().recursos,celdas.getElemento(i).getData().getIdentificadorCelda(),celdas.getElemento(i).getData().getCoordX(), celdas.getElemento(i).getData().getCoordY(),celdas.getElemento(i).getData().getListaRectangulos());

            caminosMinimos.add(grafoT.caminoMinimo(celdas.getElemento(celda).getData(), celdas.getElemento(i).getData()));

        }

        System.out.println("Numero de caminos que hay " + caminosMinimos.getNumeroElementos());

        //De todos los caminos, queremos el que tenga un menor peso posible
        Camino<Celdas> camino = new Camino<Celdas>( caminosMinimos.getElementoLS(0).getData().getCamino(), caminosMinimos.getElementoLS(0).getData().getCoste());
        for (int j = 1; j < caminosMinimos.getNumeroElementos()-1; j++) {
            if (camino != null) {

                System.out.println("El camino no es nulo");
                if (camino.getCoste() > caminosMinimos.getElementoLS(j).getData().getCoste()) {
                    camino.setCamino(caminosMinimos.getElementoLS(j).getData().getCamino());
                    camino.setCoste(caminosMinimos.getElementoLS(j).getData().getCoste());
                }

            }
        }


        ListaEnlazada<Celdas> recorrido = new ListaEnlazada<>();

        for (Integer i = 0; i < camino.getCamino().getNumeroElementos(); i++) {
            recorrido.add((Celdas) camino.getCamino().getDato(i));
        }
        return recorrido;


    }

    public ListaEnlazada<Celdas> traducirCamino(Camino camino) {
        ListaEnlazada<Celdas> recorrido = new ListaEnlazada<>();

        for (Integer i = 0; i < camino.getCamino().getNumeroElementos(); i++) {
            recorrido.add((Celdas) camino.getCamino().getElementoLS(i).getData());
        }
        return recorrido;
    }

    public Grafo<Celdas> crearGrafo() {
        Grafo<Celdas> grafoTablero = new Grafo<>();
        for (Integer i = 0; i < celdas.getNumeroElementos(); i++) {
            Celdas celda = celdas.getElemento(i).getData();
            Vertice<Celdas> vertice = new Vertice<>(celda);
            grafoTablero.addVertices(vertice);
        }
        for (int alto = 0; alto < alturaProperty().getValue(); alto++) {
            for (int lado = 0; lado < ladoProperty().getValue(); lado++) {
                Celdas celdaActual = celdas.getElemento(getPosCelda(lado, alto)).getData();


                int pesoHacia = calcularPesoArista(celdaActual);
                if (lado > 0) {
                    Celdas izquierda = celdas.getElemento(getPosCelda(lado - 1, alto)).getData();

                    int pesoIzq = calcularPesoArista(izquierda);
                    grafoTablero.addArco(celdaActual, izquierda, pesoIzq);
                    grafoTablero.addArco(izquierda, celdaActual, pesoHacia);
                }
                if (alto > 0) {
                    Celdas arriba = celdas.getElemento(getPosCelda(lado, alto - 1)).getData();

                    int pesoArri = calcularPesoArista(arriba);
                    grafoTablero.addArco(celdaActual, arriba, pesoArri);
                    grafoTablero.addArco(arriba, celdaActual, pesoHacia);
                }
                if (lado > 0 && alto > 0) {
                    Celdas diagonalIzq = celdas.getElemento(getPosCelda(lado - 1, alto - 1)).getData();

                    int pesoDizq = calcularPesoArista(diagonalIzq);
                    grafoTablero.addArco(celdaActual, diagonalIzq, pesoDizq);
                    grafoTablero.addArco(diagonalIzq, celdaActual, pesoHacia);
                }
                if (lado < ladoProperty().getValue() - 1 && alto > 0) {
                    Celdas diagonalDer = celdas.getElemento(getPosCelda(lado + 1, alto - 1)).getData();

                    int pesoDDrch = calcularPesoArista(diagonalDer);
                    grafoTablero.addArco(celdaActual, diagonalDer, pesoDDrch);
                    grafoTablero.addArco(diagonalDer, celdaActual, pesoHacia);
                }
            }
        }
        return grafoTablero;
    }

    public int calcularPesoArista(Celdas celda) {
        int peso = 1;
        if (celda.recursos.isVacia()) {
            peso = 1;
        } else {
            for (Integer i = 0; i < celda.recursos.getNumeroElementos(); i++) {
                if (celda.recursos.getElemento(i).getData().getColor() != Color.BURLYWOOD || celda.recursos.getElemento(i).getData().getColor() != Color.DARKGREY) {
                    peso = 1;
                } else {
                    peso = 34;
                }

            }

        }
        return peso;

    }


    @FXML
    public void moverIndividuos() {
        for (Integer i = 0; i < celdas.getNumeroElementos(); i++) {
            for (Integer j = 0; j < celdas.getElemento(i).getData().individuos.getNumeroElementos(); j++) {
                if (celdas.getElemento(i).getData().individuos.getElemento(j).getData().getTipo() == 0) {//es básico
                    System.out.println("Se mueve el básico");
                    moverIndividuoBasico(celdas.getElemento(i).getData().individuos.getElemento(j).getData(), celdas.getElemento(i).getData().getIdentificadorCelda(), j);
                    updateTablero();
                } else if (celdas.getElemento(i).getData().individuos.getElemento(j).getData().getTipo() == 1) {//es normal
                    System.out.println("Se mueve el normal");
                    System.out.println("La nuevaaaaaaaaa essss " + celdaAleatoria(i));

                    moverNormal(i, j);
                    System.out.println("ya se ha movido el normal.");

                } else if (celdas.getElemento(i).getData().individuos.getElemento(j).getData().getTipo() == 2) {//es advanced
                    System.out.println("Se mueve el avanzado");
                    moverAvanzado(i, j);

                }
            }
        }
        updateTablero();
    }


    ////////////Reproducción//////////////////////
    @FXML
    public void reproduccion() {
        for (Integer i = 0; i < celdas.getNumeroElementos(); i++) {
            if (celdas.getElemento(i).getData().individuos.getNumeroElementos() >= 2) {
                Celdas celdaRep = celdas.getElemento(i).getData();
                if (celdaRep.individuos.getNumeroElementos() == 2) { //Sólo hay dos individuos para reproducirse
                    Individuo ind1 = celdas.getElemento(i).getData().individuos.getElemento(0).getData();
                    Individuo ind2 = celdas.getElemento(i).getData().individuos.getElemento(1).getData();
                    if (valorarReproduccion(ind1, ind2)) { //Si ha salido que sí:
                        ind1.colaIndividuo.add("Se ha reproducido");
                        ind2.colaIndividuo.add("Se ha reproducido");
                        ListaEnlazada<Individuo> padres = new ListaEnlazada<>();
                        padres.add(ind1);
                        padres.add(ind2);
                        if(Math.max(ind1.getTipo(), ind2.getTipo())==1){ //si es normal, hay que asociarle una celda aleatoria
                            Individuo hijo = new Individuo(Math.max(ind1.getTipo(), ind2.getTipo()), numIndividuosTotales, turnosDeVidaProperty().getValue(), turnosJuego, Math.max(ind1.getpReproCadaIndividuo(), ind2.getpReproCadaIndividuo()), Math.max(ind1.getpClonacionCadaIndividuo(), ind2.getpClonacionCadaIndividuo()), padres, celdaAleatoria(i), new Cola<>());
                            numIndividuosTotales++;
                            celdas.getElemento(i).getData().individuos.add(hijo);
                        }else{
                            Individuo hijo = new Individuo(Math.max(ind1.getTipo(), ind2.getTipo()), numIndividuosTotales, turnosDeVidaProperty().getValue(), turnosJuego, Math.max(ind1.getpReproCadaIndividuo(), ind2.getpReproCadaIndividuo()), Math.max(ind1.getpClonacionCadaIndividuo(), ind2.getpClonacionCadaIndividuo()), padres, new Cola<>());
                            numIndividuosTotales++;
                            celdas.getElemento(i).getData().individuos.add(hijo);
                        }
                    } else {
                        celdas.getElemento(i).getData().individuos.vaciar(); //como sólo se reproducen cuando hay únicamente 2, si no se reproducen se mueren los dos.

                    }
//                }else if(celdaRep.individuos.getNumeroElementos() == 3){ //Hay tres individuos en la celda; vemos si los dos primeros se reproducen o no, si es que sí pueden seguir reproduciéndose, si es que no, pues se mueren y ya
//                    Individuo ind1 = celdas.getElemento(i).getData().individuos.getElemento(0).getData();
//                    Individuo ind2 = celdas.getElemento(i).getData().individuos.getElemento(1).getData();
//                    Individuo ind3 = celdas.getElemento(i).getData().individuos.getElemento(2).getData();
//                    if (valorarReproduccion(ind1, ind2)) {//Si ha salido que sí, se van a poder seguir reproduciendo (si no, pues se mueren los dos y ya, se termina la reproducción posible)
//                        ListaEnlazada<Individuo> padres = new ListaEnlazada<>();
//                        padres.add(ind1);
//                        padres.add(ind2);
//                        Individuo hijo = new Individuo(Math.max(ind1.getTipo(), ind2.getTipo()), getIndividuosTotales().getNumeroElementos(), turnosDeVidaProperty().getValue(), turnosJuego, getColorSegunTipo(Math.max(ind1.getTipo(), ind2.getTipo())), Math.max(ind1.getpAparicionSingular(), ind2.getpAparicionSingular()), Math.max(ind1.getpReproCadaIndividuo(), ind2.getpReproCadaIndividuo()), Math.max(ind1.getpClonacionCadaIndividuo(), ind2.getpClonacionCadaIndividuo()), padres);
//                        celdas.getElemento(i).getData().individuos.add(hijo);
//                        if (valorarReproduccion(ind2, ind3)) { //Si ha salido que sí, lo intenta el 1 con el 3
//                            ListaEnlazada<Individuo> padres2 = new ListaEnlazada<>();
//                            padres.add(ind2);
//                            padres.add(ind3);
//                            Individuo hijo2 = new Individuo(Math.max(ind2.getTipo(), ind3.getTipo()), getIndividuosTotales().getNumeroElementos(), turnosDeVidaProperty().getValue(), turnosJuego, getColorSegunTipo(Math.max(ind2.getTipo(), ind3.getTipo())), Math.max(ind2.getpAparicionSingular(), ind3.getpAparicionSingular()), Math.max(ind2.getpReproCadaIndividuo(), ind3.getpReproCadaIndividuo()), Math.max(ind2.getpClonacionCadaIndividuo(), ind3.getpClonacionCadaIndividuo()), padres2);
//                            celdas.getElemento(i).getData().individuos.add(hijo2);
//                            if (valorarReproduccion(ind1, ind3)) { //Si ha salido que sí, lo intenta el 1 con el 3
//                                ListaEnlazada<Individuo> padres3 = new ListaEnlazada<>();
//                                padres.add(ind1);
//                                padres.add(ind3);
//                                Individuo hijo3 = new Individuo(Math.max(ind1.getTipo(), ind3.getTipo()), getIndividuosTotales().getNumeroElementos(), turnosDeVidaProperty().getValue(), turnosJuego, getColorSegunTipo(Math.max(ind1.getTipo(), ind3.getTipo())), Math.max(ind1.getpAparicionSingular(), ind3.getpAparicionSingular()), Math.max(ind1.getpReproCadaIndividuo(), ind3.getpReproCadaIndividuo()), Math.max(ind1.getpClonacionCadaIndividuo(), ind3.getpClonacionCadaIndividuo()), padres3);
//                                celdas.getElemento(i).getData().individuos.add(hijo3);
//                            }
//                        }
//                    }
                }
            }
        }
    }

    private boolean valorarReproduccion(Individuo ind1, Individuo ind2) { //0 es que no, 1 es que sí; devolvemos un booleano
        Random random = new Random();
        int randomRep1 = random.nextInt(101);
        int randomRep2 = random.nextInt(101);
        boolean reproduccion = false;
        int rep1 = 0;
        if (randomRep1 <= ind1.getpReproCadaIndividuo()) {
            rep1 = 1;
        }
        int rep2 = 0;
        if (randomRep2 <= ind2.getpReproCadaIndividuo()) {
            rep2 = 1;
        }
        if (rep1 == 1 && rep2 == 1) {
            reproduccion = true;
        }
        return reproduccion;
    }


    ///////////////Clonación/////////////////
    @FXML
    public void clonacion() {
        for (Integer j = 0; j < celdas.getNumeroElementos(); j++) {
            ListaEnlazada<Individuo> individuoListaEnlazada = celdas.getElemento(j).getData().individuos;
            if (individuoListaEnlazada != null) {
                int longitud = celdas.getElemento(j).getData().individuos.getNumeroElementos();
                for (Integer i = 0; i < longitud; i++) {
                    Random random = new Random();
                    int numAleatorio = random.nextInt(101);
                    Individuo ind = celdas.getElemento(j).getData().individuos.getElemento(i).getData();
                    if (numAleatorio <= ind.getpClonacionCadaIndividuo()) {
                        ListaEnlazada<Individuo> padres = new ListaEnlazada<>();
                        padres.add(ind);
                        Individuo indClonado = new Individuo(ind.getTipo(), numIndividuosTotales, ind.getTurnosDeVida(), turnosJuego, ind.getpReproCadaIndividuo(), ind.getpClonacionCadaIndividuo(), padres,new Cola<>());
                        numIndividuosTotales++;
                        celdas.getElemento(j).getData().individuos.add(indClonado);

                        ind.colaIndividuo.add("Se ha clonado el individuo");
                        ind.colaIndividuo.add("clonado");
                    }
                }
            }
        }
    }


    //////////////Grafo en base a las colas de cada individuo/////////////



    //////////////Eliminación de individuos//////////////////
    @FXML
    public void eliminacionIndividuos() {
        for (Integer i = 0; i < celdas.getNumeroElementos(); i++) {
            if (celdas.getElemento(i).getData().individuos.getNumeroElementos() > 3) {
                int eliminar = celdas.getElemento(i).getData().individuos.getNumeroElementos() - 3;
                for (Integer eliminados = 0; eliminados < eliminar; eliminados++) {
                    Celdas celdaBorrar = celdas.getElemento(i).getData();
                    Integer idIndivBorrar = 0;
                    Integer menorvida = celdaBorrar.individuos.getElemento(idIndivBorrar).getData().getTurnosDeVida();
                    for (Integer posIndiv = 1; posIndiv < celdaBorrar.individuos.getNumeroElementos(); posIndiv++) {
                        if (celdaBorrar.individuos.getElemento(posIndiv).getData().getTurnosDeVida() < menorvida) {
                            menorvida = celdaBorrar.individuos.getElemento(posIndiv).getData().getTurnosDeVida();
                            idIndivBorrar = posIndiv;
                        }
                    }
                    celdas.getElemento(i).getData().individuos.del(idIndivBorrar);
                }
            }
        }
    }




    @FXML
    public void turnoPasa() {
        turnosJuego++;


        actualizarTurnoIndividuos();
        actualizarTurnoVidaRecursos();


        //moverIndividuos();
        //mejorasIndividuosRecursos();

        reproduccion();
        //clonacion();


        crearRecursos();
        //eliminacionIndividuos();
        updateTablero();
        actualizarPaneLateral();
        System.out.println("Se ha finalizado el turno " + turnosJuego);
    }


    private void bucleDeControlIniciar() {
        if (control == null) {
            control = new Timeline(new KeyFrame(Duration.seconds(1), event -> {
                if (!isPausa()) {
                    turnoPasa();
                } else {
                    System.out.println("Bucle pausado");
                    control.stop();
                }
            }));
            control.setCycleCount(Animation.INDEFINITE);
        } else {
            control.stop(); // Detener la animación si ya estaba en marcha
        }
        control.play(); // Iniciar o reanudar la animación
    }







    public void loadUserData(TableroProperties tablero) {
        this.modelo = tablero;
    }

    public void setStage(Stage s) {
        this.scene = s;
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        System.out.println("Inicialización del tablero");

        if(!isPartidaCargada()){
            crearNuevoTablero();
        } else {
            cargarTablero();
        }

//
//        tableroJuego.setVisible(true);
//
//        //Vaciamos el gridpane
//        informacionGridPane.getChildren().clear();
//        informacionGridPane.setAlignment(Pos.CENTER);
//        informacionGridPane.setMinSize(400, 700);
//
//
//        ///Vaciamos el gridPane en el que vamos a crear los el tablero de botones
//        tableroJuego.getChildren().clear();
//        tableroJuego.setPadding(new Insets(valorAltura.getValue() * valorLado.getValue()));
//        tableroJuego.setGridLinesVisible(true);
//        tableroJuego.setHgap(0);
//        tableroJuego.setVgap(0);
//        tableroJuego.setMinSize(800, 800);
//        tableroJuego.setAlignment(Pos.CENTER);
//        Integer ident = 0;
//        for (Integer i = 0; i < valorAltura.getValue(); i++) {
//            for (Integer j = 0; j < valorLado.getValue(); j++) {
//                Button celdaButton = new Button();
//                celdaButton.setId(String.valueOf(ident));
//                GridPane.setRowIndex(celdaButton, i);
//                GridPane.setColumnIndex(celdaButton, j);
//                celdaButton.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
//                celdaButton.setStyle("-fx-background-color: #cef18c");
//                celdaButton.setOnAction((ActionEvent event) -> {
//                    System.out.println("EL BOTÓN " + celdaButton.getId() + " HA SIDO PULSADO");
//                    onCeldaButtonClick(celdaButton, event);
//                });
//
//                GridPane fondoCelda = new GridPane();
//                fondoCelda.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
//                ListaEnlazada<StackPane> listaCuadraditos = new ListaEnlazada<>();
//                for (Integer p1 = 0; p1 < 3; p1++) {
//                    for (Integer p2 = 0; p2 < 2; p2++) {
//                        StackPane cuadraditoanadir = createRectangle(Color.LIGHTGRAY);
//                        cuadraditoanadir.resize(Double.MAX_VALUE, Double.MAX_VALUE);
//                        listaCuadraditos.add(cuadraditoanadir);
//                        fondoCelda.add(cuadraditoanadir, p1, p2);
//                    }
//                }
//                celdaButton.setGraphic(fondoCelda);
//
//                tableroJuego.getChildren().add(celdaButton);
//                GridPane.setHgrow(celdaButton, Priority.ALWAYS);
//                GridPane.setVgrow(celdaButton, Priority.ALWAYS);
//                tableroJuego.setDisable(false);
//
//                ListaEnlazada<Individuo> inds = new ListaEnlazada<>();
//                ListaEnlazada<Recurso> recs = new ListaEnlazada<>();
//                Celdas cel = new Celdas(inds, recs, ident, i, j, listaCuadraditos);
//                celdas.add(cel);
//                ident++;
//            }
//        }
//        crearIndividuosIniciales();
//        actualizarPaneLateral();
//        crearRecursos();
//        updateTablero();
//
//        //añadir();



    }
}
