package com.example.pruebafinal_.intento1.grafo;

import com.example.pruebafinal_.intento1.Listas.ElementoLDE;
import com.google.gson.annotations.Expose;
import com.example.pruebafinal_.intento1.Listas.ListaSimple;

public class Cola<tipoDeDato> {

    @Expose
    protected ElementoLDE<tipoDeDato> primero;
    @Expose
    protected ElementoLDE<tipoDeDato> ultimo;


    public Cola(){}

    public void add(tipoDeDato t){
        ElementoLDE<tipoDeDato> e= new ElementoLDE<>(t);
        if(isVacia()){
            primero=ultimo=e;
        }else {
           e.siguiente=ultimo.siguiente;
           e.anterior=ultimo;
           ultimo.siguiente=e;
           ultimo=e;
        }
    }


    public ElementoLDE<tipoDeDato> poll(){
        ElementoLDE eliminar= ultimo;
        if(isVacia()){
            return null;
        }
        if(ultimo==primero){
            ultimo=null;
            primero=null;
            return eliminar;


        }
        else {
            ultimo = ultimo.anterior;
            ultimo.siguiente = null;
            return eliminar;}


    }
    public boolean isVacia(){
        if(primero== null && ultimo==null){
            return true;
        }
        return false;
    }
}
