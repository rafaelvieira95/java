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
public class Calca extends RoupaAtributo implements Roupa {

    public Calca() {
    }

    @Override
    public void setCodido(int codigo) {
        this.codigo = codigo;
    }

    @Override
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public void setMarca(String marca) {
        this.marca = marca;
    }

    @Override
    public void setValor(double valor) {
        this.valor = valor;
    }

    @Override
    public void setQuantidadeEstoque(int quantidade) {
        this.quantidadeEstoque = quantidade;
    }

    @Override
    public void setAnoColecao(int anoColecao) {
        this.anoColecao = anoColecao;
    }

    @Override
    public void setEsgotado(boolean esgostado) {
        this.esgotado = esgostado;
    }

    @Override
    public void setGenero(char genero) {
        this.genero = genero;
    }

    @Override
    public void setTamanho(int tamanho) {
        this.tamanho = tamanho;
    }

    @Override
    public void setEstilista(Estilista estilista) {
        this.estilista = estilista;
    }

}
