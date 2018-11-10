package br.ufc.crateus.aps.facade;

public class Aluno {

	private int matricula;
	private String nome;
	
	@SuppressWarnings("unused")
	private Exemplar exemplar;

	
	public Aluno(String nome,int matricula,Exemplar exemplar) {
		this.nome = nome;
		this.matricula = matricula;
		this.exemplar = exemplar;
	}
	
	public int getMatricula() {
		return matricula;
	}
	public void setMatricula(int matricula) {
		this.matricula = matricula;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}


}
