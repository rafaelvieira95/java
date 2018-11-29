/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufc.crateus.aps.roupas;

import br.ufc.crateus.aps.pedido.CarrinhoDeCompras;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author rafael
 */
public abstract class RoupaDecorator extends Roupa{

    protected Roupa novaRoupa;

    private CarrinhoDeCompras carrinho; 
    
    public RoupaDecorator(Roupa novaRoupa){
        
        this.novaRoupa = novaRoupa;
        
        carrinho = new CarrinhoDeCompras();
        
        carrinho.carrinho.add(this);
        carrinho.carrinho.add(novaRoupa);
    }
    
    public RoupaDecorator(){
       carrinho = new CarrinhoDeCompras();
       carrinho.carrinho.add(this);
    }
    
    
    protected double custoComOutraRoupa(){
        if(novaRoupa == null) return 0.0;
        return novaRoupa.custoRoupa();
    }


}
