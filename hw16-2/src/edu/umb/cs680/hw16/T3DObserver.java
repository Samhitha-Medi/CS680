package edu.umb.cs680.hw16;

public class T3DObserver implements Observer{
    @Override
    public void update(Observable sender, Object event) {
        System.out.println("3DOberserver notified");
    }
}
