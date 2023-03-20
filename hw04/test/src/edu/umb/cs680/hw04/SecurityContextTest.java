package edu.umb.cs680.hw04;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SecurityContextTest {
    SecurityContext ctx = new SecurityContext(new User());

    @Test
    void test_1_initial(){
        //SecurityContext context = new SecurityContext(new User());
        boolean check_ins=this.ctx.getState() instanceof LoggedOut;
        assertTrue(check_ins);
    }

    @Test
    void test_2_login()
    {
        SecurityContext ctx2=SecurityContext.getInstance();
        EncryptedString pwd = new EncryptedString();
        ctx2.login(pwd);
        //System.out.println(ctx2.getState());
        assertTrue(ctx2.getState() instanceof LoggedIn);
    }

    @Test
    void test_3_Equality()
    {
        SecurityContext ctx1=SecurityContext.getInstance();
        SecurityContext ctx3=SecurityContext.getInstance();
        assertEquals(ctx1,ctx3);
    }
    @Test
    void test_4_transitions(){
        SecurityContext ctx4=SecurityContext.getInstance();
        ctx4.login(new EncryptedString());
        //System.out.println(ctx4.getState());
        assertFalse(ctx4.getState() instanceof LoggedOut);
        ctx4.logout();
        assertTrue(ctx4.getState() instanceof LoggedOut);
        ctx4.login(new EncryptedString());
        assertTrue(ctx4.getState() instanceof LoggedIn);
        ctx4.login(new EncryptedString());
        assertTrue(ctx4.getState() instanceof LoggedIn);
        ctx4.logout();
        assertTrue(ctx4.getState() instanceof LoggedOut);

    }
}