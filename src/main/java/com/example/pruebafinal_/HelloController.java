package com.example.pruebafinal_;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import javax.security.auth.login.Configuration;
import java.lang.reflect.Parameter;
import java.net.URL;
import java.util.ResourceBundle;

public class HelloController {
    @FXML
    private Label welcomeText; //Enganchamos un Label con el nombre welcomeText
    public Label labelTextoEjemplo;
    public Label valorSlider;
    private Slider miSlider;



    protected StringProperty texto= new SimpleStringProperty("No hay nada");
    //Para cambiar el texto del botón
    protected IntegerProperty num = new SimpleIntegerProperty(0);
    //Para cambiar los números de los botones

    //Moddelo de datos


    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }

    @FXML
    protected void onNuevaPartidaButtonClick(){
        welcomeText.setText("Has elegido crear una nueva partida.");
    }


    @FXML
    public void initialize(URL location, ResourceBundle resources) { //Los cambios que se hacen aqui se reflejan directamente en la vista
        System.out.println("Inicializar");



    }
//    protected void onMiBotonNuevaVentana(){  //Para crear ventanas dentro de ventanas
//        Stage stage = new Stage();
//        FXMLLoader fxmlLoader= new FXMLLoader(HelloApplication.class.getResource("Ventana Hija"));
//        try{
//            Scene scene = new Scene(fxmlLoader.load(),120,344);
//            stage.setTitle("hola");
//            stage.setScene(scene);
//            stage.show();
//
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }

}