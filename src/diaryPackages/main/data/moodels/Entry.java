package main.data.moodels;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Data
@Document
public class Entry{
    @Id
    private String id;
    private String author;
    private String body;
    private String title;
    private LocalDate date=LocalDate.now( );

}