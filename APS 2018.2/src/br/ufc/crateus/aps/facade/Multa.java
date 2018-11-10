package br.ufc.crateus.aps.facade;

public class Multa {
	
    private  double MULTA_DIARIA = 0.10;
	private Aluno alunoDevedor;
	private Livro livroPendente;
	private Emprestimo numeroDias;
	private double valor_multa;

	public double getMULTA_DIARIA() {
		return MULTA_DIARIA;
	}

	public void setMULTA_DIARIA(double mULTA_DIARIA) {
		MULTA_DIARIA = mULTA_DIARIA;
	}

	public Aluno getAlunoDevedor() {
		return alunoDevedor;
	}

	public void setAlunoDevedor(Aluno alunoDevedor) {
		this.alunoDevedor = alunoDevedor;
	}

	public Livro getLivroPendente() {
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

	public double getValor_multa() {
		return valor_multa;
	}

	public void setValor_multa(double valor_multa) {
		this.valor_multa = valor_multa;
	}
	
}
