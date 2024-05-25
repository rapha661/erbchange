package model;

import java.util.List;

/**
 *
 * @author rgara
 */

public class Investidor {
    private String nome;
    private String cpf;
    private String senha;
    private Carteira carteira;

    public Investidor(String nome, String cpf, String senha, Carteira carteira) {
        this.nome = nome;
        this.cpf = cpf;
        this.senha = senha;
        this.carteira = carteira;;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Carteira getCarteira() {
        return carteira;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getSenha() {
        return senha;
    }   

    public void setCarteira(Carteira carteira) {
        this.carteira = carteira;
    }
      
}