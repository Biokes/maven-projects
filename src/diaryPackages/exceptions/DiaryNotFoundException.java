package exceptions;

public class DiaryNotFoundException extends RuntimeException{
    public DiaryNotFoundException(String error){
        super(error);
    }
    public DiaryNotFoundException(){
        super("Diary not found.");
    }
}
