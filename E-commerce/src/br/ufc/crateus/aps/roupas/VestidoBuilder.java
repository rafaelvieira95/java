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
public class VestidoBuilder implements RoupaBuilder{
    
    
    private Roupa r;

    public VestidoBuilder() {
        this.r = new Vestido();
    }

    public static RoupaBuilder criaRoupa() {
        return new CalcaBuilder();
    }

    @Override
    public RoupaBuilder codido(int codigo) {
        r.setCodido(codigo);
        return this;
    }

    @Override
    public RoupaBuilder tipo(String tipo) {
        r.setTipo(tipo);
        return this;
    }

    @Override
    public RoupaBuilder marca(String marca) {
        r.setMarca(marca);
        return this;
    }

    @Override
    public RoupaBuilder valor(double valor) {
        r.setValor(valor);
        return this;
    }

    @Override
    public RoupaBuilder quantidadeEstoque(int quantidade) {
        r.setQuantidadeEstoque(quantidade);
        return this;
    }

    @Override
    public RoupaBuilder anoColecao(int anoColecao) {
        r.setAnoColecao(anoColecao);
        return this;
    }

    @Override
    public RoupaBuilder esgotado(boolean esgostado) {
        r.setEsgotado(esgostado);
        return this;
    }

    @Override
    public RoupaBuilder genero(char genero) {
        r.setGenero(genero);
        return this;
    }

    @Override
    public RoupaBuilder tamanho(int tamanho) {
        r.setTamanho(tamanho);
        return this;
    }

    @Override
    public RoupaBuilder estilista(Estilista estilista) {
        r.setEstilista(estilista);
        return this;
    }

    @Override
    public Roupa builder() {
        return r;
    }

}
