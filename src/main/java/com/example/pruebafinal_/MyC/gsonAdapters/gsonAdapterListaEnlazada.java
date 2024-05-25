//package com.example.pruebafinal_.intento1.gsonAdapters;
//
//import com.example.pruebafinal_.intento1.Listas.ElementoLE;
//import com.example.pruebafinal_.intento1.Listas.ListaEnlazada;
//import com.google.gson.*;
//
//import java.lang.reflect.Type;
//
//public class gsonAdapterListaEnlazada implements JsonSerializer<ListaEnlazada>, JsonDeserializer<ListaEnlazada> {
//
//    @Override
//    public JsonElement serialize(ListaEnlazada listaEnlazada, Type type, JsonSerializationContext jsonSerializationContext) {
//        JsonObject listaJson = new JsonObject();
//        listaJson.addProperty("maximo", listaEnlazada.getNumeroElementos()); ////////////para qué
//        JsonArray jsonArray = new JsonArray();
//        for(Integer i=0; i< listaEnlazada.getNumeroElementos(); i++){
//            jsonArray.add(jsonSerializationContext.serialize(listaEnlazada.getElemento(i).getData()).getAsJsonObject());
//        }
//        listaJson.addProperty("datos", jsonArray.getAsString());
//
//        return jsonArray;
//    }
//    @Override
//    public ListaEnlazada deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
//        JsonObject jsonObject=jsonElement.getAsJsonObject();
//        int i=0;
//        for(JsonElement elemento : jsonObject.get("datos").getAsJsonArray())
//            i++;
//        ElementoLE[] arrayElementos = new ElementoLE[i];
//        for (int j=0; j!=i; j++){
//            arrayElementos[j] =jsonDeserializationContext.deserialize(jsonObject.get("datos").getAsJsonArray().get(j), ElementoLE.class);
//        }
//        ListaEnlazada listaEnlazada= new ListaEnlazada();
//        for(Integer k=0; k< arrayElementos.length; k++){
//            listaEnlazada.add(arrayElementos[k]);
//        }
//
//        return listaEnlazada;
//    }
//
//
//}
