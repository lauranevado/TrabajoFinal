package com.example.pruebafinal_.intento1;


import com.example.pruebafinal_.intento1.Listas.ListaEnlazada;
import com.example.pruebafinal_.intento1.grafo.Cola;

import static com.example.pruebafinal_.intento1.Tablero.celdas;
import static com.example.pruebafinal_.intento1.Tablero.grafoColaIndividuos;

import com.example.pruebafinal_.intento1.arbol.ArbolBinarioDeBusqueda;

public class InformacionPartida {
    private int masLongevo;  ///Mas turnos ha vivido
    private int numMutaciones;
    private int numReproducciones;
    private int individuoMasReproducciones;
    private int individuoMasClonaciones;
    private int individuoMasAgua;




    public int getLongevo(){
        int longevo=0;
        int individuo=0;
        for(Integer i=0;i<grafoColaIndividuos.getVertices().getNumeroElementos();i++){
            int ind= (int) grafoColaIndividuos.getVertices().getElementoLS(i).getData().getData().poll().getData();
            if ( ind>=longevo) {
                individuo=i;
                longevo=ind;
            }

        }
        return individuo;   //Retornamos simepre el identificador
    }

    public int getNumMutaciones(){
        int contador=0;
        for(Integer i=0;i<grafoColaIndividuos.getVertices().getNumeroElementos();i++){
            Cola cola= grafoColaIndividuos.getVertices().getElementoLS(i).getData().getData();
            while (cola!=null){
                if(cola.poll().getData()=="clonado"){
                    contador++;

                }

            }

        }
        return contador;
    }



    public int getNumReproducciones(){
        int contador=0;
        for(Integer i=0;i<grafoColaIndividuos.getVertices().getNumeroElementos();i++){
            Cola cola= grafoColaIndividuos.getVertices().getElementoLS(i).getData().getData();
            while (cola!=null){
                if(cola.poll().getData()=="Se ha reproducido"){
                    contador++;

                }

            }

        }
        int resultado=contador/2;
        return resultado;

    }

    public int getIndividuoMasReproducciones(){
        int masReproducciones=0;
        int individuo = 0;
        for(Integer i=0;i<grafoColaIndividuos.getVertices().getNumeroElementos();i++){
            Cola cola= grafoColaIndividuos.getVertices().getElementoLS(i).getData().getData();
            int otro=0;
            while (cola!=null){
                if(cola.poll().getData()=="Se ha reproducido"){
                    otro++;

                }

            }
            if(masReproducciones<=otro){
                individuo=i;
                masReproducciones=otro;
            }

        }
        return individuo;   //La posición de las colas en el gfrafo corresponden con sus identificadores
    }

    public int getIndividuoMasClonaciones(){
        int masClonaciones=0;
        int individuo=0;
        for(Integer i=0;i<grafoColaIndividuos.getVertices().getNumeroElementos();i++){
            Cola cola= grafoColaIndividuos.getVertices().getElementoLS(i).getData().getData();
            int otro=0;
            while (cola!=null){
                if(cola.poll().getData()=="clonado"){
                    otro++;

                }

            }
            if(masClonaciones<=otro){
                individuo=i;
                masClonaciones=otro;
            }

        }
        return individuo;  //La posición de las colas en el gfrafo corresponden con sus identificadores
    }

    public int getIndividuoMasAgua(){
        int masAgua=0;
        int individuo=0;
        for(Integer i=0;i<grafoColaIndividuos.getVertices().getNumeroElementos();i++){
            Cola cola= grafoColaIndividuos.getVertices().getElementoLS(i).getData().getData();
            int otro=0;
            while (cola!=null){
                if(cola.poll().getData()=="agua"){
                    otro++;

                }

            }
            if(masAgua<=otro){
                individuo=i;
                masAgua=otro;
            }

        }
        return individuo;

    }


    public ListaEnlazada<Integer> getMaximoVida(){
        ListaEnlazada<Integer> max= new ListaEnlazada<>();
        int maxVida=0;
        int individuo=0;
        for(Integer i=0;i<grafoColaIndividuos.getVertices().getNumeroElementos();i++) {
            grafoColaIndividuos.getVertices().getElementoLS(i).getData().getData().poll().getData();
            int ind = (int) grafoColaIndividuos.getVertices().getElementoLS(i).getData().getData().poll().getData();
            while (grafoColaIndividuos.getVertices().getElementoLS(i) != null) {
                if (ind >= maxVida) {
                    individuo = i;
                    maxVida = ind;
                }
            }
        }
         max.add(individuo);
         max.add(maxVida);
         return max;

    }

    public boolean isLongevoMaxvida(){
        if(getMaximoVida().getElemento(0).getData()==getLongevo()){
            return true;
        }
        else{
            return false;
        }
    }



    private ArbolBinarioDeBusqueda<Individuo> arbolSuperviviente;

    private void addPadres(Individuo indivAddPadres, ArbolBinarioDeBusqueda<Individuo> arbolGenealogico){
        for (Integer i = 0; i < indivAddPadres.getPadres().getNumeroElementos(); i++) {
            arbolGenealogico.add(indivAddPadres.getPadres().getElemento(i).getData());
            addPadres(indivAddPadres, arbolGenealogico);
        }
    }

    private ArbolBinarioDeBusqueda<Individuo> getArbolSuperviviente(Individuo individuoSuperviviente){
        ArbolBinarioDeBusqueda<Individuo> arbolGenealogico= new ArbolBinarioDeBusqueda<>();
        arbolGenealogico.add(individuoSuperviviente);
        addPadres(individuoSuperviviente, arbolGenealogico);

        return arbolGenealogico;

    }
}

