package Mecanica.controllers;

import Mecanica.Main;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import Mecanica.models.ExecucaoServico;
import Mecanica.models.Servico;
import Mecanica.models.Veiculo;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class Home implements Initializable {
    @FXML
    public Button btnCadastrarVeiculo;
    @FXML
    public Button btnCadastrarServico;
    @FXML
    public Button btnExec;
    @FXML
    public Button btnRelatorio;
    @FXML
    public TextField search;
    @FXML
    public ListView<Veiculo> lvVaiculos;
    @FXML
    public ListView<Servico> lvServicos;
    @FXML
    public ListView<ExecucaoServico> lvExecutados;

    private Mecanica mecanica;

    public Home(Mecanica mecanica) {
        this.mecanica=mecanica;
    }


    @Override
    public void initialize(URL url,ResourceBundle resourceBundle) {
        verCarros();
        verServicos();
        verExec();
    }

    private void verExec() {
        List<ExecucaoServico> lista=mecanica.getExecucoes();
        lvExecutados.getItems().clear();
        for(ExecucaoServico execucaoServico: lista){
            lvExecutados.getItems().add(execucaoServico);
        }
    }

    private void verServicos() {
        List<Servico> lista=mecanica.getServicos();
        lvServicos.getItems().clear();
        for(Servico servico: lista){
            lvServicos.getItems().add(servico);
        }
    }

    public void verCarros() {
        List<Veiculo> lista=mecanica.getVeiculos();
        lvVaiculos.getItems().clear();
        for(Veiculo veiculo: lista){
            lvVaiculos.getItems().add(veiculo);
        }
    }

    public void Search() {
        Veiculo lista=mecanica.buscaVeiculo(search.getText());
        lvVaiculos.getItems().clear();
        if(lista != null){
            lvVaiculos.getItems().add(lista);
        }else{
            verCarros();
        }

    }

    public void relatorio() {
        Main.mudaCena(Main.RELATORIO,(aClass) -> new Relatorio(mecanica));
    }

    public void CadastraServico() {
        Main.mudaCena(Main.CADASTRAR_SERVICO,(aClass) -> new CadastraServico(mecanica));
    }

    public void CadastraVeiculo() {
        Main.mudaCena(Main.CADASTRAR_VRICULO,(aClass) -> new CadastraVeiculo(mecanica));
    }

    public void FinalizaServico() {
        Main.mudaCena(Main.FINALIZA_SERVICO,(aClass) -> new FinalizaServico(mecanica));
    }


}
