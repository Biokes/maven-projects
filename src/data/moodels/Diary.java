package moodels;

import lombok.Data;

import java.lang.annotation.Documented;

@Data
@Document
public class Diary{
    private boolean isLocked=false;
    @id
    private String username;
    private String password;


}