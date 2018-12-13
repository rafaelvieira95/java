/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufc.crateus.aps.pedido;

import br.ufc.crateus.aps.roupas.Roupa;

/**
 *
 * @author rafael
 */
public interface ColecaoRoupa {
  
   
    boolean adicionarRoupa(Roupa r);
   
    boolean apagarRoupa(Roupa r);
    
    boolean pesquisarRoupa(Roupa r);
    
    boolean colecaoVazia();

}
