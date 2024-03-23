import dtos.EntryRequest;
import moodels.Diary;

public interface DiaryServices{
    Diary createDiary(RegisterDiary request);

    int count();

    void logIn(LoginRequest loginRequest);

    void deleteDiary(RegisterDiary request);

    void logOut(String userName);

    Diary findDiaryBy(String username);

    int countEntries();

    void craeateEntry(EntryRequest request);

    void deleteEntry(DeleteEntryRequest request);

}
