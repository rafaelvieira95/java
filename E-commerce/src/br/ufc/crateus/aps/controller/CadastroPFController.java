package br.ufc.crateus.aps.controller;

import br.ufc.crateus.aps.cliente.ClienteProxy;
import br.ufc.crateus.aps.cliente.TipoCliente;
import br.ufc.crateus.aps.model.BaseDadosClientes;
import com.sun.corba.se.spi.ior.iiop.AlternateIIOPAddressComponent;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class CadastroPFController implements Initializable {

    @FXML
    private TextField codigo;
    @FXML
    private TextField nome;
    @FXML
    private TextField endereco;
    @FXML
    private TextField cidade;
    @FXML
    private TextField cpf;
    @FXML
    private ChoiceBox <String> estado;
    @FXML
    private TextField cep;
    @FXML
    private TextField telefone;
    @FXML
    private TextField email;

    private void estadosDaUniao(){

        ObservableList<String> estadosDaFederacao = FXCollections.observableArrayList();

        estadosDaFederacao.addAll("AC","AL","AP","AM","BA","CE","DF","ES","GO",
                  "MA","MT","MS","MG","PA","PB","PR","PE","PI","RJ","RN",
                  "RS","RO","RR","SC","SP","SE","TO");

        estado.setItems(estadosDaFederacao);
    }


     @FXML
     private void cadastrar(){


          String doc = cpf.getText();
         try {

                 ClienteProxy cliente = new ClienteProxy(cpf.getText());
                 cliente.criarCliente(TipoCliente.PESSOA_FISICA);

                     cliente.instance().
                             codigo(Integer.parseInt(codigo.getText())).
                             nome(nome.getText()).
                             cpf(doc).
                             estado(estado.getValue()).
                             cidade(cidade.getText()).
                             endereco(endereco.getText()).
                             cep(cep.getText()).
                             email(email.getText()).
                             telefone(telefone.getText()).
                             Builder();

                     BaseDadosClientes.getInstance().map.put(cliente.instance().Builder(), cpf.getText());

         }catch (IllegalArgumentException e){
             Alert alert = new Alert(Alert.AlertType.ERROR);
             alert.setContentText("CPF inválido, verifique seus dados!");
             alert.show();
         }
     }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

         estadosDaUniao();
        codigo.setText("00");
        nome.setText("informar dados");
        endereco.setText("informar dados");;
        cidade.setText("informar dados");;
        cpf.setText("informe seu cpf");
        cep.setText("informar dados");
        telefone.setText("informar dados");
        email.setText("informar dados");
    }
}
