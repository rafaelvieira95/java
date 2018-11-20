package br.ufc.crateus.aps.bancos;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class MensagemLogonBancoBrasil extends MensagemLogon{

	@Override
	public void mostrarTelaGrafica() {
		
		this.setMensagem( "Seja Bem-vindo ao  Banco do Brasil!");
		this.setLogo("/home/rafael/NetBeansProjects/java/APS 2018.2/bancobrasil_icon.png");
		ImageIcon img =  new ImageIcon(this.getLogo());
		JOptionPane.showMessageDialog(null,getMensagem(), "Olá, Cliente!", JOptionPane.INFORMATION_MESSAGE, img);
		
	}

}
