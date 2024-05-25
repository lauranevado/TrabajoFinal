package com.example.pruebafinal_.MyC.Celdas;

import com.example.pruebafinal_.MyC.Datos.Individuo;
import com.example.pruebafinal_.MyC.Datos.Recurso;
import com.example.pruebafinal_.MyC.Estructuras.Listas.ListaEnlazada;
import com.example.pruebafinal_.MyC.Estructuras.grafo.Cola;
import com.example.pruebafinal_.MyC.Parametros.ParametrosProperties;
import com.example.pruebafinal_.MyC.Tablero.TableroControllers;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;


import static com.example.pruebafinal_.MyC.Parametros.ParametrosProperties.*;
import static com.example.pruebafinal_.MyC.Tablero.Tablero.*;


public class  CeldasControllers implements Initializable {

    //cosas que necesitamos
    private CeldasProperties modelo;
    private Stage scene;
    private  Integer idCelda;




    @FXML
    private RadioButton aguaRadioButton, comidaRadioButton, montanaRadioButton, tesoroRadioButton,bibliotecaRadioButton, pozoRadioButton;
    private ToggleGroup grupoRecursos = new ToggleGroup();

    @FXML
    private RadioButton basicoRadioButton, normalRadioButton, avanzadoRadioButton;

    private ToggleGroup grupoIndividuos = new ToggleGroup();


    @FXML
    private Label individuo1Label, individuo2Label,individuo3Label, recurso1Label, recurso2Label, recurso3Label;



    //Añadir Recursos e individuos
    @FXML
    public void addRecurso(){
        grupoRecursos.selectedToggleProperty().addListener((observable , oldValue, newValue )-> {
            RadioButton recursoElegido=(RadioButton) newValue;
            if (recursoElegido != null){
                if ( celdas.getElemento(idCelda).getData().getRecursos().getNumeroElementos()<3){
                    if (recursoElegido== aguaRadioButton){
                        Recurso agua= new Recurso(0, tiempoDeAparicionProperty().getValue() ,  modelo.original.getIdentificadorCelda(), ParametrosProperties.probabilidadDeAparicionProperty().getValue(), ParametrosProperties.pAgua().getValue(), ParametrosProperties.vidaAguaSumaProperty().getValue());
                        celdas.getElemento(idCelda).getData().getRecursos().add(agua);
                        System.out.println("Se ha añadido agua a la celda "+ idCelda );
                    }
                    else if (recursoElegido== comidaRadioButton){
                        Recurso comida= new Recurso(1, tiempoDeAparicionProperty().getValue() ,  modelo.original.getIdentificadorCelda(), ParametrosProperties.probabilidadDeAparicionProperty().getValue(), ParametrosProperties.pComida().getValue(), ParametrosProperties.vidaComidaSumaProperty().getValue());
                        celdas.getElemento(idCelda).getData().getRecursos().add(comida);
                        System.out.println("Se ha añadido comida a la celda "+ idCelda );
                    }
                    else if (recursoElegido== montanaRadioButton){
                        Recurso montana= new Recurso(2, tiempoDeAparicionProperty().getValue() ,  modelo.original.getIdentificadorCelda(), ParametrosProperties.probabilidadDeAparicionProperty().getValue(), ParametrosProperties.pMontana().getValue(), ParametrosProperties.vidaMontanaRestaProperty().getValue());
                        celdas.getElemento(idCelda).getData().getRecursos().add(montana);
                        System.out.println("Se ha añadido montaña a la celda "+ idCelda );
                    }
                    else if (recursoElegido== tesoroRadioButton){
                        Recurso tesoro= new Recurso(3, tiempoDeAparicionProperty().getValue() ,  modelo.original.getIdentificadorCelda(), ParametrosProperties.probabilidadDeAparicionProperty().getValue(), ParametrosProperties.pTesoro().getValue(), ParametrosProperties.pReproTesoroSumaProperty().getValue());
                        celdas.getElemento(idCelda).getData().getRecursos().add(tesoro);
                        System.out.println("Se ha añadido tesoro a la celda "+ idCelda );
                    }
                    else if (recursoElegido== bibliotecaRadioButton){
                        Recurso biblioteca= new Recurso(4, tiempoDeAparicionProperty().getValue() ,  modelo.original.getIdentificadorCelda(), ParametrosProperties.probabilidadDeAparicionProperty().getValue(), ParametrosProperties.pBiblioteca().getValue(), ParametrosProperties.pClonacionBibliotecaSumaProperty().getValue());
                        celdas.getElemento(idCelda).getData().getRecursos().add(biblioteca);
                        System.out.println("Se ha añadido biblioteca a la celda "+ idCelda );
                    }
                    else if (recursoElegido== pozoRadioButton){
                        Recurso pozo= new Recurso(5, tiempoDeAparicionProperty().getValue() ,  modelo.original.getIdentificadorCelda(), ParametrosProperties.probabilidadDeAparicionProperty().getValue(), ParametrosProperties.pPozo().getValue(), ParametrosProperties.pPozo().getValue());
                        celdas.getElemento(idCelda).getData().getRecursos().add(pozo);
                        System.out.println("Se ha añadido pozo a la celda "+ idCelda );
                    }

                }else{
                    System.out.println("Recursos lleno");
                }
                grupoRecursos.getSelectedToggle().setSelected(false);
                showCelda(idCelda);
            }
        });

    }

    @FXML
    private void addIndividuo(){
        grupoIndividuos.selectedToggleProperty().addListener((observable , oldValue, newValue )-> {
            RadioButton individuoElegido=(RadioButton) newValue;
            if (individuoElegido != null) {
                if (celdas.getElemento(idCelda).getData().getIndividuos().getNumeroElementos() < 3) {
                    if (individuoElegido == basicoRadioButton) {
                        Individuo individuoBasico = new Individuo(0,numIndividuosTotales, turnosDeVidaProperty().getValue(), turnosJuego, pRepProperty().getValue(), pClonProperty().getValue(),new Cola<>());
                        numIndividuosTotales++;
                        celdas.getElemento(idCelda).getData().getIndividuos().add(individuoBasico);
                        System.out.println("Se ha añadido un individuo básico a la celda "+ idCelda );
                    }
                    if (individuoElegido == normalRadioButton) {
                        Individuo individuoNormal = new Individuo(1, numIndividuosTotales, turnosDeVidaProperty().getValue(), turnosJuego, pRepProperty().getValue(), pClonProperty().getValue(), TableroControllers.celdaAleatoria(idCelda),new Cola<>());
                        numIndividuosTotales++;
                        celdas.getElemento(idCelda).getData().getIndividuos().add(individuoNormal);
                        System.out.println("Se ha añadido un individuo normal a la celda "+ idCelda );
                    }
                    if (individuoElegido == avanzadoRadioButton) {
                        Individuo individuoAvanzado = new Individuo(2,numIndividuosTotales, turnosDeVidaProperty().getValue(), turnosJuego, pRepProperty().getValue(), pClonProperty().getValue() , new Cola<>());
                        numIndividuosTotales++;
                        celdas.getElemento(idCelda).getData().individuos.add(individuoAvanzado);
                        System.out.println("Se ha añadido un individuo avanzado a la celda "+ idCelda );
                    }
                }
                else{
                    System.out.println("Individuos lleno");
                }
                grupoIndividuos.getSelectedToggle().setSelected(false);
                showCelda(idCelda);
            }
        });
    }



    //Funciones para mostrar por pantalla la información
    @FXML
    public void showCelda(Integer idCelda) {
        ListaEnlazada<Label> listaLabels= new ListaEnlazada<>();
        listaLabels.add(recurso1Label);listaLabels.add(recurso2Label);listaLabels.add(recurso3Label);
        listaLabels.add(individuo1Label);listaLabels.add(individuo2Label);listaLabels.add(individuo3Label);
        Integer contador = 0;
        Integer contador2 = 0;
        if (celdas.getElemento(idCelda).getData().recursos != null) {
            for (Integer i = 0; i < celdas.getElemento(idCelda).getData().recursos.getNumeroElementos(); i++) {
                if (celdas.getElemento(idCelda).getData().recursos.getElemento(contador) != null) {
                    Color color1 = celdas.getElemento(idCelda).getData().recursos.getElemento(contador).getData().getColor();
                    String texto= traducirColor(color1);
                    listaLabels.getElemento(i).getData().setText(texto);
                    contador++;
                }
            }
        }
        if (celdas.getElemento(idCelda).getData().individuos != null) {
            for (Integer i = 0; i < celdas.getElemento(idCelda).getData().individuos.getNumeroElementos(); i++) {
                if (celdas.getElemento(idCelda).getData().individuos.getElemento(contador2) != null) {
                    Color color2 = celdas.getElemento(idCelda).getData().individuos.getElemento(contador2).getData().getColor();
                    String texto= traducirColor(color2);
                    listaLabels.getElemento(3+i).getData().setText(texto);
                    contador2++;
                    contador++;
                }
            }
        }
        if(celdas.getElemento(idCelda).getData().individuos.getNumeroElementos() == 0  && celdas.getElemento(idCelda).getData().recursos.getNumeroElementos() == 0){
            for (Integer i = 0; i < 6; i++) {
                listaLabels.getElemento(i).getData().setText("");
            }
        }
    }

    private String traducirColor(Color colorTraducir){
        if (colorTraducir==Color.TURQUOISE) {
            return "Agua";
        } else if (colorTraducir==Color.TOMATO) {
            return "Comida";
        } else if (colorTraducir==Color.BURLYWOOD) {
            return "Montaña";
        } else if (colorTraducir==Color.YELLOW) {
            return "Tesoro";
        } else if (colorTraducir==Color.HOTPINK) {
            return "Biblioteca";
        } else if (colorTraducir==Color.DARKGREY) {
            return "Pozo";
        } else if (colorTraducir==Color.YELLOWGREEN) {
            return "Básico";
        } else if (colorTraducir==Color.FORESTGREEN) {
            return "Normal";
        } else if (colorTraducir==Color.LAWNGREEN) {
            return "Avanzado";
        } else {
            return "";
        }
    }


    //Funciones para el botón de vaciar
    @FXML
    public void onVaciarButtonClick(){
        vaciar(idCelda);
        showCelda(idCelda);
        System.out.println("Se ha vaciado la celda "+ idCelda);
    }

    public void vaciar(int id){
        for(Integer i=0; i<6; i++){
            celdas.getElemento(id).getData().getRecursos().vaciar();
            for(Integer j=0;j<celdas.getElemento(id).getData().individuos.getNumeroElementos();j++){
                Individuo ind= celdas.getElemento(id).getData().individuos.getElemento(j).getData();
                ind.colaIndividuo.add("Se murio el individuo ");
                ind.colaIndividuo.add(turnosJuego-ind.getGeneracion());
            }
            celdas.getElemento(id).getData().getIndividuos().vaciar();
        }
    }



    public void loadCeldasData(CeldasProperties celdas, Integer idCelda) {
        this.idCelda= idCelda;
        this.modelo = celdas;
    }

    public static ListaEnlazada<Celdas> getListaDeCeldas() {
        return celdas;
    }

    public void setStage(Stage s) {
        this.scene = s;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //Hacemos que de los seis botones de recursos se escoja uno únicamente
        aguaRadioButton.setToggleGroup(grupoRecursos);
        comidaRadioButton.setToggleGroup(grupoRecursos);
        montanaRadioButton.setToggleGroup(grupoRecursos);
        tesoroRadioButton.setToggleGroup(grupoRecursos);
        bibliotecaRadioButton.setToggleGroup(grupoRecursos);
        pozoRadioButton.setToggleGroup(grupoRecursos);

        //Y que de los tres tipos de individuo coja uno
        basicoRadioButton.setToggleGroup(grupoIndividuos);
        normalRadioButton.setToggleGroup(grupoIndividuos);
        avanzadoRadioButton.setToggleGroup(grupoIndividuos);


        addRecurso();
        addIndividuo();
    }
}
