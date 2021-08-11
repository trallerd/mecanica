package Mecanica.controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;

import java.net.URL;
import java.util.ResourceBundle;

public class Relatorio implements Initializable {
    @FXML
    public TextArea taRelatorio;
    private Mecanica mecanica;

    public Relatorio(Mecanica mecanica) {
        this.mecanica=mecanica;
    }

    @Override
    public void initialize(URL url,ResourceBundle resourceBundle) {
        taRelatorio.setText(mecanica.toString());
    }
}
