public class DiaryController{
    private DiaryServices services = new DiaryServiceImpo();

    public String createDiary(RegisterDiary request){
        try{
            services.createDiary(request);
        }catch(DiaryNotFoundException error){
            System.out.println(error.getMessage( ));
            return "\n";
        }
        return "Diary created successfully.";
    }

    public int count(){
        return services.count();
    }
}