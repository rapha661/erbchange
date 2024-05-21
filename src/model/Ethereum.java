package model;
/**
 *
 * @author rgara
 */

public class Ethereum extends Moedas implements Tarifacao {
    public Ethereum(double cotacao) {
        super(0.01, 0.02, cotacao);
    }

    @Override
    public double novaCotacao() {
        double variacaoPercentual = -0.05 + 0.10 * random.nextDouble();
        double novaCotacao = getCotacao() * (1 + variacaoPercentual);
        setCotacao(novaCotacao);
        return novaCotacao;
    }

    @Override
    public double calcularTaxaCompra(double quantidade) {
        return quantidade * (1 - getTaxa_compra());
    }

    @Override
    public double calcularTaxaVenda(double quantidade) {
        return quantidade * (1 - getTaxa_venda());
    }
}


