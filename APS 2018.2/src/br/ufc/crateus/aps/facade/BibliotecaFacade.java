package br.ufc.crateus.aps.facade;


public class BibliotecaFacade {

	private Aluno aluno;
    private Exemplar exemplar;
	private Emprestimo emprestimo;
	private Multa multa;
	
	public BibliotecaFacade(Aluno aluno,Exemplar exemplar,Emprestimo emprestimo,Multa multa) {
		this.aluno = aluno;
		this.exemplar = exemplar;
		this.emprestimo = emprestimo;
		this.multa = multa;
	}
	
	
	public void situacaoBiblioteca() {
		
		System.out.println("Nome aluno: "+ aluno.getNome());
		System.out.println("Matricula: "+ aluno.getMatricula());
		
		if(Revista.class.isInstance(exemplar.getInstance())) 
		System.out.println("Revista emprestada: "+((Revista) exemplar).getInstance().tituloCapa);
		
		if(Livro.class.isInstance(exemplar.getInstance())) 
			System.out.println("Livro emprestado: "+((Livro) exemplar).getInstance().titulo);
		
		System.out.println("dia do emprestimo: "+emprestimo.getDataEmprestimo());
		System.out.println("dia de devolucao: "+emprestimo.getDataEntrega());
		System.out.println("Dia que foi entregue: "+multa.getDiaLivroEntreque());
		System.out.println("Multa (R$): "+ multa.valorMulta());
		System.out.println("-----------------------------------");
	}
	
	
}
