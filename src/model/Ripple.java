package model;
/**
 *
 * @author rgara
 */

public class Ripple extends Moedas {
    public Ripple(double cotacao) {
        super(0.01, 0.01, cotacao);
    }

    @Override
    public double novaCotacao() {
        double variacaoPercentual = -0.05 + 0.10 * random.nextDouble();
        double novaCotacao = getCotacao() * (1 + variacaoPercentual);
        setCotacao(novaCotacao);
        return novaCotacao;
    }
}
