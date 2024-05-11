/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.Random;

/**
 *
 * @author rgara
 */
public class Ripple extends Moedas implements Tarifacao {

    public Ripple(double cotacao, double taxaCompra, double taxaVenda) {
        super();
        setTaxaCompra(taxaCompra);
        setTaxaVenda(taxaVenda);
        setCotacao(cotacao);
    }

    double baseValue = 1.0;
    Random rand = new Random();
    double randomCot = baseValue * (1 + (rand.nextDouble() * 0.10 - 0.05));
    
    @Override
    public double novaCotacao() {
        double novaCotacao = getCotacao() * randomCot;
        setCotacao(novaCotacao);
        return novaCotacao;
    }

    @Override
    public double getTaxaCompra() {
        return super.getTaxa_compra();
    }

    @Override
    public void setTaxaCompra(double taxaCompra) {
        super.setTaxa_compra(taxaCompra); 
    }

    public void setTaxaVenda(double taxaVenda) {
        super.setTaxa_venda(taxaVenda);
    }

    public double getTaxaVenda() {
        return super.getTaxa_venda();
    }
}