package data.moodels;

import lombok.Data;

@Data
public class Diary{
    private boolean isLocked=false;
    private String username;
    private String password;

    public boolean isLocked(){
        return isLocked;
    }

    public void setLocked(boolean locked){
        isLocked=locked;
    }

    public String getUsername(){
        return username;
    }

    public void setUsername(String username){
        this.username=username;
    }

    public String getPassword(){
        return password;
    }

    public void setPassword(String password){
        this.password=password;
    }
}