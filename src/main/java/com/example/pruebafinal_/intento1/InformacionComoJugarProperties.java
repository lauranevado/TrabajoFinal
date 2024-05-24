package com.example.pruebafinal_.intento1;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class InformacionComoJugarProperties {
    protected InformacionComoJugar original;

    protected StringProperty info= new SimpleStringProperty();

    public InformacionComoJugarProperties(InformacionComoJugar original){setOriginal(original);}

    public void setOriginal(InformacionComoJugar original) {
        this.original = original;
    }

}
