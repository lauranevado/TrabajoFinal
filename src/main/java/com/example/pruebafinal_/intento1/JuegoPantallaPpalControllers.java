package com.example.pruebafinal_.intento1;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import java.net.URL;
import java.util.ResourceBundle;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static com.example.pruebafinal_.intento1.Tablero.celdas;
import static com.example.pruebafinal_.intento1.Tablero.setPartidaCargada;

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


    private InformacionComoJugar info= new InformacionComoJugar("");
    private InformacionComoJugarProperties informacion = new InformacionComoJugarProperties(info);

    private static final Logger log = LogManager.getLogger(JuegoPantallaPpalControllers.class);


    @FXML
    protected void onNuevaPartidaButtonClick(){
        setPartidaCargada(false);
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
        Stage stageBorrar= (Stage) cargarPartidaButton.getScene().getWindow();
        stageBorrar.close();
        System.out.println("Se ha cerrado la pantalla principal");
        log.info("Se ha cerrado la pantalla");
        cargando.setText("Ha elegido cargar una partida");
        log.info("Cargar una nueva partida");
        Stage stage = new Stage();
        FXMLLoader fxmlLoader=new FXMLLoader(JuegoDeLaVida.class.getResource("/com/example/pruebafinal_/juego-tablero.fxml"));
        try {
            Scene scene = new Scene(fxmlLoader.load());
            stage.setTitle("El juego de la vida");
            stage.setScene(scene);
            TableroControllers tableroControllers = fxmlLoader.getController();
            tableroControllers.loadUserData(this.tableroCompartir);
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
            infoComoJugar.loadInfoData(this.informacion);
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
