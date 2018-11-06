package br.ufc.crateus.aps.bancos;

public class FabricaBradesco extends FabricaAbstrata {

    @Override
    public MensagemLogon gerarMensagemLogon() {
        return new MensagemLogonBradesco();
    }

    @Override
    public MensagemLogout gerarMensagemLogout() {
        return new MensagemLogoutBradesco();
    }
}
