import moodels.Diary;
import org.junit.Test;
import repositories.DiaryRepo;
import repositories.DiaryRepoImpo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class DiaryRepoTest{
    private final DiaryRepo diaryRepo=new DiaryRepoImpo( );

    @Test
    public void saveDiary_DiaryIsSaved(){
        Diary diary=new Diary( );
        RegisterDiary register=new RegisterDiary("userName", "password");
        diary.setUsername(register.getUserName( ));
        diary.setPassword(register.getPassword( ));
        assertEquals(0, diaryRepo.count( ));
        diaryRepo.save(diary);
        assertEquals(1, diaryRepo.count( ));
    }

    @Test
    public void deleteDiary_testDiaryIsDeleted(){
        Diary diary=new Diary( );
        RegisterDiary register=new RegisterDiary("userName", "password");
        diary.setUsername(register.getUserName( ));
        diary.setPassword(register.getPassword( ));
        assertEquals(0, diaryRepo.count( ));
        diaryRepo.save(diary);
        assertEquals(1, diaryRepo.count( ));
        diaryRepo.deleteDiary(diary);
        assertEquals(0, diaryRepo.count( ));
    }

    @Test
    public void findAll_testAllIsReturned(){
        Diary diary=new Diary( );
        RegisterDiary register=new RegisterDiary("userName", "password");
        diary.setUsername(register.getUserName( ));
        diary.setPassword(register.getPassword( ));
        assertEquals(0, diaryRepo.findAll( ).size( ));
        diaryRepo.save(diary);
        assertEquals(1, diaryRepo.findAll( ).size( ));
        diaryRepo.deleteDiary(diary);
        assertEquals(0, diaryRepo.findAll( ).size( ));
    }

    @Test
    public void findByUserName_testDiaryIsFound(){
        assertNull(diaryRepo.findByUserName("name"));
        Diary diary=new Diary( );
        RegisterDiary register=new RegisterDiary("userName", "password");
        diary.setUsername(register.getUserName( ));
        diary.setPassword(register.getPassword( ));
        assertEquals(0, diaryRepo.count( ));
        diaryRepo.save(diary);
        assertEquals(diary, diaryRepo.findByUserName(register.getUserName( )));
        assertEquals(register.getUserName( ), diaryRepo.findByUserName(register.getUserName( )).getUserName( ));
    }

    @Test
    public void deleteUserName(){
        Diary diary=new Diary( );
        RegisterDiary register=new RegisterDiary("userName", "password");
        diary.setUsername(register.getUserName( ));
        diary.setPassword(register.getPassword( ));
        assertEquals(0, diaryRepo.count( ));
        diaryRepo.save(diary);
        assertEquals(1, diaryRepo.count( ));
        diaryRepo.deleteByUserName(register.getUserName( ));
        assertEquals(0, diaryRepo.count( ));
    }
}
