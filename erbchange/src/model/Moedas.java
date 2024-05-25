package model;
/**
 *
 * @author rgara
 */

import java.util.Random;

public abstract class Moedas {
    private double taxa_compra, taxa_venda, cotacao, quantidade_carteira;
    protected static final Random random = new Random();

    public Moedas(double taxa_compra, double taxa_venda, double cotacao, double quantidade_carteira) {
        this.taxa_compra = taxa_compra;
        this.taxa_venda = taxa_venda;
        this.cotacao = cotacao;
        this.quantidade_carteira = quantidade_carteira;
    }
    
    public Moedas(double taxa_compra, double taxa_venda, double cotacao) {
        this.taxa_compra = taxa_compra;
        this.taxa_venda = taxa_venda;
        this.cotacao = cotacao;
        this.quantidade_carteira = 0;
    }

    public double getTaxa_compra() {
        return taxa_compra;
    }

    public void setTaxa_compra(double taxa_compra) {
        this.taxa_compra = taxa_compra;
    }

    public double getTaxa_venda() {
        return taxa_venda;
    }

    public void setTaxa_venda(double taxa_venda) {
        this.taxa_venda = taxa_venda;
    }

    public double getCotacao() {
        return cotacao;
    }

    public void setCotacao(double cotacao) {
        this.cotacao = cotacao;
    }

    public double getQuantidade_carteira() {
        return quantidade_carteira;
    }

    public void setQuantidade_carteira(double quantidade_carteira) {
        this.quantidade_carteira = quantidade_carteira;
    }
    
    public abstract double novaCotacao();
}