package eu.glowacki.utp.assignment01.sample;

public class Battery {

    private int storageCapacity;

    public Battery(int capacity){
        this.storageCapacity = capacity;
    }

    public void charge(int capacity){
        this.storageCapacity += capacity;

    }

    public int getStorageCapacity(){
        return storageCapacity;
    }
}
