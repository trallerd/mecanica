package Mecanica.controllers;

import Mecanica.Main;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;

import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.ResourceBundle;

public class CadastraServico implements Initializable {
    @FXML
    public Button btnProx;
    @FXML
    public TextArea txtDescricao;
    @FXML
    public TextField txtValorMaoObra;
    @FXML
    public ComboBox<String> cbTipo;
    @FXML
    public Button btnvoltar;
    @FXML
    public VBox vbConserto;
    @FXML
    public TextArea taPecas;
    @FXML
    public TextField txtValorPecas;
    @FXML
    public VBox vbPintura;
    @FXML
    public TextField txtCor;
    @FXML
    public TextField txtValorTinta;
    @FXML
    public TextField txtValorCera;
    private Mecanica mecanica;

    public CadastraServico(Mecanica mecanica) {
        this.mecanica=mecanica;
    }


    @Override
    public void initialize(URL url,ResourceBundle resourceBundle) {
        cbTipo.getItems().add("Pintura");
        cbTipo.getItems().add("Conserto");
    }

    public void voltar() {
        Main.mudaCena(Main.HOME,(aClass) -> new Home(mecanica));
    }

    public void cadastrar() {
        String descricao=txtDescricao.getText();
        double maoDeObra=Double.parseDouble(txtValorMaoObra.getText());
        String tipo=cbTipo.getValue();

        if(tipo.equals("Pintura")){
            String cor=txtCor.getText();
            double valorTinta=Double.parseDouble(txtValorTinta.getText());
            double valorCera=Double.parseDouble(txtValorCera.getText());
            boolean resp=mecanica.cadastraServico(descricao,cor,maoDeObra,valorTinta,valorCera);

            if(resp){
                mensagem(Alert.AlertType.CONFIRMATION,"Servico salvo!!");
                limpar();
            }else{
                mensagem(Alert.AlertType.ERROR,"Erro ao Cadastrar Serviço!");
            }

        }else
            if(tipo.equals("Conserto")){
                double valorPecas=Double.parseDouble(txtValorPecas.getText());
                String dado=taPecas.getText();
                String[] pec=dado.split(",");
                ArrayList<String> pecas=new ArrayList<>(Arrays.asList(pec));
                boolean resp=mecanica.cadastraServico(descricao,pecas,maoDeObra,valorPecas);

                if(resp){
                    mensagem(Alert.AlertType.CONFIRMATION,"Servico salvo!!");
                    limpar();
                }else{
                    mensagem(Alert.AlertType.ERROR,"Erro ao Cadastrar Serviço!");
                }

            }
    }

    private void limpar() {
        txtDescricao.setText("");
        txtValorMaoObra.setText("");
        cbTipo.getSelectionModel().clearSelection();
        taPecas.setText("");
        txtValorPecas.setText("");
        txtCor.setText("");
        txtValorTinta.setText("");
        txtValorCera.setText("");
    }

    public void tipo() {
        if(cbTipo.getValue().equals("Pintura")){
            vbPintura.disableProperty().setValue(false);
            vbConserto.disableProperty().setValue(true);
        }else
            if(cbTipo.getValue().equals("Conserto")){
                vbPintura.disableProperty().setValue(true);
                vbConserto.disableProperty().setValue(false);
            }else{
                vbPintura.disableProperty().setValue(false);
                vbConserto.disableProperty().setValue(false);
            }
    }


    private void mensagem(Alert.AlertType type,String msg) {
        Alert alert=new Alert(type,msg);
        alert.showAndWait();
    }
}
