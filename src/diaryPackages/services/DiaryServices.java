package services;


import data.moodels.Diary;
import dtos.DeleteEntryRequest;
import dtos.LoginRequest;
import dtos.RegisterDiary;
import dtos.dtos.EntryRequest;

public interface DiaryServices{
    void createDiary(RegisterDiary request);

    int count();

    void logIn(LoginRequest loginRequest);

    void deleteDiary(RegisterDiary request);

    void logOut(String userName);

    Diary findDiaryBy(String username);

    int countEntries();

    void createEntry(EntryRequest request);

    void deleteEntry(DeleteEntryRequest request);

    void updateEntry(EntryRequest request);
}
