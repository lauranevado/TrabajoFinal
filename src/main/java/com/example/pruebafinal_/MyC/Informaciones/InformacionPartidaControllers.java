package com.example.pruebafinal_.MyC.Informaciones;

import com.example.pruebafinal_.MyC.PartidaFinalizada.InformacionPartida;
import javafx.fxml.Initializable;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class InformacionPartidaControllers implements Initializable {

    private InformacionPartida modelo;
    private Stage scene;


    public void loadInformacionPartidaData(InformacionPartida tablero) {
        this.modelo = tablero;
    }

    public void setStage(Stage s) {
        this.scene = s;
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
