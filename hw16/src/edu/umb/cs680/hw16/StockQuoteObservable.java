package edu.umb.cs680.hw16;

import java.util.HashMap;

public class StockQuoteObservable extends Observable{
    HashMap<String,Double>map=new HashMap<String, Double>();
    public void changeQuote(String t, double q){
        map.put(t,q);
        notifyObservers(new StockEvent(t,q));
        System.out.println("StockQuote changed");
    }
    public static void main(String args[]){
        StockQuoteObservable obs=new StockQuoteObservable();
        System.out.println("Stock Quote Example");
    }
}
