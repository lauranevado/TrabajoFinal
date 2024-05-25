package com.example.pruebafinal_.MyC.PartidaFinalizada;


import com.example.pruebafinal_.MyC.Estructuras.Listas.ListaEnlazada;
import com.example.pruebafinal_.MyC.Estructuras.grafo.Cola;

import static com.example.pruebafinal_.MyC.Tablero.Tablero.grafoColaIndividuos;

import com.example.pruebafinal_.MyC.Estructuras.arbol.ArbolBinarioDeBusqueda;
import com.example.pruebafinal_.MyC.Datos.Individuo;
import com.example.pruebafinal_.MyC.Estructuras.grafo.Grafo;
import com.example.pruebafinal_.MyC.Guardado.DatosCargados;
import com.example.pruebafinal_.MyC.Tablero.Tablero;

public class InformacionPartida {
    private int turnosJugados;
    private int individuosVivos;
    private int masLongevo;  ///Mas turnos ha vivido
    private int numMutaciones;
    private int numReproducciones;
    private int individuoMasReproducciones;
    private int individuoMasClonaciones;
    private int individuoMasAgua;

    private Individuo idSuperviviente;


    public InformacionPartida(int turnosJugados, int individuosVivos,Individuo idSuperviviente) {
        this.turnosJugados = turnosJugados;
        this.individuosVivos = individuosVivos;
        this.masLongevo = getLongevo();
        this.numMutaciones= getNumMutaciones();
        this.numReproducciones= getNumReproducciones();
        this.individuoMasReproducciones = getIndividuoMasReproducciones();
        this.individuoMasClonaciones = getIndividuoMasClonaciones();
        this.individuoMasAgua = getIndividuoMasAgua();
        this.arbolSuperviviente = getArbolSuperviviente(idSuperviviente);
    }

    public int getLongevo(){

        int id=0;
        int individuo=0;
        for(Integer i=0;i<grafoColaIndividuos.getVertices().getNumeroElementos();i++){
            int contador=0;
            Cola ind= grafoColaIndividuos.getVertices().getElementoLS(i).getData().getData();
            while (!ind.isVacia()){
                if( ind.poll().getData()!=null){
                    contador++;
                }


            }
            if(individuo==0) {
                individuo = contador;
            }
            else if(contador>individuo){
                individuo=contador;
                id=i;
            }
        }
        return id;
    }

    public int getNumMutaciones(){
        Grafo<Cola> grafoAnalizar= grafoColaIndividuos;
        int contador=0;
        for(Integer i=0;i<grafoAnalizar.getVertices().getNumeroElementos();i++){
            Cola cola= grafoAnalizar.getVertices().getElementoLS(i).getData().getData();
            while (!cola.isVacia()){
                if(cola.poll().getData()=="clonado"){
                    contador++;

                }

            }

        }
        return contador;
    }



    public int getNumReproducciones(){
        Grafo<Cola> grafoAnalizar= grafoColaIndividuos;
        int contador=0;
        for(Integer i=0;i<grafoAnalizar.getVertices().getNumeroElementos();i++){
            Cola cola= grafoAnalizar.getVertices().getElementoLS(i).getData().getData();
            while (!cola.isVacia()){
                if(cola.poll().getData()=="Se ha reproducido"){
                    contador++;

                }

            }

        }
        int resultado=contador/2;
        return resultado;

    }

    public int getIndividuoMasReproducciones(){
        Grafo<Cola> grafoAnalizar= grafoColaIndividuos;
        int masReproducciones=0;
        int individuo = 0;
        for(Integer i=0;i<grafoAnalizar.getVertices().getNumeroElementos();i++){
            Cola cola= grafoAnalizar.getVertices().getElementoLS(i).getData().getData();
            int otro=0;
            while (!cola.isVacia()){
                if(cola.poll().getData()=="Se ha reproducido"){
                    otro++;

                }

            }
            if(masReproducciones<=otro){
                individuo=i;
                masReproducciones=otro;
            }

        }
        return individuo;
    }

    public int getIndividuoMasClonaciones(){
        Grafo<Cola> grafoAnalizar= grafoColaIndividuos;
        int masClonaciones=0;
        int individuo=0;
        for(Integer i=0;i<grafoAnalizar.getVertices().getNumeroElementos();i++){
            Cola cola= grafoAnalizar.getVertices().getElementoLS(i).getData().getData();
            int otro=0;
            while (!cola.isVacia()){
                if(cola.poll().getData()=="clonado"){
                    otro++;

                }

            }
            if(masClonaciones<=otro){
                individuo=i;
                masClonaciones=otro;
            }

        }
        return individuo;
    }

    public int getIndividuoMasAgua(){
        Grafo<Cola> grafoAnalizar= grafoColaIndividuos;
        int masAgua=0;
        int individuo=0;
        for(Integer i=0;i<grafoAnalizar.getVertices().getNumeroElementos();i++){
            Cola cola= grafoAnalizar.getVertices().getElementoLS(i).getData().getData();
            int otro=0;
            while (!cola.isVacia()){
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
        Grafo<Cola> grafoAnalizar= grafoColaIndividuos;
        ListaEnlazada<Integer> max= new ListaEnlazada<>();
        int maxVida=0;
        int individuo=0;
        for(Integer i=0;i<grafoAnalizar.getVertices().getNumeroElementos();i++) {
            grafoAnalizar.getVertices().getElementoLS(i).getData().getData().poll().getData();
            int ind = (int) grafoAnalizar.getVertices().getElementoLS(i).getData().getData().poll().getData();
            while (grafoAnalizar.getVertices().getElementoLS(i) != null) {
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

    private void addPadres(ListaEnlazada<Individuo> indivAddPadres, ArbolBinarioDeBusqueda<Individuo> arbolGenealogico){
        for (Integer i = 0; i < indivAddPadres.getNumeroElementos(); i++) {
            arbolGenealogico.add(indivAddPadres.getElemento(i).getData());
        }

//        if(indivAddPadres!=null) {
//            for (Integer i = 0; i < indivAddPadres.getNumeroElementos(); i++) {
//                arbolGenealogico.add(indivAddPadres.getElemento(i).getData());
//                if(indivAddPadres!=null) {
//                    addPadres(indivAddPadres, arbolGenealogico);
//                }
//            }
//        }
    }

    private ArbolBinarioDeBusqueda<Individuo> getArbolSuperviviente(Individuo individuoSuperviviente){
        ArbolBinarioDeBusqueda<Individuo> arbolGenealogico= new ArbolBinarioDeBusqueda<>();
        arbolGenealogico.add(individuoSuperviviente);
        if(individuoSuperviviente.getPadres()!=null) {
            addPadres(individuoSuperviviente.getPadres(), arbolGenealogico);
        }
        return arbolGenealogico;

    }

    public int getTurnosJugados() {
        return turnosJugados;
    }

    public void setTurnosJugados(int turnosJugados) {
        this.turnosJugados = turnosJugados;
    }

    public int getIndividuosVivos() {
        return individuosVivos;
    }

    public void setIndividuosVivos(int individuosVivos) {
        this.individuosVivos = individuosVivos;
    }
}

