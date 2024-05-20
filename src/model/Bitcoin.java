package model;
/**
 *
 * @author rgara
 */

public class Bitcoin extends Moedas {
    public Bitcoin(double cotacao) {
        super(0.02, 0.03, cotacao);
    }

    @Override
    public double novaCotacao() {
    double variacaoPercentual = -0.05 + 0.10 * random.nextDouble(); // Corretamente chama `random`
    double novaCotacao = getCotacao() * (1 + variacaoPercentual);
    setCotacao(novaCotacao);
    return novaCotacao;
}

}
