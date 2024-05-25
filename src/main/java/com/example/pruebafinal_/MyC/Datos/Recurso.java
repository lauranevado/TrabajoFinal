package com.example.pruebafinal_.MyC.Datos;

import com.google.gson.annotations.Expose;
import javafx.scene.paint.Color;

public class Recurso {
    /** 0 es agua, 1 es comida, 2 es montaña, 3 es tesoro, 4 es biblioteca, 5 es pozo */
    //private Color color;
    @Expose
    private int tipo;
    @Expose
    private Integer turnosDeVida;
    @Expose
    private int posicion;
    @Expose
    private int probabilidadGeneral;

    @Expose
    private int probabilidadRecurso;
    @Expose
    private int propiedad;

    //Constructor


    public Recurso(int tipo, Integer turnosDeVida, int posicion, int probabilidadGeneral, int probabilidadRecurso, int propiedad) {
        this.tipo = tipo;
        this.turnosDeVida = turnosDeVida;
        this.posicion = posicion;
        this.probabilidadGeneral = probabilidadGeneral;
        this.probabilidadRecurso = probabilidadRecurso;
        this.propiedad = propiedad;
    }

//    public Recurso(int propiedad) {
//        this.propiedad = propiedad;
//    }

    //Getters y setters
    public int getTipo() {
        return tipo;
    }
    public void setTipo(int tipo) {
        this.tipo = tipo;
    }
    public Integer getTurnosDeVida() {
        return turnosDeVida;
    }
    public void setTurnosDeVida(Integer turnosDeVida) {
        this.turnosDeVida = turnosDeVida;
    }
    public int getPosicion() {
        return posicion;
    }
    public void setPosicion(int posicion) {
        this.posicion = posicion;
    }
    public int getProbabilidadGeneral() {
        return probabilidadGeneral;
    }
    public void setProbabilidadGeneral(int probabilidadGeneral) {
        this.probabilidadGeneral = probabilidadGeneral;
    }
    public int getProbabilidadRecurso() {
        return probabilidadRecurso;
    }
    public void setProbabilidadRecurso(int probabilidadRecurso) {
        this.probabilidadRecurso = probabilidadRecurso;
    }
    public int getPropiedad() {
        return propiedad;
    }
    public void setPropiedad(int propiedad) {
        this.propiedad = propiedad;
    }


    public Color getColor(){
        if (this.tipo==0){
            return Color.TURQUOISE;
        } else if (this.tipo==1) {
            return Color.TOMATO;
        } else if (this.tipo==2) {
            return Color.BURLYWOOD;
        } else if (this.tipo==3) {
            return Color.YELLOW;
        } else if (this.tipo==4) {
            return Color.HOTPINK;
        } else if (this.tipo==5) {
            return Color.DARKGREY;
        } else { return Color.GREY; }
    }
}
