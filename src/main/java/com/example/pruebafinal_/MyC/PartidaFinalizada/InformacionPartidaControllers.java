package com.example.pruebafinal_.MyC.PartidaFinalizada;

import com.example.pruebafinal_.MyC.JuegoDeLaVida;
import com.example.pruebafinal_.MyC.PartidaFinalizada.InformacionPartida;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.net.URL;
import java.util.ResourceBundle;

public class InformacionPartidaControllers implements Initializable {

    private InformacionPartida modelo;
    private Stage scene;
    private  final Logger log= LogManager.getLogger(JuegoDeLaVida.class);

    @FXML
    private Label turnosJugadosLabel, individuosVivosLabel,numClonacionesLabel, numReproduccionesLabel;


    public void loadInformacionPartidaData(InformacionPartida tablero) {
        this.modelo = tablero;
    }

    public void setStage(Stage s) {
        this.scene = s;
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        if (this.modelo!= null) {
            log.info("Se ha inicializado");
            //turnosJugadosLabel.setText(String.valueOf(modelo.getTurnosJugados()));
            turnosJugadosLabel.setText("10");
            individuosVivosLabel.setText(String.valueOf(modelo.getIndividuosVivos()));
            numClonacionesLabel.setText(String.valueOf(modelo.getNumMutaciones()));
            numReproduccionesLabel.setText(String.valueOf(modelo.getNumReproducciones()));

        }
    }
}
