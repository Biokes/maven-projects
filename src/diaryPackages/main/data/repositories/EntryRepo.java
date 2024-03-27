package main.data.repositories;

import main.data.moodels.Entry;
import main.dtos.dtos.EntryRequest;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EntryRepo extends MongoRepository<Entry, String>{

    void deleteEntryById(int id);

    void update(EntryRequest request);
}
