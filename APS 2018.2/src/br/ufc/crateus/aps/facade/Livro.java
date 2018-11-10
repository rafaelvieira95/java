package br.ufc.crateus.aps.facade;

public class Livro implements Exemplar{
    
	String titulo;
	String nomeAutor;
	int ano;
	String editora;
	String ISBN;
	
	public Livro(String titulo,String nomeAutor,int ano,String editora,String ISBN) {
		this.titulo = titulo;
		this.nomeAutor = nomeAutor;
		this.ano = ano;
		this.editora = editora;
		this.ISBN = ISBN;
	}

	@Override
	public void dadosDoExemplar() {
		
		System.out.println("Titulo: "+ titulo);
		System.out.println("Autor: "+ nomeAutor);
		System.out.println("Editora: "+editora);
		System.out.println("Ano: "+ano);
		System.out.println("ISBN: "+ISBN);
		
	}

	@Override
	public Livro getInstance() {
			return this;
	}
}
