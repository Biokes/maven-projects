import dtos.EntryRequest;
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
        assertEquals("log out successful", controller.logOut("user name1"));
        EntryRequest entryRequest = new EntryRequest("name","body");
        entryRequest.setUserName("user name1");
        assertEquals("Diary is Locked", controller.createEntry(entryRequest));
    }
    @Test public void testCreateEntryAndDeleteEntryProperly(){
        RegisterDiary request=new RegisterDiary("user name1", "pass");
        controller.createDiary(request);
        assertEquals("User Already Exist",controller.createDiary(request));
        assertEquals("log out successful", controller.logOut("user name1"));
        LoginRequest loginRequest = new LoginRequest("user name1", "pass");
        assertEquals("log in successful",controller.logIn(loginRequest));
        EntryRequest entry = new EntryRequest("Title","Body");
        entry.setUserName("user name1");
        assertEquals("Entry created successfully", controller.createEntry(entry));
        DeleteEntryRequest request1= new DeleteEntryRequest();
        request1.setId(1);
        request1.setUserName("user name1");
        request1.setPassword("pass");
        controller.deleteEntry(request1);
        assertEquals(0, controller.countEntries());

    }
    @Test public void testUpdateEntryProperly(){}
}
