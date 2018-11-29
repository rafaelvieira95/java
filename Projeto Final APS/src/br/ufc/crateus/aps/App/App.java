/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufc.crateus.aps.App;

import br.ufc.crateus.aps.cliente.Cliente;
import br.ufc.crateus.aps.cliente.PessoaFisica;
import br.ufc.crateus.aps.pedido.Item;
import br.ufc.crateus.aps.roupas.Camisa;
import br.ufc.crateus.aps.roupas.RoupaDecorator;
import br.ufc.crateus.aps.roupas.Vestido;

/**
 *
 * @author rafael
 */
public class App {
    
    public static void main(String[] args) {
        
        Cliente c = new PessoaFisica.PFBuilder().
                codigo(20132).
                nome("Rafael").
                estado("Ceará").
                cpf("068.090.753-05").
                email("rafaelimavieira@gmail.com").
                cidade("Independecia").
                cep("63640-000").
                endereco("Rua Tenente Facão").
                telefone("88 993278922").
                builder();
        
        //c.infoCliente();
        
        
        RoupaDecorator camisa = new Camisa();
        RoupaDecorator camisaPolo = new Camisa(camisa);
        RoupaDecorator vestido = new Vestido(camisaPolo);
        
        camisa.setValor(75.50);
        camisaPolo.setValor(155.99);
        vestido.setValor(45.00);
        Item it = new Item();
        
     
       
        System.out.println(it.toString());
        
    }
}
