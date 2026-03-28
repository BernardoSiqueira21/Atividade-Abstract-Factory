package banco.produto.emprestimo;

import java.math.BigDecimal;


public class EmprestimoPessoaJuridica implements Emprestimo {

    @Override public String getModalidade() { return "Capital de Giro PJ"; }

    @Override public BigDecimal getValorMaximo() {
        return new BigDecimal("200000.00");
    }

    @Override public double getTaxaJurosMensal() { return 1.49; }

    @Override public int getPrazoMaximoMeses() { return 60; }

    @Override
    public void exibirDetalhes() {
        System.out.println("  [Empréstimo] " + getModalidade());
        System.out.println("              Valor máximo  : R$ " + getValorMaximo());
        System.out.println("              Juros mensais : " + getTaxaJurosMensal() + "%");
        System.out.println("              Prazo máximo  : " + getPrazoMaximoMeses() + " meses");
    }
}
