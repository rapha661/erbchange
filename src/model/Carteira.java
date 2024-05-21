package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Date;

public class Carteira {
    private double saldoBRL;
    private double saldoBTC;
    private double saldoETH;
    private double saldoXRP;
    private List<Transacao> transacoes;

    private Bitcoin saldoBitcoin;
    private Ethereum saldoEthereum;
    private Ripple saldoRipple;
    private Real saldoReal;

    public Carteira() {
        this.saldoBRL = 0;
        this.saldoBTC = 0;
        this.saldoETH = 0;
        this.saldoXRP = 0;
        this.transacoes = new ArrayList<>();
        this.saldoBitcoin = new Bitcoin(364235);
        this.saldoEthereum = new Ethereum(18898);
        this.saldoRipple = new Ripple(2.77);      
        this.saldoReal = new Real(1);            
    }

    private Moedas obterMoeda(String moeda) {
        switch (moeda) {
            case "BTC":
                return saldoBitcoin;
            case "ETH":
                return saldoEthereum;
            case "XRP":
                return saldoRipple;
            case "BRL":
                return saldoReal;
            default:
                return null;
        }
    }

    public void aplicarTransacao(Transacao transacaoOriginal) {
        double quantidade = transacaoOriginal.getQuantidade();
        Moedas moeda = obterMoeda(transacaoOriginal.getMoeda());
        if (moeda == null) {
            System.out.println("Erro: Moeda desconhecida " + transacaoOriginal.getMoeda());
            return; 
        }
        
        if (quantidade > 0) {
            quantidade = moeda.calcularTaxaCompra(quantidade);
        } else {
            quantidade = moeda.calcularTaxaVenda(quantidade);
        }

        double custoTransacao = calcularCustoTransacao(quantidade, transacaoOriginal.getMoeda());
        double taxaTransacao = calcularTaxaTransacao(quantidade, transacaoOriginal.getMoeda());
        double saldoPosTransacao = calcularSaldoPosTransacao(transacaoOriginal.getMoeda(), quantidade);

        Transacao novaTransacao = new Transacao(transacaoOriginal.getData(), quantidade, transacaoOriginal.getMoeda(), custoTransacao, taxaTransacao, saldoPosTransacao);
        adicionarTransacao(novaTransacao);
    }

    private double calcularCustoTransacao(double quantidade, String moeda) {
        return Math.abs(quantidade) * 0.005;
    }

    private double calcularTaxaTransacao(double quantidade, String moeda) {
        return Math.abs(quantidade) * 0.002;
    }

    private double calcularSaldoPosTransacao(String moeda, double quantidade) {
        switch (moeda) {
            case "BRL":
                return saldoBRL + quantidade;
            case "BTC":
                return saldoBTC + quantidade;
            case "ETH":
                return saldoETH + quantidade;
            case "XRP":
                return saldoXRP + quantidade;
            default:
                return 0;
        }
    }

    private void adicionarTransacao(Transacao transacao) {
        switch (transacao.getMoeda()) {
            case "BRL":
                saldoBRL += transacao.getQuantidade();
                break;
            case "BTC":
                saldoBTC += transacao.getQuantidade();
                break;
            case "ETH":
                saldoETH += transacao.getQuantidade();
                break;
            case "XRP":
                saldoXRP += transacao.getQuantidade();
                break;
        }
        transacoes.add(transacao);
    }

    public List<Transacao> obterTransacoes() {
        return transacoes;
    }
}
