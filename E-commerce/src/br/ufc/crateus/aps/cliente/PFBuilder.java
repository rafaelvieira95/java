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
public class PFBuilder implements ClienteBuilder {

    private Cliente cliente;

    public PFBuilder() {
        this.cliente = new PessoaFisica();
    }

    public static ClienteBuilder criarCliente() {
        return new PFBuilder();
    }

    @Override
    public ClienteBuilder codigo(int codigo) {
        cliente.setCodigo(codigo);
        return this;
    }

    @Override
    public ClienteBuilder nome(String nome) {
        cliente.setNome(nome);
        return this;
    }

    @Override
    public ClienteBuilder endereco(String endereco) {
        cliente.setEndereco(endereco);
        return this;
    }

    @Override
    public ClienteBuilder cidade(String cidade) {
        cliente.setCidade(cidade);
        return this;
    }

    @Override
    public ClienteBuilder estado(String estado) {
        cliente.setEstado(estado);
        return this;
    }

    @Override
    public ClienteBuilder cep(String cep) {
        cliente.setCep(cep);
        return this;
    }

    @Override
    public ClienteBuilder telefone(String telefone) {
        cliente.setTelefone(telefone);
        return this;
    }

    @Override
    public ClienteBuilder email(String email) {
        cliente.setEmail(email);
        return this;
    }

    @Override
    public ClienteBuilder cpf(String cpf) {
        cliente.setCpf(cpf);
        return this;
    }

    @Override
    public ClienteBuilder cnpj(String cnpj) {
        return this;
    }

    @Override
    public ClienteBuilder passaporte(String passaporte) {
        return this;
    }

    @Override
    public ClienteBuilder nomeFantasia(String nomeFantasia) {
        return this;
    }

    @Override
    public Cliente Builder() {
        return cliente;
    }

   
    @SuppressWarnings("override")
    public String toString() {
        return cliente.toString();
    }
}
