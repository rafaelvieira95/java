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
public class PessoaJuridica extends Pessoa{
    
    private String cnpj;
    private String cpf;
    private String nomeFantasia;

    @Override
    public boolean autenticaDocumento(String documento) {
        return documento.matches("[0-9][0-9].[0-9][0-9][0-9].[0-9][0-9][0-9]/[0-9][0-9][0-9][0-9]-[0-9][0-9]");
    }
    
    @Override
    public void setCpf(String cpf) {
       this.cpf = cpf;
    }

    @Override
    public void setCnpj(String cnpj) {
       this.cnpj = cnpj;
    }

    @Override
    public void setPassaporte(String passaporte) {
        //Não consta
    }

    @Override
    public void setNomeFantasia(String nomeFantasia) {
        this.nomeFantasia = nomeFantasia;
    }

    @Override
    public String infoCliente() {
       
          StringBuilder c = new StringBuilder("\tInformações do Cliente").append("\n");
        c.append("Código: ").append(getCodigo()).append("\n").
                append("Nome: ").append(getNome()).append("\n").
                append("CNPJ: ").append(cnpj).append("\n").
                append("CPF: ").append(cpf).append("\n").
                append("Cidade: ").append(getCidade()).append("\n").
                append("Estado: ").append(getEstado()).append("\n").
                append("Endereço: ").append(getEndereco()).append("\n").
                append("Cep: ").append(getCep()).append("\n").
                append("Telefone: ").append(getTelefone()).append("\n").
                append("E-mail: ").append(getEmail()).append("\n");
                c.append(this.listaPedidos());
                
        return c.toString();
        
    }

    @Override
    public String toString() {
        return infoCliente();
    }
    
    
}
