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
public class PessoaEstrangeira extends Cliente{
    
    private String passaporte;
    
    
    public PessoaEstrangeira(PEBuilder p){
          
        setCodigo(p.codigo);
        setNome(p.nome);
        passaporte = p.passaporte;
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
    
    static class PEBuilder {

        private int codigo;
        private String nome;
        private String passaporte;
        private String endereco;
        private String cidade;
        private String estado;
        private String cep;
        private String telefone;
        private String email;

        public PEBuilder(String nome, String passaporte) {
            this.nome = nome;
            this.passaporte = passaporte;
        }

        public PEBuilder() {
        }

        public PEBuilder codigo(int codigo) {
            this.codigo = codigo;
            return this;
        }

        public PEBuilder nome(String nome) {
            this.nome = nome;
            return this;
        }

        public PEBuilder passaporte(String passaporte) {
            this.passaporte = passaporte;
            return this;
        }

        public PEBuilder endereco(String endereco) {
            this.endereco = endereco;
            return this;
        }

        public PEBuilder cidade(String cidade) {
            this.cidade = cidade;
            return this;
        }

        public PEBuilder estado(String estado) {
            this.estado = estado;
            return this;
        }

        public PEBuilder cep(String cep) {
            this.cep = cep;
            return this;
        }

        public PEBuilder telefone(String telefone) {
            this.telefone = telefone;
            return this;
        }

        public PEBuilder email(String email) {
            this.email = email;
            return this;
        }

        public Cliente builder() {
            return new PessoaEstrangeira(this);
        }
    }
    
    @Override
    public void infoCliente() {
        
            StringBuilder c = new StringBuilder("\tInformações do Cliente");
        c.append("Código: ").append(getCodigo()).append("\n").
                append("Nome: ").append(getNome()).append("\n").
                append("Passaporte: ").append(passaporte).append("\n").
                append("Cidade: ").append(getCidade()).append("\n").
                append("Estado").append(getEstado()).append("\n").
                append("Endereço: ").append(getEndereco()).append("\n").
                append("Cep: ").append(getCep()).append("\n").
                append("Telefone: ").append(getTelefone()).append("\n").
                append("E-mail: ").append(getEmail()).append("\n");
        
        System.out.println(c.toString());
        
    }
    
}
