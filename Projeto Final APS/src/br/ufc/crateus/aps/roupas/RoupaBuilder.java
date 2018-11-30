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
public interface RoupaBuilder {
    
    RoupaBuilder codido(int codigo);
    
    RoupaBuilder tipo(String tipo);
    
    RoupaBuilder marca(String marca);
    
    RoupaBuilder valor(double valor);
    
    RoupaBuilder quantidadeEstoque(int quantidade);
    
    RoupaBuilder anoColecao(int anoColecao);
    
    RoupaBuilder esgotado(boolean esgostado);
    
    RoupaBuilder genero(char genero);
    
    RoupaBuilder tamanho(int tamanho);
    
    RoupaBuilder estilista(Estilista estilista);
    
    Roupa builder();
    
}
