import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.Assert.assertThrows;

public class DiaryControllerTest{
    private DiaryController controller = new DiaryController();
    @BeforeEach
    public void initializer(){
        controller = new DiaryController();
    }
    @Test
    public void testCreateDiary_testDiaryIsCReatedProperly(){
        RegisterDiary request=new RegisterDiary("user name", "pass");
        controller.createDiary(request);
//        Assertions.assertEquals(1, diaryService.count( ));
        request=new RegisterDiary("", "pass");
        RegisterDiary finalRequest=request;
//        assertThrows(exceptions.InvalidDetailsException.class, ()->diaryService.createDiary(finalRequest));
//        Assertions.assertEquals(1, diaryService.count( ));
        request=new RegisterDiary("user name", "");
        RegisterDiary finalRequest1=request;
//        assertThrows(exceptions.InvalidDetailsException.class, ()->diaryService.createDiary(finalRequest1));
//        Assertions.assertEquals(1, diaryService.count( ));
    }
    @Test public void testLogInAndLogOutProperly(){}
    @Test public void testCreateEntryAndDeleteEntryProperly(){}
    @Test public void testUpdateEntryProperly(){}
}
