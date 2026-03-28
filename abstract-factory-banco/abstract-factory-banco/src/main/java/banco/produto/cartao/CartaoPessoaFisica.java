package banco.produto.cartao;

import java.math.BigDecimal;


public class CartaoPessoaFisica implements Cartao {

    @Override public String getBandeira() { return "Visa Classic"; }

    @Override public BigDecimal getLimiteCredito() {
        return new BigDecimal("3000.00");
    }

    @Override public double getCashbackPercentual() { return 0.5; }

    @Override public boolean temSalaVip() { return false; }

    @Override
    public void exibirDetalhes() {
        System.out.println("  [Cartão] " + getBandeira());
        System.out.println("          Limite        : R$ " + getLimiteCredito());
        System.out.println("          Cashback      : " + getCashbackPercentual() + "%");
        System.out.println("          Sala VIP      : " + temSalaVip());
    }
}
