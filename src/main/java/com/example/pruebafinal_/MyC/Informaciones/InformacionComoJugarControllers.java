package com.example.pruebafinal_.MyC.Informaciones;

import javafx.fxml.Initializable;
import javafx.stage.Stage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.net.URL;
import java.util.ResourceBundle;

public class InformacionComoJugarControllers implements Initializable {
    //Atributos necesarios
    private static final Logger log = LogManager.getLogger(InformacionComoJugarControllers.class);
    private Stage scene;



    public void setStage (Stage s){
        this.scene=s;
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        log.info("Se ha abierto la pestaña de información sobre el juego");
        System.out.println("Se ha abierto la pestaña de información sobre el juego");
    }
}
