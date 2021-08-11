package Mecanica.controllers;

import Mecanica.Main;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import Mecanica.models.Servico;
import Mecanica.models.Veiculo;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class FinalizaServico implements Initializable {
    @FXML
    public Button btnvoltar;
    @FXML
    public ComboBox<Veiculo> cbVeiculo;
    @FXML
    public ComboBox<Servico> cbServicos;
    @FXML
    public Button btnFinalizar;

    private Mecanica mecanica;

    public FinalizaServico(Mecanica mecanica) {
        this.mecanica=mecanica;
    }

    @Override
    public void initialize(URL url,ResourceBundle resourceBundle) {
        List<Servico> lista=mecanica.getServicos();
        cbServicos.getItems().clear();
        for(Servico servico: lista){
            cbServicos.getItems().add(servico);
        }
        List<Veiculo> listaveic=mecanica.getVeiculos();
        cbVeiculo.getItems().clear();
        for(Veiculo veiculo: listaveic){
            cbVeiculo.getItems().add(veiculo);
        }
    }

    public void voltar() {
        Main.mudaCena(Main.HOME,(aClass) -> new Home(mecanica));
    }

    public void finalizar() {
        Veiculo veiculo=cbVeiculo.getValue();
        Servico servico=cbServicos.getValue();
        mecanica.executaServico(veiculo,servico);
        mensagem();
        limpar();
    }

    private void limpar() {
        cbVeiculo.getSelectionModel().clearSelection();
        cbServicos.getSelectionModel().clearSelection();
    }

    private void mensagem() {
        Alert alert=new Alert(Alert.AlertType.INFORMATION,"Serviço Executado!!");
        alert.showAndWait();
    }
}
