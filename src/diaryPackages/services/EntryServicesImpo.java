package services;

import data.moodels.Entry;
import data.repositories.EntryRepo;
import dtos.DeleteEntryRequest;
import dtos.dtos.EntryRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EntryServicesImpo implements EntryServices{
    @Autowired
    private EntryRepo entryRepo;
    public int countEntries(){
        return (int)entryRepo.count( );
    }
    public void createEntry(EntryRequest request){
            Entry entry=new Entry( );
            entry.setTitle(request.getTitle( ));
            entry.setBody(request.getBody( ));
            entry.setAuthor(request.getUserName( ));
            int id=(int)entryRepo.count( );
            entry.setId(++id);
            entryRepo.save(entry);
    }
    public void deleteEntry(DeleteEntryRequest request){
                for( Entry entry : entryRepo.findAll()){
                    if( entry.getId( )==request.getId( ) )
                        entryRepo.deleteEntryById(entry.getId( ));
                    return;
                }
    }
    public void updateEntry(EntryRequest request){
        entryRepo.update(request);
    }

}
