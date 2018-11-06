package br.ufc.crateus.aps.bridge.dentran;

public class App {

	public static void main(String[] args) {

		 AbstracaoMulta m =   new MultaConcreta(new Patio());
		 AbstracaoMulta m2 = new MultaConcreta(new Guincho());
		 
		 AbstracaoMulta m3 = new MultaConcreta(new Velocidade());
		 AbstracaoMulta m4 = new MultaConcreta(new Bafometro());
		 
         System.out.println( "Multa de Patio: " +m.multa());
         System.out.println( "Multa de Guincho: " +m2.multa());
         
         System.out.println( "Multa de Valocidade:  " +m3.multa());
         System.out.println( "Multa de Bafometro:  " +m4.multa());
	
	}

}
