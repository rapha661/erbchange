package model;

/**
 *
 * @author rgara
 */
public class Moedas {
    private double real, btc, eth,xrp;
    
    public Moedas(){
    }

    public Moedas(double real, double btc, double eth, double xrp) {
        this.real = real;
        this.btc = btc;
        this.eth = eth;
        this.xrp = xrp;
    }

    public double getReal() {
        return real;
    }

    public void setReal(double real) {
        this.real = real;
    }

    public double getBtc() {
        return btc;
    }

    public void setBtc(double btc) {
        this.btc = btc;
    }

    public double getEth() {
        return eth;
    }

    public void setEth(double eth) {
        this.eth = eth;
    }

    public double getXrp() {
        return xrp;
    }

    public void setXrp(double xrp) {
        this.xrp = xrp;
    }
    
    
}
