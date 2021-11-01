package eu.glowacki.utp.assignment01.sample;

import eu.glowacki.utp.assignment01.IAggregable;
import eu.glowacki.utp.assignment01.IDeeplyCloneable;

public class Tesla implements IAggregable<Tesla, Integer>, IDeeplyCloneable<Tesla> {

    private double weight;
    private double horsePower;
    private String model;
    private Battery battery;

    public Tesla(double weight, double horsePower, String model) {
        this.weight = weight;
        this.horsePower = horsePower;
        this.model = model;
        this.battery = new Battery(85);
    }

    public double getWeight() {
        return weight;
    }

    public double getHorsePower() {
        return horsePower;
    }

    public String getModel() {
        return model;
    }

    public Integer aggregate(Integer intermediateResult) {
        if  (intermediateResult == null) {
            return battery.getStorageCapacity();
        }
        battery.charge(intermediateResult);
        return battery.getStorageCapacity();
    }

    public Tesla deepClone() {
        Tesla clone = new Tesla(this.weight,this.horsePower,this.model);
        clone.battery = new Battery(battery.getStorageCapacity());
        return clone;
    }
}