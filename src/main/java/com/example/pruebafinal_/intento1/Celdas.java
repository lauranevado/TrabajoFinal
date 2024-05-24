package com.example.pruebafinal_.intento1;

import com.example.pruebafinal_.intento1.Listas.ListaEnlazada;
import com.google.gson.annotations.Expose;
import javafx.scene.layout.*;

public class Celdas {
    @Expose
    protected ListaEnlazada<Individuo> individuos;
    @Expose
    protected ListaEnlazada<Recurso> recursos;
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


}