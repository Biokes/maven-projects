package controllers;


import dtos.DeleteEntryRequest;
import dtos.LoginRequest;
import dtos.RegisterDiary;
import dtos.dtos.EntryRequest;
import exceptions.DiaryNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import services.DiaryServiceImpo;
import services.DiaryServices;

@RestController
public class DiaryController{
    @Autowired
    private final DiaryServices services = new DiaryServiceImpo();
    @PostMapping("/sign_up")
    public String createDiary(RegisterDiary request){
        try{
            services.createDiary(request);
        }catch( DiaryNotFoundException error){
            return error.getMessage( );
        }
        return "Diary created successfully.";
    }
    public int count(){
        return services.count();
    }
    @PatchMapping("/login")
    public String logIn(LoginRequest loginRequest){
        try{
            services.logIn(loginRequest);
        }catch( DiaryNotFoundException error){return error.getMessage();}
        return "log in successful";
    }
    @PostMapping("/logOut")
    public String logOut(String  userName){
        try{
            services.logOut(userName);
        }catch(DiaryNotFoundException error){
            System.out.println(error.getMessage( ));
            return error.getMessage();
        }
        System.out.println("log out successful");
        return "log out successful";
    }
    @PatchMapping("/createEntry")
    public String createEntry(EntryRequest entry){
        try{
        String output = services.createEntry(entry);
            System.out.println(output);
        }catch(DiaryNotFoundException error ){
            System.out.println(error.getMessage( ));
            return error.getMessage();
        }
        return "Entry created successfully";
    }
    @PatchMapping("/deleteEntry")
    public String deleteEntry(DeleteEntryRequest request1){
        try{
             services.deleteEntry(request1);
            System.out.println("Entry deleted.");
        }catch(DiaryNotFoundException error){
            System.out.println(error.getMessage( ));
            return error.getMessage();
        }
        return "Entry deleted.";
    }
    public int countEntries(){
        return services.countEntries();
    }
    @PatchMapping("/updateEntry")
    public String updateEntry(EntryRequest entryRequest){
        try{
            System.out.println(services.updateEntry(entryRequest));
        }catch(DiaryNotFoundException error){
            System.out.println(error.getMessage( ));
            return error.getMessage();
        }
        return "Entry updated successfully";
    }
}