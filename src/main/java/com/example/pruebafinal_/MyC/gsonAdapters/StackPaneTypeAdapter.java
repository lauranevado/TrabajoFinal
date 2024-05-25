//package com.example.pruebafinal_.intento1;
//
//import com.google.gson.Gson;
//import com.google.gson.TypeAdapter;
//import com.google.gson.reflect.TypeToken;
//import com.google.gson.stream.JsonReader;
//import com.google.gson.stream.JsonWriter;
//import javafx.scene.Node;
//import javafx.scene.layout.StackPane;
//
//import java.io.IOException;
//import java.util.List;
//
//public class StackPaneTypeAdapter extends TypeAdapter<StackPane> {
//    @Override
//    public void write(JsonWriter out, StackPane stackPane) throws IOException {
//        Gson gson= new Gson();
//        out.beginObject(); // Comienza el objeto JSON
//        out.name("children"); // Nombre del campo
//        out.beginArray(); // Comienza un arreglo JSON para los hijos del StackPane
//        // Itera sobre los hijos del StackPane
//        for (Node child : stackPane.getChildren()) {
//            // Serializa cada hijo y escribe su representación JSON
//            gson.toJson(child, Node.class, out); // 'gson' es tu instancia de Gson
//        }
//        out.endArray(); // Finaliza el arreglo JSON
//        // Puedes agregar más campos si es necesario
//        out.endObject(); // Finaliza el objeto JSON
//    }
//
//    @Override
//    public StackPane read(JsonReader in) throws IOException {
//        Gson gson= new Gson();
//        StackPane stackPane = new StackPane(); // Crea una nueva instancia de StackPane
//        in.beginObject(); // Comienza a leer el objeto JSON
//        while (in.hasNext()) {
//            String name = in.nextName();
//            if (name.equals("children")) {
//                in.beginArray(); // Comienza a leer el arreglo JSON
//                List<Node> children = gson.fromJson(in, new TypeToken<List<Node>>(){}.getType());
//                stackPane.getChildren().addAll(children); // Agrega los hijos al StackPane
//                in.endArray(); // Finaliza el arreglo JSON
//            } else {
//                in.skipValue(); // Salta cualquier otro valor
//            }
//        }
//        in.endObject(); // Finaliza el objeto JSON
//        return stackPane; // Devuelve el objeto StackPane deserializado
//    }
//}
