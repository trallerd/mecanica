package Mecanica.models;

public class Pintura extends Servico {
    private String cor;
    private double valorTinta;
    private double valorCera;

    public Pintura(int codigo,String descricao,double valorMaodeObra,String cor,double valorTinta,double valorCera) {
        super(codigo,descricao,valorMaodeObra);
        this.cor=cor;
        this.valorTinta=valorTinta;
        this.valorCera=valorCera;
        valorTotal=getValorTotal();
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor=cor;
    }

    public double getValorTinta() {
        return valorTinta;
    }

    public void setValorTinta(double valorTinta) {
        this.valorTinta=valorTinta;
    }

    public double getValorCera() {
        return valorCera;
    }

    public void setValorCera(double valorCera) {
        this.valorCera=valorCera;
    }

    @Override
    public double calcularTotal() {
        valorTotal=0;
        valorTotal+=valorMaodeObra + valorCera + valorTinta;
        return valorTotal;
    }

    @Override
    public String toString() {
        return "\nDescricao: " + getDescricao() + "\t Cor: " + cor + "\t Valor da Tinta: " + valorTinta + "\t Valor da Cera: " + valorCera + "\t Valor da Mao de Obra: " + valorMaodeObra + "\t Valor Total: " + df.format(valorTotal);
    }
}
