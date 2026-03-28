package banco.factory;

import banco.produto.cartao.Cartao;
import banco.produto.cartao.CartaoPrivate;
import banco.produto.conta.Conta;
import banco.produto.conta.ContaPrivate;
import banco.produto.emprestimo.Emprestimo;
import banco.produto.emprestimo.EmprestimoPrivate;

/**
 * Fábrica concreta — cria produtos para o segmento Private (alta renda).
 */
public class PrivateFactory implements BancoFactory {

    @Override
    public Conta criarConta() {
        return new ContaPrivate();
    }

    @Override
    public Cartao criarCartao() {
        return new CartaoPrivate();
    }

    @Override
    public Emprestimo criarEmprestimo() {
        return new EmprestimoPrivate();
    }

    @Override
    public String getSegmento() {
        return "Private";
    }
}
