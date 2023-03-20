package edu.umb.cs680.hw05.Login;

public class LoggedIn implements State{
    private static LoggedIn ins=null;
    static SecurityContext ctx=SecurityContext.getInstance(new User());
    public LoggedIn(SecurityContext ctx){}

    public static LoggedIn getInstance(){

        if (ins==null){
            ins = new LoggedIn(ctx);
        }
        return ins;
    }
    @Override
    public void login(EncryptedString pwd) {
        if(!ctx.isActive()){
            ctx.changeState(LoggedOut.getInstance());
            ctx.login(pwd);
        }

    }
    @Override
    public void logout() {
        ctx.changeState(LoggedOut.getInstance());
    }
    public void setCtx(SecurityContext ctx2) {
        LoggedIn.ctx = ctx2;
    }

    @Override
    public boolean equals(Object obj) {
        if(this.toString()==obj.toString()){return true;}
        else
            return false;
        //return super.equals(obj);
    }
}
