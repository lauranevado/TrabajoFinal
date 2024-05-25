module com.example.pruebafinal_ {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.apache.logging.log4j;
    requires com.google.gson;


    opens com.example.pruebafinal_ to javafx.fxml, com.google.gson;

    opens com.example.pruebafinal_.MyC to javafx.fxml, com.google.gson;
    opens com.example.pruebafinal_.MyC.Estructuras.Listas to com.google.gson;
    opens com.example.pruebafinal_.MyC.Estructuras.grafo to com.google.gson;

    exports com.example.pruebafinal_;
    exports com.example.pruebafinal_.MyC;
    exports com.example.pruebafinal_.MyC.Celdas;
    opens com.example.pruebafinal_.MyC.Celdas to com.google.gson, javafx.fxml;
    exports com.example.pruebafinal_.MyC.Informaciones;
    opens com.example.pruebafinal_.MyC.Informaciones to com.google.gson, javafx.fxml;
    exports com.example.pruebafinal_.MyC.Parametros;
    opens com.example.pruebafinal_.MyC.Parametros to com.google.gson, javafx.fxml;
    exports com.example.pruebafinal_.MyC.Tablero;
    opens com.example.pruebafinal_.MyC.Tablero to com.google.gson, javafx.fxml;
    exports com.example.pruebafinal_.MyC.Datos;
    opens com.example.pruebafinal_.MyC.Datos to com.google.gson, javafx.fxml;
    exports com.example.pruebafinal_.MyC.Guardado;
    opens com.example.pruebafinal_.MyC.Guardado to com.google.gson, javafx.fxml;
}