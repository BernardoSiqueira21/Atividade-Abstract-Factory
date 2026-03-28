package banco.service;

import banco.factory.BancoFactory;
import banco.produto.cartao.Cartao;
import banco.produto.conta.Conta;
import banco.produto.emprestimo.Emprestimo;


public class AberturaContaService {

    private final BancoFactory factory;

    public AberturaContaService(BancoFactory factory) {
        this.factory = factory;
    }

    public void abrirPacoteCompleto(String nomeCliente) {
        System.out.println("╔══════════════════════════════════════════════╗");
        System.out.printf("  Abrindo pacote %s para: %s%n",
                factory.getSegmento(), nomeCliente);
        System.out.println("╚══════════════════════════════════════════════╝");

        Conta conta           = factory.criarConta();
        Cartao cartao         = factory.criarCartao();
        Emprestimo emprestimo = factory.criarEmprestimo();

        System.out.println("\nProdutos contratados:");
        conta.exibirDetalhes();
        cartao.exibirDetalhes();
        emprestimo.exibirDetalhes();
        System.out.println();
    }
}
