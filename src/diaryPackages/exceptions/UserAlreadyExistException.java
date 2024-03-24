package exceptions;

public class UserAlreadyExistException extends DiaryNotFoundException{
    public UserAlreadyExistException(){
        super("User Already Exist");
    }
}
