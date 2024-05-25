package com.example.pruebafinal_.MyC.Parametros;


import com.example.pruebafinal_.MyC.Celdas.Celdas;
import com.example.pruebafinal_.MyC.Estructuras.Listas.ListaEnlazada;
import com.example.pruebafinal_.MyC.Informaciones.InformacionRecursosControllers;
import com.example.pruebafinal_.MyC.Tablero.Tablero;
import com.example.pruebafinal_.MyC.Tablero.TableroControllers;
import com.example.pruebafinal_.MyC.Tablero.TableroProperties;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.net.URL;
import java.util.ResourceBundle;

public class ParametrosControllers implements Initializable {


    //Se necesita para iniciar
    private ParametrosProperties modelo;
    private Stage scene;


    private static final Logger log = LogManager.getLogger(ParametrosControllers.class);


    @FXML
    private TabPane parametrosTabPane;


    //Individuo
    @FXML
    private Slider sliderTurnosDeVida, sliderNumIndividuosInicial, sliderpRep, sliderpMuerte, sliderpClon; //, sliderpBasico, sliderpNormal, sliderpAvanzado

    //Tablero
    @FXML
    private Slider sliderAltura, sliderLado;

    //Recursos
    @FXML
    private Slider sliderTiempoDeAparicion, sliderProbabilidadDeAparicion, sliderVidaAguaSuma, sliderPAgua, sliderVidaComidaSuma, sliderPComida,
            sliderVidaMontanaResta, sliderPMontana, sliderPReproTesoroSuma, sliderPTesoro, sliderPClonacionBiblioteca, sliderPBiblioteca, sliderPPozo ;

    @FXML
    private Label muertePozo;




    //Labels para sincronizar información//
    //Individuos
    @FXML
    private Label turnosDeVidaLabel;
    private int valorTurnosDeVida;

    @FXML
    private Label numIndividuosInicialLabel;
    private int valorNumIndividuosInicial;


    @FXML
    private Label pRepLabel;
    private int valorpRep;

    @FXML
    private Label pMuerteLabel;
    private int valorpMuerte;

    @FXML
    private Label pClonLabel;
    private int valorpClon;

//    @FXML
//    private Label pBasicoLabel;
//    private int valorpBasico;
//
//    @FXML
//    private Label pNormalLabel;
//    private int valorpNormal;
//
//    @FXML
//    private Label pAvanzadoLabel;
//    private int valorpAvanzado;





    //Tablero
    @FXML
    private Label alturaLabel;
    private int valorAltura;
    @FXML
    private Label ladoLabel;
    private int valorLado;



    //Recursos
    @FXML
    private Label tiempoDeAparicionLabel;
    private int valorTiempoDeAparicion;
    @FXML
    private Label probabilidadDeAparicionLabel;
    private int valorProbabilidadDeAparicion;
    @FXML
    private Label vidaAguaSumaLabel;
    private int valorVidaAguaSuma;
    @FXML
    private Label pAguaLabel;
    private int valorPAgua;
    @FXML
    private Label vidaComidaSumaLabel;
    private int valorVidaComidaSuma;
    @FXML
    private Label pComidaLabel;
    private int valorPComida;
    @FXML
    private Label vidaMontanaRestaLabel;
    private int valorVidaMontanaResta;
    @FXML
    private Label pMontanaLabel;
    private int valorPMontana;
    @FXML
    private Label PReproTesoroLabel;
    private int valorPReproTesoro;
    @FXML
    private Label pTesoroLabel;
    private int valorPTesoro;
    @FXML
    private Label PClonacionBibliotecaLabel;
    private int valorPClonacionBiblioteca;
    @FXML
    private Label pBibliotecaLabel;
    private int valorPBiblioteca;
    @FXML
    private Label pPozoLabel;
    private int valorPPozo;
    private int valorMuertePozo=0;









    @FXML
    protected void onReestablecerButtonClick(){
        modelo.rollback();
    }
    @FXML
    protected void onAnteriorButtonClick(){
        log.info("Click en boton anterior");
        modelo.commit();
        int actualIndex= parametrosTabPane.getSelectionModel().getSelectedIndex();
        int anteriorIndex= (actualIndex-1)% parametrosTabPane.getTabs().size();
        parametrosTabPane.getSelectionModel().select(anteriorIndex);
    }
    @FXML
    protected void onSiguienteButtonClick(){
        log.info("Click en boton siguiente");
        modelo.commit();
        int actualIndex= parametrosTabPane.getSelectionModel().getSelectedIndex();
        int siguienteIndex= (actualIndex+1)% parametrosTabPane.getTabs().size();
        parametrosTabPane.getSelectionModel().select(siguienteIndex);
    }





    private static ListaEnlazada<Celdas> celdas= new ListaEnlazada<>();
    private Tablero tablero= new Tablero( celdas );
    private TableroProperties tableroCompartir = new TableroProperties(tablero);





    @FXML
    protected void onInformacionRecursosButtonClick(){ //ponerle el botón redondo y bloquearlo como el otro
        log.info("Información recursos");
        Stage stage = new Stage();
        FXMLLoader fxmlLoader=new FXMLLoader(Parametros.class.getResource("/com/example/pruebafinal_/juego-informacionRecursos.fxml"));
        try {
            Scene scene = new Scene(fxmlLoader.load());
            stage.setTitle("Información de los recursos");
            stage.setScene(scene);
            InformacionRecursosControllers info = fxmlLoader.getController();
            info.setStage(stage);
            stage.show();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @FXML
    protected void onIniciarPartidaButtonClick(){
        log.info("Iniciar partida");
        scene.close();
        System.out.println("Cerrado de parámetros");
        System.out.println("Inicialización de pantalla de juego");
        Stage stage = new Stage();
        FXMLLoader fxmlLoader=new FXMLLoader(Parametros.class.getResource("/com/example/pruebafinal_/juego-tablero.fxml"));
        try {
            Scene scene = new Scene(fxmlLoader.load());
            stage.setMaximized(true);
            stage.setResizable(false);
            stage.setTitle("El juego de la vida");
            stage.setScene(scene);
            TableroControllers tableroControllers = fxmlLoader.getController();
            tableroControllers.loadUserData(this.tableroCompartir);
            tableroControllers.setStage(stage);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }




    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        log.info("Inicialización del controlador de los parámetros");
        System.out.println("Inicialización del controlador de los parámetros");

        if (modelo !=null){
            this.updateGUIconmodelo();
        }


        //Sliders individuos
        sliderTurnosDeVida.valueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observableValue, Number number, Number t1) {
                log.info("Slider turnos de vida");
                valorTurnosDeVida=(int) sliderTurnosDeVida.getValue();
                turnosDeVidaLabel.setText(Integer.toString(valorTurnosDeVida));
            }
        });
        sliderpRep.valueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observableValue, Number number, Number t1) {
                log.info("Slider probabilidad reproducción");
                valorpRep=(int) sliderpRep.getValue();
                pRepLabel.setText(Integer.toString(valorpRep)+ "%");
            }
        });
        sliderpMuerte.valueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observableValue, Number number, Number t1) {
                log.info("Slider probabilidad de muerte");
                valorpMuerte=(int) sliderpMuerte.getValue();
                pMuerteLabel.setText(Integer.toString(valorpMuerte)+ "%");
            }
        });

        //Para hacerlos complementarios y sumen el 100%
        sliderpRep.setOnMouseDragged(event-> {
            int nuevoValorRep = (int) sliderpRep.getValue();
            int nuevoValorMuerte = 100- nuevoValorRep;
            sliderpMuerte.setValue(nuevoValorMuerte);
        });
        sliderpMuerte.setOnMouseDragged(event-> {
            int nuevoValorMuerte = (int) sliderpMuerte.getValue();
            int nuevoValorRep = 100- nuevoValorMuerte;
            sliderpRep.setValue(nuevoValorRep);
        });

        sliderpClon.valueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observableValue, Number number, Number t1) {
                log.info("Slider probabilidad de clonado");
                valorpClon=(int) sliderpClon.getValue();
                pClonLabel.setText(Integer.toString(valorpClon)+ "%");
            }
        });
        sliderNumIndividuosInicial.valueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observableValue, Number number, Number t1) {
                valorNumIndividuosInicial = (int) sliderNumIndividuosInicial.getValue();
                numIndividuosInicialLabel.setText(Integer.toString(valorNumIndividuosInicial));
            }
        });

        //Sliders Tablero
        sliderAltura.valueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observableValue, Number number, Number t1) {
                log.info("Slider altura del tablero");
                valorAltura=(int) sliderAltura.getValue();
                alturaLabel.setText(Integer.toString(valorAltura));
            }
        });
        sliderLado.valueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observableValue, Number number, Number t1) {
                log.info("Slider lado del tablero");
                valorLado=(int) sliderLado.getValue();
                ladoLabel.setText(Integer.toString(valorLado));
            }
        });



        //Sliders recursos
        sliderTiempoDeAparicion.valueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observableValue, Number number, Number t1) {
                log.info("Slider tiempo de aparición de los recursos");
                valorTiempoDeAparicion=(int) sliderTiempoDeAparicion.getValue();
                tiempoDeAparicionLabel.setText(Integer.toString(valorTiempoDeAparicion));
            }
        });
        sliderProbabilidadDeAparicion.valueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observableValue, Number number, Number t1) {
                log.info("Slider probabilidad de aparición de los recursos");
                valorProbabilidadDeAparicion=(int) sliderProbabilidadDeAparicion.getValue();
                probabilidadDeAparicionLabel.setText(Integer.toString(valorProbabilidadDeAparicion)+ "%");
            }
        });
        sliderVidaAguaSuma.valueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observableValue, Number number, Number t1) {
                log.info("Slider vida del agua");
                valorVidaAguaSuma =(int) sliderVidaAguaSuma.getValue();
                vidaAguaSumaLabel.setText(Integer.toString(valorVidaAguaSuma));
            }
        });
        sliderVidaComidaSuma.valueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observableValue, Number number, Number t1) {
                log.info("Slider vida de la comida");
                valorVidaComidaSuma =(int) sliderVidaComidaSuma.getValue();
                vidaComidaSumaLabel.setText(Integer.toString(valorVidaComidaSuma));
            }
        });
        sliderVidaMontanaResta.valueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observableValue, Number number, Number t1) {
                log.info("Slider vida de la montaña");
                valorVidaMontanaResta =(int) sliderVidaMontanaResta.getValue();
                vidaMontanaRestaLabel.setText(Integer.toString(valorVidaMontanaResta));
            }
        });
        sliderPReproTesoroSuma.valueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observableValue, Number number, Number t1) {
                log.info("Slider vida del tesoror");
                valorPReproTesoro =(int) sliderPReproTesoroSuma.getValue();
                PReproTesoroLabel.setText(Integer.toString(valorPReproTesoro));
            }
        });
        sliderPClonacionBiblioteca.valueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observableValue, Number number, Number t1) {
                log.info("Slider vida de la biblioteca");
                valorPClonacionBiblioteca =(int) sliderPClonacionBiblioteca.getValue();
                PClonacionBibliotecaLabel.setText(Integer.toString(valorPClonacionBiblioteca));
            }
        });


        //probabilidad de los recursos
        sliderPAgua.valueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observableValue, Number number, Number t1) {
                log.info("Slider probabilidad de aparición del agua ");
                valorPAgua=(int) sliderPAgua.getValue();
                pAguaLabel.setText(Integer.toString(valorPAgua)+"%");
            }
        });
        sliderPComida.valueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observableValue, Number number, Number t1) {
                log.info("Slider probabilidad de aparición de la comida  ");
                valorPComida=(int) sliderPComida.getValue();
                pComidaLabel.setText(Integer.toString(valorPComida)+"%");
            }
        });
        sliderPMontana.valueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observableValue, Number number, Number t1) {
                log.info("Slider probabilidad de aparición de la montaña");
                valorPMontana=(int) sliderPMontana.getValue();
                pMontanaLabel.setText(Integer.toString(valorPMontana)+"%");
            }
        });
        sliderPTesoro.valueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observableValue, Number number, Number t1) {
                log.info("Slider probabilidad de aparición del tesoro");
                valorPTesoro=(int) sliderPTesoro.getValue();
                pTesoroLabel.setText(Integer.toString(valorPTesoro)+"%");
            }
        });
        sliderPBiblioteca.valueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observableValue, Number number, Number t1) {
                log.info("Slider probabilidad de clonado");
                valorPBiblioteca =(int) sliderPBiblioteca.getValue();
                pBibliotecaLabel.setText(Integer.toString(valorPBiblioteca)+"%");
            }
        });
        sliderPPozo.valueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observableValue, Number number, Number t1) {
                log.info("Slider probabilidad del pozo");
                valorPPozo =(int) sliderPPozo.getValue();
                pPozoLabel.setText(Integer.toString(valorPPozo)+"%");
            }
        });

    }



    protected void updateGUIconmodelo(){
        sliderTurnosDeVida.valueProperty().bindBidirectional(modelo.turnosDeVidaProperty());
        sliderNumIndividuosInicial.valueProperty().bindBidirectional(modelo.numIndividuosInicialProperty());
        sliderpRep.valueProperty().bindBidirectional(modelo.pRepProperty());
        sliderpMuerte.valueProperty().bindBidirectional(modelo.pMuerteProperty());
        sliderpClon.valueProperty().bindBidirectional(modelo.pClonProperty());
//        sliderpBasico.valueProperty().bindBidirectional(modelo.pBasicoProperty());
//        sliderpNormal.valueProperty().bindBidirectional(modelo.pNormalProperty());
//        sliderpAvanzado.valueProperty().bindBidirectional(modelo.pAvanzadoProperty());

        //Tablero
        sliderAltura.valueProperty().bindBidirectional(modelo.alturaProperty());
        sliderLado.valueProperty().bindBidirectional(modelo.ladoProperty());

        //Recursos
        sliderTiempoDeAparicion.valueProperty().bindBidirectional(modelo.tiempoDeAparicionProperty());
        sliderProbabilidadDeAparicion.valueProperty().bindBidirectional(modelo.probabilidadDeAparicionProperty());
        sliderVidaAguaSuma.valueProperty().bindBidirectional(modelo.vidaAguaSumaProperty());
        sliderVidaComidaSuma.valueProperty().bindBidirectional(modelo.vidaComidaSumaProperty());
        sliderVidaMontanaResta.valueProperty().bindBidirectional(modelo.vidaMontanaRestaProperty());
        sliderPReproTesoroSuma.valueProperty().bindBidirectional(modelo.pReproTesoroSumaProperty());
        sliderPClonacionBiblioteca.valueProperty().bindBidirectional(modelo.pClonacionBibliotecaSumaProperty());

        //Probabilidad de aparición de los recuros
        sliderPAgua.valueProperty().bindBidirectional(modelo.pAgua());
        sliderPBiblioteca.valueProperty().bindBidirectional(modelo.pBiblioteca());
        sliderPTesoro.valueProperty().bindBidirectional(modelo.pTesoro());
        sliderPComida.valueProperty().bindBidirectional(modelo.pComida());
        sliderPMontana.valueProperty().bindBidirectional(modelo.pMontana());
        sliderPPozo.valueProperty().bindBidirectional(modelo.pPozo());
    }




    public void loadUserData(ParametrosProperties parametros){
        this.modelo = parametros;
        this.updateGUIconmodelo();
    }



    public void setStage (Stage s){
        this.scene=s;
    }


}
