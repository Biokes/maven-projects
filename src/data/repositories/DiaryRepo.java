package repositories;

import moodels.Diary;

import java.util.List;

public interface DiaryRepo{
    Diary save(Diary diary);

    List<Diary> findAll();

    Diary findByUserName(String userName);

    int count();

    void deleteByUserName(String userName);

    void deleteDiary(Diary diary);
}
