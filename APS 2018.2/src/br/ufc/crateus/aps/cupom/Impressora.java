package br.ufc.crateus.aps.cupom;

public class Impressora {

    private  Impressora(){}

    private static Impressora imp = new Impressora();

    public static Impressora getInstance(){ return imp;}

    public void imprimirNota(CupomFiscal c){

        int i = 1;
        double calculoTotal = 0.0;

        System.out.println(c.toString());
        StringBuilder sb = new StringBuilder("\t\tCUPOM FISCAL\n");
        sb.append("ITEM \t CODIGO UNITARIO\t DESCRICAO\n");
        sb.append("\t       QTDXUNITÁRIO \t      VALOR (R$)\n");
        sb.append("________________________________________________\n");

            for(Item p : c.listaItem) {
                if(p != null) {
                    sb.append(String.format("00%d",i));
                    sb.append("\t   "+String.format("00%d",p.getCodigo())+" "+p.getNome()).append("\n");
                    sb.append("\t\t"+p.getQuantidade())
                            .append("X")
                            .append(String.format("%,.2f",p.getValorUnitario())).append("\t\t")
                            .append(String.format("%,.2f",p.calculoValorTotal()));

                    sb.append("\n");
                    calculoTotal += p.calculoValorTotal();
                    i++;
                }
            }

            sb.append("TOTAL R$\t\t\t\t"+String.format("%,.2f",calculoTotal))
              .append("\nVALOR RECEBIDO R$ \t\t\t"+ String.format("%,.2f",c.dinheiroRecebido)).append("\n")
              .append("TROCO R$ \t\t\t\t"+ String.format("%,.2f",c.dinheiroRecebido - calculoTotal))
              .append("\n------------------------------------------------\n");


        System.out.println(sb.toString());
    }

    public void imprimirNota(CupomFiscal [] c){

        for(CupomFiscal cp : c)
            if(cp != null) this.imprimirNota(cp);
    }

}
