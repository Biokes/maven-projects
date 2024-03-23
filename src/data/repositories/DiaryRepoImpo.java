package repositories;

import moodels.Diary;

import java.util.ArrayList;
import java.util.List;

public class DiaryRepoImpo implements DiaryRepo{
    private final List<Diary> diaries=new ArrayList<>( );

    public Diary save(Diary diary){
        diaries.add(diary);
        return diary;
    }

    public List<Diary> findAll(){
        return diaries;
    }

    public Diary findByUserName(String userName){
        for( Diary diary : diaries ){
            if( diary.getUserName( ).equalsIgnoreCase(userName) )
                return diary;
        }
        return null;
    }

    public int count(){
        return diaries.size( );
    }

    public void deleteByUserName(String userName){
        for( Diary diary : diaries ){
            if( diary.getUserName( ).equalsIgnoreCase(userName) ){
                diaries.remove(diary);
                return;
            }
        }
    }

    public void deleteDiary(Diary diary){
        diaries.removeIf(diary1->diary1==diary);
    }
}
