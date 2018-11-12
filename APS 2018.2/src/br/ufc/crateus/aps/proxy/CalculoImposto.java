package br.ufc.crateus.aps.proxy;

public class CalculoImposto implements Imposto{

	public double valor;
	private double aliquota = 0.12;
	
	public CalculoImposto(double valor) {
	   this.valor = valor;
	}
	
	@Override
	public void calculaImposto() {
		System.out.println("valor Passado: "+ valor);
		System.out.println("Imposto cobrado em cima do valor: "+ (valor * aliquota));
	}

}
