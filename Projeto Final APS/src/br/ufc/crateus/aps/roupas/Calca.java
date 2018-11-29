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

public class Calca extends RoupaDecorator {
    
   public Calca(){}
   
   public Calca(Roupa novaRoupa){
       super(novaRoupa);
   }
    
    @Override
    public double custoRoupa() {
        return this.getValor() + custoComOutraRoupa();
    }

    @Override
    public Roupa retornaPecaCombinada() {
         return novaRoupa != null? novaRoupa : null;
    }
    
}
