package com.example.pruebafinal_.intento1.Listas;

import com.google.gson.annotations.Expose;

public class ListaEnlazada<TipoDeDato> {
    @Expose
    private ElementoLE<TipoDeDato> primero;

    public boolean isVacia() {
        return (primero == null);
    }

    public void vaciar() {
        primero = null;
    }

    private int addElemento(ElementoLE<TipoDeDato> el) {

            if (primero == null) {
                primero = el;
                return 1;
            } else {
                ElementoLE<TipoDeDato> ultimo = getUltimo();
                ultimo.insertarmeEn(el);
                return getNumeroElementos();
            }

    }

    public void add(String s) {
        ElementoLE<TipoDeDato> el = new ElementoLE(s);
        addElemento(el);
    }

    public void add(TipoDeDato o) {
        ElementoLE<TipoDeDato> el = new ElementoLE(o);
        addElemento(el);
    }

    public void insertElemento(ElementoLE<TipoDeDato> el, int posicion){
        ElementoLE<TipoDeDato> actual = primero;
        while(actual!=null&&posicion>1){
            actual=actual.getSiguiente();
            posicion--;
        }
        el.siguiente=actual.getSiguiente();
        actual.siguiente=el;

    }



    public void insert(TipoDeDato o, int posicion) {
        ElementoLE<TipoDeDato> el = new ElementoLE(o);
        insertElemento(el, posicion);
    }

    public void del(int posicion) {
        ElementoLE<TipoDeDato> el =getElemento(posicion-1);
        if(getNumeroElementos()>1) {
            if (posicion == 0) {
                primero = primero.siguiente;
            } else if (posicion > 0) {
                el.siguiente = el.siguiente.siguiente;

            }

        }
        else{
            vaciar();
        }
    }


    public int getNumeroElementos() {
        Integer contador =0;
        ElementoLE<TipoDeDato> actual = primero;
        while (actual != null ) {
            contador++;
            actual = actual.getSiguiente();
        }
        return contador;
    }


    public ElementoLE<TipoDeDato> getPrimero() {
        return primero;
    }

    public ElementoLE<TipoDeDato> getUltimo() {
        ElementoLE<TipoDeDato> actual = primero;
        while (actual != null && actual.getSiguiente() != null) {
            actual = actual.getSiguiente();
        }
        return actual;
    }

    public ElementoLE<TipoDeDato> getSiguiente(ElementoLE<TipoDeDato> el) {

        return el.getSiguiente();
    }


    public ElementoLE<TipoDeDato> getElemento(int posicion) {

        ElementoLE<TipoDeDato> actual = null;
        if (posicion >= 0 && posicion < getNumeroElementos()) {
            int contador = 0;
            actual = primero;
            while (actual != null && contador < posicion) {
                actual = actual.getSiguiente();
                contador++;
            }

        }
        return actual;
    }

    @Override
    public String toString() {
        Integer contador=0;
        String resultado="";
        while(contador<=getNumeroElementos()-1){
            resultado+= getElemento(contador).getData()+" ";
            contador++;
        }
        return "["+resultado+"]";
    }
}

