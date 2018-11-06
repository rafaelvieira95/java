package br.ufc.crateus.aps.bancos;

public class FabricaCaixa extends FabricaAbstrata
{
    @Override
    public MensagemLogon gerarMensagemLogon() {
        return new MensagemLogonCaixa();
    }

    @Override
    public MensagemLogout gerarMensagemLogout() {
        return new MensagemLogoutCaixa();
    }
}
