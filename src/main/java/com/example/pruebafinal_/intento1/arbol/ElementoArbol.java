package com.example.pruebafinal_.intento1.arbol;

public class ElementoArbol<tipoDeDato>{
    tipoDeDato data;
    ElementoArbol izquierda;
    ElementoArbol derecha;



    protected ElementoArbol(ElementoArbol izquierda, ElementoArbol derecha, tipoDeDato data) {
        this.izquierda = izquierda;
        this.derecha =derecha;
        this.data = data;
    }
    public int getGrado(){
        Integer contador=0;
        if(izquierda!=null) {
            contador++;
        }

        if(derecha!=null){
            contador++;
        }
        return contador;
    }


    public ElementoArbol(tipoDeDato o) {
        this.data = o;
    }

    public tipoDeDato getData() {
        return data;
    }

    protected void setData(tipoDeDato data) {
        this.data = data;
    }

    public ElementoArbol getIzquierda() {
        return izquierda;
    }

    public ElementoArbol getDerecha() {
        return derecha;
    }

    protected void addElemento(tipoDeDato numero){
        ElementoArbol ela =new ElementoArbol<>(numero);

        Comparable datoraiz = (Comparable) this.getData();
        Comparable datonumero = (Comparable) numero;
        int rdo  = datoraiz.compareTo(datonumero);
        /* -1 si es menor, 0 si es igual, 1 si es mayor */


        if(rdo==0){
            System.out.println("No se ha podido insertar porque ya está en el árbol.");
        }else if(rdo ==-1){
            if(this.derecha==null){
                this.derecha=ela;
            }else{
                this.derecha.addElemento(numero);
            }
        }else if(rdo ==1) {
            if (this.izquierda == null) {
                this.izquierda = ela;
            } else {
                this.izquierda.addElemento(numero);
            }
        }
    }
}
