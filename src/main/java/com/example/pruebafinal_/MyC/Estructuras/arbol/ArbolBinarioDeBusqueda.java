package com.example.pruebafinal_.MyC.Estructuras.arbol;

import com.example.pruebafinal_.MyC.Estructuras.Listas.ListaEnlazada;


public class ArbolBinarioDeBusqueda<TipoDeDato> {
    ElementoArbol raiz;


    public ArbolBinarioDeBusqueda() {
        this.raiz = null;
    }

    private ArbolBinarioDeBusqueda(ElementoArbol nuevaraiz) {
        this.raiz = nuevaraiz;
    }


    private int getGrado1(ElementoArbol raiz) {
        Integer contador = 0;
        if (raiz != null) {
            if (raiz.derecha != null) {
                contador++;
            }
            if (raiz.izquierda != null) {
                contador++;
            }
            if (contador != 2 && (raiz.derecha != null || raiz.izquierda != null)) {
                if (raiz.izquierda != null) {
                    raiz = raiz.izquierda;
                    while (raiz.derecha != null || raiz.izquierda != null) {
                        return getGrado1(raiz);
                    }
                } else if (raiz.derecha != null) {
                    raiz = raiz.derecha;
                    while (raiz.derecha != null || raiz.izquierda != null) {
                        return getGrado1(raiz);
                    }
                }

            }
        }
        return contador;
    }

    public int getGrado() {
        return getGrado1(raiz);
    }


    private int getAltura1(ElementoArbol aux) {
        if (aux != null) {
            return 1 + Math.max(getAltura1(aux.derecha), getAltura1(aux.izquierda));
        }
        return 0;
    }

    public int getAltura() {
        return getAltura1(raiz);
    }


    private ListaEnlazada<TipoDeDato> getListaDatosNivel1(ElementoArbol raiz, int nivel1, ListaEnlazada<TipoDeDato> lista) {

        if (raiz != null) {
            if (nivel1 == 1) {
                lista.add((TipoDeDato) raiz.data);
            } else if (nivel1 > 1) {
                getListaDatosNivel1(raiz.izquierda, nivel1 - 1, lista);
                getListaDatosNivel1(raiz.derecha, nivel1 - 1, lista);
            }
        }

        return lista;
    }

    public ListaEnlazada<TipoDeDato> getListaDatosNivel(int nivel) {
        ListaEnlazada<TipoDeDato> list = new ListaEnlazada<TipoDeDato>();
        return getListaDatosNivel1(raiz, nivel, list);
    }

    private ListaEnlazada<ElementoArbol> getListaNodosNivel1(ElementoArbol raiz, int nivel1, ListaEnlazada<ElementoArbol> lista) {
        if (raiz != null) {
            if (nivel1 == 1) {
                lista.add(raiz);
            } else if (nivel1 > 1) {
                getListaNodosNivel1(raiz.izquierda, nivel1 - 1, lista);
                getListaNodosNivel1(raiz.derecha, nivel1 - 1, lista);
            }
        }
        return lista;
    }

    public ListaEnlazada<ElementoArbol> getListaNodosNivel(int nivel) {
        ListaEnlazada<ElementoArbol> list = new ListaEnlazada<ElementoArbol>();
        return getListaNodosNivel1(raiz, nivel, list);
    }



    public boolean isHomogeneo() {
        Integer contador = 0;
        Integer contador2 = 0;
        if (raiz != null) {
            if (getGrado() == 1) {
                while (contador + 1 < getAltura() && getListaDatosNivel(contador + 1).getNumeroElementos() == 1) {
                    contador++;
                }
                if (contador + 1 == getAltura()) {
                    return true;
                }
            }

            if (getGrado() == 2) {
                while (contador2 + 1 < getAltura() && getListaDatosNivel(contador2 + 2).getNumeroElementos() == Math.pow(2, contador + 1)) {
                    contador2++;

                }
                if (contador2 + 1 == getAltura()) {
                    return true;
                } else {
                    return false;
                }
            }
        }
        return true;
    }


    public boolean isCompleto() {
        if (raiz != null) {
            if (raiz.izquierda == null && raiz.derecha == null) {
                return true;
            } else {
                if (getAltura1(raiz.izquierda) == getAltura1(raiz.derecha)) {
                    return true;
                }
            }
        }
        return false;
    }


    public boolean isCasiCompleto() {
        //Creamos dos listas
        ListaEnlazada<ElementoArbol> lista;
        ListaEnlazada<ElementoArbol> lista2;

        //Estas listas anteriorores adjuntarán los nodos del último y penúltimo nivel
        lista = getListaNodosNivel(getAltura() - 1);
        lista2 = getListaNodosNivel(getAltura());
        //Comprobamos que el penúltimo nivel esta completo y el último nivel no es completo
        if (lista.getNumeroElementos() == Math.pow(2, getAltura() - 2) && lista2.getNumeroElementos() != Math.pow(2, getAltura() - 1)) {
            Integer contador = 0;
            //Comprobamos si los elementos tienen grado 2, del primero al último
            while(lista.getElemento(contador).getData().getGrado()==2){
                contador++;
            }
            //Si hay un elemento de grado 1, comprobajos que el único hijo que tiene es el de la izquierda. En caso contrario retornariamos false
            if(lista.getElemento(contador).getData().getGrado()==1 && lista.getElemento(contador).getData().izquierda!=null) {
                    contador++;
            }

            // Comprobamos que el resto de elmentos son de grado 0
            if(contador<lista.getNumeroElementos()){
                    while(contador<lista.getNumeroElementos() &&lista.getElemento(contador).getData().getGrado()==0 ) {
                        contador++;
                    }
            }

            //Si cumple todas las condiciones necesarias para que sea casi completo, el contador llegará a valer la cantidad  de elementos del penúltimo nivel.
            if(contador==lista.getNumeroElementos()){
                     return true;
            //En caso de que el contador alcance otro valor distinto de la cantidad de números de elementos, ratornará 0.
            }else{ return false;}

        }
        return false;
    }




    public ListaEnlazada<TipoDeDato> getCamino(TipoDeDato dato) {
        ListaEnlazada<TipoDeDato> lista = new ListaEnlazada<TipoDeDato>();
        ElementoArbol actual = raiz;
        if (raiz != null) {
            //Comprobamos que la raiz no adjunta el dato que buscamos y qeu es diferente de null
            while (actual.getData() != null && actual.getData() != dato) {
                //Comparamos los datos
                Comparable datoactual = (Comparable) actual.getData();
                Comparable datonumero = (Comparable) dato;
                int rdo = datoactual.compareTo(datonumero);
                //Si es mayor
                if (rdo == 1) {
                    lista.add((TipoDeDato) actual.getData());
                    actual = actual.getIzquierda();
                }
                //Si es menor
                else if (rdo == -1) {
                    lista.add((TipoDeDato) actual.getData());
                    actual = actual.getDerecha();
                }
            }
            lista.add((TipoDeDato) actual.getData());
        }
        return lista;
    }


    public void add(TipoDeDato numero) {
        if (raiz == null) {
            ElementoArbol raiznew = new ElementoArbol<>(numero);
            raiz = raiznew;
        } else {
            raiz.addElemento(numero);
        }
    }

    public ArbolBinarioDeBusqueda getSubArbolIzquierda() {
        ArbolBinarioDeBusqueda arbolIzda = new ArbolBinarioDeBusqueda(this.raiz.getIzquierda());
        return arbolIzda;
    }

    public ArbolBinarioDeBusqueda getSubArbolDerecha() {
        ArbolBinarioDeBusqueda arbolDer = new ArbolBinarioDeBusqueda(this.raiz.getDerecha());
        return arbolDer;
    }


    //Imprimir según el orden
    private ListaEnlazada<TipoDeDato> preorden(ElementoArbol elem, ListaEnlazada<TipoDeDato> list) {
        if (elem == null) {
            //detener recursividad; caso base
        } else {
            list.add((TipoDeDato) elem.getData());
            preorden(elem.getIzquierda(), list);
            preorden(elem.getDerecha(), list);
        }
        return list;
    }


    public ListaEnlazada<TipoDeDato> getListaPreOrden() {
        ListaEnlazada<TipoDeDato> list = new ListaEnlazada<TipoDeDato>();
        return this.preorden(raiz, list);
    }


    private ListaEnlazada<TipoDeDato> postorden(ElementoArbol elem, ListaEnlazada<TipoDeDato> list) {
        if (elem == null) {
            //detener recursividad; caso base
        } else {
            postorden(elem.getIzquierda(), list);
            postorden(elem.getDerecha(), list);
            list.add((TipoDeDato) elem.getData());
        }
        return list;
    }


    public ListaEnlazada<TipoDeDato> getListaPostOrden() {
        ListaEnlazada<TipoDeDato> list = new ListaEnlazada<TipoDeDato>();
        return this.postorden(raiz, list);
    }

    private ListaEnlazada<TipoDeDato> ordencentral(ElementoArbol elem, ListaEnlazada<TipoDeDato> list) {
        if (elem == null) {
            //detener recursividad; caso base
        } else {
            ordencentral(elem.getIzquierda(), list);
            list.add((TipoDeDato) elem.getData());
            ordencentral(elem.getDerecha(), list);

        }
        return list;
    }


    public ListaEnlazada<TipoDeDato> getListaOrdenCentral() {
        ListaEnlazada<TipoDeDato> list = new ListaEnlazada<TipoDeDato>();
        return this.ordencentral(raiz, list);
    }

}