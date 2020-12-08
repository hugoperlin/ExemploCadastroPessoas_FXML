package modelo;

import java.util.ArrayList;

public class Pessoa {

    private String nome;
    private String email;
    private int anoNascimento;
    private int anoEntrada;
    private ArrayList<String> jogos;
    private boolean doadorOrgaos;


    public Pessoa(String nome, String email, int anoNascimento, int anoEntrada, ArrayList<String> jogos, boolean doadorOrgaos) {
        this.nome = nome;
        this.email = email;
        this.anoNascimento = anoNascimento;
        this.anoEntrada = anoEntrada;
        this.jogos = jogos;
        this.doadorOrgaos = doadorOrgaos;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAnoNascimento() {
        return anoNascimento;
    }

    public void setAnoNascimento(int anoNascimento) {
        this.anoNascimento = anoNascimento;
    }

    public int getAnoEntrada() {
        return anoEntrada;
    }

    public void setAnoEntrada(int anoEntrada) {
        this.anoEntrada = anoEntrada;
    }

    public ArrayList<String> getJogos() {
        return jogos;
    }

    public void setJogos(ArrayList<String> jogos) {
        this.jogos = jogos;
    }

    public boolean isDoadorOrgaos() {
        return doadorOrgaos;
    }

    public void setDoadorOrgaos(boolean doadorOrgaos) {
        this.doadorOrgaos = doadorOrgaos;
    }

    @Override
    public String toString() {
        return this.nome;
    }
}
