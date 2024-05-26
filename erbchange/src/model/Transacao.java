package model;

import java.time.LocalDateTime;

public class Transacao {
    private LocalDateTime dataHora;
    private String tipo;
    private double valorTotal;
    private String moeda;
    private double cotacao;
    private double taxa;
    private double saldoReal;
    private double saldoBitcoin;
    private double saldoEthereum;
    private double saldoRipple;
    private final String cpf;

    // Construtor completo
    public Transacao(String cpf,LocalDateTime dataHora, String tipo, double valorTotal, String moeda, 
                     double cotacao, double taxa, double saldoReal, double saldoBitcoin, 
                     double saldoEthereum, double saldoRipple) {
        this.cpf = cpf;
        this.dataHora = dataHora;
        this.tipo = tipo;
        this.valorTotal = valorTotal;
        this.moeda = moeda;
        this.cotacao = cotacao;
        this.taxa = taxa;
        this.saldoReal = saldoReal;
        this.saldoBitcoin = saldoBitcoin;
        this.saldoEthereum = saldoEthereum;
        this.saldoRipple = saldoRipple;
    }

    // Getters e Setters

    public String getCpf() {
        return cpf;
    }
    
    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public void setDataHora(LocalDateTime dataHora) {
        this.dataHora = dataHora;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
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

    public double getTaxa() {
        return taxa;
    }

    public void setTaxa(double taxa) {
        this.taxa = taxa;
    }

    public double getSaldoReal() {
        return saldoReal;
    }

    public void setSaldoReal(double saldoReal) {
        this.saldoReal = saldoReal;
    }

    public double getSaldoBitcoin() {
        return saldoBitcoin;
    }

    public void setSaldoBitcoin(double saldoBitcoin) {
        this.saldoBitcoin = saldoBitcoin;
    }

    public double getSaldoEthereum() {
        return saldoEthereum;
    }

    public void setSaldoEthereum(double saldoEthereum) {
        this.saldoEthereum = saldoEthereum;
    }

    public double getSaldoRipple() {
        return saldoRipple;
    }

    public void setSaldoRipple(double saldoRipple) {
        this.saldoRipple = saldoRipple;
    }
    
    
}
