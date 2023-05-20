package edu.umb.cs680.hw09.ModelABC;

import java.util.Objects;

public class Printer {
    private static Printer ins=null;
    public static Printer getInstance(){
        try{
            return Objects.requireNonNull(ins);
        }
        catch(NullPointerException ex) {
            ins = new Printer();
            return ins;
        }
    }

    public static void print() {

        System.out.println("Printers Print");
    }

}
