package edu.umb.cs680.hw09.PrintingFramework;

import edu.umb.cs680.hw09.Login.EncryptedString;
import edu.umb.cs680.hw09.Login.LoggedIn;
import edu.umb.cs680.hw09.Login.SecurityContext;
import edu.umb.cs680.hw09.Login.User;
import edu.umb.cs680.hw09.ModelABC.PrintJob;
import edu.umb.cs680.hw09.ModelABC.PrintJobExecutor;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PrintJobExecutorTest {
    @Test
    public void test()
    {
        edu.umb.cs680.hw09.ModelABC.PrintJobExecutor ex=new PrintJobExecutor();
        Command newjob=new PrintJob();
        EncryptedString pwd=new EncryptedString();
        SecurityContext ctx=new SecurityContext(new User());
        ex.execute(newjob,pwd,ctx);
        boolean a= ctx.getState()instanceof LoggedIn;
        assertFalse(!a);
        ctx.logout();
    }

}