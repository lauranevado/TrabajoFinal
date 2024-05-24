//package com.example.pruebafinal_.intento1.gsonAdapters;
//
//import com.example.pruebafinal_.intento1.Listas.ListaEnlazada;
//import com.example.pruebafinal_.intento1.grafo.Cola;
//import com.google.gson.*;
//
//import java.lang.reflect.Type;
//
//public class gsonAdapterCola implements JsonSerializer<Cola>, JsonDeserializer<Cola> {
//    @Override
//    public JsonElement serialize(Cola cola, Type type, JsonSerializationContext jsonSerializationContext) {
//        Cola colaSerializar= cola;
//        ListaEnlazada listaColaSerializar = new ListaEnlazada();
//        while(!colaSerializar.isVacia()){
//            listaColaSerializar.add(colaSerializar.poll().getData());
//        }
//        return jsonSerializationContext.serialize(listaColaSerializar);
//    }
//
//    @Override
//    public Cola deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
//        Cola<?> cola = new Cola<>();
//        cola.add(jsonDeserializationContext.deserialize(jsonElement, ListaEnlazada.class));
//        return cola;
//    }
//
//
//}
