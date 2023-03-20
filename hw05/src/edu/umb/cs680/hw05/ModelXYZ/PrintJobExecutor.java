package edu.umb.cs680.hw05.ModelXYZ;

import edu.umb.cs680.hw05.Login.*;

public class PrintJobExecutor extends edu.umb.cs680.hw05.PrintingFramework.PrintJobExecutor {
    @Override
    public void doAuthentication(EncryptedString pwd,SecurityContext ctx){
    }
    public void doAccessControl(){}
    public void doPrint(SecurityContext ctx){}
    public void doErrorHandling(){}
}
