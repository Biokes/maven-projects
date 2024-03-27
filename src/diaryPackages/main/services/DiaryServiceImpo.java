package main.services;

import main.data.moodels.Diary;
import main.data.repositories.DiaryRepository;
import main.dtos.DeleteEntryRequest;
import main.dtos.LoginRequest;
import main.dtos.RegisterDiary;
import main.dtos.dtos.EntryRequest;
import main.exceptions.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DiaryServiceImpo implements DiaryServices{
    @Autowired
    private DiaryRepository repo;
    @Autowired
    private EntryServicesImpo entryServicesImpo;
    public void createDiary(RegisterDiary request){
        validate(request);
        Diary diary = new Diary( );
        diary.setUsername(request.getUserName( ));
        diary.setPassword(request.getPassword( ));
        repo.save(diary);
        }
    private void validate(RegisterDiary request){
        if( request.getUserName( ).isEmpty( )||request.getPassword( ).isEmpty( ) )
            throw new InvalidDetailsException( );
       for( Diary diary : repo.findAll()){
           if(diary.getUsername().equalsIgnoreCase(request.getUserName()))
               throw new UserAlreadyExistException();
       }
    }
    public int count(){
        return (int)repo.count( );
    }
    public void logIn(LoginRequest loginRequest){
        if( repo.findDiaryByUsername(loginRequest.getUserName( ))==null )
            throw new DiaryNotFoundException( );
        if( !repo.findDiaryByUsername(loginRequest.getUserName( )).getPassword( ).equalsIgnoreCase(loginRequest.getPassword( )) )
            throw new IncorrectPasswordException( );
        repo.findDiaryByUsername(loginRequest.getUserName( )).setLocked(false);
    }
    public void deleteDiary(RegisterDiary request){
        validate(request);
        if( null==repo.findDiaryByUsername(request.getUserName( )) )
            throw new DiaryNotFoundException( );
        if( !(repo.findDiaryByUsername(request.getUserName( )).getPassword( )).equals(request.getPassword( )) )
            throw new IncorrectPasswordException( );
        repo.deleteDiaryByUsername(findDiaryBy(request.getUserName( )).getUsername( ));
    }
    public void logOut(String userName){
        if( repo.findDiaryByUsername(userName)==null )
            throw new InvalidDetailsException( );
        repo.findDiaryByUsername(userName).setLocked(true);
    }
    public Diary findDiaryBy(String username){
        Optional<Diary> diary = repo.findById(username.toLowerCase());
        if(diary.isEmpty())
            throw new DiaryNotFoundException();
        return diary.get();
    }
    public int countEntries(){
        return entryServicesImpo.countEntries( );
    }
    public void createEntry(EntryRequest request){
        if(!findDiaryBy(request.getUserName()).isLocked()){
          entryServicesImpo.createEntry(request);
        }
        throw new DiaryIsLockedException();

    }
    public void deleteEntry(DeleteEntryRequest request){
        if(!findDiaryBy(request.getUserName()).isLocked()){
            boolean usernameMatch = findDiaryBy(request.getUserName()).getUsername().equalsIgnoreCase(request.getUserName());
            if(usernameMatch){
                   entryServicesImpo.deleteEntry(request);
                    }
            throw new InvalidDetailsException( );
        }
        throw new DiaryIsLockedException( );
    }
    public void updateEntry(EntryRequest request){
        if( findDiaryBy(request.getUserName( )).isLocked( ) ){
            throw new DiaryIsLockedException( );
        }
        entryServicesImpo.updateEntry(request);
    }
}

