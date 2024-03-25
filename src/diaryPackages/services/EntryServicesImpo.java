package services;

import data.repositories.EntryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EntryServicesImpo implements EntryServices{
    @Autowired
    private EntryRepo entryRepo;
    public int countEntries(){
        return (int)entryRepo.count( );
    }


}
