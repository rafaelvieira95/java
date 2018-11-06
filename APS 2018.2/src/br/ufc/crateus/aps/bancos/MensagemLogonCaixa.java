package br.ufc.crateus.aps.bancos;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class MensagemLogonCaixa extends MensagemLogon{

	@Override
	public void mostrarTelaGrafica() {
	    this.setMensagem("Seja Bem-vindo a Caixa! a vida pede mais que um Banco.");
        this.setLogo("/home/rafael/eclipse-workspace/APS 2018.2/caixa_icon.png");
        ImageIcon img = new ImageIcon(getLogo());
		JOptionPane.showMessageDialog(null, this.getMensagem(), "Olá, Cliente !", JOptionPane.INFORMATION_MESSAGE, img);
		
	}

}
