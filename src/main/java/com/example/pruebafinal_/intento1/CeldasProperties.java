package com.example.pruebafinal_.intento1;

import javafx.beans.property.*;

import java.util.Properties;

public class CeldasProperties {

    protected Celdas original;

    private Properties individuosProperties= new Properties();
    private Properties recursosProperties= new Properties();

    private IntegerProperty identificadorCelda= new SimpleIntegerProperty();


    public CeldasProperties(Celdas original, Properties individuosProperties, Properties recursosProperties) {
        this.original = original;
        this.individuosProperties = individuosProperties;
        this.recursosProperties = recursosProperties;
    }

//    public Properties getIndividuosProperties() {
//        return individuosProperties;
//    }
//
//    public Properties getRecursosProperties() {
//        return recursosProperties;
//    }

//    private Property<ListaEnlazada<Recurso>> recursos= new Property<ListaEnlazada<Recurso>>() {
//        @Override
//        public void bind(ObservableValue<? extends ListaEnlazada<Recurso>> observableValue) {
//
//        }
//
//        @Override
//        public void unbind() {
//
//        }
//
//        @Override
//        public boolean isBound() {
//            return false;
//        }
//
//        @Override
//        public void bindBidirectional(Property<ListaEnlazada<Recurso>> property) {
//
//        }
//
//        @Override
//        public void unbindBidirectional(Property<ListaEnlazada<Recurso>> property) {
//
//        }
//
//        @Override
//        public Object getBean() {
//            return null;
//        }
//
//        @Override
//        public String getName() {
//            return null;
//        }
//
//        @Override
//        public void addListener(ChangeListener<? super ListaEnlazada<Recurso>> changeListener) {
//
//        }
//
//        @Override
//        public void removeListener(ChangeListener<? super ListaEnlazada<Recurso>> changeListener) {
//
//        }
//
//        @Override
//        public ListaEnlazada<Recurso> getValue() {
//            return null;
//        }
//
//        @Override
//        public void addListener(InvalidationListener invalidationListener) {
//
//        }
//
//        @Override
//        public void removeListener(InvalidationListener invalidationListener) {
//
//        }
//
//        @Override
//        public void setValue(ListaEnlazada<Recurso> recursoListaEnlazada) {
//
//        }
//    };


    public CeldasProperties(Celdas original){
        setOriginal(original);
    }

    public void setOriginal(Celdas original){
        this.original = original;
        rollback();
    }
    public void commit(){

    }
    public void rollback(){

    }
}
