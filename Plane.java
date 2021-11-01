package eu.glowacki.utp.assignment01.sample;

import eu.glowacki.utp.assignment01.IAggregable;
import eu.glowacki.utp.assignment01.IDeeplyCloneable;

public class Plane implements IAggregable<Plane, Double>, IDeeplyCloneable<Plane> {
    private double price;
    private Double fuelReduce;
    private String turboEngine;

    public Plane(String turboEngine, double price, double fuelReduce){
        this.price = price;
        this.fuelReduce = fuelReduce;
        this.turboEngine = turboEngine;
    }

    public String getTurboEngine() {
        return turboEngine;
    }

    public double getPrice() {
        return price;
    }

    public double getFuelReduce() {
        return fuelReduce;
    }

    public Double aggregate(Double intermediateResult) {
        if (intermediateResult == null) {
            return fuelReduce;
        }
        fuelReduce += intermediateResult;
        return fuelReduce;
    }

    public Plane deepClone() {
        return new Plane(this.turboEngine, this.price, this.fuelReduce);
    }
}
