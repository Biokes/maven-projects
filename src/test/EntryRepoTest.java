import dtos.EntryRequest;
import moodels.Entry;
import org.junit.Test;
import repositories.EntryRepo;
import repositories.EntryRepoImpo;

import static org.junit.Assert.assertEquals;

public class EntryRepoTest{
    private EntryRepo repo;

    @Test
    public void createEntry_testEntryIsCreated(){
        repo=new EntryRepoImpo( );
        EntryRequest entryRequest=new EntryRequest( );
        entryRequest.setUserName("authour");
        entryRequest.setTitle("title");
        entryRequest.setbody("body");
        Entry entry=new Entry( );
        entry.setId(1);
        entry.setTitle(entryRequest.getTitle( ));
        entry.setBody(entryRequest.getBody( ));
        repo.save(entry);
        assertEquals(1, repo.count( ));
    }
    @Test
    public void deleteEntry_testEntryIsDeleted(){
        repo=new EntryRepoImpo( );
        EntryRequest entryRequest=new EntryRequest( );
        entryRequest.setUserName("authour");
        entryRequest.setTitle("title");
        entryRequest.setbody("body");
        Entry entry=new Entry( );
        entry.setId(1);
        entry.setTitle(entryRequest.getTitle( ));
        entry.setBody(entryRequest.getBody( ));
        assertEquals(0, repo.count( ));
        repo.save(entry);
        assertEquals(1, repo.count( ));
        repo.deleteEntryById(entry.getId( ));
        assertEquals(0, repo.count( ));
    }
    @Test
    public void updateEntry_testEntryIsUpdated(){
        repo=new EntryRepoImpo( );
        EntryRequest entryRequest=new EntryRequest( );
        entryRequest.setUserName("authour");
        entryRequest.setTitle("title");
        entryRequest.setbody("body");
        Entry entry=new Entry( );
        entry.setId(1);
        entry.setTitle(entryRequest.getTitle( ));
        entry.setBody(entryRequest.getBody( ));
        assertEquals(0, repo.count( ));
        repo.save(entry);
        assertEquals(1, repo.count( ));
        repo.deleteEntryById(entry.getId( ));
        assertEquals(0, repo.count( ));
        entryRequest.setTitle("name");
        entryRequest.setbody("nme d");
        entry.update(entryRequest);
        assertEquals("nme d", entry.getBody( ));
        assertEquals("name", entry.getTitle( ));
    }
    @Test
    public void findAllEntries_testAllEntryIsFound(){
        repo=new EntryRepoImpo( );
        for( int count=0; count<3; count++ )
            repo.save(new Entry( ));
        assertEquals(3, repo.findAll( ).size( ));
    }
}
