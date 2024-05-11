package model;

/**
 *
 * @author rgara
 */
public class Investidor {
    
    private String nome, cpf, senha;
    private int carteira;
    
    public Investidor(){
    }
    
    public Investidor(String nome, String cpf, String senha, Integer carteira){
        this.nome = nome;
        this.cpf = cpf;
        this.senha = senha;
        this.carteira = carteira;
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

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public int getCarteira() {
        return carteira;
    }

    public void setCarteira(int carteira) {
        this.carteira = carteira;
    }
    
    
}
