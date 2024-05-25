package com.example.pruebafinal_.MyC.PartidaFinalizada;

import com.example.pruebafinal_.MyC.Parametros.Parametros;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class InformacionPartidaProperties {

    protected InformacionPartida original;
    private static IntegerProperty masLongevo= new SimpleIntegerProperty();
    private static IntegerProperty numMutaciones=new SimpleIntegerProperty();
    private static IntegerProperty numReproducciones=new SimpleIntegerProperty();
    private static IntegerProperty individuoMasReproducciones=new SimpleIntegerProperty();
    private static IntegerProperty individuoMasClonaciones=new SimpleIntegerProperty();
    private static IntegerProperty individuoMasAgua=new SimpleIntegerProperty();

    public InformacionPartidaProperties(InformacionPartida original){ setOriginal(original);}
    public void setOriginal(InformacionPartida original){
        this.original = original;
        rollback(); //Se inicializan los properties.

    }

    public void rollback(){
        masLongevo.set(original.getLongevo());
        numMutaciones.set(original.getNumMutaciones());
        numReproducciones.set(original.getNumReproducciones());
        individuoMasReproducciones.set(original.getIndividuoMasReproducciones());
        individuoMasClonaciones.set(original.getIndividuoMasClonaciones());
        individuoMasAgua.set(original.getIndividuoMasAgua());
    }

    public static IntegerProperty getMasLongevo(){
        return masLongevo;
    }
//    public static IntegerProperty getNumMutaciones(){}

}
