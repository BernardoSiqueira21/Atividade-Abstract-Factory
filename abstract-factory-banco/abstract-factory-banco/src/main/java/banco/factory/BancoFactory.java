package banco.factory;

import banco.produto.cartao.Cartao;
import banco.produto.conta.Conta;
import banco.produto.emprestimo.Emprestimo;

/**
 * Abstract Factory — BancoFactory
 *
 * Define a interface para criação de famílias de produtos bancários
 * compatíveis entre si. Cada segmento de cliente (Pessoa Física,
 * Pessoa Jurídica, Private) terá sua própria fábrica concreta,
 * garantindo que os produtos criados sejam sempre do mesmo segmento.
 *
 * Famílias de produtos:
 *   - Conta     (corrente, empresarial, premium)
 *   - Cartão    (básico, empresarial, black)
 *   - Empréstimo (pessoal, capital de giro, crédito exclusivo)
 */
public interface BancoFactory {
    Conta criarConta();
    Cartao criarCartao();
    Emprestimo criarEmprestimo();
    String getSegmento();
}
