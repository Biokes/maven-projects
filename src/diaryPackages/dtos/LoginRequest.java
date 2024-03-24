package dtos;

public class LoginRequest{
    private String password;
    private String userName;

    public LoginRequest(){
    }

    public LoginRequest(String userName, String password){
        this.userName=userName;
        this.password=password;
    }

    public String getPassword(){
        return password;
    }

    public void setPassword(String password){
        this.password=password;
    }

    public String getUserName(){
        return userName;
    }

    private void setUserName(String userName){
        this.userName=userName;
    }
}
