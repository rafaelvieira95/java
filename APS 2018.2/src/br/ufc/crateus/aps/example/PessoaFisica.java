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
public class PessoaFisica extends Cliente{

    private String cpf;
    
    public PessoaFisica(PessoaFisicaBuilder p){
        this.nome = p.nome;
        this.cpf = p.cpf;
        this.endereco = p.endereco;
        this.cep = p.cep;
    }
    
    public PessoaFisica(){
        
    }
    
    @Override
    public String infoCliente() {
      StringBuilder stringBuilder = new StringBuilder("\t Info").append("\n");
      
      stringBuilder.append("Nome: ").append(nome).append("\n").
                           append("cpf: ").append(cpf).append("\n").
                           append("endereco: ").append(endereco).append("\n").
                           append("cep: ").append(cep);
      
        return stringBuilder.toString();
    }
    
    static class PessoaFisicaBuilder{
   
        private String nome;
        private String cep;
        private String endereco;
        private String cpf;
        
        public PessoaFisicaBuilder nome(String nome){
            this.nome = nome;
            return this;
        }
        
          public PessoaFisicaBuilder cep(String cep){
            this.cep = cep;
            return this;
        }
          
            public PessoaFisicaBuilder endereco(String endereco){
            this.endereco = endereco;
            return this;
        }
            
              public PessoaFisicaBuilder cpf(String cpf){
               this.cpf = cpf;
              return this;
        }
              
            public Cliente builder(){
                return new PessoaFisica(this);
            }    
    }
    
}
