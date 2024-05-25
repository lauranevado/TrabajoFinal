package com.example.pruebafinal_.MyC.Estructuras.grafo;

public class Arista<tipoDeDato> {

    protected Vertice origen;
    protected double peso;
    protected Vertice destino;


    public Arista(Vertice origen,  Vertice destino,double peso) {
        this.origen = origen;
        this.peso = peso;
        this.destino = destino;

    }
    public Arista(Vertice origen,  Vertice destino) {
        this.origen = origen;
        this.destino = destino;

    }

}
