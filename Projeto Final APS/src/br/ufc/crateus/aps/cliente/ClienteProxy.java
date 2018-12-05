/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufc.crateus.aps.cliente;

import br.ufc.crateus.aps.pedido.Pedido;
;
/**
 *
 * @author rafael
 */
public class ClienteProxy implements Autenticacao, ColecaoPedido {

    private ClienteBuilder cli;
    private final String documento;

    public ClienteProxy(String documento) {
        this.documento = documento;
    }

    public void criarCliente(TipoCliente tc) {
        
        cli = ClienteFactory.factoryMethod(tc);
        
        switch (tc) {
            case PESSOA_FISICA:
                
            {
                
                if(!cli.Builder().autenticaDocumento(this.documento)){
                    throw new IllegalArgumentException("Documento inválido!");
                }
                cli.cpf(documento);
            }
                break;
            case PESSOA_JURIDICA:
                
                 {
                
                if(!cli.Builder().autenticaDocumento(this.documento)){
                    throw new IllegalArgumentException("Documento inválido!");
                }
                cli.cnpj(documento);
            }
                break;
                
            case PESSOA_ESTRANGEIRA:
                 {
                   
                if(!cli.Builder().autenticaDocumento(this.documento)){
                    throw new IllegalArgumentException("Documento inválido!");
                }
                 cli.passaporte(documento);
            }
                break;

            default:
        }
    }

   
    public ClienteBuilder instance() {
        return cli;
    }

    @Override
    public boolean autenticaDocumento(String documento) {
        return cli.Builder().autenticaDocumento(documento);
    }

    @Override
    public boolean adicionarPedido(Pedido... pedido) {
        if (pedido == null) {
            return false;
        }

        for (Pedido p : pedido) {
            instance().Builder().listaPedidos().add(p);
        }

        return true;
    }

    @Override
    public boolean removerPedido(Pedido pedido) {
        return instance().Builder().listaPedidos().remove(pedido);
    }

    @Override
    public boolean pesquisarPedido(Pedido pedido) {
        return instance().Builder().listaPedidos().contains(pedido);
    }

    @Override
    public boolean colecaoVazia() {
        return instance().Builder().listaPedidos().isEmpty();
    }

    @Override
    public Pedido pagarPedido(int i) {
         return cli.Builder().listaPedidos().get(i);
       
    }

}
