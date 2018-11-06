package br.ufc.crateus.aps.singleton;

import java.util.Calendar;
import java.util.Date;

public class PessoaFisica extends Pessoa{

	private String cpf;
	private Date dataNascimento;
	
	public boolean equals(PessoaFisica p) {
		if(this.cpf.equals(p.cpf)) return true;
		return false;
	}
	
	@Override
	public boolean validarDocumento() {
		if(this.cpf.matches("[0-9][0-9][0-9].[0-9][0-9][0-9].[0-9][0-9][0-9]-[0-9][0-9]")) return true;	
		return false;
	}

	@SuppressWarnings("deprecation")
	@Override
	public int calcularIdade() {
		return getCalendar().get(Calendar.YEAR) - (this.dataNascimento.getYear() + 1900);
	}

	public String getCpf() { return cpf; }

	public void setCpf(String cpf) { this.cpf = cpf; }

	public Date getDataNascimento() { return dataNascimento; }

	public void setDataNascimento(Date dataNascimento) { this.dataNascimento = dataNascimento;}

	@Override
	public String toString() {
		return "Nome: "+getNome() + "\nCPF: "+this.cpf +"\nData Nasc:  "+ getDateFormat().format(this.dataNascimento);
	}
}
