package data.repositories;


import data.moodels.Entry;

public interface EntryRepo{
    String save(Entry entry);

    int count();

    String update(EntryRequest entryRequest);

    void deleteEntryById(int id);

    List<Entry> findAll();
}
