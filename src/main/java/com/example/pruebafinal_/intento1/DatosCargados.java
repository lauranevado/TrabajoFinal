package com.example.pruebafinal_.intento1;

import com.example.pruebafinal_.intento1.Listas.ListaEnlazada;
import com.google.gson.annotations.Expose;

public class DatosCargados {
    /////////////////////////////PARÁMETROS/////////////////////////////

    //Atributos del individuo
    @Expose
    public int turnosDeVida;
    @Expose
    public int pRep;
    @Expose
    public int pMuerte;
    @Expose
    public int pClon;

    //Atributos del tablero
    @Expose
    public int lado;
    @Expose
    public int altura;


    //Atributos recursos
    @Expose
    public int tiempoDeAparicion;
    @Expose
    public int probabilidadDeAparicion;
    @Expose
    public int vidaAguaSuma;
    @Expose
    public int pAgua;
    @Expose
    public int vidaComidaSuma;
    @Expose
    public int pComida;
    @Expose
    public int vidaMontanaResta;
    @Expose
    public int pMontana;
    @Expose
    public int pReproTesoroSuma;
    @Expose
    public int pTesoro;
    @Expose
    public int pClonacionBiblioteca;  //Además te aumenta 1 el nivel del tipo de invidivuo
    @Expose
    public int pBiblioteca;
    @Expose
    public int muertePozo; //=0 lo mata
    @Expose
    public int pPozo;


    /////////////////////////////TABLERO/////////////////////////////

    @Expose
    public ListaEnlazada<Celdas> celdas;
    @Expose
    public int numIndividuosVivos;
    @Expose
    public int turnosJuego;

    //Constructor

    public DatosCargados(int turnosDeVida, int pRep, int pMuerte, int pClon, int lado, int altura, int tiempoDeAparicion, int probabilidadDeAparicion, int vidaAguaSuma, int pAgua, int vidaComidaSuma, int pComida, int vidaMontanaResta, int pMontana, int pReproTesoroSuma, int pTesoro, int pClonacionBiblioteca, int pBiblioteca, int muertePozo, int pPozo, ListaEnlazada<Celdas> celdas, int numIndividuosVivos, int turnosJuego) {
        this.turnosDeVida = turnosDeVida;
        this.pRep = pRep;
        this.pMuerte = pMuerte;
        this.pClon = pClon;
        this.lado = lado;
        this.altura = altura;
        this.tiempoDeAparicion = tiempoDeAparicion;
        this.probabilidadDeAparicion = probabilidadDeAparicion;
        this.vidaAguaSuma = vidaAguaSuma;
        this.pAgua = pAgua;
        this.vidaComidaSuma = vidaComidaSuma;
        this.pComida = pComida;
        this.vidaMontanaResta = vidaMontanaResta;
        this.pMontana = pMontana;
        this.pReproTesoroSuma = pReproTesoroSuma;
        this.pTesoro = pTesoro;
        this.pClonacionBiblioteca = pClonacionBiblioteca;
        this.pBiblioteca = pBiblioteca;
        this.muertePozo = muertePozo;
        this.pPozo = pPozo;
        this.celdas = celdas;
        this.numIndividuosVivos = getNumIndividuosVivos();
        this.turnosJuego = turnosJuego;
    }


    //Getters y setters


    public int getTurnosDeVida() {
        return turnosDeVida;
    }

    public void setTurnosDeVida(int turnosDeVida) {
        this.turnosDeVida = turnosDeVida;
    }

    public int getpRep() {
        return pRep;
    }

    public void setpRep(int pRep) {
        this.pRep = pRep;
    }

    public int getpMuerte() {
        return pMuerte;
    }

    public void setpMuerte(int pMuerte) {
        this.pMuerte = pMuerte;
    }

    public int getpClon() {
        return pClon;
    }

    public void setpClon(int pClon) {
        this.pClon = pClon;
    }

    public int getLado() {
        return lado;
    }

    public void setLado(int lado) {
        this.lado = lado;
    }

    public int getAltura() {
        return altura;
    }

    public void setAltura(int altura) {
        this.altura = altura;
    }

    public int getTiempoDeAparicion() {
        return tiempoDeAparicion;
    }

    public void setTiempoDeAparicion(int tiempoDeAparicion) {
        this.tiempoDeAparicion = tiempoDeAparicion;
    }

    public int getProbabilidadDeAparicion() {
        return probabilidadDeAparicion;
    }

    public void setProbabilidadDeAparicion(int probabilidadDeAparicion) {
        this.probabilidadDeAparicion = probabilidadDeAparicion;
    }

    public int getVidaAguaSuma() {
        return vidaAguaSuma;
    }

    public void setVidaAguaSuma(int vidaAguaSuma) {
        this.vidaAguaSuma = vidaAguaSuma;
    }

    public int getpAgua() {
        return pAgua;
    }

    public void setpAgua(int pAgua) {
        this.pAgua = pAgua;
    }

    public int getVidaComidaSuma() {
        return vidaComidaSuma;
    }

    public void setVidaComidaSuma(int vidaComidaSuma) {
        this.vidaComidaSuma = vidaComidaSuma;
    }

    public int getpComida() {
        return pComida;
    }

    public void setpComida(int pComida) {
        this.pComida = pComida;
    }

    public int getVidaMontanaResta() {
        return vidaMontanaResta;
    }

    public void setVidaMontanaResta(int vidaMontanaResta) {
        this.vidaMontanaResta = vidaMontanaResta;
    }

    public int getpMontana() {
        return pMontana;
    }

    public void setpMontana(int pMontana) {
        this.pMontana = pMontana;
    }

    public int getpReproTesoroSuma() {
        return pReproTesoroSuma;
    }

    public void setpReproTesoroSuma(int pReproTesoroSuma) {
        this.pReproTesoroSuma = pReproTesoroSuma;
    }

    public int getpTesoro() {
        return pTesoro;
    }

    public void setpTesoro(int pTesoro) {
        this.pTesoro = pTesoro;
    }

    public int getpClonacionBiblioteca() {
        return pClonacionBiblioteca;
    }

    public void setpClonacionBiblioteca(int pClonacionBiblioteca) {
        this.pClonacionBiblioteca = pClonacionBiblioteca;
    }

    public int getpBiblioteca() {
        return pBiblioteca;
    }

    public void setpBiblioteca(int pBiblioteca) {
        this.pBiblioteca = pBiblioteca;
    }

    public int getMuertePozo() {
        return muertePozo;
    }

    public void setMuertePozo(int muertePozo) {
        this.muertePozo = muertePozo;
    }

    public int getpPozo() {
        return pPozo;
    }

    public void setpPozo(int pPozo) {
        this.pPozo = pPozo;
    }

    public ListaEnlazada<Celdas> getCeldas() {
        return celdas;
    }

    public void setCeldas(ListaEnlazada<Celdas> celdas) {
        this.celdas = celdas;
    }

    public int getNumIndividuosVivos() {
        ListaEnlazada<Individuo> totales = new ListaEnlazada<>();
        if (celdas != null) {
            for (Integer i = 0; i < celdas.getNumeroElementos(); i++) {
                for (Integer j = 0; j < celdas.getElemento(i).getData().getIndividuos().getNumeroElementos(); j++) {
                    totales.add(celdas.getElemento(i).getData().individuos.getElemento(j).getData());
                }
            }

        }
        return totales.getNumeroElementos();
    }

    public void setNumIndividuosVivos(int numIndividuosVivos) {
        this.numIndividuosVivos = numIndividuosVivos;
    }

    public int getTurnosJuego() {
        return turnosJuego;
    }

    public void setTurnosJuego(int turnosJuego) {
        this.turnosJuego = turnosJuego;
    }

}
