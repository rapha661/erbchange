package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Date;

class Carteira {
    private double saldoBRL;
    private double saldoBTC;
    private double saldoETH;
    private double saldoXRP;
    private List<Transacao> transacoes;

    public Carteira() {
        this.saldoBRL = 0;
        this.saldoBTC = 0;
        this.saldoETH = 0;
        this.saldoXRP = 0;
        this.transacoes = new ArrayList<>();
    }

    public void aplicarTransacao(Transacao transacaoOriginal) {
        double quantidade = transacaoOriginal.getQuantidade();
        String moeda = transacaoOriginal.getMoeda();
        Date data = transacaoOriginal.getData();

        if (quantidade > 0) {
            quantidade = aplicarTaxaCompra(moeda, quantidade);
        } else {
            quantidade = aplicarTaxaVenda(moeda, quantidade);
        }

        double custoTransacao = calcularCustoTransacao(quantidade, moeda);
        double taxaTransacao = calcularTaxaTransacao(quantidade, moeda);
        double saldoPosTransacao = calcularSaldoPosTransacao(moeda, quantidade);

        Transacao novaTransacao = new Transacao(data, quantidade, moeda, custoTransacao, taxaTransacao, saldoPosTransacao);
        adicionarTransacao(novaTransacao);
    }

    private double aplicarTaxaCompra(String moeda, double quantidade) {
        switch (moeda) {
            case "BTC":
                return quantidade * (1 - 0.02); 
            case "ETH":
                return quantidade * (1 - 0.01);
            case "XRP":
                return quantidade * (1 - 0.01);
            default:
                return quantidade;
        }
    }

    private double aplicarTaxaVenda(String moeda, double quantidade) {
        switch (moeda) {
            case "BTC":
                return quantidade * (1 - 0.03);
            case "ETH":
                return quantidade * (1 - 0.02); 
            case "XRP":
                return quantidade * (1 - 0.01);
            default:
                return quantidade;
        }
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

