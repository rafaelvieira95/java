package br.ufc.crateus.aps.bancos;

public abstract class MensagemLogon {
	
	private String logo;
	private String mensagem;
	
	public abstract void mostrarTelaGrafica();

	public String getLogo() {
		return logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}
	
}
