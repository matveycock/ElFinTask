package ru.matveycock.ElFinTask.model;

import lombok.Data;


public class Client {

    private double INN;
    private double region;
    private double capital;

    public double getINN() {
        return INN;
    }

    public void setINN(double INN) {
        this.INN = INN;
    }

    public double getRegion() {
        return region;
    }

    public void setRegion(double region) {
        this.region = region;
    }

    public double getCapital() {
        return capital;
    }

    public void setCapital(double capital) {
        this.capital = capital;
    }
}
