package edu.umb.cs680.hw16;

public class LineChartObserver implements Observer{

    @Override
    public void update(Observable sender, Object event) {
        System.out.println("LineChartObserver notified");
    }
}
