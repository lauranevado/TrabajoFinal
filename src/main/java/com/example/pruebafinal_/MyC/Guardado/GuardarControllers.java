package com.example.pruebafinal_.MyC.Guardado;

import com.example.pruebafinal_.MyC.JuegoDeLaVida;
import com.example.pruebafinal_.MyC.PartidaFinalizada.InformacionPartidaControllers;
import com.example.pruebafinal_.MyC.PartidaFinalizada.InformacionPartida;
//import com.example.pruebafinal_.MyC.PartidaFinalizada.InformacionPartidaProperties;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.net.URL;
import java.util.ResourceBundle;

import static com.example.pruebafinal_.MyC.JuegoDeLaVida.guardarPartidaEnArchivo;
import static com.example.pruebafinal_.MyC.Parametros.ParametrosProperties.*;
import static com.example.pruebafinal_.MyC.Tablero.Tablero.*;

public class GuardarControllers implements Initializable {

    private DatosCargados modelo;
    private Stage scene;

    private Stage stageTableroBorrar;


    @FXML
    private Button salirButton, guardarButton;
    private  final Logger log= LogManager.getLogger(JuegoDeLaVida.class);

//meter un logger

    @FXML
    private void onSalirButtonClick() {
//        scene.close();
        log.info("Se van a enseñar los datos de la partida.");
//
//        //System.out.println("Se ha pulsado un botón; enseñando información");
        Stage guardarStage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(DatosCargados.class.getResource("/com/example/pruebafinal_/juego-informacion-partida.fxml"));
        try {
            Stage stageInfoBorrar = (Stage) salirButton.getScene().getWindow();
            stageInfoBorrar.close();
            //stageTableroBorrar.close();
            Scene scene = new Scene(fxmlLoader.load(), 800, 800);
            guardarStage.setTitle("Información de la partida");
            guardarStage.setScene(scene);
            InformacionPartidaControllers infoControllers = fxmlLoader.getController();
            infoControllers.loadInformacionPartidaData(new InformacionPartida(turnosJuego, getIndividuosActuales().getNumeroElementos(),getIndividuosActuales().getElemento(0).getData())); /////////
//            guardarStage.initModality(Modality.APPLICATION_MODAL);
//            Stage stageAnterior = (Stage) ((Button) event.getSource()).getScene().getWindow();
//            guardarStage.initOwner(stageAnterior);
            infoControllers.setStage(guardarStage);
            guardarStage.setResizable(false);
            guardarStage.setOnHidden(evento -> {
                System.out.println("Se cerró la ventana de guardado");
            });
//            guardarStage.show();
            guardarStage.showAndWait();
//            updateTablero();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void onGuardarButtonClick() {

        System.out.println("Se va a guardar la partida y llevar al menú inicial.");

//        //DatosCargados datosPartida2= new DatosCargados(turnosDeVidaProperty().getValue(), pRepProperty().getValue(),pMuerteProperty().getValue(), pClonProperty().getValue(),ladoProperty().getValue(), alturaProperty().getValue(),tiempoDeAparicionProperty().getValue(), probabilidadDeAparicionProperty().getValue(),vidaAguaSumaProperty().getValue(),pAgua().getValue(),vidaComidaSumaProperty().getValue(),pComida().getValue(),vidaMontanaRestaProperty().getValue(),pMontana().getValue(),pReproTesoroSumaProperty().getValue(),pTesoro().getValue(),pClonacionBibliotecaSumaProperty().getValue(),pBiblioteca().getValue(),0,pPozo().getValue(), celdas, getNumIndividuosTotales(), getTurnosJuego());
        DatosCargados datosPartida1= new DatosCargados(turnosDeVidaProperty().getValue().intValue(), pRepProperty().getValue().intValue(),pMuerteProperty().getValue().intValue(), pClonProperty().getValue().intValue(),ladoProperty().getValue().intValue(), alturaProperty().getValue().intValue(),tiempoDeAparicionProperty().getValue().intValue(), probabilidadDeAparicionProperty().getValue().intValue(),vidaAguaSumaProperty().getValue().intValue(),pAgua().getValue().intValue(),vidaComidaSumaProperty().getValue().intValue(),pComida().getValue().intValue(),vidaMontanaRestaProperty().getValue().intValue(),pMontana().getValue().intValue(),pReproTesoroSumaProperty().getValue().intValue(),pTesoro().getValue().intValue(),pClonacionBibliotecaSumaProperty().getValue().intValue(),pBiblioteca().getValue().intValue(),0,pPozo().getValue().intValue(), celdas, getNumIndividuosTotales(), getTurnosJuego());
        String rutaArchivo = "partidas.json";

        guardarPartidaEnArchivo(rutaArchivo, datosPartida1);

        Stage stageInfoBorrar = (Stage) guardarButton.getScene().getWindow();
        stageInfoBorrar.close();
        stageTableroBorrar.close();
//
//        DatosCargados datosCargadosPartida1 = cargarObjetoDesdeArchivo(rutaArchivo, DatosCargados.class);
//
//        if (datosPartida1 != null){
//            System.out.println("Partida cargada:(num individuos totales) " + datosCargadosPartida1.getNumIndividuosTotales());
//        }

        //scene.close();
//        System.out.println("Inicialización de pantalla de juego");
//        Stage stage = new Stage();
//        FXMLLoader fxmlLoader=new FXMLLoader(Guardar.class.getResource("/com/example/pruebafinal_/juego-tablero.fxml"));
//        try {
//            Scene scene = new Scene(fxmlLoader.load());
//            stage.setMaximized(true);
//            stage.setResizable(false);
//            stage.setTitle("El juego de la vida");
//            stage.setScene(scene);
//            TableroControllers tableroControllers = fxmlLoader.getController();
//            //tableroControllers.loadUserData(this.tableroCompartir);
//            tableroControllers.setStage(stage);
//            stage.show();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
    }


    public void loadGuardarData(DatosCargados tablero, Stage stageBorrar) {
        this.modelo = tablero;
        this.stageTableroBorrar= stageBorrar;
    }

    public void setStage(Stage s) {
        this.scene = s;
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
//        siButton.setOnAction(actionEvent -> {
//            onSiButtonClick();
//        });
//        noButton.setOnAction(actionEvent -> {
//            onNoButtonClick(actionEvent);
//        });
    }
}
