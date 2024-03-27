package main.services;


import main.data.moodels.Diary;
import main.dtos.DeleteEntryRequest;
import main.dtos.LoginRequest;
import main.dtos.RegisterDiary;
import main.dtos.dtos.EntryRequest;
import org.springframework.stereotype.Service;

@Service
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
