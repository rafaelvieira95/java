package br.ufc.crateus.aps.bancos;

public class Cliente {

	public static void main(String[] args) {
	
		//questao 02 e 03 estão embutidas nesta classe
  
		FabricaAbstrata bank = FactoryLogon.factoryMethodLogon(CodigoBancos.CAIXA);
		bank.gerarMensagemLogon().mostrarTelaGrafica();
 
	}

}
