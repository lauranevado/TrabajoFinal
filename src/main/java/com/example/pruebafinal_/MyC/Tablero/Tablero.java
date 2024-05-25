package com.example.pruebafinal_.MyC.Tablero;

import com.example.pruebafinal_.MyC.Celdas.*;
import com.example.pruebafinal_.MyC.Estructuras.Listas.ListaEnlazada;
import com.example.pruebafinal_.MyC.Estructuras.grafo.Cola;
import com.example.pruebafinal_.MyC.Estructuras.grafo.Grafo;
import com.example.pruebafinal_.MyC.Datos.Individuo;

import static com.example.pruebafinal_.MyC.Parametros.ParametrosProperties.alturaProperty;
import static com.example.pruebafinal_.MyC.Parametros.ParametrosProperties.ladoProperty;

public class Tablero {

    //Atributos del tablero


    public static ListaEnlazada<Celdas> celdas;
    public static int numIndividuosTotales;

    protected static boolean pausa;

    public static int turnosJuego;
    public static Grafo<Cola> grafoColaIndividuos= new Grafo<>();

    private static boolean partidaCargada= false;
    protected static int valorAltura = alturaProperty().getValue();
    protected static int  valorLado = ladoProperty().getValue();


    public static boolean isPartidaCargada() {
        return partidaCargada;
    }
    public static void setPartidaCargada(boolean partidaCargada1) {
        partidaCargada = partidaCargada1;
    }


    public static ListaEnlazada<Individuo> getIndividuosActuales(){
        ListaEnlazada<Individuo> totales= new ListaEnlazada<>();
        if(celdas!=null) {
            for (Integer i = 0; i < celdas.getNumeroElementos(); i++) {
                for (Integer j = 0; j < celdas.getElemento(i).getData().getIndividuos().getNumeroElementos(); j++) {
                    totales.add(celdas.getElemento(i).getData().individuos.getElemento(j).getData());
                }
            }

        }
        return totales;
    }

    //Constructor
    public Tablero(ListaEnlazada<Celdas> celdas) { //recibe lo que ha recibido antes el slider
        this.celdas = celdas;
        this.pausa= true;

    }

    //Getters y setters
    public ListaEnlazada<Celdas> getCeldas() {
        return celdas;
    }

    public void setCeldas(ListaEnlazada<Celdas> celdas) {
        this.celdas = celdas;
    }

    public static int getNumIndividuosTotales() {
        return numIndividuosTotales;
    }

    public static void setNumIndividuosTotales(int numIndividuos) {
        Tablero.numIndividuosTotales = numIndividuos;
    }

    public static boolean isPausa() {
        return pausa;
    }

    public static void setPausa(boolean pausa1) {
        pausa = pausa1;
    }

    public static int getTurnosJuego() {
        return turnosJuego;
    }

    public static void setTurnosJuego(int turnosJuegoNew) {
        turnosJuego = turnosJuegoNew;
    }
    public static int getPosCelda(int coordX, int coordY){
        for(Integer i=0;i< celdas.getNumeroElementos();i++){
            if(celdas.getElemento(i).getData().getCoordX()== coordX && celdas.getElemento(i).getData().getCoordY()==coordY){
                return celdas.getElemento(i).getData().getIdentificadorCelda();
            }
        }
        return 0;
    }
}
