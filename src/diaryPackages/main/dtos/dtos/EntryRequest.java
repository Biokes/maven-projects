package main.dtos.dtos;

import lombok.Data;

@Data
public class EntryRequest{
    private String userName;
    private String title;
    private String body;
    private String id;
}
