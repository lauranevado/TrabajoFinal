package com.example.pruebafinal_.MyC.Guardado;

import com.example.pruebafinal_.MyC.JuegoDeLaVida;
import com.example.pruebafinal_.MyC.PartidaFinalizada.InformacionPartidaControllers;
import com.example.pruebafinal_.MyC.PartidaFinalizada.InformacionPartida;
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

    @FXML
    private void onSalirButtonClick() {
        log.info("Se van a enseñar los datos de la partida.");
        Stage guardarStage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(DatosCargados.class.getResource("/com/example/pruebafinal_/juego-informacion-partida.fxml"));
        try {
            Stage stageInfoBorrar = (Stage) salirButton.getScene().getWindow();
            stageInfoBorrar.close();
            stageTableroBorrar.close();
            Scene scene = new Scene(fxmlLoader.load(), 600, 500);
            guardarStage.setTitle("Información de la partida");
            guardarStage.setScene(scene);
            InformacionPartidaControllers infoControllers = fxmlLoader.getController();
            infoControllers.loadInformacionPartidaData(new InformacionPartida(turnosJuego, getIndividuosActuales().getNumeroElementos(),getIndividuosActuales().getElemento(0).getData()));
            infoControllers.setStage(guardarStage);
            guardarStage.setResizable(false);
            guardarStage.setOnHidden(evento -> {
                System.out.println("Se cerró la ventana de guardado");
            });
            guardarStage.showAndWait();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void onGuardarButtonClick() {

        System.out.println("Se va a guardar la partida y llevar al menú inicial.");

        DatosCargados datosPartida1= new DatosCargados(turnosDeVidaProperty().getValue().intValue(), pRepProperty().getValue().intValue(),pMuerteProperty().getValue().intValue(), pClonProperty().getValue().intValue(),ladoProperty().getValue().intValue(), alturaProperty().getValue().intValue(),tiempoDeAparicionProperty().getValue().intValue(), probabilidadDeAparicionProperty().getValue().intValue(),vidaAguaSumaProperty().getValue().intValue(),pAgua().getValue().intValue(),vidaComidaSumaProperty().getValue().intValue(),pComida().getValue().intValue(),vidaMontanaRestaProperty().getValue().intValue(),pMontana().getValue().intValue(),pReproTesoroSumaProperty().getValue().intValue(),pTesoro().getValue().intValue(),pClonacionBibliotecaSumaProperty().getValue().intValue(),pBiblioteca().getValue().intValue(),0,pPozo().getValue().intValue(), celdas, getNumIndividuosTotales(), getTurnosJuego());
        String rutaArchivo = "partidas.json";

        guardarPartidaEnArchivo(rutaArchivo, datosPartida1);

        Stage stageInfoBorrar = (Stage) guardarButton.getScene().getWindow();
        stageInfoBorrar.close();
        stageTableroBorrar.close();

        System.out.println("Inicialización de pantalla inicial de nuevo");
        Stage stage = new Stage();
        FXMLLoader fxmlLoader=new FXMLLoader(DatosCargados.class.getResource("/com/example/pruebafinal_/juego-pantalla-ppal.fxml"));
        try {
            Scene scene = new Scene(fxmlLoader.load());
            stage.setMaximized(true);
            stage.setResizable(false);
            stage.setTitle("El juego de la vida");
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
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

    }
}
