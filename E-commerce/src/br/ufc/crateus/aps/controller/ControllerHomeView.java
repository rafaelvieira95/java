package br.ufc.crateus.aps.controller;

import br.ufc.crateus.aps.view.CadastroPEView;
import br.ufc.crateus.aps.view.CadastroPFView;
import br.ufc.crateus.aps.view.CadastroPJView;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.util.HashMap;
import java.util.ResourceBundle;

public class ControllerHomeView implements Initializable {


    private HashMap<String,String> dados = new HashMap<>();

    @FXML
    private TextField email_text;
    @FXML
    private TextField doc_text;

    @FXML
    private CheckBox pf_checkbox;
    @FXML
    private CheckBox pj_checkbox;
    @FXML
    private CheckBox pe_checkbox;


    @FXML
    private void tipoCadastro() throws Exception {

        if(pf_checkbox.isSelected()){
            pe_checkbox.setSelected(false);
            pj_checkbox.setSelected(false);

            new CadastroPFView().start(new Stage());
        }


        if(pj_checkbox.isSelected()){
            pe_checkbox.setSelected(false);
            pf_checkbox.setSelected(false);

            new CadastroPJView().start(new Stage());
        }

        if(pe_checkbox.isSelected()){
            pf_checkbox.setSelected(false);
            pj_checkbox.setSelected(false);

            new CadastroPEView().start(new Stage());
        }

    }

    @FXML
    private void login() {

        if (dados.containsKey(email_text.getText())) {
            if (dados.get(email_text.getText()).equals(doc_text.getText())) {
                System.out.println("Login realizado!");
            }
        }

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
