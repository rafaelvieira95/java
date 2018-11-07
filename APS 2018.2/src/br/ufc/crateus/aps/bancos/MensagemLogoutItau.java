package br.ufc.crateus.aps.bancos;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class MensagemLogoutItau extends MensagemLogout{

	@Override
	public void mostrarTelaGrafica() {
		this.setMensagem("O Banco Itaú agradece sua Preferência!");
		this.setLogo("/home/rafael/eclipse-workspace/APS 2018.2/itau_icon.png");
		ImageIcon img = new ImageIcon(getLogo());
		JOptionPane.showMessageDialog(null, this.getMensagem() , "Até mais", JOptionPane.INFORMATION_MESSAGE,img);
		
	}

}
