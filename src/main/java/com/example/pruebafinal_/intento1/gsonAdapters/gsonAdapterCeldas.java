//package com.example.pruebafinal_.intento1.gsonAdapters;
//
//import com.example.pruebafinal_.intento1.Celdas;
//import com.example.pruebafinal_.intento1.Individuo;
//import com.example.pruebafinal_.intento1.Listas.ElementoLE;
//import com.example.pruebafinal_.intento1.Listas.ListaEnlazada;
//import com.example.pruebafinal_.intento1.grafo.Cola;
//import com.google.gson.*;
//
//import java.lang.reflect.Type;
//
//public class gsonAdapterCeldas implements JsonSerializer<Celdas>, JsonDeserializer<Celdas> {
//
//    @Override
//    public JsonElement serialize(Celdas celdas, Type type, JsonSerializationContext jsonSerializationContext) {
//        JsonObject celda = new JsonObject();
//        ListaEnlazada<Individuo> individuosListaEnlazada= celdas.getIndividuos();
//        if (!individuosListaEnlazada.isVacia()){
//            JsonArray individuosJson= new JsonArray(individuosListaEnlazada.getNumeroElementos());
//            for (Integer i=0; i<individuosListaEnlazada.getNumeroElementos(); i++){
//                individuosJson.add(serialize(individuosListaEnlazada.getElemento(i).getData(), type, jsonSerializationContext));
//            }
//            celda.addProperty("individuos", individuosJson.getAsString());
//        }
//
//        return null;
//    }
//
//    private JsonElement serialize(Individuo individuo, Type type, JsonSerializationContext jsonSerializationContext) {
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
//        ListaEnlazada listaColaSerializar = new ListaEnlazada();
//        if (!colaIndividuo.isVacia()){
//            JsonArray colaIndividuoJson = new JsonArray();
//
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
//
//    }
//
//
//
//
//    @Override
//    public Celdas deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
//        JsonObject jsonCelda = jsonElement.getAsJsonObject();
//        Celdas celda= jsonDeserializationContext.deserialize(jsonCelda.get("propiedades").getAsJsonObject(), Celdas.class); //no tenemos otras propiedades no?
//        ListaEnlazada<Individuo> listaIndividuos = new ListaEnlazada<>();
//        if(jsonCelda.has("individuos")){
//            JsonArray indivsJson= jsonCelda.get("individuos").getAsJsonArray();
//            for (int i=0; i<indivsJson.size(); i++){
//                Individuo ind = deserializeInd(indivsJson, type, jsonDeserializationContext);
//                ElementoLE<Individuo> elementoLE= new ElementoLE<>(ind);
//                listaIndividuos.add(elementoLE.getData());
//            }
//            celda.setIndividuos(listaIndividuos);
//        }
//
//
//
//        return celda;
//    }
//
//    public Individuo deserializeInd(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
//        JsonObject jsonIndividuo = jsonElement.getAsJsonObject();
//
//        Individuo individuo= jsonDeserializationContext.deserialize(jsonIndividuo.get("propiedades").getAsJsonObject(), Individuo.class);
//        ListaEnlazada<Individuo> lista = new ListaEnlazada<>();
//        if(jsonIndividuo.has("padres")){
//            JsonArray padres= jsonIndividuo.get("padres").getAsJsonArray();
//            for (int i=0; i<2; i++){ //no es un 2
//                Individuo padre= deserializeInd(padres.get(i).getAsJsonObject(), type, jsonDeserializationContext);
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
