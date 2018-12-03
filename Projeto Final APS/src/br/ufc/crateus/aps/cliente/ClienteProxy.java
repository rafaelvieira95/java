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
public class ClienteProxy implements Autenticacao{
    
    private ClienteBuilder cli;
    private String documento;

    public ClienteProxy(String documento) {
    this.documento = documento;
    }
      
    public void criarCliente(TipoCliente tc){
   
        cli = ClienteFactory.factoryMethod(tc);
        if(!cli.Builder().autenticaDocumento(this.documento)){
            cli = null;
            throw new IllegalArgumentException("Documento Inválido!");
        }
        
    }
    
    @Override
    public ClienteBuilder instance() {
        return cli;
    }

    @Override
    public boolean autenticaDocumento(String documento) {
       return cli.Builder().autenticaDocumento(documento);
    }
    
}
