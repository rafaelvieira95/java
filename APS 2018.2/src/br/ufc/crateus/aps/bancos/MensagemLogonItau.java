package br.ufc.crateus.aps.bancos;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class MensagemLogonItau extends MensagemLogon {

	@Override
	public void mostrarTelaGrafica() {
		
		this.setMensagem("Seja Bem-vindo ao Banco Itaú!");
		this.setLogo("/home/rafael/eclipse-workspace/APS 2018.2/itau_icon.png");
		ImageIcon img = new ImageIcon(getLogo());
		JOptionPane.showMessageDialog(null, this.getMensagem() , "Olá, Cliente!", JOptionPane.INFORMATION_MESSAGE,img);
		
	}

}
