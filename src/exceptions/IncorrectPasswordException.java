public class IncorrectPasswordException extends DiaryNotFoundException{
    public IncorrectPasswordException(){
        super("Incorrect password");
    }
}
