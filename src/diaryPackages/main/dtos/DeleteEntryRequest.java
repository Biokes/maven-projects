package main.dtos;

import lombok.Data;

@Data
public class DeleteEntryRequest{
    private String userName;
    private int id;
    private String password;

}
