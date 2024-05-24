package com.example.pruebafinal_.intento1;

import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.net.URL;
import java.util.ResourceBundle;

public class InformacionComoJugarControllers implements Initializable {
    //Atributos necesarios
    private static final Logger log = LogManager.getLogger(InformacionComoJugarControllers.class);
    private Stage scene;
    private InformacionComoJugarProperties modelo;


    protected void updateGUIconmodelo(){}
    public void loadInfoData(InformacionComoJugarProperties info){
        this.modelo = info;
        this.updateGUIconmodelo();
    }


    public void setStage (Stage s){
        this.scene=s;
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        log.info("Se ha abierto la pestaña de información sobre el juego");
        System.out.println("Se ha abierto la pestaña de información sobre el juego");
        if (modelo !=null){
            this.updateGUIconmodelo();
        }
    }
}
