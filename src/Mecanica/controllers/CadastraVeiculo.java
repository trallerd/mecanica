package Mecanica.controllers;

import Mecanica.Main;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class CadastraVeiculo implements Initializable {
    @FXML
    public Button btnvoltar;
    @FXML
    public Button btnCadastra;
    @FXML
    public TextField txtPlaca;
    @FXML
    public TextField txtModelo;
    @FXML
    public TextField txtCliente;
    @FXML
    public ComboBox<Integer> cbAno;
    private Mecanica mecanica;

    public CadastraVeiculo(Mecanica mecanica) {
        this.mecanica=mecanica;
    }

    @Override
    public void initialize(URL url,ResourceBundle resourceBundle) {
        for(int i=1970;i<2020;i++){
            cbAno.getItems().add(i);
        }
    }

    public void cadastrar() {
        String placa=txtPlaca.getText();
        int ano=cbAno.getValue();
        String modelo=txtModelo.getText();
        String cliente=txtCliente.getText();

        boolean resp=mecanica.cadastraVeiculo(placa,ano,modelo,cliente);

        if(resp){
            mensagem(Alert.AlertType.INFORMATION,"Veiculo salvo!!");
            limpar();
        }else{
            mensagem(Alert.AlertType.ERROR,"Erro ao Cadastrar Veiculo!!");
        }

    }

    private void limpar() {
        txtPlaca.setText("");
        txtCliente.setText("");
        txtModelo.setText("");
        cbAno.getSelectionModel().clearSelection();
    }

    public void voltar() {
        Main.mudaCena(Main.HOME,(aClass) -> new Home(mecanica));
    }

    private void mensagem(Alert.AlertType type,String msg) {
        Alert alert=new Alert(type,msg);
        alert.showAndWait();
    }
}
