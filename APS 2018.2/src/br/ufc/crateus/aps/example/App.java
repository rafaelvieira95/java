/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufc.crateus.aps.example;

/**
 *
 * @author rafael
 */
public class App {
 
    public static void main(String[] args) {
        
        Cliente c = new PessoaFisica.PessoaFisicaBuilder().
                                  nome("Rafael").
                                  cep("63640-000").
                                  cpf("068.090.753-05").
                                  endereco("Rua tenente Falcão").
                                  builder();
          System.out.println(c.infoCliente());
    }
    
}
