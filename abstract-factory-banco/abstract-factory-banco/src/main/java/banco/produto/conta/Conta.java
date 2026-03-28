package banco.produto.conta;

import java.math.BigDecimal;


public interface Conta {
    String getTipo();
    BigDecimal getLimiteChequEspecial();
    BigDecimal getTaxaManutencao();
    boolean temInvestimentoAutomatico();
    void exibirDetalhes();
}
