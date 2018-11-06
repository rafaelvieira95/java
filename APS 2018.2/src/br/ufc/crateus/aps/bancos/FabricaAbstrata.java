package br.ufc.crateus.aps.bancos;

public abstract class FabricaAbstrata {

  public abstract MensagemLogon gerarMensagemLogon();

  public abstract MensagemLogout gerarMensagemLogout();

  public static FabricaAbstrata configurarInstancia(CodigoBancos codigo){

      switch (codigo){

          case BANCO_BRASIL:
              return new FabricaBancoBrasil();

          case ITAU:
              return new FabricaItau();

          case CAIXA:
              return new FabricaCaixa();

          case BRADESCO:
              return new FabricaBradesco();

              default:
            	  throw  new IllegalArgumentException("esse banco não existe!");
      }
       
  }

}
