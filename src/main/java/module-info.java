module com.example.pruebafinal_ {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.apache.logging.log4j;
    requires com.google.gson;


    opens com.example.pruebafinal_ to javafx.fxml, com.google.gson;

    opens com.example.pruebafinal_.intento1 to javafx.fxml, com.google.gson;
    opens com.example.pruebafinal_.intento1.Listas to com.google.gson;
    opens com.example.pruebafinal_.intento1.grafo to com.google.gson;

    exports com.example.pruebafinal_;
    exports com.example.pruebafinal_.intento1;
}