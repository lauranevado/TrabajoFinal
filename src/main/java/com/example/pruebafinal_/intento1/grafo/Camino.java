package com.example.pruebafinal_.intento1.grafo;

import com.example.pruebafinal_.intento1.Listas.ListaSimple;

public class Camino<tipoDeDato> {

    private ListaSimple<Vertice> camino;
    private double coste;

    public Camino(ListaSimple<Vertice> camino, double coste) {
        this.camino = camino;
        this.coste = coste;
    }

    public void setCamino(ListaSimple camino) {
        this.camino = camino;
    }

    public void setCoste(double coste) {
        this.coste = coste;
    }

    public ListaSimple getCamino(){return camino;}

    public double getCoste(){return coste;}

//    public String toString() {
//        StringBuffer salida = new StringBuffer();
//        salida.append("======= Volcado del camino desde [" + getCamino().getElementoLS(0).getData() + "] hasta [" + getCamino().getElementoLS(camino.getNumeroElementos()-1).getData() + "]: ======\n");
//        //salida.append("Referencias a los vértices: " + this.getCami + "\n");
//        salida.append("Lista de datos en vértices: [-");
//        for (Integer i=0; i<this.getCamino().getNumeroElementos();i++) {            //Recorremos la lista
//            salida.append(this.getCamino().getElementoLS(i).getData()+"-");
//        }
//        salida.append("] - Coste: " + this.getCoste() + "\n");
//
//        return salida.toString();
//    }

}
