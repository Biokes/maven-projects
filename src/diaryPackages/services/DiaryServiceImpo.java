package services;
import data.moodels.Diary;
import data.repositories.DiaryRepo;
import data.repositories.EntryRepo;
import dtos.DeleteEntryRequest;
import dtos.LoginRequest;
import dtos.RegisterDiary;
import dtos.dtos.EntryRequest;
import exceptions.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class DiaryServiceImpo implements DiaryServices{
    @Autowired
    private  DiaryRepo repo ;
    @Autowired
    private  EntryRepo entryRepo;
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
        if( repo.findByUserName(loginRequest.getUserName( ))==null )
            throw new DiaryNotFoundException( );
        if( !repo.findByUserName(loginRequest.getUserName( )).getPassword( ).equalsIgnoreCase(loginRequest.getPassword( )) )
            throw new IncorrectPasswordException( );
        repo.findByUserName(loginRequest.getUserName( )).setLocked(false);
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
        repo.findByUserName(userName).setLocked(true);
    }
    public Diary findDiaryBy(String username){
        Optional<Diary> diary = repo.findById(username.toLowerCase());
        if(diary.isEmpty())
            throw new DiaryNotFoundException();
        return diary.get();
    }
    public int countEntries(){
        return (int)entryRepo.count( );
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

