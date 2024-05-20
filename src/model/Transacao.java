package model;

import java.util.Date;

class Transacao {
    private Date data;
    private double quantidade;
    private String moeda;
    private double custoTransacao;
    private double taxaTransacao;
    private double saldoPosTransacao;

    public Transacao(Date data, double quantidade, String moeda, double custoTransacao, double taxaTransacao, double saldoPosTransacao) {
        this.data = data;
        this.quantidade = quantidade;
        this.moeda = moeda;
        this.custoTransacao = custoTransacao;
        this.taxaTransacao = taxaTransacao;
        this.saldoPosTransacao = saldoPosTransacao;
    }

    @Override
    public String toString() {
        return String.format("%tF %<tR %+,.2f %s CT: %.2f TX: %.2f %s: %.2f", 
                             data, quantidade, moeda, custoTransacao, taxaTransacao, moeda, saldoPosTransacao);
    }

    // Getters para cada campo, se necessário
    public Date getData() {
        return data;
    }

    public double getQuantidade() {
        return quantidade;
    }

    public String getMoeda() {
        return moeda;
    }

    public double getCustoTransacao() {
        return custoTransacao;
    }

    public double getTaxaTransacao() {
        return taxaTransacao;
    }

    public double getSaldoPosTransacao() {
        return saldoPosTransacao;
    }
}

