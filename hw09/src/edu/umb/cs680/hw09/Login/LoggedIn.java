package edu.umb.cs680.hw09.Login;

public class LoggedIn implements State{
    private SecurityContext ctx;
    private static LoggedIn ins=null;
    LoggedIn(SecurityContext ctx){
        this.ctx=ctx;
    }

    public static LoggedIn getInstance(SecurityContext ctx){

        if (ins==null){
            ins = new LoggedIn(ctx);
        }
        return ins;
    }
    @Override
    public void login(EncryptedString pwd) {
        if(!ctx.isActive()){
            ctx.changeState(LoggedOut.getInstance(ctx));
            ctx.login(pwd);
        }

    }
    @Override
    public void logout() {
        ctx.changeState(LoggedOut.getInstance(ctx));
    }


}
