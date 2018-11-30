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
public interface Roupa {
    
    void setCodido(int codigo);
    
    void setTipo(String tipo);
    
    void setMarca(String marca);
    
    void setValor(double valor);
    
    void setQuantidadeEstoque(int quantidade);
    
    void setAnoColecao(int anoColecao);
    
    void setEsgotado(boolean esgostado);
    
    void setGenero(char genero);
    
    void setTamanho(int tamanho);
    
    void setEstilista(Estilista estilista);
    
}
