package data.repositories;


import data.moodels.Diary;

public interface DiaryRepo{
    Diary save(Diary diary);

    List<Diary> findAll();

    Diary findByUserName(String userName);

    int count();

    void deleteByUserName(String userName);

    void deleteDiary(Diary diary);
}
