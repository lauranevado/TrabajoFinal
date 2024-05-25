package com.example.pruebafinal_.MyC.Datos;

import com.example.pruebafinal_.MyC.Estructuras.Listas.ListaEnlazada;
import com.example.pruebafinal_.MyC.Estructuras.grafo.Cola;
import com.google.gson.annotations.Expose;
import javafx.scene.paint.Color;

public class Individuo {
    @Expose
    private int tipo; //0 es básico, 1 es normal, 2 es avanzado
    @Expose
    private int id;
    @Expose
    private int turnosDeVida;
    @Expose
    private int generacion; //es el turno en el que ha sido creado

    //private Color color;
    @Expose
    private ListaEnlazada<Individuo> padres = new ListaEnlazada<>(); //puede tener 1 padre (se ha clonado) o 2 padres
    @Expose
    private int pReproCadaIndividuo;
    @Expose
    private int pClonacionCadaIndividuo;
    @Expose
    private int celdaObjetivoNormal;
    @Expose
    public Cola<Object> colaIndividuo;

    public Individuo(int tipo, int id, int turnosDeVida, int generacion, int pReproCadaIndividuo, int pClonacionCadaIndividuo, Cola colaIndividuo) {
        this.tipo = tipo;
        this.id = id;
        this.turnosDeVida = turnosDeVida;
        this.generacion = generacion;
        this.pReproCadaIndividuo = pReproCadaIndividuo;
        this.pClonacionCadaIndividuo = pClonacionCadaIndividuo;
        this.colaIndividuo = colaIndividuo;
    }

    public Individuo(int tipo, int id, int turnosDeVida, int generacion, int pReproCadaIndividuo, int pClonacionCadaIndividuo, ListaEnlazada<Individuo> padres, Cola colaIndividuo) {
        this.tipo = tipo;
        this.id = id;
        this.turnosDeVida = turnosDeVida;
        this.generacion = generacion;
        this.pReproCadaIndividuo = pReproCadaIndividuo;
        this.pClonacionCadaIndividuo = pClonacionCadaIndividuo;
        this.padres = padres;
        this.colaIndividuo = colaIndividuo;
    }


    //Constructores para el normal
    public Individuo(int tipo, int id, int turnosDeVida, int generacion, int pReproCadaIndividuo, int pClonacionCadaIndividuo, int celdaObjetivoNormal, Cola colaIndividuo) {
        this.tipo = tipo;
        this.id = id;
        this.turnosDeVida = turnosDeVida;
        this.generacion = generacion;
        this.pReproCadaIndividuo = pReproCadaIndividuo;
        this.pClonacionCadaIndividuo = pClonacionCadaIndividuo;
        this.celdaObjetivoNormal = celdaObjetivoNormal;
        this.colaIndividuo = colaIndividuo;
    }

    public Individuo(int tipo, int id, int turnosDeVida, int generacion, int pReproCadaIndividuo, int pClonacionCadaIndividuo, ListaEnlazada<Individuo> padres, int celdaObjetivoNormal, Cola colaIndividuo) {
        this.tipo = tipo;
        this.id = id;
        this.turnosDeVida = turnosDeVida;
        this.generacion = generacion;
        this.pReproCadaIndividuo = pReproCadaIndividuo;
        this.pClonacionCadaIndividuo = pClonacionCadaIndividuo;
        this.padres = padres;
        this.celdaObjetivoNormal = celdaObjetivoNormal;
        this.colaIndividuo = colaIndividuo;
    }


    //Getters y setters
    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTurnosDeVida() {
        return turnosDeVida;
    }

    public void setTurnosDeVida(int turnosDeVida) {
        this.turnosDeVida = turnosDeVida;
    }

    public int getGeneracion() {
        return generacion;
    }

    public void setGeneracion(int generacion) {
        this.generacion = generacion;
    }

    public ListaEnlazada<Individuo> getPadres() {
        return padres;
    }

    public void setPadres(ListaEnlazada<Individuo> padres) {
        this.padres = padres;
    }

    public int getpReproCadaIndividuo() {
        return pReproCadaIndividuo;
    }

    public void setpReproCadaIndividuo(int pReproCadaIndividuo) {
        this.pReproCadaIndividuo = pReproCadaIndividuo;
    }

    public int getpClonacionCadaIndividuo() {
        return pClonacionCadaIndividuo;
    }

    public void setpClonacionCadaIndividuo(int pClonacionCadaIndividuo) {
        this.pClonacionCadaIndividuo = pClonacionCadaIndividuo;
    }

    public int getCeldaObjetivoNormal() {
        return celdaObjetivoNormal;
    }

    public void setCeldaObjetivoNormal(int celdaObjetivoNormal) {
        this.celdaObjetivoNormal = celdaObjetivoNormal;
    }

    public Cola<Object> getColaIndividuo() {
        return colaIndividuo;
    }

    public void setColaIndividuo(Cola<Object> colaIndividuo) {
        this.colaIndividuo = colaIndividuo;
    }

    public Color getColor() {
        if (tipo == 0) {
            return Color.YELLOWGREEN;
        } else if (tipo == 1) {
            return Color.FORESTGREEN;
        } else if (tipo == 2) {
            return Color.LAWNGREEN;
        } else {
            return null;
        }
    }
}
