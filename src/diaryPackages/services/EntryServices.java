package services;

import dtos.DeleteEntryRequest;
import dtos.dtos.EntryRequest;

public interface EntryServices{
    int countEntries();
    void createEntry(EntryRequest request);

    void deleteEntry(DeleteEntryRequest request);

    void updateEntry(EntryRequest request);
}