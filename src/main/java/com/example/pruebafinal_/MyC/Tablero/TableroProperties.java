package com.example.pruebafinal_.MyC.Tablero;

import com.example.pruebafinal_.MyC.Celdas.Celdas;
import com.example.pruebafinal_.MyC.Estructuras.Listas.ListaEnlazada;
import com.example.pruebafinal_.MyC.Tablero.Tablero;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.Property;
import javafx.beans.property.SimpleIntegerProperty;

import static com.example.pruebafinal_.MyC.Tablero.Tablero.celdas;

public class TableroProperties {

    protected Tablero original;

//EL DE NUMINDIV INICIAL YA NO ES INICIAL Y NO SE USA COMO PROPERTY; HABRA QUE HACER UNO PARA VER EL NUM DE INDIVIDUOS EN EL MOMENTO Y ESE SI SERA UNA PROPERTY
    private static IntegerProperty turnosJuego = new SimpleIntegerProperty();

    public TableroProperties(Tablero original){ setOriginal(original);}


    public void setOriginal(Tablero original){
        this.original = original;
        rollback();
    }
    public Tablero getOriginal(){ return original;}
    public void commit(){
        original.setCeldas((ListaEnlazada<Celdas>) celdas);
        original.setTurnosJuego(turnosJuego.get());
    }
    public void rollback(){
        turnosJuego.set(original.getTurnosJuego());
//        celdas.setValue(original.getCeldas());
    }

    public static IntegerProperty turnosJuegoProperty(){ return turnosJuego; }

    public static Property celdasProperty(){ return (Property) celdas;}
}
