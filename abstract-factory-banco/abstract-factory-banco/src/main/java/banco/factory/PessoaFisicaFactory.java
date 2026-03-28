package banco.factory;

import banco.produto.cartao.Cartao;
import banco.produto.cartao.CartaoPessoaFisica;
import banco.produto.conta.Conta;
import banco.produto.conta.ContaPessoaFisica;
import banco.produto.emprestimo.Emprestimo;
import banco.produto.emprestimo.EmprestimoPessoaFisica;

/**
 * Fábrica concreta — cria produtos para o segmento Pessoa Física.
 * Todos os produtos gerados são compatíveis entre si dentro deste segmento.
 */
public class PessoaFisicaFactory implements BancoFactory {

    @Override
    public Conta criarConta() {
        return new ContaPessoaFisica();
    }

    @Override
    public Cartao criarCartao() {
        return new CartaoPessoaFisica();
    }

    @Override
    public Emprestimo criarEmprestimo() {
        return new EmprestimoPessoaFisica();
    }

    @Override
    public String getSegmento() {
        return "Pessoa Física";
    }
}
