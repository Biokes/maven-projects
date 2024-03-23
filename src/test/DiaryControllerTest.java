import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.Assert.assertEquals;

public class DiaryControllerTest{
    private DiaryController controller = new DiaryController();
    @BeforeEach
    public void initializer(){
        controller = new DiaryController();
    }
    @Test
    public void testCreateDiary_testDiaryIsCReatedProperly(){
        RegisterDiary request=new RegisterDiary("user name1", "pass");
        controller.createDiary(request);
       assertEquals(1, controller.count( ));
        request=new RegisterDiary("", "pass");
        request=new RegisterDiary("user name1", "");
        assertEquals("Invalid Username or Password was Provided",controller.createDiary(request));
        request=new RegisterDiary("user name1", "password");
        assertEquals("User Already Exist",controller.createDiary(request));

    }
    @Test public void testLogInAndLogOutProperly(){
        RegisterDiary request=new RegisterDiary("user name1", "pass");
        controller.createDiary(request);
        assertEquals("User Already Exist",controller.createDiary(request));
        assertEquals(1, controller.count( ));
        LoginRequest loginRequest = new LoginRequest("user name1", "pass");
        assertEquals("log in successful",controller.logIn(loginRequest));
        loginRequest = new LoginRequest("user name1", "pas1s");
        assertEquals("Incorrect password",controller.logIn(loginRequest));
        loginRequest = new LoginRequest("user ", "pas1s");
        assertEquals("Diary not found.",controller.logIn(loginRequest));
        assertEquals("Log out successful.", controller.logOut("user name"));

    }
    @Test public void testCreateEntryAndDeleteEntryProperly(){}
    @Test public void testUpdateEntryProperly(){}
}
