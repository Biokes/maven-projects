package repositories;

import dtos.EntryRequest;
import moodels.Entry;

import java.util.List;

public interface EntryRepo{
    void save(Entry entry);

    int count();

    String update(EntryRequest entryRequest);

    void deleteEntryById(int id);

    List<Entry> findAll();
}
