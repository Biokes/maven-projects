package data.repositories;


import data.moodels.Diary;
import data.moodels.Entry;
import dtos.dtos.EntryRequest;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface EntryRepo extends MongoRepository<Entry, String>{

    void deleteEntryById(int id);

    String update(EntryRequest request);
}
