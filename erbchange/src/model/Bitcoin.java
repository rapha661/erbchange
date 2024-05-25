package model;
/**
 *
 * @author rgara
 */

public class Bitcoin extends Moedas implements Tarifacao {
    public Bitcoin() {
        super(0.02, 0.03, 364235, 0);
    }

    @Override
    public double novaCotacao() {
        double variacaoPercentual = -0.05 + 0.10 * random.nextDouble();
        double novaCotacao = getCotacao() * (1 + variacaoPercentual);
        System.out.println("Atualizando Bitcoin de " + getCotacao() + " para " + novaCotacao);
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

