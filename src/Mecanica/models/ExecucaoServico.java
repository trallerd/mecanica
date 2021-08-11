package Mecanica.models;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Objects;

public class ExecucaoServico implements Serializable {
    private int codigo;
    private String data;
    private Veiculo veiculo;
    private Servico servico;
    private double total;
    SimpleDateFormat formatador=new SimpleDateFormat("EEE, d MMM yyyy HH:mm:ss");

    public ExecucaoServico(int codigo,Veiculo veiculo,Servico servico) {
        this.codigo=codigo;
        this.veiculo=veiculo;
        this.servico=servico;
        this.data=formatador.format(System.currentTimeMillis());
        this.total=servico.valorTotal;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo=codigo;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data=data;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(Veiculo veiculo) {
        this.veiculo=veiculo;
    }

    public Servico getServico() {
        return servico;
    }

    public void setServico(Servico servico) {
        this.servico=servico;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total=servico.valorTotal;
    }

    @Override
    public boolean equals(Object o) {
        if(this == o) return true;
        if(o == null || getClass() != o.getClass()) return false;
        ExecucaoServico that=(ExecucaoServico) o;
        return codigo == that.codigo;
    }

    @Override
    public int hashCode() {
        return Objects.hash(codigo);
    }

    @Override
    public String toString() {
        return "\nCodigo:" + codigo + "\tData: " + data + "\nVeiculo: " + veiculo + "\nServico: " + servico + "\n";

    }
}
