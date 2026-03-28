package banco.produto.emprestimo;

import java.math.BigDecimal;


public interface Emprestimo {
    String getModalidade();
    BigDecimal getValorMaximo();
    double getTaxaJurosMensal();
    int getPrazoMaximoMeses();
    void exibirDetalhes();
}
