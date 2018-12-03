/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufc.crateus.aps.cliente;

/**
 *
 * @author rafael
 */
public class ClienteFactory {
    
    private ClienteFactory(){}
    
    public static ClienteBuilder factoryMethod(TipoCliente tc){
        
        switch(tc){
            
            case PESSOA_FISICA:
                return PFBuilder.criarCliente();
            
            case PESSOA_JURIDICA:
                return PJBuilder.criarCliente();
            
            case PESSOA_ESTRANGEIRA:
                return PEBuilder.criarCliente();
                
        }
        throw  new IllegalArgumentException("Tipo de Cliente Inexistente");
    }
    
}
