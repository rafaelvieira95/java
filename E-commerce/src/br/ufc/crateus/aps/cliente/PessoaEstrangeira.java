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
public class PessoaEstrangeira extends Pessoa{
    
    private String passaporte;

    @Override
    public boolean autenticaDocumento(String documento) {
        return documento.matches("[A-Z][A-Z][0-9][0-9][0-9][0-9][0-9][0-9]");
    }
   
    @Override
    public void setCpf(String cpf) {
        //Não consta
    }

    @Override
    public void setCnpj(String cnpj) {
        //Não consta
    }

    @Override
    public void setPassaporte(String passaporte) {
        this.passaporte = passaporte;
    }

    @Override
    public void setNomeFantasia(String nomeFantasia) {
        //Não consta
        
    }
   
    
      @Override
    public String infoCliente() {
        
            StringBuilder c = new StringBuilder("\tInformações do Cliente").append("\n");
        c.append("Código: ").append(getCodigo()).append("\n").
                append("Nome: ").append(getNome()).append("\n").
                append("Passaporte: ").append(passaporte).append("\n").
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
