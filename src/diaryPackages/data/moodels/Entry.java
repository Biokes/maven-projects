package data.moodels;

import java.time.LocalDate;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class Entry{
    @Id
    private int id;
    private String author;
    private String body;
    private String title;
    private LocalDate date=LocalDate.now( );

}