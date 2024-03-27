package main.dtos;

import lombok.Data;

@Data
public class DeleteEntryRequest{
    private String userName;
    private String id;
    private String password;

}
