package edu.umb.cs680.hw09.ModelABC;

import edu.umb.cs680.hw09.PrintingFramework.Command;

public class PrintJob implements Command {
    Command newjob;
    public PrintJob() {

        this.newjob=newjob;
    }



    public static void execute() {
        Printer.print();
    }
}
