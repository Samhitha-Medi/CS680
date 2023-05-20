package edu.umb.cs680.hw16;

public class StockEvent {
    String ticker;
    double quote;
    public StockEvent(String ticker,double quote){

    }

    public double getQuote() {
        return quote;
    }

    public String getTicker() {
        return ticker;
    }
}
