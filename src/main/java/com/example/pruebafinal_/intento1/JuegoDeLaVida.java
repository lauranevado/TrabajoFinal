package com.example.pruebafinal_.intento1;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Modifier;
import java.net.URL;

import static com.example.pruebafinal_.intento1.ParametrosProperties.*;
import static com.example.pruebafinal_.intento1.Tablero.*;

public class JuegoDeLaVida extends Application {
    private static final Logger log = LogManager.getLogger(JuegoDeLaVida.class);



    @Override
    public void start(Stage stage) throws IOException {
        URL fxmlURL = getClass().getResource("/com/example/pruebafinal_/juego-pantalla-ppal.fxml");
        Parent root = FXMLLoader.load(fxmlURL);
        Scene scene = new Scene(root);
        stage.setMaximized(true);
        stage.setResizable(false);
        stage.setTitle("El juego de la vida");
        stage.setScene(scene);
        stage.show();
        log.info("El juego de la vida");


        // Los logs sólo operan si la clase utilizada coincide con el patrón que se pone en el log4j2.xml.
        // En este caso el patrón es "com.example.pruebafinal_" que coincide con nuestro paquete, por eso funciona.


    }



    //Método para guardar un archivo en un archivo Json
    public static <T> void guardarPartidaEnArchivo(String rutaArchivo, T partida){ //T es DatosCargados
        Gson gson= new GsonBuilder()
                .excludeFieldsWithoutExposeAnnotation()
                .excludeFieldsWithModifiers(Modifier.STATIC)
                .setPrettyPrinting()
                .create();
        try (FileWriter writer = new FileWriter(rutaArchivo)){
            gson.toJson(partida, writer);
        } catch (IOException e){
            e.printStackTrace();
            log.error("No existe la ruta para guardar el archivo");
        }
    }

    // Método para cargar un objeto desde un archivo JSON
    public static <T> T cargarObjetoDesdeArchivo(String rutaArchivo, Class<T> clase) {
        Gson gson= new GsonBuilder()
                .excludeFieldsWithoutExposeAnnotation()
                .excludeFieldsWithModifiers(Modifier.STATIC)
                .setPrettyPrinting()
                .create();

        try (FileReader reader = new FileReader(rutaArchivo)) {
            return gson.fromJson(reader, clase);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }







    public static void main(String[] args) {

        launch(args);

///////////////////////////BORRAR YA/////////////////////////////////
        //DatosCargados datosPartida2= new DatosCargados(turnosDeVidaProperty().getValue(), pRepProperty().getValue(),pMuerteProperty().getValue(), pClonProperty().getValue(),ladoProperty().getValue(), alturaProperty().getValue(),tiempoDeAparicionProperty().getValue(), probabilidadDeAparicionProperty().getValue(),vidaAguaSumaProperty().getValue(),pAgua().getValue(),vidaComidaSumaProperty().getValue(),pComida().getValue(),vidaMontanaRestaProperty().getValue(),pMontana().getValue(),pReproTesoroSumaProperty().getValue(),pTesoro().getValue(),pClonacionBibliotecaSumaProperty().getValue(),pBiblioteca().getValue(),0,pPozo().getValue(), celdas, getNumIndividuosTotales(), getTurnosJuego());
        //DatosCargados datosPartida12= new DatosCargados(turnosDeVidaProperty().getValue(), pRepProperty().getValue(),pMuerteProperty().getValue(), pClonProperty().getValue(),ladoProperty().getValue(), alturaProperty().getValue(),tiempoDeAparicionProperty().getValue(), probabilidadDeAparicionProperty().getValue(),vidaAguaSumaProperty().getValue(),pAgua().getValue(),vidaComidaSumaProperty().getValue(),pComida().getValue(),vidaMontanaRestaProperty().getValue(),pMontana().getValue(),pReproTesoroSumaProperty().getValue(),pTesoro().getValue(),pClonacionBibliotecaSumaProperty().getValue(),pBiblioteca().getValue(),0,pPozo().getValue(), getNumIndividuosTotales(), getTurnosJuego());
//        DatosCargados datosPartida1= new DatosCargados(turnosDeVidaProperty().getValue().intValue(), pRepProperty().getValue().intValue(),pMuerteProperty().getValue().intValue(), pClonProperty().getValue().intValue(),ladoProperty().getValue().intValue(), alturaProperty().getValue().intValue(),tiempoDeAparicionProperty().getValue().intValue(), probabilidadDeAparicionProperty().getValue().intValue(),vidaAguaSumaProperty().getValue().intValue(),pAgua().getValue().intValue(),vidaComidaSumaProperty().getValue().intValue(),pComida().getValue().intValue(),vidaMontanaRestaProperty().getValue().intValue(),pMontana().getValue().intValue(),pReproTesoroSumaProperty().getValue().intValue(),pTesoro().getValue().intValue(),pClonacionBibliotecaSumaProperty().getValue().intValue(),pBiblioteca().getValue().intValue(),0,pPozo().getValue().intValue(), celdas, getNumIndividuosTotales(), getTurnosJuego());
//
//        String rutaArchivo = "partidas.json";
//
//        guardarPartidaEnArchivo(rutaArchivo, datosPartida1);
//
//        DatosCargados datosCargadosPartida1 = cargarObjetoDesdeArchivo(rutaArchivo, DatosCargados.class);
//
//        if (datosCargadosPartida1 != null){
//            System.out.println("Partida cargada:(num individuos totales) " + datosCargadosPartida1.getNumIndividuosVivos());
//        }
    }
}
