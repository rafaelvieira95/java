/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufc.crateus.aps.pedido;

/**
 *
 * @author rafael
 */
public interface ColecaoItem {
    
    boolean adicionarItem(Item ... item);

    boolean apagarItem(int i);
    
    boolean apagarItem();

    boolean colecaoVazia();

    void imprimirColecao();  
    
    boolean pesquisarItem(Item item);
}
