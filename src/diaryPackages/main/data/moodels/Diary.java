package main.data.moodels;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class Diary{
    private boolean isLocked=false;
    @Id
    private String username;
    private String password;
}