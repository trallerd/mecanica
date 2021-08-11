package Mecanica.controllers;

import Mecanica.models.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Mecanica implements Serializable {

    private String nome;
    private ArrayList<Veiculo> veiculos;
    private ArrayList<Servico> servicos;
    private ArrayList<ExecucaoServico> execucoes;

    public Mecanica(String nome) {
        this.nome=nome;
        this.veiculos=new ArrayList<>();
        this.servicos=new ArrayList<>();
        this.execucoes=new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome=nome;
    }

    public List<Veiculo> getVeiculos() {
        return Collections.unmodifiableList(this.veiculos);
    }

    public void setVeiculos(ArrayList<Veiculo> veiculos) {
        this.veiculos=veiculos;
    }

    public List<Servico> getServicos() {
        return Collections.unmodifiableList(this.servicos);
    }

    public void setServicos(ArrayList<Servico> servicos) {
        this.servicos=servicos;
    }

    public List<ExecucaoServico> getExecucoes() {
        return Collections.unmodifiableList(this.execucoes);
    }

    public void setExecucoes(ArrayList<ExecucaoServico> execucoes) {
        this.execucoes=execucoes;
    }

    public boolean cadastraVeiculo(int codigo,String placa,int ano,String modelo,String cliente) {
        Veiculo veiculo=new Veiculo(codigo,placa,ano,modelo,cliente);
        veiculos.add(veiculo);
        return true;
    }

    public boolean cadastraVeiculo(String placa,int ano,String modelo,String cliente) {
        int codigo=proximoCodigoVeiculo();
        Veiculo veiculo=new Veiculo(codigo,placa,ano,modelo,cliente);
        veiculos.add(veiculo);
        return true;
    }

    public boolean cadastraServico(int codigo,String descricao,ArrayList<String> pecas,double valorMaodeObra,double valorPecas) {
        Conserto conserto=new Conserto(codigo,descricao,valorMaodeObra,valorPecas,pecas);
        servicos.add(conserto);
        return true;
    }

    public boolean cadastraServico(String descricao,ArrayList<String> pecas,double valorMaodeObra,double valorPecas) {
        int codigo=proximoCodigoServicos();
        Conserto conserto=new Conserto(codigo,descricao,valorMaodeObra,valorPecas,pecas);
        conserto.setValorTotal(valorMaodeObra + valorPecas);
        servicos.add(conserto);
        return true;
    }

    public boolean cadastraServico(int codigo,String descricao,String cor,double valorMaodeObra,double valorTinta,double valorCera) {
        Pintura pintura=new Pintura(codigo,descricao,valorMaodeObra,cor,valorTinta,valorCera);
        servicos.add(pintura);
        return true;
    }

    public boolean cadastraServico(String descricao,String cor,double valorMaodeObra,double valorTinta,double valorCera) {
        int codigo=proximoCodigoServicos();
        Pintura pintura=new Pintura(codigo,descricao,valorMaodeObra,cor,valorTinta,valorCera);
        servicos.add(pintura);
        return true;
    }

    public void executaServico(int codigo,Veiculo veiculo,Servico servico) {
        ExecucaoServico execucao=new ExecucaoServico(codigo,veiculo,servico);
        execucoes.add(execucao);
    }

    public void executaServico(Veiculo veiculo,Servico servico) {
        int codigo=proximoCodigoExecucao();
        ExecucaoServico execucao=new ExecucaoServico(codigo,veiculo,servico);
        execucoes.add(execucao);
    }

    public String relatorioVeiculos() {
        StringBuilder str=new StringBuilder("Veiculos [\n");
        for(Veiculo veiculo: this.veiculos){
            str.append("\t").append(veiculo).append("\n");
        }
        str.append("]\n");

        return str.toString();
    }

    public String relatorioServicos() {
        StringBuilder str=new StringBuilder("Serviços [\n");
        for(Servico servico: this.servicos){
            str.append("\t").append(servico).append("\n");
        }
        str.append("]\n");

        return str.toString();
    }

    public String relatorioExecucoes() {
        StringBuilder str=new StringBuilder("Serviços Executados [\n");
        for(ExecucaoServico execucaoServico: this.execucoes){
            str.append("\t").append(execucaoServico).append("\n");
        }
        str.append("]\n");

        return str.toString();
    }

    private int proximoCodigoVeiculo() {
        return veiculos.size();
    }

    private int proximoCodigoServicos() {
        return servicos.size();
    }

    private int proximoCodigoExecucao() {
        return execucoes.size();
    }

    public Veiculo buscaVeiculo(String placa) {
        for(Veiculo veiculo: veiculos){
            if(veiculo.getPlaca().equals(placa)){
                int pos=this.veiculos.indexOf(veiculo);
                if(pos != -1){
                    return this.veiculos.get(pos);
                }
            }
        }
        return null;
    }

    public Veiculo buscaVeiculo(int codigo) {
        for(Veiculo veiculo: veiculos){
            if(veiculo.getCodigo() == codigo){
                int pos=this.veiculos.indexOf(veiculo);
                if(pos != -1){
                    return this.veiculos.get(pos);
                }
            }
        }
        return null;
    }

    public Servico buscaServico(int codigo) {
        for(Servico servico: servicos){
            if(servico.getCodigo() == codigo){
                int pos=this.servicos.indexOf(servico);
                if(pos != -1){
                    return this.servicos.get(pos);
                }
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return "Mecanica" + "\nNome: " + nome + "\n\nVeiculos: " + veiculos + "\n\nServicos: " + servicos + "\n\nServiços Executados: " + execucoes + "\n ";
    }
}
