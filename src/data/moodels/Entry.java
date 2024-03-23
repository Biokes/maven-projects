package moodels;

import dtos.EntryRequest;

import java.time.LocalDate;

public class Entry{
    private String body;
    private int id;
    private String title;
    private LocalDate date=LocalDate.now( );

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

    public void setId(int id){
        this.id=id;
    }

    public String toString(){
        String output=String.format(
                """
                        Entry id : %s
                        Title : %s
                        Body : %s
                        Date Created : %s.""", getId( ), getTitle( ), getBody( ), this.date);
        return output;
    }


    public void update(EntryRequest entryRequest){
        this.title=entryRequest.getTitle( );
        this.body=entryRequest.getBody( );
    }
}