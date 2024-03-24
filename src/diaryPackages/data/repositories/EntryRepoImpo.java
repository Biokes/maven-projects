package data.repositories;

import data.moodels.Entry;
import dtos.dtos.EntryRequest;

import java.util.ArrayList;
import java.util.List;

public class EntryRepoImpo implements EntryRepo{
    private final List<Entry> entries=new ArrayList<>( );
    public String save(Entry entry){
        entries.add(entry);
        return entry.toString();
    }
    public int count(){
        return entries.size( );
    }
    public String update(EntryRequest entryRequest){
        Entry entryTemp = new Entry();
        for( Entry entry : findAll()){
            if( entry.getTitle().equalsIgnoreCase(entryRequest.getTitle())){
                entryTemp.setBody(entryRequest.getBody());
                entryTemp.setId(entry.getId());
                entryTemp.setAuthor(entryRequest.getUserName( ));
                entryTemp.setDateCreated(entry.getDateCreated());
                entryTemp.setTitle(entry.getTitle());
                entries.remove(entry);
                entries.add(entryTemp);
                return entryTemp.toString();
            }
        }
        return null;
    }
    public void deleteEntryById(int id){
        for( Entry entry : entries )
            if( entry.getId()==id ){
                entries.remove(entry);
                return;
            }
    }
    public List<Entry> findAll(){
        return entries;
    }
}
