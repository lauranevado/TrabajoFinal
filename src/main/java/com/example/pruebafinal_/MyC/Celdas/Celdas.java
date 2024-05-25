package com.example.pruebafinal_.MyC.Celdas;

import com.example.pruebafinal_.MyC.Estructuras.Listas.ListaEnlazada;
import com.example.pruebafinal_.MyC.Datos.Individuo;
import com.example.pruebafinal_.MyC.Datos.Recurso;
import com.google.gson.annotations.Expose;
import javafx.scene.layout.*;

public class Celdas {
    @Expose
    public ListaEnlazada<Individuo> individuos;
    @Expose
    public ListaEnlazada<Recurso> recursos;
    @Expose
    private int identificadorCelda;

    @Expose
    private int coordX;
    @Expose
    private int coordY;

    private ListaEnlazada<StackPane> listaRectangulos;



    public Celdas() {}//Lo necesito para las properties y eso


    public Celdas(ListaEnlazada<Individuo> individuos, ListaEnlazada<Recurso> recursos, int identificadorCelda, int coordX, int coordY, ListaEnlazada<StackPane> listaRectangulos) {
        this.individuos = individuos;
        this.recursos = recursos;
        this.identificadorCelda = identificadorCelda;
        this.coordX = coordX;
        this.coordY = coordY;
        this.listaRectangulos = listaRectangulos;
    }

    public ListaEnlazada<Individuo> getIndividuos() {
        return individuos;
    }

    public void setIndividuos(ListaEnlazada<Individuo> individuos) {
        this.individuos = individuos;
    }

    public ListaEnlazada<Recurso> getRecursos() {
        return recursos;
    }

    public void setRecursos(ListaEnlazada<Recurso> recursos) {
        this.recursos = recursos;
    }

    public int getIdentificadorCelda() {
        return identificadorCelda;
    }

    public void setIdentificadorCelda(int identificadorCelda) {
        this.identificadorCelda = identificadorCelda;
    }

    public ListaEnlazada<StackPane> getListaRectangulos() {
        return listaRectangulos;
    }

    public void setListaRectangulos(ListaEnlazada<StackPane> listaRectangulos) {
        this.listaRectangulos = listaRectangulos;
    }

    public int getCoordX() {
        return coordX;
    }

    public void setCoordX(int coordX) {
        this.coordX = coordX;
    }

    public int getCoordY() {
        return coordY;
    }

    public void setCoordY(int coordY) {
        this.coordY = coordY;
    }

    public void setData(Celdas celdaNueva){
        this.individuos = celdaNueva.individuos;
        this.recursos = celdaNueva.recursos;
        this.identificadorCelda = celdaNueva.identificadorCelda;
        this.coordX = celdaNueva.coordX;
        this.coordY = celdaNueva.coordY;
        this.listaRectangulos = celdaNueva.listaRectangulos;
    }

}