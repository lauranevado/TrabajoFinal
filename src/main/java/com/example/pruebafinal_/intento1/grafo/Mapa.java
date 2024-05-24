package com.example.pruebafinal_.intento1.grafo;

import com.example.pruebafinal_.intento1.Listas.ListaSimple;

public class Mapa<TipoDato1,TipoDato2> {

    private ListaSimple<Dupla<TipoDato1,TipoDato2>> datosMapa; //Clave, dato

    public Mapa() {
        this.datosMapa= new ListaSimple<>();
    }


    //Para obtener la suma de los pesos de los caminos desde el origen hasta cualquier otro vertice

   public void add(TipoDato1 clave, TipoDato2 dato){
       if(this.datosMapa.isVacia()){
           datosMapa.add(new Dupla<>(clave,dato));
       }
       int contador=0;
       boolean existe=false;
       while((contador<datosMapa.getNumeroElementos()) && (!existe)){
           if(datosMapa.getElementoLS(contador).getData().getClave()==clave){
               existe=true;

           }else{
               contador++;
           }
       }if(!existe){
           datosMapa.add(new Dupla<>(clave,dato));

       }else{
           datosMapa.getElementoLS(contador).getData().setDato(dato);
       }
   }


    public TipoDato2 getValue(TipoDato1 clave){
        Integer contador=0;
        while(contador<datosMapa.getNumeroElementos()){
            if (datosMapa.getElementoLS(contador).getData().getClave()==clave){
                return datosMapa.getElementoLS(contador).getData().getDato();
            }
            contador++;
        }
        return null;
    }

    public int getNumElem(){
        return datosMapa.getNumeroElementos();
    }

    public ListaSimple<TipoDato1> getIndice(){
        ListaSimple<TipoDato1> lista = new  ListaSimple<>();
        Integer contador=0;
        while(contador<datosMapa.getNumeroElementos()){
            lista.add(datosMapa.getElementoLS(contador).getData().getClave());
            contador++;
        }
        return lista;
    }
    public ListaSimple<TipoDato2> getIndice2(){
        ListaSimple<TipoDato2> lista = new  ListaSimple<>();
        Integer contador=0;
        while(contador<datosMapa.getNumeroElementos()){
            lista.add(datosMapa.getElementoLS(contador).getData().getDato());
            contador++;
        }
        return lista;
    }



}
