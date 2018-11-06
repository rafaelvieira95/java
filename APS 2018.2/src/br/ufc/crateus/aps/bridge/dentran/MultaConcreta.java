package br.ufc.crateus.aps.bridge.dentran;

public class MultaConcreta implements AbstracaoMulta {

	 private Multa tipoMulta;
	
	  public MultaConcreta(Multa tipoMulta) {
	  this.tipoMulta = tipoMulta;	
	}
	@Override
	public double multa() {
		// TODO Auto-generated method stub
		return tipoMulta.multaDentran();
	}

	
	
}
