package com.example.pruebafinal_.intento1.grafo;

import com.example.pruebafinal_.intento1.Celdas;
import com.example.pruebafinal_.intento1.Listas.ListaSimple;

import java.nio.channels.NonReadableChannelException;

public class Grafo<tipoDeDato> {

    private ListaSimple<Vertice<tipoDeDato>> vertices = new ListaSimple<>();
    private ListaSimple<Arista<tipoDeDato>> arcos = new ListaSimple<>();

    public Grafo(){
        this.vertices= new ListaSimple<>();
        this.arcos= new ListaSimple<>();
    }
    public void addVertices(Vertice<tipoDeDato> vertice){
        this.vertices.add(vertice);
    }

    public void addArco(Arista<tipoDeDato> arco){
        this.arcos.add(arco);
        arco.origen.addArcoSalida(arco);
        arco.destino.addArcoEntrada(arco);
    }

    public void addArco(tipoDeDato a, tipoDeDato b, int peso){
        Vertice<tipoDeDato> vIni=null;
        Vertice<tipoDeDato> vFin=null;
        for(int i=0; i<vertices.getNumeroElementos();i++){
            if(vertices.getElementoLS(i).getData().data==a){
                vIni =vertices.getElementoLS(i).getData();
            }
            if(vertices.getElementoLS(i).getData().data==b){
                vFin =vertices.getElementoLS(i).getData();
            }
        }
        if(vIni !=null && vFin !=null){
            try{
                addArco(new Arista<>(vIni,vFin,peso));
            }catch (NonReadableChannelException ex){
                ex.printStackTrace();

            }
        }
    }

    //DijKstra


    public Mapa<Vertice<tipoDeDato>,Camino<tipoDeDato>> dijkstra(Vertice<tipoDeDato> origen){

        Mapa<Vertice<tipoDeDato>,Double> distancias = new Mapa<>();
        Cola<Vertice<tipoDeDato>> colaPendientes = new Cola<>();
        Mapa<Vertice<tipoDeDato>,Vertice<tipoDeDato>>  verticesAnteriores = new Mapa<>();

        //En caso de que no exista el origen-->
        if(vertices.getPosicion(origen)!=null) {
            this.dijkstra_init(vertices.getElementoLS(vertices.getPosicion(origen)).getData(), distancias, colaPendientes, verticesAnteriores);
            this.dijkstra_calcula(distancias, colaPendientes, verticesAnteriores);
            return this.dijkstra_procesaResultado(distancias, verticesAnteriores, origen);
        }
        System.out.println("Error, no existe el origen");
        return null;
    }

    public boolean isPosible(Vertice<tipoDeDato> origen , Vertice<tipoDeDato> destino){
        if(vertices.getPosicion(origen)!=null && vertices.getPosicion(destino)!=null){
            return true;
        }
        return false;
    }
    public Camino<Vertice<tipoDeDato>> caminoMinimo(tipoDeDato origen,tipoDeDato destino){

        Vertice<tipoDeDato> verticeO= getVertice(origen);
        Vertice<tipoDeDato> verticeD = getVertice(destino);
        return   getCaminoMinimo(verticeO,verticeD);

    }

    public Camino getCaminoMinimo(Vertice origen, Vertice fin){
        Mapa<Vertice<tipoDeDato>, Camino<tipoDeDato>> caminos = this.dijkstra(origen);
        Camino camino= caminos.getValue(fin);
        return   camino;
    }

    public Vertice<tipoDeDato> getVertice(tipoDeDato dato){
        for(Integer i=0;i<vertices.getNumeroElementos();i++){
            if(vertices.getElementoLS(i).getData().data==dato){
                Vertice vertice=vertices.getElementoLS(i).getData();
                return vertice;

            }
        }
        return null;
    }
    /**
     *Inicializa las variables de distancias del grafo, la cola de vertices pendientes de procesar, y la lista de vértices anteriores al calculado.
     * Params:
     * origen distancias colaPendientes verticesAnteriores
     */

    protected void dijkstra_init(Vertice<tipoDeDato> origen, Mapa<Vertice<tipoDeDato>,Double> distancias, Cola<Vertice<tipoDeDato>> colaPendiente, Mapa<Vertice<tipoDeDato>,Vertice<tipoDeDato>> verticesAnteriores ){
        Integer contador=0;
        while(this.vertices.getNumeroElementos()>contador){
            distancias.add(this.vertices.getElementoLS(contador).getData(),Double.MAX_VALUE);
            contador++;
        }

        distancias.add(origen,0.0);
        colaPendiente.add(origen);
    }



    /**
     * Realiza el cálculo de dijkstra, calculando tanto las distancias como los anteriores vértices que llegan a uno determinado.
     * Params:
     * distancias colaPendientes verticesAnteriores
     */

    protected void dijkstra_calcula(Mapa<Vertice<tipoDeDato>, Double> distancias, Cola<Vertice<tipoDeDato>> colaPendientes, Mapa<Vertice<tipoDeDato>, Vertice<tipoDeDato>> verticesAnteriores){
        while(!colaPendientes.isVacia()){
            Vertice<tipoDeDato> verticeActual = colaPendientes.poll().getData();
            Integer contador=0;
            while(verticeActual.arcoSalida.getNumeroElementos()>contador){
                Vertice<tipoDeDato> verticeVecino= verticeActual.arcoSalida.getElementoLS(contador).getData().destino;
                double nuevoCalculoDeDistancia = distancias.getValue(verticeActual) + verticeActual.arcoSalida.getElementoLS(contador).getData().peso;
                contador++;
                if(nuevoCalculoDeDistancia < distancias.getValue(verticeVecino)) {
                    distancias.add(verticeVecino, nuevoCalculoDeDistancia);
                    verticesAnteriores.add(verticeVecino, verticeActual);
                    colaPendientes.add(verticeVecino);

                }
            }
        }
    }
    //


    /**
     *Cuando el cálculo ya ha acabado, toda la información queda en las variables por parámetros, pero hay que procesar los resultados para generar algo que sea manejable. El objetivo es generar un mapa o lista en la cuál para cada vértice se guarde el camino desde el origen hasta él y el coste de ese camino completo.
     * Params:
     * distancias verticesAnteriores
     */

    protected Mapa<Vertice<tipoDeDato>,Camino<tipoDeDato>> dijkstra_procesaResultado(Mapa<Vertice<tipoDeDato>,Double> distancias, Mapa<Vertice<tipoDeDato>,Vertice<tipoDeDato>> verticesAnteriores,Vertice<tipoDeDato> origen){
        Mapa<Vertice<tipoDeDato>,Camino<tipoDeDato>> caminos = new Mapa<>();
        Integer contador=0;
        while(verticesAnteriores.getNumElem()>contador){
            ListaSimple<Vertice> caminoCalculado= new ListaSimple<>();
            Vertice verticeDestino= verticesAnteriores.getIndice().getElementoLS(contador).getData(); //vertice destino
            Vertice v= verticeDestino;
            while(v!= null ){
                caminoCalculado.add(v);
                v= verticesAnteriores.getValue(v);

            }
            caminos.add(verticeDestino,new Camino<>(caminoCalculado.vuelta(),distancias.getValue(verticeDestino)));
            contador++;
        }
        return caminos;
    }
    public void borrarV(Vertice<tipoDeDato> v){
        if(!vertices.isVacia()){
            vertices.del(vertices.getPosicion(v));
            for(Integer i=0;i<arcos.getNumeroElementos();i++){
                if(arcos.getElementoLS(i).getData().destino==v || arcos.getElementoLS(i).getData().origen==v ){
                    arcos.del(i);
                }
            }
        }

    }
    public void borrarA(Arista<tipoDeDato> a){
        if(!arcos.isVacia()){
            arcos.del(arcos.getPosicion(a));
        }

    }

    public ListaSimple<Vertice<tipoDeDato>> getVertices(){return vertices;}
    public ListaSimple<Arista<tipoDeDato>> getAristas(){return arcos;}
    public String toPrintV(){
        StringBuffer salida = new StringBuffer();
        Integer contador =0;
        salida.append("[ ");
        while (contador<vertices.getNumeroElementos()) {
            salida.append(vertices.getElementoLS(contador).getData().data + " ");
            contador++;
        }
        salida.append("]");
        return salida.toString();
    }
    public String toPrintA(){
        StringBuffer salida = new StringBuffer();
        Integer contador =0;
        salida.append("[");
        while (contador<arcos.getNumeroElementos()) {
            salida.append("{"+arcos.getElementoLS(contador).getData().origen.data+","+arcos.getElementoLS(contador).getData().destino.data+"}");
            contador++;
        }
        salida.append("]");
        return salida.toString();
    }





}




