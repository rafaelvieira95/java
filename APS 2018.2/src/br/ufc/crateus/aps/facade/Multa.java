package br.ufc.crateus.aps.facade;

public class Multa {
	
    private static final double MULTA_DIARIA = 0.10;
	private Aluno alunoDevedor;
	private Exemplar livroPendente;
	private Emprestimo numeroDias;
	private int diaLivroEntreque;
    
	public Multa(Aluno alunoDevedor,Exemplar livroPendente,Emprestimo numeroDias,int diaLivroEntregue) {
		this.alunoDevedor = alunoDevedor;
		this.livroPendente = livroPendente;
		this.numeroDias = numeroDias;
		this.diaLivroEntreque = diaLivroEntregue;
	}
	
	public double valorMulta() {
		
        int cobranca = numeroDias.getDataEntrega() - diaLivroEntreque;
        double multa = 0.0;
        
		if(diaLivroEntreque - numeroDias.getDataEntrega() == 0) return 0.0;
		if(numeroDias.getDataEntrega() - diaLivroEntreque > 0)  return 0.0;
		if(cobranca < 0) multa =  -cobranca * MULTA_DIARIA;
		return multa;
	}
	
	public Aluno getAlunoDevedor() {
		return alunoDevedor;
	}

	public void setAlunoDevedor(Aluno alunoDevedor) {
		this.alunoDevedor = alunoDevedor;
	}

	public Exemplar getLivroPendente() {
		return livroPendente;
	}

	public void setLivroPendente(Livro livroPendente) {
		this.livroPendente = livroPendente;
	}

	public Emprestimo getNumeroDias() {
		return numeroDias;
	}

	public void setNumeroDias(Emprestimo numeroDias) {
		this.numeroDias = numeroDias;
	}

	public int getDiaLivroEntreque() {
		return diaLivroEntreque;
	}

	public void setDiaLivroEntreque(int diaLivroEntreque) {
		this.diaLivroEntreque = diaLivroEntreque;
	}
  
	
	
}
