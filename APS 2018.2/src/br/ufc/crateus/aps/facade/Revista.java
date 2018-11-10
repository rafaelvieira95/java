package br.ufc.crateus.aps.facade;

public class Revista implements Exemplar {

	String tituloCapa;
	int numeroEdicao;
	int ano;
	
	public Revista(String tituloCapa,int numeroEdicao,int ano) {
		this.tituloCapa = tituloCapa;
		this.numeroEdicao = numeroEdicao;
		this.ano = ano;
	}

	@Override
	public void dadosDoExemplar() {
		System.out.println("Titulo Capa: "+tituloCapa);
		System.out.println("N° edicao: "+ numeroEdicao);
		System.out.println("Ano: "+ ano);
		
	}

	@Override
	public Revista getInstance() {
		return this;
	}
	
	
}
