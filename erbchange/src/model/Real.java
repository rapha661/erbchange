package model;
/**
 *
 * @author rgara
 */

public class Real extends Moedas {
    public Real() {
        super(0, 0, 1, 0);
    }

    @Override
    public double novaCotacao() {
        return getCotacao();
    }
}

