package model;
/**
 *
 * @author rgara
 */

public interface Tarifacao {
    double calcularTaxaCompra(double quantidade);
    double calcularTaxaVenda(double quantidade);
}
