package com.example.pruebafinal_.intento1;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class InformacionRecursosProperties {

    protected InformacionRecursos original;

    protected StringProperty info= new SimpleStringProperty();

    public InformacionRecursosProperties(InformacionRecursos original){setOriginal(original);}

    public void setOriginal(InformacionRecursos original) {
        this.original = original;
    }

}
