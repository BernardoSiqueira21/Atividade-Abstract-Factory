package banco.produto.cartao;

import java.math.BigDecimal;


public class CartaoPessoaJuridica implements Cartao {

    @Override public String getBandeira() { return "Mastercard Business"; }

    @Override public BigDecimal getLimiteCredito() {
        return new BigDecimal("30000.00");
    }

    @Override public double getCashbackPercentual() { return 1.2; }

    @Override public boolean temSalaVip() { return true; }

    @Override
    public void exibirDetalhes() {
        System.out.println("  [Cartão] " + getBandeira());
        System.out.println("          Limite        : R$ " + getLimiteCredito());
        System.out.println("          Cashback      : " + getCashbackPercentual() + "%");
        System.out.println("          Sala VIP      : " + temSalaVip());
    }
}
