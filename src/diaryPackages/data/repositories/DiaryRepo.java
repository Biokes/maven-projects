package data.repositories;


import data.moodels.Diary;
import data.moodels.Entry;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface DiaryRepo extends MongoRepository<Entry, String>{

    Diary findByUserName(String userName);

    void deleteDiary(Diary diaryBy);
}
