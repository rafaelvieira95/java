package br.ufc.crateus.aps.facade;

public class Emprestimo {
	
	 private Aluno aluno;
	 private Exemplar livroEmprestado;
	 private int dataEmprestimo;
	 private int dataEntrega;
	 
	 public Emprestimo(Aluno aluno,Exemplar livroEmprestado,int dataEmprestimo,int dataEntrega) {
		 this.aluno = aluno;
		 this.livroEmprestado = livroEmprestado;
		 this.dataEmprestimo = dataEmprestimo;
		 this.dataEntrega = dataEntrega;
	 }
	 
	public Aluno getAluno() {
		return aluno;
	}
	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}
	public Exemplar getLivroEmprestado() {
		return livroEmprestado;
	}
	public void setLivroEmprestado(Livro livroEmprestado) {
		this.livroEmprestado = livroEmprestado;
	}
	public int getDataEmprestimo() {
		return dataEmprestimo;
	}
	public void setDataEmprestimo(int dataEmprestimo) {
		this.dataEmprestimo = dataEmprestimo;
	}
	public int getDataEntrega() {
		return dataEntrega;
	}
	public void setDataEntrega(int dataEntrega) {
		this.dataEntrega = dataEntrega;
	}

	
	 
}
