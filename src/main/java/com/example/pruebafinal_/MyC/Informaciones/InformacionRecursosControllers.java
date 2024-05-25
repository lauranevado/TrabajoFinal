package com.example.pruebafinal_.MyC.Informaciones;

import com.example.pruebafinal_.MyC.JuegoDeLaVida;
import javafx.fxml.Initializable;
import javafx.stage.Stage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.net.URL;
import java.util.ResourceBundle;

public class InformacionRecursosControllers implements Initializable {

    private static final Logger log = LogManager.getLogger(JuegoDeLaVida.class);

    //Atributos necesarios
    private Stage scene;




    public void setStage (Stage s){
        this.scene=s;
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
