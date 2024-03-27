package main.data.repositories;


import main.data.moodels.Diary;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DiaryRepository extends MongoRepository<Diary, String>{

    Diary findDiaryByUsername(String userName);

    void deleteDiary(Diary diaryBy);
}
