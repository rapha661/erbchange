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

    // Construtor
    public Investidor(String nome, String cpf, String senha) {
        this.nome = nome;
        this.cpf = cpf;
        this.senha = senha;
        this.carteira = new Carteira();
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

    public boolean validarSenha(String senha) {
        return this.senha.equals(senha);
    }

    public void realizarTransacao(Transacao transacao, String senha) {
        if (validarSenha(senha)) {
            carteira.aplicarTransacao(transacao);
            System.out.println("Transação realizada com sucesso.");
        } else {
            System.out.println("Senha inválida. Transação não realizada.");
        }
    }

    public void imprimirTransacoes(String senha) {
        if (validarSenha(senha)) {
            List<Transacao> transacoes = carteira.obterTransacoes();
            System.out.println("Transações do Investidor " + nome + ":");
            for (Transacao transacao : transacoes) {
                System.out.println(transacao);
            }
        } else {
            System.out.println("Senha inválida. Não foi possível acessar as transações.");
        }
    }
}
