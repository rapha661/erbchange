package model;
/**
 *
 * @author rgara
 */

public interface Tarifacao {
    double novaCotacao();
    double calcularTaxaCompra(double quantidade);
    double calcularTaxaVenda(double quantidade);
}
