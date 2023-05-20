package edu.umb.cs680.hw16;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StockQuoteObservableTest {
    StockQuoteObservable a=new StockQuoteObservable();
    LineChartObserver b=new LineChartObserver();
    T3DObserver c=new T3DObserver();
    TableObserver d=new TableObserver();

    @Test
    public void test_With_LE(){
        Observer quotelc=((sender, event) -> {System.out.println("LineChartObserver notified");});
        a.addObserver(quotelc);
        Observer quote3d=((sender, event) -> {System.out.println("3DObeserver notified");});
        a.addObserver(quote3d);
        Observer quotetb=((sender, event) -> {System.out.println("TableObeserver notified");});
        a.addObserver(quotetb);
        a.changeQuote("quote1",20000);
        System.out.println();
        a.changeQuote("quote2",100000);
        assertEquals(3,a.getObservers().size());
        a.removeObserver(quotelc);
        a.removeObserver(quote3d);
        a.removeObserver(quotetb);
    }

}