package com.example.pruebafinal_.MyC.Datos;

import com.example.pruebafinal_.MyC.Estructuras.Listas.ListaEnlazada;
import com.example.pruebafinal_.MyC.Estructuras.grafo.Cola;
import javafx.scene.paint.Color;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IndividuoTest {

    @Test
    void getTipo() {
        Individuo individuo = new Individuo(0, 1, 5, 1, 50, 50, new Cola());
        assertEquals(0, individuo.getTipo());
    }


    @Test
    void setTipo() {
        Individuo individuo = new Individuo(0, 1, 5, 1, 50, 50, new Cola());
        assertDoesNotThrow(() -> individuo.setTipo(2));
        assertEquals(2, individuo.getTipo());
    }

    @Test
    void getId() {
        Individuo individuo = new Individuo(0, 1, 5, 1, 50, 50, new Cola());
        assertEquals(1, individuo.getId());
    }

    @Test
    void setId() {
        Individuo padreClon = new Individuo(0, 5, 3, 0, 60, 80, new Cola<>());
        ListaEnlazada<Individuo> padres = new ListaEnlazada<>();
        padres.add(padreClon);
        Individuo individuo = new Individuo(1, 1, 5, 1, 50, 50, padres, new Cola());
        assertDoesNotThrow(() -> individuo.setId(10));
        assertEquals(10, individuo.getId());
    }

    @Test
    void getTurnosDeVida() {
        Individuo individuo = new Individuo(0, 1, 5, 1, 50, 50, new Cola());
        assertEquals(5, individuo.getTurnosDeVida());
    }

    @Test
    void setTurnosDeVida() {
        Individuo individuo = new Individuo(0, 1, 5, 1, 50, 50, new Cola());
        assertDoesNotThrow(() -> individuo.setTurnosDeVida(45));
        assertEquals(45, individuo.getTurnosDeVida());
    }

    @Test
    void getGeneracion() {
        Individuo individuo = new Individuo(0, 1, 5, 1, 50, 50, new Cola());
        assertEquals(1, individuo.getGeneracion());
    }

    @Test
    void setGeneracion() {
        Individuo individuo = new Individuo(0, 1, 5, 1, 50, 50, new Cola());
        assertDoesNotThrow(() -> individuo.setGeneracion(11));
        assertEquals(11, individuo.getGeneracion());
    }

    @Test
    void getPadres() {
        Individuo padreClon = new Individuo(0, 5, 3, 0, 60, 80, new Cola<>());
        ListaEnlazada<Individuo> padres = new ListaEnlazada<>();
        padres.add(padreClon);
        Individuo individuo = new Individuo(0, 1, 5, 1, 50, 50, padres, new Cola());
        assertEquals(1, individuo.getPadres().getNumeroElementos());
    }

    @Test
    void setPadres() {
        Individuo padreClon = new Individuo(0, 5, 3, 0, 60, 80, new Cola<>());
        ListaEnlazada<Individuo> padres = new ListaEnlazada<>();
        padres.add(padreClon);
        Individuo individuo = new Individuo(0, 1, 5, 1, 50, 50, padres, 15, new Cola());
        Individuo padreClon2 = new Individuo(0, 8, 3, 0, 60, 80, new Cola<>());
        ListaEnlazada<Individuo> padres2 = new ListaEnlazada<>();
        padres2.add(padreClon2);
        assertDoesNotThrow(() -> individuo.setPadres(padres2));
        assertEquals(1, individuo.getPadres().getNumeroElementos());
    }

    @Test
    void getpReproCadaIndividuo() {
        Individuo individuo = new Individuo(0, 1, 5, 1, 50, 50, new Cola());
        assertEquals(50, individuo.getpReproCadaIndividuo());
    }

    @Test
    void setpReproCadaIndividuo() {
        Individuo individuo = new Individuo(0, 1, 5, 1, 50, 50, new Cola());
        assertDoesNotThrow(() -> individuo.setpReproCadaIndividuo(80));
        assertEquals(80, individuo.getpReproCadaIndividuo());
    }

    @Test
    void getpClonacionCadaIndividuo() {
        Individuo individuo = new Individuo(0, 1, 5, 1, 50, 50, new Cola());
        assertEquals(50, individuo.getpClonacionCadaIndividuo());
    }

    @Test
    void setpClonacionCadaIndividuo() {
        Individuo individuo = new Individuo(0, 1, 5, 1, 50, 50, new Cola());
        assertDoesNotThrow(() -> individuo.setpClonacionCadaIndividuo(60));
        assertEquals(60, individuo.getpClonacionCadaIndividuo());
    }

    @Test
    void getCeldaObjetivoNormal() {
        Individuo individuo = new Individuo(1, 1, 5, 1, 50, 50, 14, new Cola());
        assertEquals(14, individuo.getCeldaObjetivoNormal());
    }

    @Test
    void setCeldaObjetivoNormal() {
        Individuo individuo = new Individuo(1, 1, 5, 1, 50, 50, 14, new Cola());
        assertDoesNotThrow(() -> individuo.setCeldaObjetivoNormal(18));
        assertEquals(18, individuo.getCeldaObjetivoNormal());
    }

    @Test
    void getColaIndividuo() {
        Individuo individuo = new Individuo(0, 1, 5, 1, 50, 50, new Cola());
        assertTrue(individuo.getColaIndividuo().isVacia());
    }

    @Test
    void setColaIndividuo() {
        Individuo individuo = new Individuo(0, 1, 5, 1, 50, 50, new Cola());
        Cola cola2 = new Cola<>();
        cola2.add(45);
        assertDoesNotThrow(() -> individuo.setColaIndividuo(cola2));
        assertFalse(individuo.getColaIndividuo().isVacia());
    }

    @Test
    void getColor() {
        Individuo individuo = new Individuo(0, 1, 5, 1, 50, 50, new Cola());
        assertEquals(Color.YELLOWGREEN, individuo.getColor());
        Individuo individuo2 = new Individuo(1, 1, 5, 1, 50, 50, 14, new Cola());
        assertEquals(Color.FORESTGREEN, individuo2.getColor());
        Individuo individuo3 = new Individuo(2, 1, 5, 1, 50, 50, new Cola());
        assertEquals(Color.LAWNGREEN, individuo3.getColor());
        Individuo individuo4 = new Individuo(7, 1, 5, 1, 50, 50, new Cola());
        assertNull(individuo4.getColor());
    }
}