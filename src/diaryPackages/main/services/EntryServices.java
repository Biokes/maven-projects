package main.services;


import main.dtos.DeleteEntryRequest;
import main.dtos.dtos.EntryRequest;
import org.springframework.stereotype.Service;

@Service
public interface EntryServices{
    int countEntries();
    void createEntry(EntryRequest request);

    void deleteEntry(DeleteEntryRequest request);

    void updateEntry(EntryRequest request);
}