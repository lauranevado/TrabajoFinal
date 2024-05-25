//package com.example.pruebafinal_.intento1.gsonAdapters;
//
//import com.example.pruebafinal_.intento1.Individuo;
//import com.example.pruebafinal_.intento1.Listas.ElementoLE;
//import com.example.pruebafinal_.intento1.Listas.ListaEnlazada;
//import com.example.pruebafinal_.intento1.grafo.Cola;
//import com.google.gson.*;
//
//import java.lang.reflect.Type;
//
//public class gsonAdapterIndividuo implements JsonSerializer<Individuo>, JsonDeserializer<Individuo> {
//    @Override
//    public JsonElement serialize(Individuo individuo, Type type, JsonSerializationContext jsonSerializationContext) {
//        JsonObject indiv = new JsonObject();
//        ListaEnlazada<Individuo> padres = individuo.getPadres();
//        if (!padres.isVacia()){
//            JsonArray padresJson = new JsonArray(padres.getNumeroElementos());
//            for(Integer i=0; i< padres.getNumeroElementos(); i++){
//                padresJson.add(serialize(padres.getElemento(i).getData(), type, jsonSerializationContext));
//            }
//            indiv.addProperty("padres", padresJson.getAsString());
//        }
//        Cola colaIndividuo = individuo.getColaIndividuo();
//        if (!colaIndividuo.isVacia()){
//            JsonArray colaIndividuoJson = new JsonArray();
//            ListaEnlazada listaColaSerializar = new ListaEnlazada();
//            while(!colaIndividuo.isVacia()){
//                listaColaSerializar.add(colaIndividuo.poll().getData());
//            }
//            colaIndividuoJson= jsonSerializationContext.serialize(listaColaSerializar).getAsJsonArray();
//            indiv.addProperty("cola", colaIndividuoJson.getAsString());
//
//        }
//        indiv.add("propiedades", jsonSerializationContext.serialize(individuo));
//
//        return indiv;
//    }
//
//    @Override
//    public Individuo deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
//        JsonObject jsonIndividuo = jsonElement.getAsJsonObject();
//
//        Individuo individuo= jsonDeserializationContext.deserialize(jsonIndividuo.get("propiedades").getAsJsonObject(), Individuo.class);
//        ListaEnlazada<Individuo> lista = new ListaEnlazada<>();
//        if(jsonIndividuo.has("padres")){
//            JsonArray padres= jsonIndividuo.get("padres").getAsJsonArray();
//            for (int i=0; i<2; i++){ //no es un 2
//                Individuo padre= deserialize(padres.get(i).getAsJsonObject(), type, jsonDeserializationContext);
//                ElementoLE<Individuo> elementoLE = new ElementoLE<>(padre);
//                lista.add(elementoLE.getData());
//            }
//            individuo.setPadres(lista);
//        }
//        Cola colaIndividuo = individuo.getColaIndividuo();
//        if (!colaIndividuo.isVacia()){
//            Cola<?> cola = new Cola<>();
//            cola.add(jsonDeserializationContext.deserialize(jsonElement, ListaEnlazada.class));
//            individuo.setColaIndividuo((Cola<Object>) cola);
//        }
//
//
//        return individuo;
//    }
//
//}
