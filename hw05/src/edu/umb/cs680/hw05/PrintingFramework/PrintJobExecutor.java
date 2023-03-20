package edu.umb.cs680.hw05.PrintingFramework;

import edu.umb.cs680.hw05.Login.*;

public abstract class PrintJobExecutor {
    public void execute( PrintJob job,EncryptedString pwd, SecurityContext ctx){
        try {
            doAuthentication(pwd, ctx);
            doAccessControl();
            doPrint(ctx);
            doErrorHandling();
           // return true;
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
    public void doAuthentication(EncryptedString pwd,SecurityContext ctx){}
    public void doAccessControl(){}
    public void doPrint(SecurityContext ctx){}
    public void doErrorHandling(){}
}
