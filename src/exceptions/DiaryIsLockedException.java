public class DiaryIsLockedException extends DiaryNotFoundException{
    public DiaryIsLockedException(){
        super("Diary is Locked");
    }
}

