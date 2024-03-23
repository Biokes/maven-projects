import dtos.EntryRequest;
import moodels.Diary;
import moodels.Entry;
import repositories.DiaryRepo;
import repositories.DiaryRepoImpo;
import repositories.EntryRepo;
import repositories.EntryRepoImpo;

public class DiaryServiceImpo implements DiaryServices{
    private final DiaryRepo repo=new DiaryRepoImpo( );
    private final EntryRepo entryRepo=new EntryRepoImpo( );

    public Diary createDiary(RegisterDiary request){
        validate(request);
        Diary diary=new Diary( );
        diary.setUsername(request.getUserName( ));
        diary.setPassword(request.getPassword( ));
        diary=repo.save(diary);
        return diary;
    }

    private void validate(RegisterDiary request){
        if( request.getUserName( ).isEmpty( )||request.getPassword( ).isEmpty( ) )
            throw new InvalidDetailsException( );
    }

    public int count(){
        return repo.count( );
    }

    public void logIn(LoginRequest loginRequest){
        if( repo.findByUserName(loginRequest.getUserName( ))==null )
            throw new DiaryNotFoundException( );
        if( !repo.findByUserName(loginRequest.getUserName( )).getPassword( ).equalsIgnoreCase(loginRequest.getPassword( )) )
            throw new IncorrectPasswordException( );
        repo.findByUserName(loginRequest.getUserName( )).isLocked(false);
    }

    public void deleteDiary(RegisterDiary request){
        validate(request);
        if( null==repo.findByUserName(request.getUserName( )) )
            throw new DiaryNotFoundException( );
        if( !(repo.findByUserName(request.getUserName( )).getPassword( )).equals(request.getPassword( )) )
            throw new IncorrectPasswordException( );
        repo.deleteDiary(findDiaryBy(request.getUserName( )));
    }

    public void logOut(String userName){
        if( repo.findByUserName(userName)==null )
            throw new InvalidDetailsException( );
        repo.findByUserName(userName).isLocked(true);
    }

    public Diary findDiaryBy(String username){
        if( repo.findByUserName(username)==null )
            throw new DiaryNotFoundException( );
        return repo.findByUserName(username);
    }

    public int countEntries(){
        return entryRepo.count( );
    }

    public void craeateEntry(EntryRequest request){
        Entry entry=new Entry( );
        entry.setTitle(request.getTitle( ));
        entry.setBody(request.getBody( ));
        entry.setId(entryRepo.count( )+1);
        entryRepo.save(entry);
    }

    public void deleteEntry(DeleteEntryRequest request){
        if( !findDiaryBy(request.getUserName( )).isLocked( ) ){
            for( Diary diary : repo.findAll( ) )
                if( diary.getUserName( ).equals(request.getUserName( )) ){
                    for( Entry entry : entryRepo.findAll( ) ){
                        if( entry.getId( )==request.getId( ) )
                            entryRepo.deleteEntryById(entry.getId( ));
                        return;
                    }
                }
            throw new InvalidDetailsException( );
        }
        throw new DiaryIsLockedException( );
    }

    public String updateEntry(EntryRequest request){
        if( !findDiaryBy(request.getUserName( )).isLocked( ) ){
            return entryRepo.update(request);
        }
        throw new DiaryIsLockedException( );
    }

}

