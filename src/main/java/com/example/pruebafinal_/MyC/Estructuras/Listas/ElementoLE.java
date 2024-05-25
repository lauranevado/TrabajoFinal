package com.example.pruebafinal_.MyC.Estructuras.Listas;

import com.google.gson.annotations.Expose;

public class ElementoLE<TipoDeDato> {

    @Expose
    TipoDeDato data;
    @Expose
    ElementoLE siguiente;


    /////////constructor//////
    public ElementoLE(TipoDeDato o){
        this.data=o;
        this.siguiente=null;
    }


    ///////////////////

    protected void insertarmeEn(ElementoLE el){
        this.siguiente=el;
    }

    protected ElementoLE getSiguiente(){
        return siguiente;
    }

    public TipoDeDato getData() {
        return  data;
    }

    protected void setData(TipoDeDato o) {
        data = o;
    }

}
