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
public class Camisa extends RoupaDecorator{

    public Camisa(){}
    
    public Camisa(Roupa novaRoupa){
        super(novaRoupa);
    }
    
    @Override
    public double custoRoupa() {
        return valor + custoComOutraRoupa();
    }
    
}
