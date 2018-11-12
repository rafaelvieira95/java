package br.ufc.crateus.aps.proxy;

public class ImpostoProxy implements Imposto {

	
	private CalculoImposto calc = new CalculoImposto(0.0);
	
	public ImpostoProxy(double valor) {
		 calc.valor = valor; 
	}
	 	
	@Override
	public void calculaImposto() {
		calc.calculaImposto();
	}
	 	
	
}
