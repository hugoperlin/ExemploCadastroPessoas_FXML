package modelo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Cadastro {


    private ArrayList<Pessoa> cadastro;


    public Cadastro(){
        cadastro = new ArrayList<>();
    }



    public boolean adicionaPessoa(String nome, String email, int anoNascimento, int anoEntrada, ArrayList<String> jogos, boolean doadorOrgaos){
        Pessoa p = new Pessoa(nome, email, anoNascimento, anoEntrada, jogos, doadorOrgaos);

        cadastro.add(p);

        return true;
    }


    public List<Pessoa> getLista(){
        return Collections.unmodifiableList(cadastro);
    }

}
