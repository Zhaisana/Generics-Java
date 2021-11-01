package eu.glowacki.utp.assignment01.sample;

import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class TeslaTest {
    private static final int CAPACITY = 85;
    public Tesla tesla;

    @BeforeClass
    public static void beforeClass() {
        System.out.println("Tesla parameters were set");
    }

    @Before
    public void before() {
        tesla = new Tesla(1500, 350, "S");
    }

    @Test
    public void aggregate() {
        double aggregate = tesla.aggregate(null);
        Assert.assertEquals(aggregate, CAPACITY, 0.02);
    }

    @Test
    public void deepClone() {
        Tesla clone = tesla.deepClone();
        Assert.assertEquals(tesla.getWeight(), clone.getWeight(), 0.03);
        Assert.assertEquals(tesla.getHorsePower(), clone.getHorsePower(), 0.01);
        Assert.assertEquals(tesla.getModel(), clone.getModel(), "S");
    }
}
