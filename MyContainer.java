package eu.glowacki.utp.assignment01.sample;

import eu.glowacki.utp.assignment01.IAggregable;
import eu.glowacki.utp.assignment01.IContainer;
import eu.glowacki.utp.assignment01.IDeeplyCloneable;

import java.util.ArrayList;
import java.util.List;

public class MyContainer <TElement extends
        IAggregable<TElement, TAggregateResult> & IDeeplyCloneable<TElement>, TAggregateResult>
        implements IContainer<TElement, TAggregateResult> {

    private ArrayList<TElement> elements;

    public MyContainer(ArrayList<TElement> elements) {
        this.elements = elements;
    }

    public void add(TElement elementT) {
        elements.add(elementT);
    }

    @Override
    public List<TElement> elements() {
        return elements;
    }

    @Override
    public TAggregateResult aggregateAllElements() {
        TAggregateResult sum = null;
        for(TElement elem: elements) {
            sum = elem.aggregate(sum);
        }
        return sum;
    }

    @Override
    public TElement cloneElementAtIndex(int index) throws ArrayIndexOutOfBoundsException {
        if (index > elements.size())
            throw new ArrayIndexOutOfBoundsException();
        return elements.get(index).deepClone();

    }
}