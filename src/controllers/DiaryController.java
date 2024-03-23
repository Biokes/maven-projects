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
}