package com.example.pruebafinal_.MyC.Parametros;

import javafx.beans.property.*;

public class ParametrosProperties {

    protected Parametros original;

    //Parametros individuo
    private static IntegerProperty turnosDeVida = new SimpleIntegerProperty();
    private static IntegerProperty numIndividuosInicial = new SimpleIntegerProperty();
    private static IntegerProperty pRep = new SimpleIntegerProperty();
    private static IntegerProperty pMuerte= new SimpleIntegerProperty();
    private static IntegerProperty pClon = new SimpleIntegerProperty();
    private static DoubleProperty pBasico = new SimpleDoubleProperty();
    private static DoubleProperty pNormal = new SimpleDoubleProperty();
    private static DoubleProperty pAvanzado = new SimpleDoubleProperty();




    //Parametros tablero
    private static IntegerProperty lado= new SimpleIntegerProperty();
    private static IntegerProperty altura= new SimpleIntegerProperty();


    //Parametros recursos
    private static IntegerProperty tiempoDeAparicion= new SimpleIntegerProperty();
    private static IntegerProperty probabilidadDeAparicion= new SimpleIntegerProperty();
    private static IntegerProperty vidaAguaSuma= new SimpleIntegerProperty();
    private static  IntegerProperty pAgua= new SimpleIntegerProperty();
    private static IntegerProperty vidaComidaSuma= new SimpleIntegerProperty();
    private static IntegerProperty pComida= new SimpleIntegerProperty();
    private static IntegerProperty vidaMontanaResta= new SimpleIntegerProperty();
    private static IntegerProperty pMontana= new SimpleIntegerProperty();
    private static IntegerProperty pReproTesoroSuma= new SimpleIntegerProperty();
    private static IntegerProperty pTesoro= new SimpleIntegerProperty();
    private static IntegerProperty pClonacionBibliotecaSuma= new SimpleIntegerProperty();
    private static IntegerProperty pBiblioteca= new SimpleIntegerProperty();
    private static IntegerProperty muertePozo= new SimpleIntegerProperty();
    private static IntegerProperty pPozo= new SimpleIntegerProperty();



    public ParametrosProperties(Parametros original){ setOriginal(original);}

    public void setOriginal(Parametros original){
        this.original = original;
        rollback(); //Se inicializan los properties.

    }
    public Parametros getOriginal(){
        return original;
    }

    public void commit(){

        //Individuos
        original.setTurnosDeVida(turnosDeVida.get());
        original.setNumIndividuosInicial(numIndividuosInicial.get());
        original.setpRep(pRep.get());
        original.setpMuerte(pMuerte.get());
        original.setpClon(pClon.get());
        original.setpBasico(pBasico.get());
        original.setpNormal(pNormal.get());
        original.setpAvanzado(pAvanzado.get());

        //Tablero
        original.setAltura(altura.get());
        original.setLado(lado.get());

        //Recursos
        original.setTiempoDeAparicion(tiempoDeAparicion.get());
        original.setProbabilidadDeAparicion(probabilidadDeAparicion.get());
        original.setVidaAguaSuma(vidaAguaSuma.get());
        original.setVidaComidaSuma(vidaComidaSuma.get());
        original.setVidaMontanaResta(vidaMontanaResta.get());
        original.setpReproTesoroSuma(pReproTesoroSuma.get());
        original.setpClonacionBiblioteca(pClonacionBibliotecaSuma.get());
        original.setMuertePozo(muertePozo.get());
        original.setpAgua(pAgua.get());
        original.setpComida(pComida.get());
        original.setpBiblioteca(pBiblioteca.get());
        original.setpTesoro(pTesoro.get());
        original.setpMontana(pMontana.get());
        original.setpPozo(pPozo.get());
    }

    public void rollback(){
        turnosDeVida.set(original.getTurnosDeVida());
        numIndividuosInicial.set(original.getNumIndividuosInicial());
        pRep.set(original.getpRep());
        pMuerte.set(original.getpMuerte());
        pClon.set(original.getpClon());
        pBasico.set(original.getpBasico());
        pNormal.set(original.getpNormal());
        pAvanzado.set(original.getpAvanzado());

        //Tablero
        lado.set(original.getLado());
        altura.set(original.getAltura());

        //Recursos
        tiempoDeAparicion.set(original.getTiempoDeAparicion());
        probabilidadDeAparicion.set(original.getProbabilidadDeAparicion());
        vidaAguaSuma.set(original.getVidaAguaSuma());
        vidaComidaSuma.set(original.getVidaComidaSuma());
        vidaMontanaResta.set(original.getVidaMontanaResta());
        pReproTesoroSuma.set(original.getpReproTesoroSuma());
        pClonacionBibliotecaSuma.set(original.getpClonacionBiblioteca());
        muertePozo.set(original.getMuertePozo());
        pAgua.set(original.getpAgua());
        pComida.set(original.getpComida());
        pBiblioteca.set(original.getpBiblioteca());
        pMontana.set(original.getpMontana());
        pTesoro.set(original.getpTesoro());
        pPozo.set(original.getpPozo());
    }



    public static IntegerProperty turnosDeVidaProperty() { return turnosDeVida;}
    public static IntegerProperty numIndividuosInicialProperty(){ return numIndividuosInicial; }
    public static IntegerProperty pRepProperty() { return pRep;}
    public static IntegerProperty pMuerteProperty() { return pMuerte;}
    public static IntegerProperty pClonProperty() { return pClon;}
    public static DoubleProperty pBasicoProperty() { return pBasico;}
    public static DoubleProperty pNormalProperty() { return pNormal;}
    public static DoubleProperty pAvanzadoProperty() { return pAvanzado;}


    //Tablero
    public static IntegerProperty alturaProperty(){return altura;}
    public static IntegerProperty ladoProperty(){return lado;}

    //Recursos
    public static IntegerProperty tiempoDeAparicionProperty(){ return tiempoDeAparicion;}
    public static IntegerProperty probabilidadDeAparicionProperty(){ return probabilidadDeAparicion;}
    public static IntegerProperty vidaAguaSumaProperty() {
        return vidaAguaSuma;
    }
    public static IntegerProperty pAgua() {
        return pAgua;
    }
    public static IntegerProperty vidaComidaSumaProperty() {
        return vidaComidaSuma;
    }
    public static IntegerProperty pComida() {
        return pComida;
    }
    public static IntegerProperty vidaMontanaRestaProperty() {
        return vidaMontanaResta;
    }
    public static IntegerProperty pMontana() {return pMontana;}
    public static IntegerProperty pReproTesoroSumaProperty() {
        return pReproTesoroSuma;
    }
    public static IntegerProperty pTesoro() {
        return pTesoro;
    }
    public static IntegerProperty pClonacionBibliotecaSumaProperty() {
        return pClonacionBibliotecaSuma;
    }
    public static IntegerProperty pBiblioteca() {
        return pBiblioteca;
    }
    public static IntegerProperty muertePozoProperty() {
        return muertePozo;
    }
    public static IntegerProperty pPozo() {
        return pPozo;
    }




}
