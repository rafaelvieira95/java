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
    
    private int codigo;
    private  String tipo;
    private String marca;
    private double valor;
    private int quantidadeEstoque;
    private int anoColecao;
    private  boolean esgotado;
    private char genero;
    private int tamanho;
    private Estilista estilista;
    
    public abstract double custoRoupa();

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public int getQuantidadeEstoque() {
        return quantidadeEstoque;
    }

    public void setQuantidadeEstoque(int quantidadeEstoque) {
        this.quantidadeEstoque = quantidadeEstoque;
    }

    public int getAnoColecao() {
        return anoColecao;
    }

    public void setAnoColecao(int anoColecao) {
        this.anoColecao = anoColecao;
    }

    public boolean isEsgotado() {
        return esgotado;
    }

    public void setEsgotado(boolean esgotado) {
        this.esgotado = esgotado;
    }

    public char getGenero() {
        return genero;
    }

    public void setGenero(char genero) {
        this.genero = genero;
    }

    public int getTamanho() {
        return tamanho;
    }

    public void setTamanho(int tamanho) {
        this.tamanho = tamanho;
    }

    public Estilista getEstilista() {
        return estilista;
    }

    public void setEstilista(Estilista estilista) {
        this.estilista = estilista;
    }

    
    
    
    @Override
    public String toString() {
        return "Roupa{" + "codigo=" + codigo + ", tipo=" + 
                tipo + ", marca=" + marca + ", valor=" + valor + ", quantidadeEstoque=" +
                quantidadeEstoque + ", anoColecao=" + anoColecao + ", esgotado=" + esgotado + 
                ", genero=" + genero + ", tamanho=" + tamanho + ", estilista=" + estilista + '}';
    }
  
    
}
