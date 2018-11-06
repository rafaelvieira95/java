package br.ufc.crateus.aps.cupom;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class CupomFiscal {

    public String nomeLoja;
    public String cnpj;
    public String cpfConsumidor;
    public String cnpjConsumidor;
    public double dinheiroRecebido;
    public Item [] listaItem = new Item[100];

      public CupomFiscal(Cupom c){

       this.nomeLoja = c.nomeLoja;
       this.cnpj = c.cnpj;
       this.cpfConsumidor = c.cpfConsumidor;
       this.cnpjConsumidor = c.cnpjConsumidor;
       this.dinheiroRecebido = c.dinheiroRecebido;

   }

    static class Cupom{

       private String nomeLoja;
       private String cnpj;
       private String cpfConsumidor;
       private String cnpjConsumidor;
       private double dinheiroRecebido;

       public Cupom(){}

       public Cupom(String nomeLoja, String cnpj){
          this.nomeLoja = nomeLoja;
          this.cnpj = cnpj;
   }

      public Cupom nomeLoja(String nomeLoja){
           this.nomeLoja = nomeLoja;
           return this;
      }

       public Cupom cnpj(String cnpj){
           this.cnpj = cnpj;
           return this;
       }

       public Cupom cnpjConsumidor(String cnpjConsumidor){
           this.cnpjConsumidor = cnpjConsumidor;
           return this;
       }

       public Cupom cpfConsumidor(String cpfConsumidor){
           this.cpfConsumidor = cpfConsumidor;
           return this;
       }

       public Cupom dinheiroRecebido(double dinheiroRecebido){
           this.dinheiroRecebido = dinheiroRecebido;
           return this;
       }

       public CupomFiscal builder(){
           return new CupomFiscal(this);
       }
   }

   private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yy  HH:mm:ss");

    @Override
    public String toString() {
    	
    	if(this.cnpjConsumidor == null) {
    		this.cnpjConsumidor = "";
    	}
    	
    	if(this.cpfConsumidor == null) {
    		this.cpfConsumidor = "";
    	}
    		
        return "\n\t\t "+this.nomeLoja +"\n"+"CNPJ/CPF: "+this.cnpj+
                "\n"+sdf.format(Calendar.getInstance().getTime())+
                "\n------------------------------------------------\n"+
                 "CNPJ/CPF consumidor: "+this.cnpjConsumidor +""+ this.cpfConsumidor+
                "\n------------------------------------------------\n";
    }
}
