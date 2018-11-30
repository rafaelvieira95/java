/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufc.crateus.aps.pedido;

import br.ufc.crateus.aps.roupas.ModeloRoupa;
import br.ufc.crateus.aps.roupas.Roupa;
import br.ufc.crateus.aps.roupas.RoupaBuilder;

/**
 *
 * @author rafael
 */
public interface ColecaoRoupa {
    
    void gerarRoupa(ModeloRoupa modelo);
    
    boolean adicionarRoupa(Roupa r);
    
    boolean apagarRoupa(Roupa r);
    
    boolean pesquisarRoupa(Roupa r);
    
    boolean colecaoVazia();
    
    RoupaBuilder obterRoupa();
    
    
}
