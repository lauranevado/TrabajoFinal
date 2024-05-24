package com.example.pruebafinal_.intento1;

import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.net.URL;
import java.util.ResourceBundle;

public class InformacionRecursosControllers implements Initializable {

    private static final Logger log = LogManager.getLogger(InformacionRecursosProperties.class);

    //Atributos necesarios
    private Stage scene;
    //private Label welcomeText;
    private InformacionRecursosProperties modelo;

    protected void updateGUIconmodelo(){

    }
//    protected void onHelloButtonClick(){
//        log.info("Se abre pestaña sobre la información de los recursos");
//        welcomeText.setText("Información de los recursos");
//    }

    public void loadInfoData(InformacionRecursosProperties info){
        this.modelo = info;
        this.updateGUIconmodelo();
    }


    public void setStage (Stage s){
        this.scene=s;
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {

        //welcomeText.setText("Informacion de los recursos");
        if (modelo !=null){
            this.updateGUIconmodelo();
        }
    }
}
