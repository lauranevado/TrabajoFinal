package com.example.pruebafinal_.MyC;

import com.example.pruebafinal_.MyC.Guardado.DatosCargados;
import com.example.pruebafinal_.MyC.Informaciones.InformacionComoJugarControllers;
import com.example.pruebafinal_.MyC.Parametros.Parametros;
import com.example.pruebafinal_.MyC.Parametros.ParametrosControllers;
import com.example.pruebafinal_.MyC.Parametros.ParametrosProperties;
import com.example.pruebafinal_.MyC.Tablero.Tablero;
import com.example.pruebafinal_.MyC.Tablero.TableroControllers;
import com.example.pruebafinal_.MyC.Tablero.TableroProperties;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import java.net.URL;
import java.util.ResourceBundle;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static com.example.pruebafinal_.MyC.JuegoDeLaVida.cargarObjetoDesdeArchivo;
import static com.example.pruebafinal_.MyC.Parametros.ParametrosProperties.*;
import static com.example.pruebafinal_.MyC.Tablero.Tablero.*;
import static com.example.pruebafinal_.MyC.Tablero.Tablero.turnosJuego;

public class JuegoPantallaPpalControllers implements Initializable {

    @FXML
    private Label cargando;
    @FXML
    private Button nuevaPartidaButton, cargarPartidaButton;
    @FXML
    private Button informacionComoJugarButton;

//    @FXML
//    ImageView miImagenView;
//    @FXML
//    Image miImagen= new Image(getClass().getResourceAsStream("JuegoVida.Portada"));




    private Parametros parametros= new Parametros(5,1,50,50,50,0.333,0.333,0.333,5,5,3, 70,2,16,1,16,1,16,20,16,10,16,0,16);
    private ParametrosProperties parametrosCompartir = new ParametrosProperties(parametros);


    private static final Logger log = LogManager.getLogger(JuegoPantallaPpalControllers.class);


    @FXML
    protected void onNuevaPartidaButtonClick(){
        Stage stageBorrar= (Stage) nuevaPartidaButton.getScene().getWindow();
        stageBorrar.close();
//        Stage stageInfoBorrar = (Stage) informacionComoJugarButton.getScene().getWindow();
//        stageInfoBorrar.close(); //ahora mismo esto no funciona
        System.out.println("Se ha cerrado la pantalla principal");
        log.info("Se ha cerrado la pantalla");
        cargando.setText("Ha elegido crear una nueva partida");
        log.info("Crear una nueva partida");
        Stage stage = new Stage();
        FXMLLoader fxmlLoader=new FXMLLoader(JuegoDeLaVida.class.getResource("/com/example/pruebafinal_/juego-parametros.fxml"));
        try {
            Scene scene = new Scene(fxmlLoader.load());
            stage.setTitle("Parámetros");
            log.info("Parámetros");
            stage.setScene(scene);
            stage.setResizable(false);
            ParametrosControllers pParam = fxmlLoader.getController();
            pParam.loadUserData(this.parametrosCompartir);
            pParam.setStage(stage);
            stage.show();
        } catch (Exception e) { e.printStackTrace();}

    }
//    @FXML
//    public void displayImage(){
//        miImagenView.setImage(miImagen);
//    }

    private Tablero tablero= new Tablero( celdas );
    private TableroProperties tableroCompartir = new TableroProperties(tablero);


    @FXML
    protected void onCargarPartidaButtonClick(){ //hacer una pestaña antes en la que elegir la partida que quiere cargar
        setPartidaCargada(true);
        String rutaArchivo = "partidas.json";

        DatosCargados datosCargadosPartida1 = cargarObjetoDesdeArchivo(rutaArchivo);

        if (datosCargadosPartida1 != null) {
            System.out.println("Partida cargada:(num turnos) " + datosCargadosPartida1.getTurnosJuego());
            System.out.println("Partida cargada:(p rep) " + datosCargadosPartida1.getpRep());
            turnosJuego = datosCargadosPartida1.getTurnosJuego();
            pRepProperty().setValue(datosCargadosPartida1.getpRep());
            pMuerteProperty().setValue(datosCargadosPartida1.getpMuerte());
            pClonProperty().setValue(datosCargadosPartida1.getpClon());
            ladoProperty().setValue(datosCargadosPartida1.getLado());
            alturaProperty().setValue(datosCargadosPartida1.getAltura());
            tiempoDeAparicionProperty().setValue(datosCargadosPartida1.getProbabilidadDeAparicion());
            probabilidadDeAparicionProperty().setValue(datosCargadosPartida1.getProbabilidadDeAparicion());
            vidaAguaSumaProperty().setValue(datosCargadosPartida1.getVidaAguaSuma());
            pAgua().setValue(datosCargadosPartida1.getpAgua());
            vidaComidaSumaProperty().setValue(datosCargadosPartida1.getVidaComidaSuma());
            pComida().setValue(datosCargadosPartida1.getpComida());
            vidaMontanaRestaProperty().setValue(datosCargadosPartida1.getVidaMontanaResta());
            pMontana().setValue(datosCargadosPartida1.getpMontana());
            pReproTesoroSumaProperty().setValue(datosCargadosPartida1.getpReproTesoroSuma());
            pTesoro().setValue(datosCargadosPartida1.getpTesoro());
            pClonacionBibliotecaSumaProperty().setValue(datosCargadosPartida1.getpClonacionBiblioteca());
            pBiblioteca().setValue(datosCargadosPartida1.getpClonacionBiblioteca());
            muertePozoProperty().setValue(datosCargadosPartida1.getMuertePozo());
            pPozo().setValue(datosCargadosPartida1.getpPozo());
            celdas=datosCargadosPartida1.celdas;
            //tablero.setCeldas(datosCargadosPartida1.celdas);
//            ListaEnlazada<Celdas> celdass= new ListaEnlazada<>();
//            for (Integer i = 0; i < datosCargadosPartida1.celdas.getNumeroElementos(); i++) {
//                celdass.add(new Celdas(datosCargadosPartida1.celdas.getElemento(i).getData().getIndividuos(), datosCargadosPartida1.celdas.getElemento(i).getData().getRecursos(), datosCargadosPartida1.celdas.getElemento(i).getData().getIdentificadorCelda(), datosCargadosPartida1.celdas.getElemento(i).getData().getCoordX(), datosCargadosPartida1.celdas.getElemento(i).getData().getCoordY(), datosCargadosPartida1.celdas.getElemento(i).getData().getListaRectangulos()));
//                //celdas.getElemento(i).getData().setData(datosCargadosPartida1.celdas.getElemento(i).getData());
////                celdass.getElemento(i).getData().setIndividuos(datosCargadosPartida1.celdas.getElemento(i).getData().getIndividuos());
////                celdass.getElemento(i).getData().setRecursos(datosCargadosPartida1.celdas.getElemento(i).getData().getRecursos());
////                celdass.getElemento(i).getData().setIdentificadorCelda(datosCargadosPartida1.celdas.getElemento(i).getData().getIdentificadorCelda());
////                celdass.getElemento(i).getData().setCoordX(datosCargadosPartida1.celdas.getElemento(i).getData().getCoordX());
////                celdass.getElemento(i).getData().setCoordY(datosCargadosPartida1.celdas.getElemento(i).getData().getCoordY());
////                celdass.getElemento(i).getData().setListaRectangulos(datosCargadosPartida1.celdas.getElemento(i).getData().getListaRectangulos());
//
//            }
//
//            celdas=celdass;
            //celdas= datosCargadosPartida1.getCeldas();
            turnosJuego = datosCargadosPartida1.getTurnosJuego();

        }

        Tablero tablero= new Tablero( datosCargadosPartida1.celdas );
        this.tableroCompartir = new TableroProperties(tablero);


//        Stage stageBorrar= (Stage) cargarPartidaButton.getScene().getWindow();
//        stageBorrar.close();
        System.out.println("Se ha cerrado la pantalla principal");
        log.info("Se ha cerrado la pantalla");
        //cargando.setText("Ha elegido cargar una partida");
        log.info("Cargar una partida");
        Stage stage = new Stage();
        FXMLLoader fxmlLoader=new FXMLLoader(JuegoDeLaVida.class.getResource("/com/example/pruebafinal_/juego-tablero.fxml"));
        try {
            Scene scene = new Scene(fxmlLoader.load());
            stage.setMaximized(true);
            stage.setResizable(false);
            stage.setTitle("El juego de la vida");
            stage.setScene(scene);
            TableroControllers tableroControllers = fxmlLoader.getController();
            tableroControllers.loadUserData(tableroCompartir);
            tableroControllers.setStage(stage);
            stage.show();

        } catch (Exception e) { e.printStackTrace();}

    }



    @FXML
    protected void onInformacionComoJugarButtonClick(){
        log.info("Información sobre el juego");
        Stage stage = new Stage();
        FXMLLoader fxmlLoader=new FXMLLoader(Parametros.class.getResource("/com/example/pruebafinal_/juego-informacionComoJugar.fxml"));
        try {
            Scene scene = new Scene(fxmlLoader.load(),600,400);//ajustar bien el tamaño que queramos y con los label fijos !!!!!!!!!!!!!!!!!con sliding nseque
            stage.setTitle("¿Cómo jugar?");
            stage.setScene(scene);
            InformacionComoJugarControllers infoComoJugar = fxmlLoader.getController();
            infoComoJugar.setStage(stage);
            stage.setResizable(false);
            stage.setFullScreen(false);
            stage.show();
            informacionComoJugarButton.setDisable(true);
            stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
                @Override
                public void handle(WindowEvent windowEvent) {
                    System.out.println("Se ha cerrado la ventana de información sobre el juego.");
                    log.info("Se ha cerrado la ventana de información sobre el juego.");
                    informacionComoJugarButton.setDisable(false);
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }





    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        log.info("Inicialización en ejecución del controlador\n");
        System.out.print("Inicialización en ejecución del controlador\n");



    }
}
