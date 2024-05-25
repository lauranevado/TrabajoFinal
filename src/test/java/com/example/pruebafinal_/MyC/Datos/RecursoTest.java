package com.example.pruebafinal_.MyC.Datos;

import javafx.scene.paint.Color;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RecursoTest {

    @Test
    void getTipo() {
        Recurso recurso = new Recurso(0, 3, 0, 70, 16, 3);
        assertEquals(0, recurso.getTipo());
    }

    @Test
    void setTipo() {
        Recurso recurso = new Recurso(0, 3, 0, 70, 16, 3);
        assertDoesNotThrow(() -> recurso.setTipo(1));
        assertEquals(1, recurso.getTipo());
    }

    @Test
    void getTurnosDeVida() {
        Recurso recurso = new Recurso(0, 3, 0, 70, 16, 3);
        assertEquals(3, recurso.getTurnosDeVida());
    }

    @Test
    void setTurnosDeVida() {
        Recurso recurso = new Recurso(0, 3, 0, 70, 16, 3);
        assertDoesNotThrow(() -> recurso.setTurnosDeVida(10));
        assertEquals(10, recurso.getTurnosDeVida());
    }

    @Test
    void getPosicion() {
        Recurso recurso = new Recurso(0, 3, 0, 70, 16, 3);
        assertEquals(0, recurso.getPosicion());
    }

    @Test
    void setPosicion() {
        Recurso recurso = new Recurso(0, 3, 0, 70, 16, 3);
        assertDoesNotThrow(() -> recurso.setPosicion(10));
        assertEquals(10, recurso.getPosicion());
    }

    @Test
    void getProbabilidadGeneral() {
        Recurso recurso = new Recurso(0, 3, 0, 70, 16, 3);
        assertEquals(70, recurso.getProbabilidadGeneral());
    }

    @Test
    void setProbabilidadGeneral() {
        Recurso recurso = new Recurso(0, 3, 0, 70, 16, 3);
        assertDoesNotThrow(() -> recurso.setProbabilidadGeneral(80));
        assertEquals(80, recurso.getProbabilidadGeneral());
    }

    @Test
    void getProbabilidadRecurso() {
        Recurso recurso = new Recurso(0, 3, 0, 70, 16, 3);
        assertEquals(16, recurso.getProbabilidadRecurso());
    }

    @Test
    void setProbabilidadRecurso() {
        Recurso recurso = new Recurso(0, 3, 0, 70, 16, 3);
        assertDoesNotThrow(() -> recurso.setProbabilidadRecurso(20));
        assertEquals(20, recurso.getProbabilidadRecurso());
    }

    @Test
    void getPropiedad() {
        Recurso recurso = new Recurso(0, 3, 0, 70, 16, 3);
        assertEquals(3, recurso.getPropiedad());
    }

    @Test
    void setPropiedad() {
        Recurso recurso = new Recurso(0, 3, 0, 70, 16, 3);
        assertDoesNotThrow(() -> recurso.setPropiedad(7));
        assertEquals(7, recurso.getPropiedad());
    }

    @Test
    void getColor() {
        Recurso recurso = new Recurso(0, 3, 0, 70, 16, 3);
        assertEquals(Color.TURQUOISE, recurso.getColor());
        Recurso recurso1 = new Recurso(1, 3, 0, 70, 16, 3);
        assertEquals(Color.TOMATO, recurso1.getColor());
        Recurso recurso2 = new Recurso(2, 3, 0, 70, 16, 3);
        assertEquals(Color.BURLYWOOD, recurso2.getColor());
        Recurso recurso3 = new Recurso(3, 3, 0, 70, 16, 3);
        assertEquals(Color.YELLOW, recurso3.getColor());
        Recurso recurso4 = new Recurso(4, 3, 0, 70, 16, 3);
        assertEquals(Color.HOTPINK, recurso4.getColor());
        Recurso recurso5 = new Recurso(5, 3, 0, 70, 16, 3);
        assertEquals(Color.DARKGREY, recurso5.getColor());
        Recurso recurso6 = new Recurso(6, 3, 0, 70, 16, 3);
        assertEquals(Color.GREY, recurso6.getColor());
    }
}