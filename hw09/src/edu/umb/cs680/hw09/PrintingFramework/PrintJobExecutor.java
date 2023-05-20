package edu.umb.cs680.hw09.PrintingFramework;

import edu.umb.cs680.hw09.Login.*;

public abstract class PrintJobExecutor {
    public void execute( Command job,EncryptedString pwd, SecurityContext ctx){
        try {
            doAuthentication(pwd, ctx);
            doAccessControl();
            // return true;
        }
        catch(Exception e)
        {
            doErrorHandling();
            System.out.println(e);
        }
        doPrint(ctx);

    }
    public void doAuthentication(EncryptedString pwd,SecurityContext ctx){}
    public void doAccessControl(){}
    public void doPrint(SecurityContext ctx){

    }
    public void doErrorHandling(){}

    public static void main(String args[]){
        System.out.println("Print Job Executor");
    }
}
