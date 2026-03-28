package banco.produto.emprestimo;

import java.math.BigDecimal;


public class EmprestimoPessoaFisica implements Emprestimo {

    @Override public String getModalidade() { return "Crédito Pessoal PF"; }

    @Override public BigDecimal getValorMaximo() {
        return new BigDecimal("20000.00");
    }

    @Override public double getTaxaJurosMensal() { return 2.99; }

    @Override public int getPrazoMaximoMeses() { return 36; }

    @Override
    public void exibirDetalhes() {
        System.out.println("  [Empréstimo] " + getModalidade());
        System.out.println("              Valor máximo  : R$ " + getValorMaximo());
        System.out.println("              Juros mensais : " + getTaxaJurosMensal() + "%");
        System.out.println("              Prazo máximo  : " + getPrazoMaximoMeses() + " meses");
    }
}
