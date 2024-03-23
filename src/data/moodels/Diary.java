package moodels;


public class Diary{
    private boolean isLocked=false;
    private String username;
    private String password;

    public String getPassword(){
        return password;
    }

    public void setPassword(String password){
        this.password=password;
    }

    public String getUserName(){
        return this.username;
    }

    public void setUsername(String username){
        this.username=username;
    }

    public boolean isLocked(){
        return isLocked;
    }

    public void isLocked(boolean condition){
        isLocked=condition;
    }

}