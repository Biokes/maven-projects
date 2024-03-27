//package test.diaryPackagesTest;
//
//import main.java.services.DiaryServiceImpo;
//import main.java.services.DiaryServices;
//
//public class DiaryServicesTest{
//    private DiaryServices diaryService=new DiaryServiceImpo( );
//
//    @BeforeEach
//    void initialize(){
//        diaryService=new DiaryServiceImpo( );
//    }
//
//    @Test
//    public void createDiary_testDiaryIsCreated(){
//        diaryPackages.main.dtos.RegisterDiary request=new diaryPackages.main.dtos.RegisterDiary("user name", "pass");
//        diaryService.createDiary(request);
//        RegisterDiary request1 = request;
//        assertThrows(UserAlreadyExistException.class,()->diaryService.createDiary(request1));
//        Assertions.assertEquals(1, diaryService.count( ));
//        request=new RegisterDiary("", "pass");
//        RegisterDiary finalRequest=request;
//        assertThrows(InvalidDetailsException.class, ()->diaryService.createDiary(finalRequest));
//        Assertions.assertEquals(1, diaryService.count( ));
//        request=new RegisterDiary("user name", "");
//        RegisterDiary finalRequest1=request;
//        assertThrows(InvalidDetailsException.class, ()->diaryService.createDiary(finalRequest1));
//        Assertions.assertEquals(1, diaryService.count( ));
//    }
//
//    @Test
//    public void deleteDiary_testThatDiaryIsDeleted(){
//        RegisterDiary request=new RegisterDiary("user name", "pass");
//        assertThrows(DiaryNotFoundException.class, ()->diaryService.deleteDiary(request));
//        diaryService.createDiary(request);
//        Assertions.assertEquals(1, diaryService.count( ));
//    }
//
//    @Test
//    public void testLoginAndLogOut(){
//        RegisterDiary request=new RegisterDiary("user name", "pass");
//        assertThrows(DiaryNotFoundException.class, ()->diaryService.deleteDiary(request));
//        Diary diary=diaryService.createDiary(request);
//        assertFalse(diary.isLocked( ));
//        Assertions.assertEquals(1, diaryService.count( ));
//        diaryService.logOut(request.getUserName( ));
//        assertTrue(diary.isLocked( ));
//    }
//
//    @Test
//    public void deleteEntry_testEntryIsDeletedProperly(){
//        RegisterDiary request=new RegisterDiary("user name", "pass");
//        diaryService.createDiary(request);
//        Assertions.assertEquals(1, diaryService.count( ));
//        EntryRequest request1=new EntryRequest( );
//        request1.setTitle("name");
//        request1.setbody("body of whatever");
//        request1.setUserName("user Name");
//        diaryService.createEntry(request1);
//        assertEquals(1, diaryService.countEntries( ));
//        DeleteEntryRequest deleteEntryRequest=new DeleteEntryRequest( );
//        deleteEntryRequest.setPassword("pass");
//        deleteEntryRequest.setId(1);
//        deleteEntryRequest.setUserName("user name");
//        diaryService.deleteEntry(deleteEntryRequest);
//        assertEquals(0, diaryService.countEntries( ));
//        diaryService.logOut("user name");
//        assertTrue(diaryService.findDiaryBy("user name").isLocked( ));
//        assertThrows(DiaryIsLockedException.class, ()->diaryService.deleteEntry(deleteEntryRequest));
//        LoginRequest loginRequest=new LoginRequest("user name", "pass1");
//        assertThrows(IncorrectPasswordException.class, ()->diaryService.logIn(loginRequest));
//        loginRequest.setPassword("pass");
//
//        diaryService.logIn(loginRequest);
//        assertThrows(InvalidDetailsException.class, ()->diaryService.deleteEntry(deleteEntryRequest));
//    }
//    @Test
//    public void updateEntry_testEntryIsUpdatedProperly(){
//        RegisterDiary request=new RegisterDiary("user name", "pass");
//        diaryService.createDiary(request);
//        Assertions.assertEquals(1, diaryService.count( ));
//        EntryRequest request1=new EntryRequest( );
//        request1.setTitle("name");
//        request1.setbody("body of whatever");
//        request1.setUserName("user name");
//        diaryService.createEntry(request1);
//        assertEquals(1, diaryService.countEntries());
//        EntryRequest entryRequest=new EntryRequest( );
//        entryRequest.setbody("body");
//        entryRequest.setTitle("name");
//        entryRequest.setUserName("user name1");
//        assertThrows(DiaryNotFoundException.class, ()->diaryService.updateEntry(entryRequest));
//        entryRequest.setUserName("user name");
//        assertEquals(String.format("""
//                        Entry id : %s
//                        Title : %s
//                        Body : %s
//                        Author : %s
//                        Date Created : %s.""", 1, "name","body", "user name","2024-03-24"),
//                diaryService.updateEntry(entryRequest));
//    }
//}
