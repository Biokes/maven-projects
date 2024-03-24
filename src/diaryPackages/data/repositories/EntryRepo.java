package data.repositories;


import data.moodels.Entry;
import dtos.dtos.EntryRequest;

import java.util.List;

public interface EntryRepo{
    String save(Entry entry);

    int count();

    String update(EntryRequest entryRequest);

    void deleteEntryById(int id);

    List<Entry> findAll();
}
