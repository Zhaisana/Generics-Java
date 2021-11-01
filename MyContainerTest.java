package eu.glowacki.utp.assignment01.sample;

import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;

import java.util.ArrayList;

public class MyContainerTest {
    private Plane plane1;
    private Plane plane2;

    private MyContainer<Plane, Double> contPlane;
    private ArrayList<Plane> arrPlane;

    @Before
    public void before() {
        arrPlane = new ArrayList<>();
        contPlane = new MyContainer<>(arrPlane);
        plane1 = new Plane("Airbus", 360, 150);
        plane2 = new Plane("Mria", 500, 400);
        contPlane.add(plane1);
        contPlane.add(plane2);
        arrPlane.add(plane1);
        arrPlane.add(plane2);
    }

    @Test
    public void elements(){
        ArrayList<Plane> arrP = new ArrayList<>();
        arrP.add(plane1);
        arrP.add(plane2);
        Assert.assertEquals(arrP.get(0).getPrice(), contPlane.elements().get(0).getPrice(), 0.01);
        Assert.assertEquals(arrP.get(1).getPrice(), contPlane.elements().get(1).getPrice(), 0.01);
    }

    @Test
    public void cloneElementAtIndex() {
        Plane clonePlane1 = contPlane.cloneElementAtIndex(0);
        Plane clonePlane2 = contPlane.cloneElementAtIndex(1);
        Assert.assertEquals(contPlane.elements().get(0).getFuelReduce(), clonePlane1.getFuelReduce(), 0.01);
        Assert.assertEquals(contPlane.elements().get(1).getFuelReduce(), clonePlane2.getFuelReduce(), 0.01);
        Assert.assertNotSame(contPlane.elements().get(0), clonePlane1);
        Assert.assertNotSame(contPlane.elements().get(1), clonePlane2);
    }

    @Test
    public void aggregatableElements() {
        Double aggregator = contPlane.aggregateAllElements();
        Double number = null;
        for (Plane p: arrPlane) {
            number = p.aggregate(number);
        }
        Assert.assertEquals(number, aggregator);
    }


}
