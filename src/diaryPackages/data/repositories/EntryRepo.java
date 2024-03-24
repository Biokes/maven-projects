package data.repositories;


import data.moodels.Entry;
import dtos.dtos.EntryRequest;

public interface EntryRepo{
    String save(Entry entry);

    int count();

    String update(EntryRequest entryRequest);

    void deleteEntryById(int id);

    List<Entry> findAll();
}
