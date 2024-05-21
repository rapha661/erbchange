package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Carteira {
    private Map<String, Moedas> moedas;

    public Carteira() {
        
        this.moedas.put("BRL", new Real());
        this.moedas.put("BTC", new Bitcoin());
        this.moedas.put("ETH", new Ethereum());
        this.moedas.put("XRP", new Ripple());
    }

    public Map<String, Moedas> getMoedas() {
        return moedas;
    }

    public void setMoedas(Map<String, Moedas> moedas) {
        this.moedas = moedas;
    }  
}