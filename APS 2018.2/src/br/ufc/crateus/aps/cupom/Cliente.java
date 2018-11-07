package br.ufc.crateus.aps.cupom;

public class Cliente {

    public static void main(String[] args) {

        CupomFiscal cp = new CupomFiscal.Cupom()
                  .nomeLoja("ARMARZEM LUZIA")
                  .cnpj("12.657.982/0001-02")
                  .cnpjConsumidor("98.565.234/0001-13")
                  .dinheiroRecebido(700)
                  .builder();

        Item item1 = new Item();
        item1.setCodigo(2);
        item1.setNome("Bola");
        item1.setQuantidade(3);
        item1.setValorUnitario(100.00);
        cp.listaItem[0] = item1;

        Item item2 = new Item();
        item2.setCodigo(3);
        item2.setNome("Circulador de Ar");
        item2.setQuantidade(2);
        item2.setValorUnitario(125.00);
        cp.listaItem[1] = item2;


        CupomFiscal cp2 = new CupomFiscal.Cupom()
                .nomeLoja("MC ELETRODOMÉSTICOS")
                .cnpj("00.123.567/0002-30")
                .cpfConsumidor("068.090.753-05")
                .dinheiroRecebido(2000)
                .builder();

         Item pc = new Item();
         pc.setNome("Notebook Dell");
         pc.setCodigo(15);
         pc.setValorUnitario(1580.00);
         pc.setQuantidade(1);
         cp2.listaItem[0] = pc;

       CupomFiscal [] set = {cp,cp2};

       Impressora.getInstance().imprimirNota(set);

    }

}
