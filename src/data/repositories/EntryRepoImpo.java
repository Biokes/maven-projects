package repositories;

import dtos.EntryRequest;
import moodels.Entry;

import java.util.ArrayList;
import java.util.List;

public class EntryRepoImpo implements EntryRepo{
    private final List<Entry> entries=new ArrayList<>( );

    public void save(Entry entry){
        entries.add(entry);
    }

    public int count(){
        return entries.size( );
    }

    @Override
    public void update(EntryRequest entryRequest){
    }

    public void deleteEntryById(int id){
        for( Entry entry : entries )
            if( entry.getId( )==id ){
                entries.remove(entry);
                return;
            }
    }

    public List<Entry> findAll(){
        return entries;
    }
}
