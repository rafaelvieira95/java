package br.ufc.crateus.aps.facade;

public class Emprestimo {
	
	 private Aluno aluno;
	 private Livro livroEmprestado;
	 private int prazo;
	 
	public Aluno getAluno() {
		return aluno;
	}
	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}
	public Livro getLivroEmprestado() {
		return livroEmprestado;
	}
	public void setLivroEmprestado(Livro livroEmprestado) {
		this.livroEmprestado = livroEmprestado;
	}
	public int getPrazo() {
		return prazo;
	}
	public void setPrazo(int prazo) {
		this.prazo = prazo;
	}
	 
	 
}
