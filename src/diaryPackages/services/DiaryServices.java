package services;

import data.moodels.Diary;
import dtos.LoginRequest;
import dtos.RegisterDiary;
import dtos.dtos.EntryRequest;

public interface DiaryServices{
    Diary createDiary(RegisterDiary request);

    int count();

    void logIn(LoginRequest loginRequest);

    void deleteDiary(RegisterDiary request);

    void logOut(String userName);

    Diary findDiaryBy(String username);

    int countEntries();

    String createEntry(EntryRequest request);

    void deleteEntry(DeleteEntryRequest request);

    String updateEntry(EntryRequest request);
}
