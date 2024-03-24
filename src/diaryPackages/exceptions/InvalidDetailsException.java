package exceptions;

public class InvalidDetailsException extends DiaryNotFoundException{
    public InvalidDetailsException(){
        super("Invalid Username or Password was Provided");
    }
}
