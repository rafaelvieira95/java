package br.ufc.crateus.aps.singleton;

import java.util.Calendar;
import java.util.Date;

public class App {

    public static void main(String[] args) {

        PessoaJuridica pj = new PessoaJuridica();
        pj.setNome("Jamille Brindes");
        pj.setCnpj("00.098.123/0002-20");

        pj.getCalendar().set(2005, Calendar.APRIL, 05);
        Date d1 = pj.getCalendar().getTime();

        pj.setDataCriacao(d1);

        PessoaJuridica pj1 = new PessoaJuridica();
        pj1.setNome("Sports Eletronics");
        pj1.setCnpj("10.224.658/0001-01");

        pj1.getCalendar().set(2008, Calendar.AUGUST, 24);
        Date d2 = pj1.getCalendar().getTime();
        pj1.setDataCriacao(d2);

        PessoaFisica pf = new PessoaFisica();
        pf.setNome("Kleber");
        pf.setCpf("061.094.758-02");
        pf.getCalendar().set(2001, Calendar.JANUARY, 18);
        Date d3 = pf.getCalendar().getTime();
        pf.setDataNascimento(d3);

        PessoaFisica pf2 = new PessoaFisica();
        pf2.setNome("Josafá");
        pf2.setCpf("061.094.758-02");
        pf2.getCalendar().set(2001, Calendar.MARCH, 19);
        Date d4 = pf2.getCalendar().getTime();
        pf2.setDataNascimento(d4);

        ColecaoPessoa.getInstance().inserir(pj);
        ColecaoPessoa.getInstance().inserir(pf);
        //ColecaoPessoa.getInstance().remover();
        ColecaoPessoa.getInstance().inserir(pj1);
        ColecaoPessoa.getInstance().inserir(pf2);
        ColecaoPessoa.getInstance().imprimirDadosColecao();
        //System.out.println(pf.equals(pf2));
        // System.out.println(ColecaoPessoa.getInstance().retornarObjeto(0).calcularIdade());
        //System.out.println(ColecaoPessoa.getInstance().retornarObjeto(1));
        //System.out.println(ColecaoPessoa.getInstance().retornarObjeto(1));

    }

}
