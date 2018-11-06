package br.ufc.crateus.aps.singleton;

public class ColecaoPessoa implements Colecao {

	private ColecaoPessoa() {
	this.posicaoCorrente = 0;
	}
	 private static ColecaoPessoa instance = new ColecaoPessoa();
	
	public static ColecaoPessoa getInstance() {
		return instance;
	}
	
	private Pessoa [] dados = new Pessoa [100];
	private int posicaoCorrente;
	
	@Override
	public boolean inserir(Pessoa p) {
		
	  if(posicaoCorrente < dados.length && p.validarDocumento()) {
		  dados[posicaoCorrente] = p;
		  posicaoCorrente++;
		  return true;
	  }
		return false;
	}

	@Override
	public boolean remover() {
		
		if(posicaoCorrente >= 0 && posicaoCorrente < dados.length) {
			dados[posicaoCorrente - 1] = null;
			--posicaoCorrente;
			return true;
		}
		return false;
	}

	@Override
	public boolean remover(int i) {

		if(i >= 0 && i < dados.length) {
              if(dados[i] != null) {
            	  dados[i] = null;
            	  return true;
              }
		}
		return false;
	}

	@Override
	public void atualizar(int i, Pessoa p) {
		if(i >= 0 && i < dados.length) {
			dados[i] = p;	
		}
	}

	@Override
	public boolean pesquisar(Pessoa p) {
		for(Pessoa ob : dados) {
			if(ob.equals(p)) return true;
		}
		return false;
	}

	@Override
	public boolean colecaoEstaVazia() {
		return posicaoCorrente == 0;
	}

	@Override
	public void imprimirDadosColecao() {
		for(Pessoa p: dados) {
			if(p != null) System.out.println("--------------------------------\n"+p.toString());
		}
	}

	@Override
	public Pessoa retornarObjeto(int i) {
	    if(i >= 0 && i < dados.length) {
	    	return dados[i] != null ? dados[i] : null;
	    }
	    return null;
	}

}
