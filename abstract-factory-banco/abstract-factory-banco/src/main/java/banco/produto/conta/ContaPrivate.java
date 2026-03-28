package banco.produto.conta;

import java.math.BigDecimal;


public class ContaPrivate implements Conta {

    @Override public String getTipo() { return "Conta Private Premium"; }

    @Override public BigDecimal getLimiteChequEspecial() {
        return new BigDecimal("100000.00");
    }

    @Override public BigDecimal getTaxaManutencao() {
        return BigDecimal.ZERO; // isento
    }

    @Override public boolean temInvestimentoAutomatico() { return true; }

    @Override
    public void exibirDetalhes() {
        System.out.println("  [Conta] " + getTipo());
        System.out.println("         Cheque especial   : R$ " + getLimiteChequEspecial());
        System.out.println("         Taxa manutenção   : ISENTO");
        System.out.println("         Invest. automático: " + temInvestimentoAutomatico());
    }
}
