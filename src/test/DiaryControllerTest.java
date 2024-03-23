import org.junit.Test;
import org.junit.jupiter.api.Assertions;
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
       Assertions.assertEquals(1, controller.count( ));
        request=new RegisterDiary("", "pass");
        RegisterDiary finalRequest = request;
        request=new RegisterDiary("user name1", "");
        assertEquals("User Already Exist.",controller.createDiary(request));
    }
    @Test public void testLogInAndLogOutProperly(){}
    @Test public void testCreateEntryAndDeleteEntryProperly(){}
    @Test public void testUpdateEntryProperly(){}
}
