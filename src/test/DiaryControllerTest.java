import java.util.Scanner;

public class DiaryControllerTest{
    private final Scanner scanner=new Scanner(System.in);
    private DiaryServices diaryServices=new DiaryServiceImpo( );
    private void print(String word){
        System.out.println(word);
    }

    private String input(String word){
        print(word);
        return scanner.next( );
    }

    public String mainMenu(){
        return input("""
                Welcome to D-Diary
                1. Sign up
                2. log in
                3. Exit
""");
    }

    public void signUp(){
        try{
            String username=input("Enter your preferred name: ");
            String password=input("Enter your preferred password : ");

        }catch( RuntimeException error ){
            System.out.println(error.getMessage( ));
            mainMenu( );
        }
        System.out.println("Diary Successfully Created.");
        diaryMenu( );
    }

    public void menu(String choice){
        switch(choice){
            case "1" -> signUp( );
//            case "2" -> logIn( );
//            case "3" -> exit( );
            default -> mainMenu( );
        }
    }

    public void diaryMenu(){

    }
}
