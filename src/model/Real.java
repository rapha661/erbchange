package model;
/**
 *
 * @author rgara
 */

public class Real extends Moedas {
    public Real(double cotacao) {
        super(0, 0, cotacao);
    }

    @Override
    public double novaCotacao() {
        return getCotacao();
    }
}

