package com.example.pruebafinal_.intento1;

public class ParametrosPartida {
    //Atributos del individuo
    private int turnosDeVida;

    private int numIndividuosInicial;

    private int pRep;

    private int pMuerte;

    private int pClon;

//    private Double pBasico;
//
//    private Double pNormal;
//
//    private Double pAvanzado;



    //Atributos recursos
    private int tiempoDeAparicion;
    private  int probabilidadDeAparicion;
    private int vidaAguaSuma;
    private int pAgua;
    private int vidaComidaSuma;
    private int pComida;
    private int vidaMontanaResta;
    private int pMontana;
    private int pReproTesoroSuma;
    private int pTesoro;
    private int pClonacionBiblioteca;  //Además te aumenta 1 el nivel del tipo de invidivuo
    private int pBiblioteca;
    private int muertePozo; //=0 lo mata
    private int pPozo;


    public ParametrosPartida(Integer turnosDeVida, Integer numIndividuosInicial, Integer pRep, Integer pMuerte, Integer pClon,  Integer tiempoDeAparicion, Integer probabilidadDeAparicion,  Integer vidaAguaSuma, Integer pAgua, Integer vidaComidaSuma, Integer pComida, Integer vidaMontanaResta, Integer pMontana, Integer pReproTesoroSuma, Integer pTesoro, Integer pClonacionBiblioteca, Integer pBiblioteca, Integer muertePozo, Integer pPozo) {
        this.turnosDeVida = turnosDeVida;
        this.numIndividuosInicial=numIndividuosInicial;
        this.pRep = pRep;
        this.pMuerte = 100-pMuerte;
        this.pClon = pClon;
//        this.pBasico = pBasico;
//        this.pNormal = pNormal;
//        this.pAvanzado = pAvanzado;
        this.tiempoDeAparicion = tiempoDeAparicion;
        this.probabilidadDeAparicion= probabilidadDeAparicion;
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
    }
    //Getters y setters del individuo

    public int getTurnosDeVida() {
        return turnosDeVida;
    }

    public void setTurnosDeVida(int turnosDeVida) {
        this.turnosDeVida = turnosDeVida;
    }

    public int getNumIndividuosInicial() {
        return numIndividuosInicial;
    }

    public void setNumIndividuosInicial(int numIndividuosInicial) {
        this.numIndividuosInicial = numIndividuosInicial;
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



//    public Double getpBasico() { return pBasico;}
//
//    public void setpBasico(Double pBasico) {
//        this.pBasico = pBasico;
//    }
//
//    public Double getpNormal() {
//        return pNormal;
//    }
//
//    public void setpNormal(Double pNormal) {
//        this.pNormal = pNormal;
//    }
//
//    public Double getpAvanzado() {
//        return pAvanzado;
//    }
//
//    public void setpAvanzado(Double pAvanzado) {
//        this.pAvanzado = pAvanzado;
//    }

    public int getTiempoDeAparicion() { return tiempoDeAparicion;}

    public void setTiempoDeAparicion(int tiempoDeAparicion) { this.tiempoDeAparicion = tiempoDeAparicion;}

    public int getProbabilidadDeAparicion() {
        return probabilidadDeAparicion;
    }

    public void setProbabilidadDeAparicion(int probabilidadDeAparicion) {
        this.probabilidadDeAparicion = probabilidadDeAparicion;
    }

    public int getVidaAguaSuma() {
        return vidaAguaSuma;
    }

    public int getVidaComidaSuma() {
        return vidaComidaSuma;
    }

    public int getVidaMontanaResta() {
        return vidaMontanaResta;
    }

    public int getpReproTesoroSuma() {
        return pReproTesoroSuma;
    }

    public int getpClonacionBiblioteca() {
        return pClonacionBiblioteca;
    }

    public int getMuertePozo() {
        return muertePozo;
    }

    public void setVidaAguaSuma(int vidaAguaSuma) {
        this.vidaAguaSuma = vidaAguaSuma;
    }

    public void setVidaComidaSuma(int vidaComidaSuma) {
        this.vidaComidaSuma = vidaComidaSuma;
    }

    public void setVidaMontanaResta(int vidaMontanaResta) {
        this.vidaMontanaResta = vidaMontanaResta;
    }

    public void setpReproTesoroSuma(int pReproTesoroSuma) {
        this.pReproTesoroSuma = pReproTesoroSuma;
    }

    public void setpClonacionBiblioteca(int pClonacionBiblioteca) {
        this.pClonacionBiblioteca = pClonacionBiblioteca;
    }

    public void setMuertePozo(int muertePozo) {
        this.muertePozo = muertePozo;
    }



    public void setpAgua(int pAgua) {
        this.pAgua = pAgua;
    }

    public void setpComida(int pComida) {
        this.pComida = pComida;
    }

    public void setpMontana(int pMontana) {
        this.pMontana = pMontana;
    }

    public void setpTesoro(int pTesoro) {
        this.pTesoro = pTesoro;
    }

    public void setpBiblioteca(int pBiblioteca) {
        this.pBiblioteca = pBiblioteca;
    }

    public int getpAgua() {
        return pAgua;
    }

    public int getpComida() {
        return pComida;
    }

    public int getpMontana() {
        return pMontana;
    }

    public int getpTesoro() {
        return pTesoro;
    }

    public int getpBiblioteca() {
        return pBiblioteca;
    }

    public int getpPozo() {
        return pPozo;
    }

    public void setpPozo(int pPozo) {
        this.pPozo = pPozo;
    }

}
