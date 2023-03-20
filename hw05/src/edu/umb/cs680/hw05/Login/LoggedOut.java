package edu.umb.cs680.hw05.Login;

import java.util.Objects;

public class LoggedOut implements State {

    private static LoggedOut ins=null;
    static SecurityContext ctx= SecurityContext.getInstance(new User());
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
    public static void setCtx(SecurityContext ctx2) {
        LoggedIn.ctx = ctx2;
    }
    public boolean equals(Object obj) {
        if(this.toString()==obj.toString()){return true;}
        else
            return false;
        //return super.equals(obj);
    }

}

