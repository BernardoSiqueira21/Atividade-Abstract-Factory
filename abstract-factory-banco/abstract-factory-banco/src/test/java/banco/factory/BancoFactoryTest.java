package banco.factory;

import banco.produto.cartao.Cartao;
import banco.produto.conta.Conta;
import banco.produto.emprestimo.Emprestimo;
import banco.service.AberturaContaService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Abstract Factory — Sistema Bancário")
class BancoFactoryTest {
    
    @Test
    @DisplayName("PF: factory deve retornar segmento correto")
    void pfDeveRetornarSegmento() {
        BancoFactory factory = new PessoaFisicaFactory();
        assertEquals("Pessoa Física", factory.getSegmento());
    }

    @Test
    @DisplayName("PF: conta deve ter taxa de manutenção positiva")
    void pfContaDeveTerTaxaManutencao() {
        Conta conta = new PessoaFisicaFactory().criarConta();
        assertTrue(conta.getTaxaManutencao().compareTo(BigDecimal.ZERO) > 0);
    }

    @Test
    @DisplayName("PF: conta não deve ter investimento automático")
    void pfContaNaoTemInvestimentoAutomatico() {
        Conta conta = new PessoaFisicaFactory().criarConta();
        assertFalse(conta.temInvestimentoAutomatico());
    }

    @Test
    @DisplayName("PF: cartão não deve ter sala VIP")
    void pfCartaoNaoTemSalaVip() {
        Cartao cartao = new PessoaFisicaFactory().criarCartao();
        assertFalse(cartao.temSalaVip());
    }

    @Test
    @DisplayName("PF: limite do cartão deve ser menor que PJ")
    void pfLimiteCartaoMenorQuePj() {
        Cartao pf = new PessoaFisicaFactory().criarCartao();
        Cartao pj = new PessoaJuridicaFactory().criarCartao();
        assertTrue(pf.getLimiteCredito().compareTo(pj.getLimiteCredito()) < 0);
    }

    @Test
    @DisplayName("PF: empréstimo deve ter juros maiores que PJ")
    void pfEmprestimoJurosMaioresQuePj() {
        Emprestimo pf = new PessoaFisicaFactory().criarEmprestimo();
        Emprestimo pj = new PessoaJuridicaFactory().criarEmprestimo();
        assertTrue(pf.getTaxaJurosMensal() > pj.getTaxaJurosMensal());
    }


    @Test
    @DisplayName("PJ: factory deve retornar segmento correto")
    void pjDeveRetornarSegmento() {
        BancoFactory factory = new PessoaJuridicaFactory();
        assertEquals("Pessoa Jurídica", factory.getSegmento());
    }

    @Test
    @DisplayName("PJ: conta deve ter investimento automático")
    void pjContaTemInvestimentoAutomatico() {
        Conta conta = new PessoaJuridicaFactory().criarConta();
        assertTrue(conta.temInvestimentoAutomatico());
    }

    @Test
    @DisplayName("PJ: cartão deve ter sala VIP")
    void pjCartaoTemSalaVip() {
        Cartao cartao = new PessoaJuridicaFactory().criarCartao();
        assertTrue(cartao.temSalaVip());
    }

    @Test
    @DisplayName("PJ: empréstimo deve ser Capital de Giro")
    void pjEmprestimoDeveSerCapitalDeGiro() {
        Emprestimo emprestimo = new PessoaJuridicaFactory().criarEmprestimo();
        assertTrue(emprestimo.getModalidade().contains("Giro"));
    }



    @Test
    @DisplayName("Private: factory deve retornar segmento correto")
    void privateDeveRetornarSegmento() {
        BancoFactory factory = new PrivateFactory();
        assertEquals("Private", factory.getSegmento());
    }

    @Test
    @DisplayName("Private: conta deve ser isenta de taxa de manutenção")
    void privateContaIsentaDeTaxa() {
        Conta conta = new PrivateFactory().criarConta();
        assertEquals(BigDecimal.ZERO, conta.getTaxaManutencao());
    }

    @Test
    @DisplayName("Private: cartão deve ter maior limite entre todos os segmentos")
    void privateCartaoMaiorLimite() {
        BigDecimal limitePf      = new PessoaFisicaFactory().criarCartao().getLimiteCredito();
        BigDecimal limitePj      = new PessoaJuridicaFactory().criarCartao().getLimiteCredito();
        BigDecimal limitePrivate = new PrivateFactory().criarCartao().getLimiteCredito();

        assertTrue(limitePrivate.compareTo(limitePf) > 0);
        assertTrue(limitePrivate.compareTo(limitePj) > 0);
    }

    @Test
    @DisplayName("Private: empréstimo deve ter menor taxa de juros")
    void privateEmprestimoMenorJuros() {
        double jurosPf      = new PessoaFisicaFactory().criarEmprestimo().getTaxaJurosMensal();
        double jurosPj      = new PessoaJuridicaFactory().criarEmprestimo().getTaxaJurosMensal();
        double jurosPrivate = new PrivateFactory().criarEmprestimo().getTaxaJurosMensal();

        assertTrue(jurosPrivate < jurosPj);
        assertTrue(jurosPrivate < jurosPf);
    }

    @Test
    @DisplayName("Private: empréstimo deve ter maior prazo máximo")
    void privateEmprestimoMaiorPrazo() {
        int prazoPf      = new PessoaFisicaFactory().criarEmprestimo().getPrazoMaximoMeses();
        int prazoPj      = new PessoaJuridicaFactory().criarEmprestimo().getPrazoMaximoMeses();
        int prazoPrivate = new PrivateFactory().criarEmprestimo().getPrazoMaximoMeses();

        assertTrue(prazoPrivate > prazoPf);
        assertTrue(prazoPrivate > prazoPj);
    }



    @Test
    @DisplayName("Fábricas diferentes devem criar produtos diferentes")
    void fabricasDiferentesCriaoProdutosDiferentes() {
        Conta contaPf      = new PessoaFisicaFactory().criarConta();
        Conta contaPrivate = new PrivateFactory().criarConta();

        assertNotEquals(contaPf.getTipo(), contaPrivate.getTipo());
        assertNotEquals(contaPf.getClass(), contaPrivate.getClass());
    }

    @Test
    @DisplayName("AberturaContaService deve funcionar com qualquer fábrica")
    void servicoDeveAceitarQualquerFactory() {

        assertDoesNotThrow(() ->
            new AberturaContaService(new PessoaFisicaFactory())
                .abrirPacoteCompleto("Cliente PF"));

        assertDoesNotThrow(() ->
            new AberturaContaService(new PessoaJuridicaFactory())
                .abrirPacoteCompleto("Empresa PJ"));

        assertDoesNotThrow(() ->
            new AberturaContaService(new PrivateFactory())
                .abrirPacoteCompleto("Cliente Private"));
    }
}
