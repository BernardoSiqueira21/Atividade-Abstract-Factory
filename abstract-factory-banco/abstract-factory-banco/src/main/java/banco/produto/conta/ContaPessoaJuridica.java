package banco.produto.conta;

import java.math.BigDecimal;


public class ContaPessoaJuridica implements Conta {

    @Override public String getTipo() { return "Conta Empresarial PJ"; }

    @Override public BigDecimal getLimiteChequEspecial() {
        return new BigDecimal("10000.00");
    }

    @Override public BigDecimal getTaxaManutencao() {
        return new BigDecimal("49.90");
    }

    @Override public boolean temInvestimentoAutomatico() { return true; }

    @Override
    public void exibirDetalhes() {
        System.out.println("  [Conta] " + getTipo());
        System.out.println("         Cheque especial   : R$ " + getLimiteChequEspecial());
        System.out.println("         Taxa manutenção   : R$ " + getTaxaManutencao() + "/mês");
        System.out.println("         Invest. automático: " + temInvestimentoAutomatico());
    }
}
