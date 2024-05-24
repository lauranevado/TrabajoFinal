package com.example.pruebafinal_.intento1.Listas;

import com.google.gson.annotations.Expose;

public class ElementoLDE<tipoDeDato> {

    @Expose
    private tipoDeDato data;


    public ElementoLDE<tipoDeDato> anterior;
    @Expose
    public ElementoLDE<tipoDeDato> siguiente;


    ////////////


    public ElementoLDE(tipoDeDato o) {
        this.data = o;
    }




    public ElementoLDE getSiguiente() {
        return siguiente;
    }

    public ElementoLDE getAnterior() {
        return anterior;
    }

    public tipoDeDato getData() {
        return data;
    }

    public void setData(tipoDeDato data) {
        this.data = data;
    }

    public void setAnterior(ElementoLDE<tipoDeDato> anterior) {
        this.anterior = anterior;
    }

    public void setSiguiente(ElementoLDE<tipoDeDato> siguiente) {
        this.siguiente = siguiente;

    }
}
