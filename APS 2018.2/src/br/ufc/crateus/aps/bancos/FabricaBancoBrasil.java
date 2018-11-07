package br.ufc.crateus.aps.bancos;

public class FabricaBancoBrasil extends FabricaAbstrata {

    @Override
    public MensagemLogon gerarMensagemLogon() {
        return new MensagemLogonBancoBrasil();
    }

    @Override
    public MensagemLogout gerarMensagemLogout() {
        return new MensagemLogoutBancoBrasil();
    }
}
