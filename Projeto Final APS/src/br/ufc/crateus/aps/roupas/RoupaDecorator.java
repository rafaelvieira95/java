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
public abstract class RoupaDecorator extends Roupa{

    protected Roupa novaRoupa;
    
    public RoupaDecorator(Roupa novaRoupa){
        this.novaRoupa = novaRoupa;
    }
    
    public RoupaDecorator(){}
       
    protected double custoComOutraRoupa(){
        if(novaRoupa == null) return 0.0;
        return novaRoupa.custoRoupa();
    }
    
}
