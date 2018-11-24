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
public abstract class Roupa {
    
    int codigo;
    String tipo;
    String marca;
    double valor;
    int quantidadeEstoque;
    int anoColecao;
    boolean esgotado;
    char genero;
    int tamanho;
    Estilista estilista;
    
    public abstract double custoRoupa();

    @Override
    public String toString() {
        return "Roupa{" + "codigo=" + codigo + ", tipo=" + tipo + ", marca=" + marca + ", valor=" + valor + ", quantidadeEstoque=" + quantidadeEstoque + ", anoColecao=" + anoColecao + ", esgotado=" + esgotado + ", genero=" + genero + ", tamanho=" + tamanho + ", estilista=" + estilista + '}';
    }
  
    
}
