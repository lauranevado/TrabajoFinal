package com.example.pruebafinal_.intento1.grafo;

public class Dupla<tipoDato1,tipoDato2> {
    private tipoDato1 clave;  //Clave
    private tipoDato2 dato;  //Dato

    public Dupla(tipoDato1 elemento, tipoDato2 dato) {
        this.clave = elemento;
        this.dato = dato;
    }

    public tipoDato1 getClave(){return clave;}

    public tipoDato2 getDato(){return dato;}

    public void setClave(tipoDato1 clave) {
        this.clave = clave;
    }

    public void setDato(tipoDato2 dato) {
        this.dato = dato;
    }
    //


}
