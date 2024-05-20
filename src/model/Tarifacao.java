package model;

public class Tarifacao {

    // Calcula a taxa de compra com base no montante e na taxa
    public static double calcularTaxaCompra(double quantidade, double taxaCompra) {
        return quantidade * taxaCompra;
    }

    // Calcula a taxa de venda com base no montante e na taxa
    public static double calcularTaxaVenda(double quantidade, double taxaVenda) {
        return quantidade * taxaVenda;
    }
}
