package banco.produto.emprestimo;

import java.math.BigDecimal;


public class EmprestimoPrivate implements Emprestimo {

    @Override public String getModalidade() { return "Crédito Exclusivo Private"; }

    @Override public BigDecimal getValorMaximo() {
        return new BigDecimal("5000000.00");
    }

    @Override public double getTaxaJurosMensal() { return 0.59; }

    @Override public int getPrazoMaximoMeses() { return 120; }

    @Override
    public void exibirDetalhes() {
        System.out.println("  [Empréstimo] " + getModalidade());
        System.out.println("              Valor máximo  : R$ " + getValorMaximo());
        System.out.println("              Juros mensais : " + getTaxaJurosMensal() + "%");
        System.out.println("              Prazo máximo  : " + getPrazoMaximoMeses() + " meses");
    }
}
