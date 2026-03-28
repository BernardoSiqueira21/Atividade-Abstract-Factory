package banco;

import banco.factory.BancoFactory;
import banco.factory.PessoaFisicaFactory;
import banco.factory.PessoaJuridicaFactory;
import banco.factory.PrivateFactory;
import banco.service.AberturaContaService;


public class Main {

    public static void main(String[] args) {

        BancoFactory pfFactory = new PessoaFisicaFactory();
        new AberturaContaService(pfFactory)
                .abrirPacoteCompleto("João da Silva");

        BancoFactory pjFactory = new PessoaJuridicaFactory();
        new AberturaContaService(pjFactory)
                .abrirPacoteCompleto("Tech Soluções Ltda.");

        BancoFactory privateFactory = new PrivateFactory();
        new AberturaContaService(privateFactory)
                .abrirPacoteCompleto("Dra. Ana Beatriz Ferreira");
    }
}
