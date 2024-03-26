package data.repositories;


import data.moodels.Diary;
import data.moodels.Entry;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface DiaryRepo extends MongoRepository<Diary, String>{

    Diary findByUserName(String userName);

    void deleteDiary(Diary diaryBy);
}
