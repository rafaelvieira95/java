package br.ufc.crateus.aps.proxy;

public class App {

	public static void main(String[] args) {
		
		Imposto calc = new ImpostoProxy(100.0);
		calc.calculaImposto();

	}

}
