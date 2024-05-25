package com.example.pruebafinal_.MyC.Celdas;

import com.example.pruebafinal_.MyC.Datos.Recurso;
import com.example.pruebafinal_.MyC.Estructuras.Listas.ListaEnlazada;
import javafx.scene.control.Label;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CeldasControllersTest {

    @Test
    void showCelda() {


    }
    @Test
    void onVaciarButtonClick() {
        ListaEnlazada<Celdas> celdas= new ListaEnlazada<>();
        Celdas celda=new Celdas(null,null,0,0,0,null);
        celdas.add(celda);
        celdas.vaciar();
    }

    @Test
    void vaciar() {
            ListaEnlazada<Celdas> celdas= new ListaEnlazada<>();
            Celdas celda=new Celdas(null,null,0,0,0,null);
            celdas.add(celda);
            vaciar();

    }

    @Test
    void loadCeldasData() {
    }

    @Test
    void getListaDeCeldas() {
        ListaEnlazada<Celdas> celdas= null;


    }

    @Test
    void setStage() {
    }

    @Test
    void initialize() {
    }
}