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
    
    public void depositar(double quantidade) {
        double novoSaldo = this.getQuantidade_carteira() + quantidade;
        this.setQuantidade_carteira(novoSaldo);
    }

    public double consultarSaldo() {
        return this.getQuantidade_carteira();
    }
}

