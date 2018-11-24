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
public class PessoaFisica extends Cliente {

    private String cpf;

    @SuppressWarnings("NonPublicExported")
    public PessoaFisica(PFBuilder p) {

        setCodigo(p.codigo);
        setNome(p.nome);
        cpf = p.cpf;
        setEndereco(p.endereco);
        setCidade(p.cidade);
        setEstado(p.estado);
        setCep(p.cep);
        setTelefone(p.telefone);
        setEmail(p.email);
    }

    public PessoaFisica() {
        
    }

     public List<Pedido> getListaPedidos() {
        return super.getListaPedidos(); 
    }
    
    static class PFBuilder {

        private int codigo;
        private String nome;
        private String cpf;
        private String endereco;
        private String cidade;
        private String estado;
        private String cep;
        private String telefone;
        private String email;

        public PFBuilder(String nome, String cpf) {
            this.nome = nome;
            this.cpf = cpf;
        }

        public PFBuilder() {
        }

        public PFBuilder codigo(int codigo) {
            this.codigo = codigo;
            return this;
        }

        public PFBuilder nome(String nome) {
            this.nome = nome;
            return this;
        }

        public PFBuilder cpf(String cpf) {
            this.cpf = cpf;
            return this;
        }

        public PFBuilder endereco(String endereco) {
            this.endereco = endereco;
            return this;
        }

        public PFBuilder cidade(String cidade) {
            this.cidade = cidade;
            return this;
        }

        public PFBuilder estado(String estado) {
            this.estado = estado;
            return this;
        }

        public PFBuilder cep(String cep) {
            this.cep = cep;
            return this;
        }

        public PFBuilder telefone(String telefone) {
            this.telefone = telefone;
            return this;
        }

        public PFBuilder email(String email) {
            this.email = email;
            return this;
        }

        public Cliente builder() {
            return new PessoaFisica(this);
        }
    }

    @Override
    public void infoCliente() {
        
        StringBuilder c = new StringBuilder("\tInformações do Cliente");
        c.append("Código: ").append(getCodigo()).append("\n").
                append("Nome: ").append(getNome()).append("\n").
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
