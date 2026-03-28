package banco.factory;

import banco.produto.cartao.Cartao;
import banco.produto.cartao.CartaoPessoaJuridica;
import banco.produto.conta.Conta;
import banco.produto.conta.ContaPessoaJuridica;
import banco.produto.emprestimo.Emprestimo;
import banco.produto.emprestimo.EmprestimoPessoaJuridica;

/**
 * Fábrica concreta — cria produtos para o segmento Pessoa Jurídica.
 */
public class PessoaJuridicaFactory implements BancoFactory {

    @Override
    public Conta criarConta() {
        return new ContaPessoaJuridica();
    }

    @Override
    public Cartao criarCartao() {
        return new CartaoPessoaJuridica();
    }

    @Override
    public Emprestimo criarEmprestimo() {
        return new EmprestimoPessoaJuridica();
    }

    @Override
    public String getSegmento() {
        return "Pessoa Jurídica";
    }
}
