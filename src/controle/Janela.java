package controle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import modelo.Cadastro;
import modelo.Pessoa;


import java.lang.annotation.Repeatable;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class Janela implements Initializable{


    @FXML
    private ComboBox<Integer> cbAnoNascimento;

    @FXML
    private ComboBox<Integer> cbAnoEntrada;

    @FXML
    private TextField tfNome;

    @FXML
    private TextField tfEmail;

    @FXML
    private CheckBox chkLoL;

    @FXML
    private CheckBox chkWoW;

    @FXML
    private CheckBox chkCoD;

    @FXML
    private CheckBox chkBF;

    @FXML
    private RadioButton rbSim;

    @FXML
    private RadioButton rbNao;

    @FXML
    private ListView<Pessoa> lstwPessoas;

    @FXML
    private TextArea txtaInfos;


    Cadastro cadastro;


    public Janela(Cadastro cadastro){
        this.cadastro = cadastro;
    }



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        for(int i=1900;i<=2020;i++){
            cbAnoNascimento.getItems().add(i);
        }

        for(int i=2008;i<=2020;i++){
            cbAnoEntrada.getItems().add(i);
        }

    }



    public void limpar(){

        tfNome.setText("");
        tfEmail.setText("");
        cbAnoEntrada.getSelectionModel().clearSelection();
        cbAnoNascimento.getSelectionModel().clearSelection();

        chkBF.setSelected(false);
        chkCoD.setSelected(false);
        chkLoL.setSelected(false);
        chkWoW.setSelected(false);

        rbNao.setSelected(false);
        rbSim.setSelected(false);

    }

    @FXML
    private void salvarPessoa() {

        String nome = tfNome.getText();
        String email = tfEmail.getText();
        int anoNascimento = cbAnoNascimento.getValue();
        int anoEntrada = cbAnoEntrada.getValue();

        boolean ehDoador = rbSim.isSelected();

        ArrayList<String> jogos = new ArrayList<>();

        if(chkCoD.isSelected()){
            jogos.add(chkCoD.getText());
        }

        if(chkLoL.isSelected()){
            jogos.add(chkLoL.getText());
        }

        if(chkBF.isSelected()){
            jogos.add(chkBF.getText());
        }

        if(chkWoW.isSelected()){
            jogos.add(chkWoW.getText());
        }

        boolean ret = cadastro.adicionaPessoa(nome,email,anoNascimento,anoEntrada,jogos,ehDoador);

        if(ret){
            Alert alert = new Alert(Alert.AlertType.INFORMATION,"Pessoa salva!!");
            alert.showAndWait();
            atualizaListaPessoas();
            limpar();

        }

    }

    private void atualizaListaPessoas(){
        List<Pessoa> lista = cadastro.getLista();

        lstwPessoas.getItems().clear();
        for(Pessoa p:lista){
            lstwPessoas.getItems().add(p);
        }

    }


    @FXML
    private void atualizaAreaInfos() {

        Pessoa p = lstwPessoas.getSelectionModel().getSelectedItem();

        if(p != null){
            String str = "";

            str += "Nome: "+p.getNome()+"\n";
            str += "E-mail: "+p.getEmail()+"\n";
            str += "Ano de Entrada: "+p.getAnoEntrada()+"\n";
            str += "Ano de Nascimento: "+p.getAnoNascimento()+"\n";
            str += "Doador de orgãos?: "+(p.isDoadorOrgaos()?"Sim":"Não")+"\n";
            str += "Jogos:"+ p.getJogos();


            txtaInfos.clear();
            txtaInfos.setText(str);
        }

    }


}
