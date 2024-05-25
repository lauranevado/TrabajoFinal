//package com.example.pruebafinal_.intento1;
//
//import com.google.gson.Gson;
//import com.google.gson.TypeAdapter;
//import com.google.gson.TypeAdapterFactory;
//import com.google.gson.reflect.TypeToken;
//import javafx.scene.Node;
//
//public class NodeTypeAdapterFactory implements TypeAdapterFactory {
//    @Override
//    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
//        if (Node.class.isAssignableFrom(type.getRawType())) {
//            return (TypeAdapter<T>) gson.getAdapter(type.getRawType());
//        }
//        return null;
//    }
//}