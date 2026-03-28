package banco.produto.conta;

import java.math.BigDecimal;


public class ContaPessoaFisica implements Conta {

    @Override public String getTipo() { return "Conta Corrente PF"; }

    @Override public BigDecimal getLimiteChequEspecial() {
        return new BigDecimal("500.00");
    }

    @Override public BigDecimal getTaxaManutencao() {
        return new BigDecimal("12.90");
    }

    @Override public boolean temInvestimentoAutomatico() { return false; }

    @Override
    public void exibirDetalhes() {
        System.out.println("  [Conta] " + getTipo());
        System.out.println("         Cheque especial : R$ " + getLimiteChequEspecial());
        System.out.println("         Taxa manutenção : R$ " + getTaxaManutencao() + "/mês");
        System.out.println("         Invest. automático: " + temInvestimentoAutomatico());
    }
}
