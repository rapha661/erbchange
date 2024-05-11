package model;

/**
 *
 * @author rgara
 */
public class Carteira {
    private Integer id;
    private double real, bitcoin, etherium, ripple;

    public Carteira(Integer id, double bitcoin, double etherium, double ripple) {
        this.id = id;
        this.bitcoin = bitcoin;
        this.etherium = etherium;
        this.ripple = ripple;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public double getReal() {
        return real;
    }

    public void setReal(double real) {
        this.real = real;
    }

    public double getBitcoin() {
        return bitcoin;
    }

    public void setBitcoin(double bitcoin) {
        this.bitcoin = bitcoin;
    }

    public double getEtherium() {
        return etherium;
    }

    public void setEtherium(double etherium) {
        this.etherium = etherium;
    }

    public double getRipple() {
        return ripple;
    }

    public void setRipple(double ripple) {
        this.ripple = ripple;
    }

    
    
}
