package br.ufc.crateus.aps.singleton;

public interface Colecao {

	boolean inserir(Pessoa p);
	
	boolean remover();
	
	boolean remover(int i);
	
	void atualizar(int i,Pessoa p);
	
	boolean pesquisar(Pessoa p);
	
	boolean colecaoEstaVazia();
	
	void imprimirDadosColecao();
	
	Pessoa retornarObjeto(int i);
	
}
