package edu.umb.cs680.hw09.Login;
public class SecurityContext {
    int x=0;
    User user;

    //SecurityContext ctx;
    State state;

    public SecurityContext(User user){

        this.state= LoggedOut.getInstance(this);
    }

    EncryptedString pwd;


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

    public static void main(String[] args) {
        SecurityContext instance = new SecurityContext(new User());
        System.out.println(instance.getState());
    }
}
