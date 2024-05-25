package com.example.pruebafinal_.MyC.PartidaFinalizada;

import com.example.pruebafinal_.MyC.PartidaFinalizada.InformacionPartida;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class InformacionPartidaControllers implements Initializable {

    private InformacionPartida modelo;
    private Stage scene;

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
            turnosJugadosLabel.setText(String.valueOf(modelo.getTurnosJugados()));
            individuosVivosLabel.setText(String.valueOf(modelo.getIndividuosVivos()));
            numClonacionesLabel.setText(String.valueOf(modelo.getNumMutaciones()));
            numReproduccionesLabel.setText(String.valueOf(modelo.getNumReproducciones()));
        }
    }
}
