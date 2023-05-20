package edu.umb.cs680.hw16;

public class TableObserver implements Observer{
    String ticker;
    double quote;
    @Override
    public void update(Observable sender, Object event) {
        //public StockEvent event=new StockEvent("new",10);
        ticker=((StockEvent)event).getTicker();
        quote=((StockEvent)event).getQuote();
        System.out.println("TableObserver Notified ");
    }
}
