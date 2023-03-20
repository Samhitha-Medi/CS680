package edu.umb.cs680.hw04;
import java.util.Objects;

public class LoggedOut implements State {

    private static LoggedOut ins=null;
    private static SecurityContext ctx= SecurityContext.getInstance();
    public LoggedOut(SecurityContext ctx){}
    public static LoggedOut getInstance(){
        try{
            return Objects.requireNonNull(ins);
        }
        catch(NullPointerException ex) {
            ins = new LoggedOut(ctx);
            return ins;
        }
    }
    @Override
    public void login(EncryptedString pwd) {
        if(Authenticator.authenticate(ctx,pwd)){
            ctx.changeState( new LoggedIn(ctx));
        }

        else {
            System.out.println("Error in login");
        }

    }
    @Override
    public void logout() {
    }
    public void setCtx(SecurityContext ctx) {
        this.ctx = ctx;
    }
    public boolean equals(Object obj) {
        if(this.toString()==obj.toString()){return true;}
        else
            return false;
        //return super.equals(obj);
    }

}
