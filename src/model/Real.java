package model;

/**
 *
 * @author rgara
 */

public class Real extends Moedas {
    public Real(double cotacao) {
        super(0, 0, cotacao);  // Sem taxas de compra e venda, e com cotação inicial estática
    }

    @Override
    public double novaCotacao() {
        // Não aplica nenhuma mudança na cotação, já que o foco é usar o Real como uma moeda estável
        return getCotacao();
    }
}

