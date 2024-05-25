package com.example.pruebafinal_.MyC;

import com.example.pruebafinal_.MyC.Guardado.DatosCargados;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Modifier;
import java.net.URL;

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


    }



    //Método para guardar un archivo en un archivo Json
    public static <DatosCargados> void guardarPartidaEnArchivo(String rutaArchivo, DatosCargados partida){ //T es DatosCargados
        Gson gson= new GsonBuilder()
                //.registerTypeAdapter(Celdas.class, new gsonAdapterCeldas())
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
    public static DatosCargados cargarObjetoDesdeArchivo(String rutaArchivo) {
        Gson gson= new GsonBuilder()
                //.registerTypeAdapter(Celdas.class, new gsonAdapterCeldas())
                .excludeFieldsWithoutExposeAnnotation()
                .excludeFieldsWithModifiers(Modifier.STATIC)
                .setPrettyPrinting()
                .create();

        try (FileReader reader = new FileReader(rutaArchivo)) {

//            ListaEnlazada<Celdas> celdass= new ListaEnlazada<>();
//            for (Integer i = 0; i < datosCargadosPartida1.celdas.getNumeroElementos(); i++) {
//                celdass.add(new Celdas(datosCargadosPartida1.celdas.getElemento(i).getData().getIndividuos(), datosCargadosPartida1.celdas.getElemento(i).getData().getRecursos(), datosCargadosPartida1.celdas.getElemento(i).getData().getIdentificadorCelda(), datosCargadosPartida1.celdas.getElemento(i).getData().getCoordX(), datosCargadosPartida1.celdas.getElemento(i).getData().getCoordY(), datosCargadosPartida1.celdas.getElemento(i).getData().getListaRectangulos()));
//                //celdas.getElemento(i).getData().setData(datosCargadosPartida1.celdas.getElemento(i).getData());
////                celdass.getElemento(i).getData().setIndividuos(datosCargadosPartida1.celdas.getElemento(i).getData().getIndividuos());
////                celdass.getElemento(i).getData().setRecursos(datosCargadosPartida1.celdas.getElemento(i).getData().getRecursos());
////                celdass.getElemento(i).getData().setIdentificadorCelda(datosCargadosPartida1.celdas.getElemento(i).getData().getIdentificadorCelda());
////                celdass.getElemento(i).getData().setCoordX(datosCargadosPartida1.celdas.getElemento(i).getData().getCoordX());
////                celdass.getElemento(i).getData().setCoordY(datosCargadosPartida1.celdas.getElemento(i).getData().getCoordY());
////                celdass.getElemento(i).getData().setListaRectangulos(datosCargadosPartida1.celdas.getElemento(i).getData().getListaRectangulos());
//
            DatosCargados modelo= gson.fromJson(reader, DatosCargados.class);
            return modelo;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }







    public static void main(String[] args) {

        launch(args);
    }
}
