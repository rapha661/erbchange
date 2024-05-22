package model;

import java.util.HashMap;
import java.util.Map;

public class Carteira {
    private Map<String, Moedas> moedas;

    public Carteira() {
        this.moedas = new HashMap<>();
        this.moedas.put("real", new Real());
        this.moedas.put("bitcoin", new Bitcoin());
        this.moedas.put("ethereum", new Ethereum());
        this.moedas.put("ripple", new Ripple());
    }

    public Map<String, Moedas> getMoedas() {
        return moedas;
    }

    public void setMoedas(Map<String, Moedas> moedas) {
        this.moedas = moedas;
    }

    public void depositar(String moeda, double quantidade) {
        Moedas m = moedas.get(moeda);
        if (m != null) {
            m.depositar(quantidade);
        }
    }

    public void sacar(String moeda, double quantidade) {
        Moedas m = moedas.get(moeda);
        if (m != null) {
            m.sacar(quantidade);
        }
    }

    public double consultarSaldo(String moeda) {
        Moedas m = moedas.get(moeda);
        return m != null ? m.getQuantidade_carteira() : 0.0;
    }
    
    public void setQuantidadeCarteira(String moeda, double quantidade){
        Moedas m = moedas.get(moeda);
        if (m.getQuantidade_carteira() != 0)return;
        m.setQuantidade_carteira(quantidade);
        
    }
}