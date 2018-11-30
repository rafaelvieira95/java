/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufc.crateus.aps.roupas;

/**
 *
 * @author rafael
 */
public abstract class RoupaAtributo {

    protected int codigo;
    protected String tipo;
    protected String marca;
    protected double valor;
    protected int quantidadeEstoque;
    protected int anoColecao;
    protected boolean esgotado;
    protected char genero;
    protected int tamanho;
    protected Estilista estilista;

    @Override
    public String toString() {
        return "Roupa {" + "codigo=" + codigo + ", tipo="
                + tipo + ", marca=" + marca + ", valor=" + valor + ", quantidadeEstoque="
                + quantidadeEstoque + ", anoColecao=" + anoColecao + ", esgotado=" + esgotado
                + ", genero=" + genero + ", tamanho=" + tamanho + ", estilista=" + estilista + '}'+"\n";
    }

}
