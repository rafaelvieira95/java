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
public class RoupaFactory {
    
    private RoupaFactory() {}
    
    public static RoupaBuilder factoryMethod(ModeloRoupa mod){
        
        switch(mod){
            
            case VESTIDO:
                return VestidoBuilder.criaRoupa();
            
            case CAMISA:
                return CamisaBuilder.criaRoupa();
                
            case CALCA:
                return CalcaBuilder.criaRoupa();
                
            default:
                return null;
        }
       
    }
    
}
