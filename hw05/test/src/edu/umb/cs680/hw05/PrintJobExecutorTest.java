package edu.umb.cs680.hw05;

import edu.umb.cs680.hw05.Login.EncryptedString;
import edu.umb.cs680.hw05.Login.SecurityContext;
import edu.umb.cs680.hw05.Login.User;
import edu.umb.cs680.hw05.ModelABC.PrintJobExecutor;
import edu.umb.cs680.hw05.PrintingFramework.PrintJob;
import org.junit.jupiter.api.Test;

class PrintJobExecutorTest {
    @Test
    void test_Model_ABC(){
        edu.umb.cs680.hw05.ModelABC.PrintJobExecutor ex=new edu.umb.cs680.hw05.ModelABC.PrintJobExecutor();
        SecurityContext c=SecurityContext.getInstance(new User());
        EncryptedString pwd=new EncryptedString();
        c.login(pwd);
        System.out.println(c.getState());
        ex.execute(new PrintJob(),pwd,c);
    }
    @Test
    void test_exception(){
        edu.umb.cs680.hw05.ModelABC.PrintJobExecutor ex2=new edu.umb.cs680.hw05.ModelABC.PrintJobExecutor();
        SecurityContext ctx=SecurityContext.getInstance(new User());
        ex2.execute(new PrintJob(),new EncryptedString(), ctx);
        ctx.logout();

    }
    @Test
    void test_Model_XYZ(){
        edu.umb.cs680.hw05.ModelXYZ.PrintJobExecutor ex1=new edu.umb.cs680.hw05.ModelXYZ.PrintJobExecutor();
        ex1.execute(new PrintJob(),null, null);

    }

}