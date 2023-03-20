package edu.umb.cs680.hw05.Login;

public class SecurityContext {
    int x=0;
    static User user=new User();
    private static SecurityContext ctx=null;
    //SecurityContext ctx;
    public State state=LoggedOut.getInstance();

    public SecurityContext(){
        //this.state= LoggedOut.getInstance();
    }

    EncryptedString pwd;

    public static SecurityContext getInstance(User user) {
        if(ctx==null){
            ctx=new SecurityContext();
        }
        return ctx;
    }

    public void changeState(State newState) {
        this.state=newState;
    }

    public boolean isActive() {
        if(x==0) {
            x = 1;
            return true;
        }
        else {
            return false;
        }
    }
    public void logout()
    {
        state.logout();
    }
    public void login(EncryptedString pwd)
    {
        state.login(pwd);
    }

    public State getState(){
        return state;
    }

//    public static void main(String[] args) {
//        SecurityContext instance = new SecurityContext(new User());
//        System.out.println(instance.getState());
//    }
}
