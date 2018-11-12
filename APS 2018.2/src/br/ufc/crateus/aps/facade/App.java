package br.ufc.crateus.aps.facade;

public class App {

	public static void main(String[] args) {
			
	   Exemplar livro = new Livro("A cabana", "Desconhecido", 2012,"Elsevier" , "BR16545651651RT");
	   Exemplar rev = new Revista("A Bola",39,2018);
	   
	   Aluno aluno = new Aluno("Rafael",389936,livro);
	   Emprestimo emp = new Emprestimo(aluno, livro, 10, 25);
       Multa multa = new Multa(aluno, livro, emp, 30);
      
       Aluno aluno1 = new Aluno("Luiz",385536,rev);
	   Emprestimo emp1 = new Emprestimo(aluno, rev, 15, 29);
       Multa multa1 = new Multa(aluno1, rev, emp1, 30);
       
       BibliotecaFacade b = new BibliotecaFacade(aluno, livro, emp, multa);
       BibliotecaFacade b1 = new BibliotecaFacade(aluno1, rev, emp1, multa1);
        b.situacaoBiblioteca();
        b1.situacaoBiblioteca();
       //livro.dadosDoExemplar();
	}

}
