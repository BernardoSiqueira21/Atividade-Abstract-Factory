package banco.produto.cartao;

import java.math.BigDecimal;


public interface Cartao {
    String getBandeira();
    BigDecimal getLimiteCredito();
    double getCashbackPercentual();
    boolean temSalaVip();
    void exibirDetalhes();
}
