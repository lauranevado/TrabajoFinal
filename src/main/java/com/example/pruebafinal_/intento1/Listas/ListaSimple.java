package com.example.pruebafinal_.intento1.Listas;

import com.example.pruebafinal_.intento1.Celdas;
import com.example.pruebafinal_.intento1.grafo.Vertice;

/**
 * Programar la lista simplemente enlazada.
 */
public class ListaSimple<tipoDeDato> {
    private ElementoLS<tipoDeDato>[] datos;  //lista de ELementoLS

    private Integer maximo= 10000;

    public ListaSimple() {
        this.datos= new ElementoLS[maximo];
    }

    //Métodos
    public boolean isVacia() {
        for (int i = 0; ; i++) {
            if (datos[i] != null) {
                return false;
            }
            return true;
        }
    }

    public String vaciar() {
        if (!isVacia()) {
            for (int i = 0; i < maximo; i++) {
                datos[i] = null;
            }
            return "se ha vaciado";
        }
        return "Esta vacia";
    }

    public int add(tipoDeDato el) {
        ElementoLS<tipoDeDato> e= new ElementoLS(el);
        Integer i = 0;
        while (datos[i] != null) {
            i++;
        }
        if (i < maximo) {
            datos[i] = e;
        }
        return getNumeroElementos();
    }






    public int del(int pos) {
        ElementoLS<tipoDeDato> el = null;
        Integer i = 0;
        if (datos[pos] == null) {
            return 0;
        } else {
            while (i + pos + 1 < maximo) {
                datos[i + pos] = datos[i + pos + 1];
                i++;
            }
            datos[getNumeroElementos()] = el;
        }
        return 0;
    }

    public int getNumeroElementos() {
        if (datos[0]==null){
            return 0;
        } else {
            Integer contador=1;
            ElementoLS<tipoDeDato> el=datos[contador-1];
            while(this.getSiguiente((tipoDeDato) el)!=null){
                el=this.getSiguiente((tipoDeDato) el);
                contador++;
            }

            return contador;
        }
    }

    public Integer getPosicion(tipoDeDato el) {
        Integer contador=0;
        while(contador<getNumeroElementos()){
            if (datos[contador].getData()==el) {
                return contador;
            }
            contador++;
        }

        return null;
    }
    public Integer getPosicionCeldas(Vertice<tipoDeDato> el) {
        Integer contador=0;
        while(contador<getNumeroElementos()){
            if (datos[contador].getData()==el) {
                return contador;
            }
            contador++;
        }

        return null;
    }


    public ElementoLS<tipoDeDato> getPrimero() {
        return datos[0];
    }

    public ElementoLS<tipoDeDato> getUltimo() {
        return datos[getNumeroElementos() - 1];
    }

    private ElementoLS<tipoDeDato> getSiguiente(tipoDeDato el) {
        ElementoLS<tipoDeDato> e= new ElementoLS<>(el);
        ElementoLS<tipoDeDato> devolver=null;
        for (int i = 0; i < maximo; i++) {
            if (datos[i] != null && datos[i + 1] != null && (datos[i] == el)) {
                devolver = datos[i + 1];
                break;
            }
        }
        return devolver;
    }

    public ElementoLS<tipoDeDato> getElementoLS(int posicion) {

        if (datos[posicion] != null) {
            return  datos[posicion];
        }else{
            return null ;
        }


    }

    public tipoDeDato getDato(int pos){
        if (datos[pos] != null) {
            return  datos[pos].getData();
        }else{
            return null ;
        }
    }
//    public Celdas getCelda(int pos){
//        if (datos[pos] != null) {
//            return  datos[pos];
//        }else{
//            return null ;
//        }
//    }


    public ListaSimple<tipoDeDato> vuelta(){
        ListaSimple<tipoDeDato> lista = new ListaSimple<>();
        Integer contador=getNumeroElementos()-1;
        while(contador>=0){
            lista.add(getElementoLS(contador).getData());
            contador--;
        }
        return lista;

    }

}