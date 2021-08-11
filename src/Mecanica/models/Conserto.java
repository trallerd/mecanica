package Mecanica.models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Conserto extends Servico {
    private double valorPecas;
    private ArrayList<String> pecas;

    public Conserto(int codigo,String descricao,double valorMaodeObra,double valorPecas,ArrayList<String> pecas) {
        super(codigo,descricao,valorMaodeObra);
        this.valorPecas=valorPecas;
        this.pecas=pecas;
        valorTotal=getValorTotal();

    }

    public double getValorPecas() {
        return valorPecas;
    }

    public void setValorPecas(double valorPecas) {
        this.valorPecas=valorPecas;
    }

    public List<String> getPecas() {
        return Collections.unmodifiableList(this.pecas);
    }

    public void setPecas(ArrayList<String> pecas) {
        this.pecas=pecas;
    }

    @Override
    public double calcularTotal() {
        valorTotal=0.0;
        valorTotal=valorPecas + valorMaodeObra;
        return valorTotal;
    }

    @Override
    public String toString() {
        return "\nDescricao: " + getDescricao() + "\t Valor da Mao de Obra: " + valorMaodeObra + "\t Valor das Pecas: " + valorPecas + "\t Pecas " + "\t" + pecas + "\t Valor Total: " + df.format(valorTotal);
    }
}
