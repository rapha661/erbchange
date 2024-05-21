package model;
/**
 *
 * @author rgara
 */

import java.util.Random;

public abstract class Moedas {
    private double taxa_compra, taxa_venda, cotacao;
    protected static final Random random = new Random();

    public Moedas(double taxa_compra, double taxa_venda, double cotacao) {
        this.taxa_compra = taxa_compra;
        this.taxa_venda = taxa_venda;
        this.cotacao = cotacao;
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

    public abstract double novaCotacao();
}