package br.ufc.crateus.aps.bancos;

import javax.swing.JOptionPane;

public class FactoryLogon {

	public static FabricaAbstrata factoryMethodLogon(CodigoBancos cod) {
	
		String login =  JOptionPane.showInputDialog("Login: ");
		String senha =JOptionPane.showInputDialog("Senha: ");
		
		switch (cod) {
		case ITAU:
			if("admin".equals(login)  && "123".equals(senha)) {
			   return new FabricaItau();
			}
			return null;
		
		case BANCO_BRASIL:
			if("admin".equals(login)  && "123".equals(senha)) {
			return new FabricaBancoBrasil();
			}
			return null;
			
		case BRADESCO:
			if("admin".equals(login)  && "123".equals(senha)) {
			return new FabricaBradesco();
			}
			return null;
			
		case CAIXA:
			if("admin".equals(login)  && "123".equals(senha)) {
			return new FabricaCaixa();
			}
			
			return null;
			
		default:
			throw new IllegalArgumentException("Banco Inexistente!");
		}
		
		
				}
		
		
	
	
	
}
