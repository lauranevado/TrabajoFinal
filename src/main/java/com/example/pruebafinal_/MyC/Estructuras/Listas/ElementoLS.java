package com.example.pruebafinal_.MyC.Estructuras.Listas;

public class ElementoLS<tipoDeDato> {
    private tipoDeDato data;

    public ElementoLS(tipoDeDato t) { this.data= t;}
    public ElementoLS() { }



    //definimos las dos funciones


    public tipoDeDato getData() {
        return  data;
    }

    public void setData(tipoDeDato o) {
        this.data = o;
    }




}
