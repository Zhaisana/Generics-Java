package eu.glowacki.utp.assignment01.sample;

import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class PlaneTest {
    private static final int PRICE = 70;
    public Plane plane;

    @BeforeClass
    public static void beforeClass() {
        System.out.println("Plane parameters were set");
    }

    @Before
    public void before() {
        plane = new Plane("Boeing", 150.00, 70);
    }

    @Test
    public void aggregate() {
        double aggregate = plane.aggregate(null);
        Assert.assertEquals(aggregate,PRICE,0.01);
    }

    @Test
    public void deepClone () {
        Plane clone = plane.deepClone();
        Assert.assertEquals(plane.getPrice(), clone.getPrice(), 0.05);
        Assert.assertEquals(plane.getFuelReduce(), clone.getFuelReduce(), 0.03);
        Assert.assertEquals(plane.getTurboEngine(), clone.getTurboEngine(), "Boeing");

    }



}

