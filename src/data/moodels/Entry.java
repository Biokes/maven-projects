package moodels;

import java.time.LocalDate;

public class Entry{
    private String author;
    private String body;
    private int id;
    private String title;
    private LocalDate date=LocalDate.now( );
    public String getAuthor(){
        return this.author;
    }

    public String getBody(){
        return body;
    }

    public void setBody(String body){
        this.body=body;
    }

    public String getTitle(){
        return title;
    }

    public void setTitle(String title){
        this.title=title;
    }

    public int getId(){
        return id;
    }
    public LocalDate getDateCreated(){
        return this.date;
    }
    public void setDateCreated(LocalDate dateGiven){
        this.date  = dateGiven;
    }

    public void setId(int id){
        this.id=id;
    }

    public String toString(){
        return String.format(
                """
                        Entry id : %s
                        Title : %s
                        Body : %s
                        Author : %s
                        Date Created : %s.""",
                getId( ), getTitle( ), getBody( ),getAuthor(), this.date);
    }

    public void setAuthor(String author){
        this.author = author;
    }
}