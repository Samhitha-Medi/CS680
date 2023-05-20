package edu.umb.cs680.hw09.ModelABC;

import edu.umb.cs680.hw09.Login.EncryptedString;
import edu.umb.cs680.hw09.Login.*;
import edu.umb.cs680.hw09.Login.SecurityContext;
import edu.umb.cs680.hw09.PrintingFramework.Command;

public class PrintJobExecutor extends edu.umb.cs680.hw09.PrintingFramework.PrintJobExecutor {
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
            PrintJob.execute();
            System.out.println("user logged-in(authenticated)");
        }
    }
    public void doErrorHandling(){}
    public static void main(String[] args) {
        PrintJobExecutor ex=new PrintJobExecutor();
        System.out.println("Ex created");

    }

}
