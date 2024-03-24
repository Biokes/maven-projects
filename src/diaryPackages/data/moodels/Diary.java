package data.moodels;

import lombok.Data;

import java.lang.annotation.Documented;

@Data
public class Diary{
    private boolean isLocked=false;
    private String username;
    private String password;


}