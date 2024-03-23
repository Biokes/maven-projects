public class DiaryController{
    private DiaryServices services = new DiaryServiceImpo();

    public String createDiary(RegisterDiary request){
        try{
            services.createDiary(request);
        }catch()

    }
}