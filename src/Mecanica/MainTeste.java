package Mecanica;

import Mecanica.controllers.Mecanica;
import Mecanica.models.*;

import java.util.ArrayList;

public class MainTeste {
    public static void main(String[] args) {
        //Instanciando mecanica
        Mecanica mecanica=new Mecanica("Mecanica");
        //Preenchendo mecanica com dados estaticos
        geraRotinaMecanica(mecanica);

        //Testando metodos de busca
        Veiculo v=mecanica.buscaVeiculo(5);
        Servico c=mecanica.buscaServico(4);
        Servico p=mecanica.buscaServico(2);
        Veiculo exec=mecanica.buscaVeiculo("AAAAA2");

        //imprimindo resultados das buscas
        System.out.println(v);
        System.out.println(c);
        System.out.println(p);
        System.out.println(exec);

        //Imprimindo metodos de relátorios, com dados estaticos gerados pelo gerarRotinaMecanica()
        System.out.println(mecanica.relatorioExecucoes());
        System.out.println(mecanica.relatorioServicos());
        System.out.println(mecanica.relatorioVeiculos());

        //Imprimindo mecanica
        System.out.println(mecanica);


    }

    //Gera 10 veiculos para povoar a mecanica
    private static Veiculo[] geraVeiculos(Mecanica mecanica) {
        Veiculo[] veiculos=new Veiculo[10];

        //adiciona ao vetor para que possa ser usado pela classe gerar Serviços executados, e então cadastra na mecanica
        for(int i=0;i<5;i++){
            veiculos[i]=new Veiculo(i,"AAAAA" + i,i + 1000,"fusca","jess");
            mecanica.cadastraVeiculo(i,"AAAAA" + i,i + 1000,"fusca","jess");
        }
        for(int i=5;i<10;i++){
            veiculos[i]=new Veiculo(i,"AAAAA" + i,i + 1000,"fusca","jess");
            mecanica.cadastraVeiculo("AAAAA" + i,i + 1000,"fusca","jess");
        }
        return veiculos;
    }

    //gerando 20 serviços
    private static Servico[] geraServicos(Mecanica mecanica) {
        Servico[] servicos=new Servico[20];

        //gerando array de pecas para cadastro de serviços
        ArrayList<String> pecas=new ArrayList<>();
        for(int i=0;i<5;i++){
            pecas.add("peça " + i);
        }

        //adiciona ao vetor para que possa ser usado pela classe gerar Serviços executados, e então cadastra na mecanica
        for(int i=0;i<5;i++){
            servicos[i]=new Pintura(i,"pintando",200.0,"preto",150.0,54.21);
            mecanica.cadastraServico(i,"pintando","preto",200.0,150.0,54.21);
        }
        for(int i=5;i<10;i++){
            servicos[i]=new Conserto(i,"Concertando",150.0,154.22,pecas);
            mecanica.cadastraServico(i,"Concertando",pecas,150.0,154.22);
        }
        for(int i=10;i<15;i++){
            servicos[i]=new Pintura(i,"pintando",200.0,"preto",150.0,54.21);
            mecanica.cadastraServico("pintando","preto",200.0,150.0,54.21);
        }
        for(int i=15;i<20;i++){
            servicos[i]=new Conserto(i,"Concertando",150.0,154.22,pecas);
            mecanica.cadastraServico("Concertando",pecas,150.0,154.22);
        }
        return servicos;
    }


    //Usando dados gerados por geraVeiculos e geraServicos, gera Serviços Executados
    private static ExecucaoServico[] gerarExecucoes(Mecanica mecanica,Veiculo[] veiculos,Servico[] servicos) {
        ExecucaoServico[] execucaoServicos=new ExecucaoServico[10];

        //cadastra serviços executados na mecanica
        for(int i=0;i<5;i++){
            mecanica.executaServico(i,veiculos[i],servicos[1]);
        }
        for(int i=5;i<10;i++){
            mecanica.executaServico(veiculos[i],servicos[1]);
        }
        return execucaoServicos;
    }

    //Gera mecanica com dados estaticos
    static void geraRotinaMecanica(Mecanica mecanica) {
        //declarado como vetor para que os mesmos dados possam ser aproveitados nos serviços executados
        Veiculo[] veiculos=geraVeiculos(mecanica);
        Servico[] servicos=geraServicos(mecanica);
        ExecucaoServico[] execucoes=gerarExecucoes(mecanica,veiculos,servicos);
    }
}
