package com.example.pruebafinal_.intento1.grafo;

import com.example.pruebafinal_.intento1.Listas.ListaSimple;

public class Vertice<tipoDeDato> {

     protected tipoDeDato data;
     protected ListaSimple<Arista<tipoDeDato>> arcoEntrada;
     protected ListaSimple<Arista<tipoDeDato>> arcoSalida;

    public Vertice(tipoDeDato data) {
        this.data = data;
        this.arcoEntrada = new   ListaSimple();
        this.arcoSalida = new   ListaSimple();
    }

    public void addArcoSalida(Arista<tipoDeDato> arco){this.arcoSalida.add(arco);}
    public void addArcoEntrada(Arista<tipoDeDato> arco){this.arcoEntrada.add(arco);}

    public tipoDeDato getData(){return data;}



}
