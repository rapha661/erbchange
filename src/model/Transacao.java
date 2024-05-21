package model;

import java.util.Date;

class Transacao {
    private String cpf;
    private Date data;
    private String tipo;
    private double valor_total;
    private String moeda;
    private double cotacao;
    private double taxaTransacao;
    private double saldoRealPosTransacao;
    private double saldoBitcoinPosTransacao;
    private double saldoEthereumPosTransacao;
    private double saldoRipplePosTransacao;    
    
    public Transacao(String cpf, Date data, String tipo, double valor_total, String moeda, double cotacao, double taxaTransacao, double saldoRealPosTransacao, double saldoBitcoinPosTransacao, double saldoEthereumPosTransacao, double saldoRipplePosTransacao) {
        this.cpf = cpf;
        this.data = data;
        this.tipo = tipo;
        this.valor_total = valor_total;
        this.moeda = moeda;
        this.cotacao = cotacao;
        this.taxaTransacao = taxaTransacao;
        this.saldoRealPosTransacao = saldoRealPosTransacao;
        this.saldoBitcoinPosTransacao = saldoBitcoinPosTransacao;
        this.saldoEthereumPosTransacao = saldoEthereumPosTransacao;
        this.saldoRipplePosTransacao = saldoRipplePosTransacao;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public double getValor_total() {
        return valor_total;
    }

    public void setValor_total(double valor_total) {
        this.valor_total = valor_total;
    }

    public String getMoeda() {
        return moeda;
    }

    public void setMoeda(String moeda) {
        this.moeda = moeda;
    }

    public double getCotacao() {
        return cotacao;
    }

    public void setCotacao(double cotacao) {
        this.cotacao = cotacao;
    }

    public double getTaxaTransacao() {
        return taxaTransacao;
    }

    public void setTaxaTransacao(double taxaTransacao) {
        this.taxaTransacao = taxaTransacao;
    }

    public double getSaldoRealPosTransacao() {
        return saldoRealPosTransacao;
    }

    public void setSaldoRealPosTransacao(double saldoRealPosTransacao) {
        this.saldoRealPosTransacao = saldoRealPosTransacao;
    }

    public double getSaldoBitcoinPosTransacao() {
        return saldoBitcoinPosTransacao;
    }

    public void setSaldoBitcoinPosTransacao(double saldoBitcoinPosTransacao) {
        this.saldoBitcoinPosTransacao = saldoBitcoinPosTransacao;
    }

    public double getSaldoEthereumPosTransacao() {
        return saldoEthereumPosTransacao;
    }

    public void setSaldoEthereumPosTransacao(double saldoEthereumPosTransacao) {
        this.saldoEthereumPosTransacao = saldoEthereumPosTransacao;
    }

    public double getSaldoRipplePosTransacao() {
        return saldoRipplePosTransacao;
    }

    public void setSaldoRipplePosTransacao(double saldoRipplePosTransacao) {
        this.saldoRipplePosTransacao = saldoRipplePosTransacao;
    }

}