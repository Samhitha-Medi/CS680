package edu.umb.cs680.hw16;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StockQuoteObservableTest {

    StockQuoteObservable a=new StockQuoteObservable();
    LineChartObserver b=new LineChartObserver();
    T3DObserver c=new T3DObserver();
    TableObserver d=new TableObserver();

    @Test
    public void test_1() {
        //adding observers
        a.addObserver(b);
        a.addObserver(c);
        a.addObserver(d);
        //changing Quote
        a.changeQuote("newquote",200);
        assertEquals(3,a.getObservers().size());
        a.clearObservers();
    }
    @Test
    public void test_2() {
        //adding observers
        a.addObserver(b);
        a.addObserver(c);
        a.addObserver(d);
        //changing Quote
        System.out.println();
        a.changeQuote("quote-2",20000);
        assertEquals(3,a.getObservers().size());
        a.clearObservers();
    }

}