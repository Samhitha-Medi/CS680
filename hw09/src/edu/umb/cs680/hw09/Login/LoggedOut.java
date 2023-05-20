package edu.umb.cs680.hw09.Login;
import java.util.Objects;

public class LoggedOut implements State {

    private static LoggedOut ins = null;
    private SecurityContext ctx;

    private LoggedOut(SecurityContext ctx) {
        this.ctx = ctx;
    }

    public static LoggedOut getInstance(SecurityContext ctx) {
        try {
            return Objects.requireNonNull(ins);
        } catch (NullPointerException ex) {
            ins = new LoggedOut(ctx);
            return ins;
        }
    }

    @Override
    public void login(EncryptedString pwd) {
        if (Authenticator.authenticate(ctx, pwd)) {
            ctx.changeState(new LoggedIn(this.ctx));
        } else {
            System.out.println("Error in login");
        }

    }

    @Override
    public void logout() {
    }


}
