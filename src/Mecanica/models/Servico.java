package Mecanica.models;

import java.io.Serializable;
import java.text.DecimalFormat;
import java.util.Objects;

public abstract class Servico implements Serializable {
    private int codigo;
    private String descricao;
    protected double valorMaodeObra;
    protected double valorTotal;
    DecimalFormat df=new DecimalFormat("#,###.00");


    public Servico(int codigo,String descricao,double valorMaodeObra) {
        this.codigo=codigo;
        this.descricao=descricao;
        this.valorMaodeObra=valorMaodeObra;

    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo=codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao=descricao;
    }

    public double getValorMaodeObra() {
        return valorMaodeObra;
    }

    public void setValorMaodeObra(double valorMaodeObra) {
        this.valorMaodeObra=valorMaodeObra;
    }

    public double getValorTotal() {
        return calcularTotal();
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal=valorTotal;
    }

    public abstract double calcularTotal();

    @Override
    public boolean equals(Object o) {
        if(this == o) return true;
        if(o == null || getClass() != o.getClass()) return false;
        Servico servico=(Servico) o;
        return codigo == servico.codigo;
    }

    @Override
    public int hashCode() {
        return Objects.hash(codigo);
    }

    @Override
    public String toString() {
        return "\nServico[" + "\nCodigo:" + codigo + "\nDescricao='" + descricao + "\nValor da Mao de Obra: " + valorMaodeObra + "\nValor Total: " + df.format(valorTotal) + "\n]";
    }
}
