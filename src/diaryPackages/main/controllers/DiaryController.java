package main.controllers;

import main.dtos.DeleteEntryRequest;
import main.dtos.LoginRequest;
import main.dtos.RegisterDiary;
import main.dtos.dtos.EntryRequest;
import main.exceptions.DiaryNotFoundException;
import main.services.DiaryServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
public class DiaryController{
    @Autowired
    private DiaryServices diaryServices;
    @PostMapping("/sign-up")
    public String createDiary(@RequestBody RegisterDiary request){
        try{
            diaryServices.createDiary(request);
            return "Diary created successfully.";
        }catch( DiaryNotFoundException error){
            return error.getMessage( );
        }
    }
    @PatchMapping("/login")
    public String logIn(@RequestBody LoginRequest loginRequest){
        try{
            diaryServices.logIn(loginRequest);
        }catch( DiaryNotFoundException error){return error.getMessage();}
        return "log in successful";
    }
    @PatchMapping("/logOut/{userName}")
    public String logOut(@PathVariable("userName") String  userName){
        try{
            diaryServices.logOut(userName);
        }catch(DiaryNotFoundException error){
            System.out.println(error.getMessage( ));
            return error.getMessage();
        }
        System.out.println("log out successful");
        return "log out successful";
    }
    @PatchMapping("/createEntry")
    public List<String> createEntry(EntryRequest entry){
        diaryServices.createEntry(entry);
        return Collections.singletonList("Created Successfully.");
    }
    @GetMapping("getEntry/{entryId}")
    public String deleteEntry(@PathVariable("entryId") String id, @RequestParam(name = "userName", defaultValue = "") String userName){
        try{
            DeleteEntryRequest request = new DeleteEntryRequest();
            request.setId(id);
            request.setUserName(userName);
            diaryServices.deleteEntry(request);
            return  "deleted Successfully.";
        }
        catch(DiaryNotFoundException error){
            return error.getMessage( );
        }
    }
    @DeleteMapping("/deleteEntry/{entryID}")
    public String deleteEntry(@PathVariable("entryID") String id, @RequestParam(name = "userName", defaultValue = "") DeleteEntryRequest request1){
        try{
            diaryServices.deleteEntry(request1);
            System.out.println("Entry deleted.");
        }catch(DiaryNotFoundException error){
            System.out.println(error.getMessage( ));
            return error.getMessage();
        }
        return "Entry deleted.";
    }
    @PatchMapping("/updateEntry")
    public String updateEntry(@RequestBody() EntryRequest entryRequest){
        try{
            diaryServices.updateEntry(entryRequest);
        }catch(DiaryNotFoundException error){
            System.out.println(error.getMessage( ));
            return error.getMessage();
        }
        return "Entry updated successfully";
    }
}