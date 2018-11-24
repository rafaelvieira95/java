/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufc.crateus.aps.cliente;

import br.ufc.crateus.aps.pedido.Pedido;
import java.util.List;

/**
 *
 * @author rafael
 */
public class PessoaJuridica extends Cliente{
    
    private String cnpj;
    private String cpf;
    
    public PessoaJuridica(PJBuilder p){
        
        setCodigo(p.codigo);
        setNome(p.nome);
        cpf = p.cpf;
        cnpj = p.cnpj;
        setEndereco(p.endereco);
        setCidade(p.cidade);
        setEstado(p.estado);
        setCep(p.cep);
        setTelefone(p.telefone);
        setEmail(p.email);
        
    }
    
     public List<Pedido> getListaPedidos() {
        return super.getListaPedidos(); 
    }
    
    static class PJBuilder {

        private int codigo;
        private String nome;
        private String cpf;
        private String cnpj;
        private String endereco;
        private String cidade;
        private String estado;
        private String cep;
        private String telefone;
        private String email;

        public PJBuilder(String nome, String cpf,String cnpj) {
            this.nome = nome;
            this.cpf = cpf;
            this.cnpj = cnpj;
        }

        public PJBuilder() {
        }

        public PJBuilder codigo(int codigo) {
            this.codigo = codigo;
            return this;
        }

        public PJBuilder nome(String nome) {
            this.nome = nome;
            return this;
        }

        public PJBuilder cpf(String cpf) {
            this.cpf = cpf;
            return this;
        }
        
        
        public PJBuilder cnpj(String cnpj) {
            this.cnpj = cnpj;
            return this;
        }

        public PJBuilder endereco(String endereco) {
            this.endereco = endereco;
            return this;
        }

        public PJBuilder cidade(String cidade) {
            this.cidade = cidade;
            return this;
        }

        public PJBuilder estado(String estado) {
            this.estado = estado;
            return this;
        }

        public PJBuilder cep(String cep) {
            this.cep = cep;
            return this;
        }

        public PJBuilder telefone(String telefone) {
            this.telefone = telefone;
            return this;
        }

        public PJBuilder email(String email) {
            this.email = email;
            return this;
        }

        public Cliente builder() {
            return new PessoaJuridica(this);
        }
    }
    
    
    @Override
    public void infoCliente() {
       
          StringBuilder c = new StringBuilder("\tInformações do Cliente");
        c.append("Código: ").append(getCodigo()).append("\n").
                append("Nome: ").append(getNome()).append("\n").
                append("CNPJ: ").append(cnpj).append("\n").
                append("CPF: ").append(cpf).append("\n").
                append("Cidade: ").append(getCidade()).append("\n").
                append("Estado").append(getEstado()).append("\n").
                append("Endereço: ").append(getEndereco()).append("\n").
                append("Cep: ").append(getCep()).append("\n").
                append("Telefone: ").append(getTelefone()).append("\n").
                append("E-mail: ").append(getEmail()).append("\n");
        
        System.out.println(c.toString());
        
    }
    
}
