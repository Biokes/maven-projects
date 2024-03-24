import dtos.EntryRequest;

public class DiaryController{
    private DiaryServices services = new DiaryServiceImpo();

    public String createDiary(RegisterDiary request){
        try{
            services.createDiary(request);
        }catch(DiaryNotFoundException error){
            return error.getMessage( );
        }
        return "Diary created successfully.";
    }

    public int count(){
        return services.count();
    }

    public String logIn(LoginRequest loginRequest){
        try{
            services.logIn(loginRequest);
        }catch( DiaryNotFoundException error){return error.getMessage();}
        return "log in successful";
    }

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

    public String updateEntry(EntryRequest entryRequest){
        return null;
    }
}