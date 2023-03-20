package edu.umb.cs680.hw04;
public class SecurityContext {
    int x=0;
    static User user=new User();
   private static SecurityContext ctx=null;
    //SecurityContext ctx;
    public State state;

    public SecurityContext(User user){
        this.state= LoggedOut.getInstance();
    }

    EncryptedString pwd;

    public static SecurityContext getInstance() {
        if(ctx==null){
            ctx=new SecurityContext(user);
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
    void logout()
    {
        state.logout();
    }
    void login(EncryptedString pwd)
    {
        state.login(pwd);
    }

    public State getState(){
        return state;
    }

    public static void main(String[] args) {
        SecurityContext instance = new SecurityContext(new User());
        System.out.println(instance.getState());
    }
}
