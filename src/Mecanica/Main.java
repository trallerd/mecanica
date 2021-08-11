package Mecanica;


import Mecanica.controllers.Home;
import Mecanica.controllers.Mecanica;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Region;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.util.Callback;

import java.io.*;

public class Main extends Application {
    public static final String CADASTRAR_SERVICO="/fxml/CadastraServico.fxml";
    public static final String CADASTRAR_VRICULO="/fxml/CadastraVeiculo.fxml";
    public static final String FINALIZA_SERVICO="/fxml/FinalizarServico.fxml";
    public static final String HOME="/fxml/Home.fxml";
    public static final String RELATORIO="/fxml/Relatorio.fxml";

    private static Mecanica mecanica;

    private static StackPane base;

    public static void main(String[] args) {
        Application.launch(args);
    }


    //Requisito 7 das especificações do trabalho
    @Override
    public void init() throws Exception {
        super.init();
        //descomentar linhas a baixo

        //        File fileMecanica = new File("mecanica.bin");
        //
        //        if(fileMecanica.exists()){
        //            try(ObjectInputStream obi = new ObjectInputStream(new FileInputStream(fileMecanica))){
        //
        //                mecanica = (Mecanica) obi.readObject();
        //
        //            }catch (IOException | ClassNotFoundException e){
        //                e.printStackTrace();
        //            }
        //        }else{
        mecanica=new Mecanica("Mecanica");

        //comentar linha a baixo
        MainTeste.geraRotinaMecanica(mecanica);
        //        }
    }

    @Override
    public void start(Stage stage) {
        base=new StackPane();

        stage.setScene(new Scene(base,Region.USE_PREF_SIZE,Region.USE_PREF_SIZE));
        stage.setTitle("Home");


        mudaCena(Main.HOME,(aClass) -> new Home(mecanica));

        stage.show();
    }

    @Override
    public void stop() throws Exception {
        super.stop();
        try (ObjectOutputStream obs=new ObjectOutputStream(new FileOutputStream(new File("mecanica.bin")))) {

            obs.writeObject(mecanica);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void mudaCena(String fxml,Callback controllerFactory) {
        try {

            FXMLLoader loader=new FXMLLoader();
            loader.setLocation(Main.class.getResource(fxml));
            loader.setControllerFactory(controllerFactory);

            Parent novoRoot=loader.load();

            if(base.getChildren().stream().count()>0){
                base.getChildren().remove(0);
            }
            base.getChildren().add(novoRoot);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
