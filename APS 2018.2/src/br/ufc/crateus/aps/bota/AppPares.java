package br.ufc.crateus.aps.bota;

public class AppPares {

	public static void main(String[] args) {
	
		  Pares p = new Pares(4);
  
		p.inserePar(40,"D");
		p.inserePar(41, "E");
	    p.inserePar(41, "D");
	   p.inserePar(40, "E");
		
		
    	Pares p2 = new Pares(6);
	
	 p2.inserePar(38, "E");
    p2.inserePar(39, "E");
  	p2.inserePar(40, "D");
	p2.inserePar(38, "D");
	p2.inserePar(40, "D");
	p2.inserePar(37, "E");
   p2.inserePar(39, "D");
	
	

	 System.out.println(p.toString());
	 System.out.println(p.verificarPares());
	 System.out.println();
	System.out.println(p2.toString());
	System.out.println(p2.verificarPares());
	
	}

}
