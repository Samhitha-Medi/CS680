package edu.umb.cs680.hw05.ModelABC;

import edu.umb.cs680.hw05.Login.EncryptedString;
import edu.umb.cs680.hw05.Login.*;
import edu.umb.cs680.hw05.Login.SecurityContext;
import edu.umb.cs680.hw05.PrintingFramework.PrintJob;

public class PrintJobExecutor extends edu.umb.cs680.hw05.PrintingFramework.PrintJobExecutor {
    @Override
    public void doAuthentication(EncryptedString pwd, SecurityContext ctx){
        try{
            ctx.login(pwd);
            if(ctx.getState()instanceof LoggedIn){
        }
            else {
                throw new Exception("cannot login");
            }
    }
        catch(Exception e) {
            System.out.println(e);
        }
    }
    public void doAccessControl(){}
    public void doPrint(SecurityContext ctx){
        if(ctx.getState()instanceof LoggedIn){
            System.out.println("user logged-in(authenticated)");
        }
        else{}
    }
    public void doErrorHandling(){}
    public static void main(String[] args) {
        PrintJobExecutor abc=new PrintJobExecutor();
        PrintJob job=new PrintJob();
        EncryptedString pwd= new EncryptedString();
        SecurityContext ctx=SecurityContext.getInstance(new User());
        abc.execute(job,pwd,ctx);
        System.out.println("ABC");
    }

}
