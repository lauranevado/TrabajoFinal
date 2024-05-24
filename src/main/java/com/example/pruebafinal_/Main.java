package com.example.pruebafinal_;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {

    @Override
    public void start(Stage stagePrincipal) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("PantallaPrincipal.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stagePrincipal.setTitle("El juego de la vida");
        stagePrincipal.setScene(scene);
        stagePrincipal.show();
    }

    public static void main(String[] args) {
        launch();
    }

}
