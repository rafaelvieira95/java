package br.ufc.crateus.aps.singleton;

import java.util.Calendar;
import java.util.Date;

public class PessoaJuridica extends Pessoa {

	private String cnpj;
	private Date dataCriacao;
	
	public boolean equals(PessoaJuridica p) {
		if(this.cnpj.equals(this.cnpj)) return true;
		return false;
	} 
	
	@Override
	public boolean validarDocumento() {
		if(this.cnpj.matches("[0-9][0-9].[0-9][0-9][0-9].[0-9][0-9][0-9]/[0-9][0-9][0-9][0-9]-[0-9][0-9]")) return true;
		return false;
	}

	@SuppressWarnings("deprecation")
	@Override
	public int calcularIdade() {
		// TODO Auto-generated method stub
		return getCalendar().get(Calendar.YEAR) - (this.dataCriacao.getYear() + 1900);
	}
	
	public String getCnpj() { return cnpj; }

	public void setCnpj(String cnpj) { this.cnpj = cnpj; }

	public Date getDataCriacao() { return dataCriacao;	}

	public void setDataCriacao(Date dataCriacao) { this.dataCriacao = dataCriacao; }

	@Override
	public String toString() {
		return "Nome: "+getNome() + "\nCNPJ: "+this.cnpj + "\nData Criacao: "+ getDateFormat().format(this.dataCriacao);
	}

	
	
}
