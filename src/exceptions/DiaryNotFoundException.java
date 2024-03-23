package exceptions;

public class DiaryNotFoundException extends RuntimeException{
    public DiaryNotFoundException(){
        super("Diary not found.");
    }
}
